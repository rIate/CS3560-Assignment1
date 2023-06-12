
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private List<String> selectedChoices;

    public Student(String id) {
        this.id = id;
        selectedChoices = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void submitAnswer(List<String> selectedChoices) {
        this.selectedChoices = selectedChoices;
    }

    public List<String> getSelectedChoices() {
        return selectedChoices;
    }
}