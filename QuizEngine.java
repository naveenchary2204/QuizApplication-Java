import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class QuizEngine {
    private Scanner scanner;
    private QuestionBank bank;

    // HashMap to track user's answers: question index -> user's answer char
    private HashMap<Integer, Character> userAnswers = new HashMap<>();

    public QuizEngine(Scanner scanner) {
        this.scanner = scanner;
        this.bank    = new QuestionBank();
    }

    // ── Start Quiz ────────────────────────────────────────────
    public void startQuiz() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         SIMPLE QUIZ APPLICATION      ║");
        System.out.println("╚══════════════════════════════════════╝");

        // Step 1: Get player name
        System.out.print("\n  Enter your name: ");
        String playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) playerName = "Player";

        // Step 2: Choose category
        ArrayList<Question> questions = chooseCategoryAndGetQuestions();
        if (questions == null || questions.isEmpty()) {
            System.out.println("  No questions available. Returning to menu.");
            return;
        }

        // Step 3: Choose difficulty (number of questions)
        int numQuestions = chooseDifficulty(questions.size());

        // Trim list to chosen count
        ArrayList<Question> selectedQuestions = new ArrayList<>(questions.subList(0, numQuestions));

        // Step 4: Run the quiz
        System.out.println("\n  Ready, " + playerName + "! Quiz starts now.");
        System.out.println("  Type A, B, C, or D for each answer.");
        System.out.println("  " + "=".repeat(55));

        userAnswers.clear();
        int score = 0;

        for (int i = 0; i < selectedQuestions.size(); i++) {
            Question q = selectedQuestions.get(i);
            q.display(i + 1);

            char answer = getValidAnswer("  Your answer (A/B/C/D): ");
            userAnswers.put(i, answer);

            if (q.isCorrect(answer)) {
                System.out.println("  ✔ Correct!");
                score++;
            } else {
                System.out.println("  ✘ Wrong! Correct answer: " + q.getCorrectAnswer());
                System.out.println("  Explanation: " + q.getExplanation());
            }
        }

        // Step 5: Show final results
        showResults(playerName, score, selectedQuestions);
    }

    // ── Category Selection ────────────────────────────────────
    private ArrayList<Question> chooseCategoryAndGetQuestions() {
        java.util.List<String> categories = bank.getCategories();

        System.out.println("\n  Choose a Category:");
        System.out.println("  " + "-".repeat(35));
        System.out.println("    0) All Categories");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println("    " + (i + 1) + ") " + categories.get(i));
        }
        System.out.println("  " + "-".repeat(35));

        int choice = -1;
        while (choice < 0 || choice > categories.size()) {
            System.out.print("  Enter choice: ");
            try { choice = Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("  Please enter a valid number."); }
        }

        if (choice == 0) return bank.getAllQuestions();
        return bank.getQuestions(categories.get(choice - 1));
    }

    // ── Difficulty Selection ──────────────────────────────────
    private int chooseDifficulty(int maxQuestions) {
        System.out.println("\n  Choose Difficulty:");
        System.out.println("  " + "-".repeat(35));
        int easy   = Math.min(3, maxQuestions);
        int medium = Math.min(5, maxQuestions);
        int hard   = maxQuestions;
        System.out.println("    1) Easy   (" + easy   + " questions)");
        System.out.println("    2) Medium (" + medium + " questions)");
        System.out.println("    3) Hard   (" + hard   + " questions - all)");
        System.out.println("  " + "-".repeat(35));

        int choice = -1;
        while (choice < 1 || choice > 3) {
            System.out.print("  Enter choice (1/2/3): ");
            try { choice = Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("  Please enter 1, 2, or 3."); }
        }
        return choice == 1 ? easy : choice == 2 ? medium : hard;
    }

    // ── Show Final Results ────────────────────────────────────
    private void showResults(String name, int score, ArrayList<Question> questions) {
        int total = questions.size();
        double percent = (double) score / total * 100;
        String grade = getGrade(percent);
        String remark = getRemark(percent);

        System.out.println("\n  " + "=".repeat(55));
        System.out.println("              QUIZ RESULTS");
        System.out.println("  " + "=".repeat(55));
        System.out.printf("  Player     : %s%n", name);
        System.out.printf("  Score      : %d / %d%n", score, total);
        System.out.printf("  Percentage : %.1f%%%n", percent);
        System.out.printf("  Grade      : %s%n", grade);
        System.out.printf("  Remark     : %s%n", remark);
        System.out.println("  " + "=".repeat(55));

        // Score bar
        System.out.print("  Progress   : [");
        int filled = (int)(percent / 5);
        for (int i = 0; i < 20; i++) System.out.print(i < filled ? "#" : "-");
        System.out.printf("] %.0f%%%n", percent);
        System.out.println("  " + "=".repeat(55));
    }

    private String getGrade(double percent) {
        if (percent == 100) return "S (Perfect!)";
        if (percent >= 80)  return "A";
        if (percent >= 60)  return "B";
        if (percent >= 40)  return "C";
        return "F (Need more practice)";
    }

    private String getRemark(double percent) {
        if (percent == 100) return "Outstanding! Perfect score!";
        if (percent >= 80)  return "Excellent! Great job!";
        if (percent >= 60)  return "Good! Keep it up!";
        if (percent >= 40)  return "Average. You can do better!";
        return "Keep practicing. You'll improve!";
    }

    // ── Input Helper ──────────────────────────────────────────
    private char getValidAnswer(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1 && "ABCD".contains(input)) {
                return input.charAt(0);
            }
            System.out.println("  Invalid! Please enter A, B, C, or D only.");
        }
    }
}
