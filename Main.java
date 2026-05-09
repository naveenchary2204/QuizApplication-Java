import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static QuizEngine quizEngine = new QuizEngine(scanner);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getIntInput("  Enter your choice: ");
            switch (choice) {
                case 1 -> quizEngine.startQuiz();
                case 2 -> showInstructions();
                case 3 -> {
                    System.out.println("\n  Thanks for playing! Goodbye!");
                    running = false;
                }
                default -> System.out.println("  Invalid choice! Enter 1-3.");
            }
        }
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         SIMPLE QUIZ APPLICATION      ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║   1.  Start Quiz                     ║");
        System.out.println("║   2.  How to Play                    ║");
        System.out.println("║   3.  Exit                           ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    private static void showInstructions() {
        System.out.println("\n  HOW TO PLAY:");
        System.out.println("  " + "-".repeat(45));
        System.out.println("  1. Enter your name when prompted.");
        System.out.println("  2. Choose a category:");
        System.out.println("     - Java Programming");
        System.out.println("     - General Science");
        System.out.println("     - Mathematics");
        System.out.println("     - All Categories (mixed)");
        System.out.println("  3. Choose difficulty:");
        System.out.println("     - Easy   = 3 questions");
        System.out.println("     - Medium = 5 questions");
        System.out.println("     - Hard   = All questions");
        System.out.println("  4. For each question, type A, B, C or D.");
        System.out.println("  5. See your score, grade & remarks at end.");
        System.out.println("  " + "-".repeat(45));
        System.out.println("  GRADING SYSTEM:");
        System.out.println("  100%      -> S (Perfect!)");
        System.out.println("  80%-99%   -> A (Excellent)");
        System.out.println("  60%-79%   -> B (Good)");
        System.out.println("  40%-59%   -> C (Average)");
        System.out.println("  Below 40% -> F (Keep practicing)");
        System.out.println("  " + "-".repeat(45));
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) {
                System.out.println("  Please enter a valid number.");
            }
        }
    }
}
