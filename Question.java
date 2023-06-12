import java.util.List;

public class Question {
    private String type;
    private List<String> candidateAnswers;

    public Question(String type, List<String> candidateAnswers) {
        this.type = type;
        this.candidateAnswers = candidateAnswers;
    }

    public String getType() {
        return type;
    }

    public List<String> getCandidateAnswers() {
        return candidateAnswers;
    }
}