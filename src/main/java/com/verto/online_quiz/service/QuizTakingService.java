package com.verto.online_quiz.service;

import com.verto.online_quiz.dto.quizTaking.*;
import com.verto.online_quiz.entity.*;
import com.verto.online_quiz.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizTakingService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ChoicesRepository choicesRepository;
    @Autowired
    CorrectAnswerRepository correctAnswerRepository;
    @Autowired
    private SubmittedAnswerRepository submittedAnswerRepository;

    public FetchCompleteQuizDto fetchQuiz(Long id){
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if(optionalQuiz.isEmpty()){
            throw new EntityNotFoundException("No Quiz with given Id");
        }

        Quiz quiz = optionalQuiz.get();

        FetchCompleteQuizDto fetchCompleteQuizDto = new FetchCompleteQuizDto();
        fetchCompleteQuizDto.setId(quiz.getId());
        fetchCompleteQuizDto.setTitle(quiz.getTitle());
        fetchCompleteQuizDto.setDescription(quiz.getDescription());
        fetchCompleteQuizDto.setTotalMarks(quiz.getTotalMarks());
        fetchCompleteQuizDto.setUpdatedAt(quiz.getUpdatedAt());
        fetchCompleteQuizDto.setDurationInMinutes(quiz.getDurationInMinutes());

        List<Question> questions = questionRepository.findByQuiz(quiz);
        List<FetchQuestionDto> fetchQuestionDtos = new ArrayList<>();
        for(Question question : questions){
            FetchQuestionDto fetchQuestionDto = new FetchQuestionDto();
            List<Choices> choices = choicesRepository.findByQuestion(question);
            fetchQuestionDto.setId(question.getId());
            fetchQuestionDto.setQuestionText(question.getQuestionText());
            fetchQuestionDto.setQuestionType(question.getQuestionType());
            fetchQuestionDto.setMaxScore(question.getMaxScore());
            fetchQuestionDto.setAddOnFileUrl(question.getAddOnFileUrl());

            List<FetchChoiceDto> fetchChoiceDtos = new ArrayList<>();
            for(Choices choice : choices){
                FetchChoiceDto fetchChoiceDto = new FetchChoiceDto();
                fetchChoiceDto.setId(choice.getId());
                fetchChoiceDto.setChoiceText(choice.getChoiceText());
                fetchChoiceDto.setAddOnFileURL(choice.getAddOnFileURL());
                fetchChoiceDtos.add(fetchChoiceDto);
            }
            fetchQuestionDto.setChoices(fetchChoiceDtos);
            fetchQuestionDtos.add(fetchQuestionDto);
//            List<FetchCorrectAnswerDto> fetchCorrectAnswerDtos = new ArrayList<>();
//            List<CorrectAnswer> correctAnswers = correctAnswerRepository.findByQuestion(question);

//            for(CorrectAnswer correctAnswer : correctAnswers){
//                FetchCorrectAnswerDto correctAnswerDto = new FetchCorrectAnswerDto();
//                correctAnswerDto.setAnswerText(correctAnswer.getAnswerText());
//                correctAnswerDto.setId(correctAnswer.getId());
//
//                Choices choice = correctAnswer.getChoice();
//                FetchChoiceDto fetchChoiceDto = new FetchChoiceDto();
//                fetchChoiceDto.setId(choice.getId());
//                fetchChoiceDto.setChoiceText(choice.getChoiceText());
//                fetchChoiceDto.setAddOnFileURL(choice.getAddOnFileURL());
//                fetchChoiceDtos.add(fetchChoiceDto);
//
//                correctAnswerDto.setCorrectChoices();
//            }
        }
        fetchCompleteQuizDto.setQuestions(fetchQuestionDtos);
        return fetchCompleteQuizDto;
    }

//    Long quizId;
//    List<QuestionAnswerDto> questionAnswerList;

//    public FetchSubmitQuizScoreDto submitQuiz(SubmitQuizRequestDto submitQuizDto){
//
//        //Fetching the whole quiz along with all its fields
//
//        Long quizId = submitQuizDto.getQuizId();
//
//        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
//        if(optionalQuiz.isEmpty()){
//            throw new EntityNotFoundException("No Quiz with given Id");
//        }
//
//        Quiz quiz = optionalQuiz.get();
//
//        //Creation of Maps for easy fetching of Data for each question, choice, correctAns.
//        Map<Long, Question> questionMap = new HashMap<>();
//        Map<Long, java.util.Map<Long, Choices>> questionChoicesMap = new HashMap<>();
//        Map<Long, Map<Long, CorrectAnswer>> questionCorrectAnswersMap = new HashMap<>();
//
//        List<Question> questions = questionRepository.findByQuiz(quiz);
//        for(Question question : questions){
//            questionMap.put(question.getId(), question);
//
//            List<Choices> choices = choicesRepository.findByQuestion(question);
//            question.setChoices(choices);
//
//            Map<Long, Choices> choicesMap = new HashMap<>();
//            for (Choices choice : choices) {
//                choicesMap.put(choice.getId(), choice);
//            }
//            questionChoicesMap.put(question.getId(), choicesMap);
//
//            List<CorrectAnswer> correctAnswers = correctAnswerRepository.findByQuestion(question);
//            question.setCorrectAnswers(correctAnswers);
//
//            Map<Long, CorrectAnswer> correctAnswersMap = new HashMap<>();
//            for (CorrectAnswer correctAnswer : correctAnswers) {
//                correctAnswersMap.put(correctAnswer.getChoice().getId(), correctAnswer);
//            }
//            questionCorrectAnswersMap.put(question.getId(), correctAnswersMap);
//        }
//
//        quiz.setQuestions(questions);
//
//
//        for(QuestionAnswerDto question : submitQuizDto.getQuestionAnswerList()){
//            if(!questionMap.containsKey(quizId) || !questionChoicesMap.containsKey(question.getQuestionId())){
//                throw new EntityNotFoundException("No Quiz or Question in Quiz with given Id's");
//            }
//            for(Long choiceId : question.getSelectedChoiceIds()){
//                if(!questionChoicesMap.get(question.getQuestionId()).containsKey(choiceId)){
//                    throw new EntityNotFoundException("No matching option for question id choiceId");
//                }
//
//
//            }
//        }
//    }
}
