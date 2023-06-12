
import java.util.HashMap;
import java.util.Map;

public class VotingService {
    private Question question;
    private Map<String, Student> submissions;

    public VotingService() {
        submissions = new HashMap<>();
    }

    public void configureQuestion(Question question) {
        this.question = question;
    }

    public void acceptSubmission(Student student) {
        submissions.put(student.getId(), student);
    }

    public void displayResult() {
        Map<String, Integer> answerCounts = new HashMap<>();

        for (Student student : submissions.values()) {
            String answer = student.getAnswer();
            answerCounts.put(answer, answerCounts.getOrDefault(answer, 0) + 1);
        }

        for (String answer : question.getCandidateAnswers()) {
            int count = answerCounts.getOrDefault(answer, 0);
            System.out.println(answer + " : " + count);
        }
        System.out.println("");
    }

    public Question getQuestion() {
        return this.question;
    }
}
