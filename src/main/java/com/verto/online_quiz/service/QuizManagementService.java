package com.verto.online_quiz.service;

import com.verto.online_quiz.dto.quizManagement.*;
import com.verto.online_quiz.entity.Choices;
import com.verto.online_quiz.entity.CorrectAnswer;
import com.verto.online_quiz.entity.Question;
import com.verto.online_quiz.entity.Quiz;
import com.verto.online_quiz.entity.type.QuestionType;
import com.verto.online_quiz.repository.ChoicesRepository;
import com.verto.online_quiz.repository.CorrectAnswerRepository;
import com.verto.online_quiz.repository.QuestionRepository;
import com.verto.online_quiz.repository.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizManagementService {
    private final QuizRepository quizRepository;
    private final ModelMapper modelMapper;
    private final QuestionRepository questionRepository;
    private final ChoicesRepository choicesRepository;
    private final CorrectAnswerRepository correctAnswerRepository;

    public FetchQuizResponseDto createQuizService(QuizRequestDto requestDto){
        Quiz quiz = modelMapper.map(requestDto, Quiz.class);
        Quiz saved = quizRepository.save(quiz);
        return modelMapper.map(saved, FetchQuizResponseDto.class);
    }

    public FetchQuizResponseDto updateQuizService(Long id, QuizRequestDto requestDto){
        Optional<Quiz> quizOptional = quizRepository.findById(id);

        if(!quizOptional.isPresent()){
            throw new EntityNotFoundException("No Quiz with given Id");
        }

        Quiz quiz = quizOptional.get();
        modelMapper.getConfiguration()
                .setPropertyCondition(ctx -> ctx.getSource() != null);
        modelMapper.map(requestDto, quiz);

        Quiz saved = quizRepository.save(quiz);

        return modelMapper.map(saved, FetchQuizResponseDto.class);
    }

    public AddQuestionResponseDto createQuestionService(Long quizId, AddQuestionRequestDto questionDto) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new EntityNotFoundException("No Quiz with given Id"));

        Question question = new Question();
        question.setQuestionText(questionDto.getQuestionText()); // corrected here
        question.setAddOnFileUrl(questionDto.getAddOnFileUrl());
        question.setMaxScore(questionDto.getMaxScore());
        question.setQuestionType(questionDto.getQuestionType());
        question.setQuiz(quiz);
        Question savedQuestion = questionRepository.save(question);

        List<Choices> choices = new ArrayList<>();
        for (ChoiceRequestDto choiceDto : questionDto.getChoices()) {
            Choices choice = new Choices();
            choice.setChoiceText(choiceDto.getChoiceText());
            choice.setChoiceNum(choiceDto.getChoiceNum());
            choice.setAddOnFileURL(choiceDto.getAddOnFileURL());
            choice.setQuestion(savedQuestion);
            choices.add(choice);
        }
        List<Choices> savedChoices = choicesRepository.saveAll(choices);

        CorrectAnswerRequestDto correctAnswerRequestDto = questionDto.getCorrectAnswers();
        List<CorrectAnswer> correctAnswers = new ArrayList<>();

        //Fetching the Correct Answers.
        for (Integer choiceNum : correctAnswerRequestDto.getCorrectChoicesNum()) {
            for(Choices savedChoice : savedChoices){
                Integer choiceIdx = savedChoice.getChoiceNum();
                if(choiceIdx != null && choiceIdx.equals(choiceNum)){
                    CorrectAnswer correctAnswer = new CorrectAnswer();
                    correctAnswer.setQuestion(savedQuestion);
                    correctAnswer.setChoice(savedChoice);
                    correctAnswers.add(correctAnswer);
                }
            }
        }

        List<CorrectAnswer> savedCorrectAnswers = correctAnswerRepository.saveAll(correctAnswers);

        //Creation to Response DTO
        AddQuestionResponseDto questionResponseDto = new AddQuestionResponseDto();
        questionResponseDto.setQuestionText(question.getQuestionText());
        questionResponseDto.setQuestionType(question.getQuestionType());
        questionResponseDto.setId(question.getId());
        questionResponseDto.setAddOnFileUrl(question.getAddOnFileUrl());
        questionResponseDto.setQuizId(questionResponseDto.getQuizId());
        questionResponseDto.setMaxScore(questionResponseDto.getMaxScore());

        List<ChoiceResponseDto> choicesResponseDto = new ArrayList<>();
        for(Choices choice : savedChoices){
            ChoiceResponseDto choiceResponseDto = new ChoiceResponseDto();
            modelMapper.map(choice, choiceResponseDto);
            choicesResponseDto.add(choiceResponseDto);
        }
        questionResponseDto.setChoices(choicesResponseDto);

        CorrectAnswerResponseDto correctAnswerResponseDto = new CorrectAnswerResponseDto();
        correctAnswerResponseDto.setCorrectChoiceNum(new ArrayList<>());
        for(CorrectAnswer correctAnswer: savedCorrectAnswers){
          if(correctAnswerResponseDto.getCorrectAnswerText() == null && correctAnswer.getAnswerText() != null){
              correctAnswerResponseDto.setCorrectAnswerText(correctAnswer.getAnswerText());
          }
          correctAnswerResponseDto.getCorrectChoiceNum().add(correctAnswer.getChoice().getChoiceNum());
        }
        questionResponseDto.setCorrectAnswers(correctAnswerResponseDto);
        return questionResponseDto;
    }
}
