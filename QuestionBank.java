import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class QuestionBank {

    // HashMap stores questions grouped by category
    private HashMap<String, ArrayList<Question>> categoryMap = new HashMap<>();

    public QuestionBank() {
        loadJavaQuestions();
        loadGeneralScienceQuestions();
        loadMathQuestions();
    }

    // ── Java Questions ────────────────────────────────────────
    private void loadJavaQuestions() {
        ArrayList<Question> javaQs = new ArrayList<>();

        javaQs.add(new Question(
            "Which keyword is used to create a class in Java?",
            Arrays.asList("define", "struct", "class", "object"),
            2, "'class' is the keyword used to define a class in Java."
        ));
        javaQs.add(new Question(
            "What is the default value of an int variable in Java?",
            Arrays.asList("null", "1", "undefined", "0"),
            3, "In Java, the default value of an int is 0."
        ));
        javaQs.add(new Question(
            "Which collection allows duplicate elements?",
            Arrays.asList("HashSet", "TreeSet", "ArrayList", "LinkedHashSet"),
            2, "ArrayList allows duplicate elements and maintains insertion order."
        ));
        javaQs.add(new Question(
            "What does OOP stand for?",
            Arrays.asList("Object Oriented Programming", "Open Operational Process",
                          "Object Order Protocol", "Operational Output Program"),
            0, "OOP stands for Object Oriented Programming."
        ));
        javaQs.add(new Question(
            "Which method is the entry point of a Java program?",
            Arrays.asList("start()", "run()", "init()", "main()"),
            3, "public static void main(String[] args) is the entry point of a Java program."
        ));
        javaQs.add(new Question(
            "Which of these is NOT a Java primitive type?",
            Arrays.asList("int", "boolean", "String", "char"),
            2, "String is a class in Java, not a primitive type."
        ));
        javaQs.add(new Question(
            "What does HashMap store data as?",
            Arrays.asList("Single values", "Key-Value pairs", "Sorted lists", "Stacks"),
            1, "HashMap stores data as key-value pairs for fast retrieval."
        ));
        javaQs.add(new Question(
            "Which access modifier makes a member accessible everywhere?",
            Arrays.asList("private", "protected", "default", "public"),
            3, "'public' allows access from any class in any package."
        ));

        categoryMap.put("Java Programming", javaQs);
    }

    // ── General Science Questions ─────────────────────────────
    private void loadGeneralScienceQuestions() {
        ArrayList<Question> sciQs = new ArrayList<>();

        sciQs.add(new Question(
            "What is the chemical symbol for water?",
            Arrays.asList("WA", "H2O", "HO2", "W2O"),
            1, "Water is H2O — two hydrogen atoms bonded to one oxygen atom."
        ));
        sciQs.add(new Question(
            "Which planet is known as the Red Planet?",
            Arrays.asList("Venus", "Jupiter", "Mars", "Saturn"),
            2, "Mars is called the Red Planet due to iron oxide (rust) on its surface."
        ));
        sciQs.add(new Question(
            "What is the speed of light (approx)?",
            Arrays.asList("3x10^6 m/s", "3x10^8 m/s", "3x10^10 m/s", "3x10^4 m/s"),
            1, "Speed of light is approximately 3x10^8 meters per second."
        ));
        sciQs.add(new Question(
            "How many bones are in the adult human body?",
            Arrays.asList("196", "206", "216", "226"),
            1, "An adult human body has 206 bones."
        ));
        sciQs.add(new Question(
            "What gas do plants absorb during photosynthesis?",
            Arrays.asList("Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"),
            2, "Plants absorb CO2 and release O2 during photosynthesis."
        ));
        sciQs.add(new Question(
            "Which is the largest organ in the human body?",
            Arrays.asList("Liver", "Brain", "Skin", "Heart"),
            2, "Skin is the largest organ, covering the entire body."
        ));

        categoryMap.put("General Science", sciQs);
    }

    // ── Math Questions ────────────────────────────────────────
    private void loadMathQuestions() {
        ArrayList<Question> mathQs = new ArrayList<>();

        mathQs.add(new Question(
            "What is the value of Pi (approx)?",
            Arrays.asList("3.14", "2.71", "1.61", "3.41"),
            0, "Pi (π) is approximately 3.14159..."
        ));
        mathQs.add(new Question(
            "What is 12 x 12?",
            Arrays.asList("124", "144", "134", "154"),
            1, "12 multiplied by 12 equals 144."
        ));
        mathQs.add(new Question(
            "What is the square root of 144?",
            Arrays.asList("11", "13", "12", "14"),
            2, "sqrt(144) = 12, because 12 x 12 = 144."
        ));
        mathQs.add(new Question(
            "How many degrees are in a right angle?",
            Arrays.asList("45", "180", "360", "90"),
            3, "A right angle is exactly 90 degrees."
        ));
        mathQs.add(new Question(
            "What is 2 to the power of 10?",
            Arrays.asList("512", "1024", "2048", "256"),
            1, "2^10 = 1024."
        ));
        mathQs.add(new Question(
            "What is the perimeter of a square with side 5?",
            Arrays.asList("10", "25", "15", "20"),
            3, "Perimeter = 4 x side = 4 x 5 = 20."
        ));

        categoryMap.put("Mathematics", mathQs);
    }

    // Get all category names
    public List<String> getCategories() {
        return new ArrayList<>(categoryMap.keySet());
    }

    // Get questions for a category
    public ArrayList<Question> getQuestions(String category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    // Get ALL questions combined
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> all = new ArrayList<>();
        for (ArrayList<Question> qs : categoryMap.values()) all.addAll(qs);
        return all;
    }
}
