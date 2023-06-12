import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {
        
        Random random = new Random();
        // Ramdomly generate number of student in bound of 50
        int numStudents = random.nextInt(50);
        List<Student> students = generateStudents(numStudents);

        // Configure question and generate answers
        Question question1 = new Question("multiple-choice", Arrays.asList("A", "B", "C", "D"), true);
        VotingService votingService1 = new VotingService();
        System.out.println(question1.getType());
        votingService1.configureQuestion(question1);
        simulateVoting(votingService1, students);
        votingService1.displayResult();

        Question question2 = new Question("single-choice", Arrays.asList("1. Right", "2. Wrong"), false);
        VotingService votingService2 = new VotingService();
        votingService2.configureQuestion(question2);
        System.out.println(question2.getType());
        simulateVoting(votingService2, students);
        votingService2.displayResult();

        Question question3 = new Question("multiple-choice", Arrays.asList("1", "2", "3", "4", "5"), true);
        VotingService votingService3 = new VotingService();
        votingService3.configureQuestion(question3);
        System.out.println(question3.getType());
        simulateVoting(votingService3, students);
        votingService3.displayResult();
    }

    private static void simulateVoting(VotingService votingService, List<Student> students) {
        for (Student student : students) {
            List<String> selectedChoices = new ArrayList<>();
            List<String> candidateAnswers = votingService.getQuestion().getCandidateAnswers();
            if (votingService.getQuestion().allowMultipleChoices()) {
                // Randomly select the number of choices to be selected by the student
                int numChoices = new Random().nextInt(votingService.getQuestion().getCandidateAnswers().size()) + 1;

                // Randomly select the choices for the student
                for (int i = 0; i < numChoices; i++) {
                    String choice = candidateAnswers.get(new Random().nextInt(candidateAnswers.size()));
                    selectedChoices.add(choice);
                }
            }
            else {
                String choice = candidateAnswers.get(new Random().nextInt(candidateAnswers.size()));
                selectedChoices.add(choice);
            }

            // Submit the selected choices to the iVote Service
            student.submitAnswer(selectedChoices);
            votingService.acceptSubmission(student);
        }
    }

    private static List<Student> generateStudents(int numStudents) {
        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= numStudents; i++) {
            students.add(new Student("SID" + i));
        }

        return students;
    }
}