
import java.util.HashMap;
import java.util.List;
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
        Map<String, Integer> choiceCounts = new HashMap<>();

        for (Student student : submissions.values()) {
            List<String> selectedChoices = student.getSelectedChoices();
            for (String choice : selectedChoices) {
                choiceCounts.put(choice, choiceCounts.getOrDefault(choice, 0) + 1);
            }
        }

        for (String choice : question.getCandidateAnswers()) {
            int count = choiceCounts.getOrDefault(choice, 0);
            System.out.println(choice + " : " + count);
        }

        System.out.println("");
    }

    public Question getQuestion() {
        return question;
    }
}