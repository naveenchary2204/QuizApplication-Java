import java.util.ArrayList;
import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;      // 4 options stored in ArrayList
    private int correctOptionIndex;    // 0=A, 1=B, 2=C, 3=D
    private String explanation;        // Why the answer is correct

    public Question(String questionText, List<String> options, int correctOptionIndex, String explanation) {
        if (options.size() != 4) throw new IllegalArgumentException("Each question must have exactly 4 options.");
        this.questionText   = questionText;
        this.options        = new ArrayList<>(options);
        this.correctOptionIndex = correctOptionIndex;
        this.explanation    = explanation;
    }

    // Display the question and options
    public void display(int questionNumber) {
        System.out.println("\n  Q" + questionNumber + ". " + questionText);
        System.out.println("  " + "-".repeat(55));
        char label = 'A';
        for (String option : options) {
            System.out.println("    " + label + ") " + option);
            label++;
        }
        System.out.println("  " + "-".repeat(55));
    }

    // Check if the given answer (A/B/C/D) is correct
    public boolean isCorrect(char answer) {
        int index = Character.toUpperCase(answer) - 'A';
        return index == correctOptionIndex;
    }

    public String getCorrectAnswer() {
        return (char)('A' + correctOptionIndex) + ") " + options.get(correctOptionIndex);
    }

    public String getExplanation()  { return explanation; }
    public String getQuestionText() { return questionText; }
}
