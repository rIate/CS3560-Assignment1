
import java.util.List;

public class Question {
    private String type;
    private List<String> candidateAnswers;
    private boolean allowMultipleChoices;

    public Question(String type, List<String> candidateAnswers, boolean allowMultipleChoices) {
        this.type = type;
        this.candidateAnswers = candidateAnswers;
        this.allowMultipleChoices = allowMultipleChoices;
    }

    public String getType() {
        return type;
    }

    public List<String> getCandidateAnswers() {
        return candidateAnswers;
    }

    public boolean allowMultipleChoices() {
        return allowMultipleChoices;
    }
}