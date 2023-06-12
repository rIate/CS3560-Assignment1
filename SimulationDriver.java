import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {
        // Create a list of students
        Random random = new Random();
        int numStudents = random.nextInt(50);
        List<Student> students = generateStudents(numStudents);

        // Configure question
        Question question1 = new Question("multiple-choice", Arrays.asList("A", "B", "C", "D"));
        VotingService votingService1 = new VotingService();
        System.out.println(question1.getType());
        votingService1.configureQuestion(question1);
        simulateVoting(votingService1, students);

        Question question2 = new Question("single-choice", Arrays.asList("1. Right", "2. Wrong"));
        VotingService votingService2 = new VotingService();
        votingService2.configureQuestion(question2);
        System.out.println(question2.getType());
        simulateVoting(votingService2, students);

        Question question3 = new Question("multiple-choice", Arrays.asList("1", "2", "3", "4"));
        VotingService votingService3 = new VotingService();
        votingService3.configureQuestion(question3);
        System.out.println(question3.getType());
        simulateVoting(votingService3, students);
    }

    private static void simulateVoting(VotingService votingService, List<Student> students) {
        for (Student student : students) {
            // Randomly select an answer for each student
            String answer = votingService.getQuestion().getCandidateAnswers().get(new Random().nextInt(votingService.getQuestion().getCandidateAnswers().size()));
            student.submitAnswer(answer);

            // Submit the answer to the iVote Service
            votingService.acceptSubmission(student);
        }

        // Display the result
        votingService.displayResult();
    }

    private static List<Student> generateStudents(int numStudents) {
        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= numStudents; i++) {
            students.add(new Student("SID" + i));
        }

        return students;
    }
}