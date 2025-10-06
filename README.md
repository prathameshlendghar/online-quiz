Partially Developed till now (Working on it)

# Online Quiz API
A RESTful API designed to handle quiz creation, question management, and quiz delivery.

---
## Functional Requirements

### 📘 Quiz Management

- Full **CRUD operations** for quizzes (Create, Read, Update, Delete).
- Ability to manage questions within a quiz, including:
    - Defining question text.
    - Adding multiple choices.
    - Marking correct answers.
- Support for **multiple question types**:
    - **Multiple Choice Questions (MCQs)**:
        - Single-select
        - Multi-select
    - **Text-based Answers** (subjective)

---

### ‍💻 Quiz Participation (Taking a Quiz)

- Users can retrieve a quiz along with all its questions and available answer options.
- Users can submit their answers for a given quiz.
- Upon submission:
    - The system immediately calculates and returns a **score** for MCQ-type questions.
    - **Text-based answers** are excluded from automatic scoring and must be evaluated manually by the quiz creator (or admin).

    