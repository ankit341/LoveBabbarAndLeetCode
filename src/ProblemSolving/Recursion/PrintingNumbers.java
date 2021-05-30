package ProblemSolving.Recursion;

public class PrintingNumbers {
    public static void printNumbers(int range) {
        if (range == 1) { // Base condition
            System.out.println(1);
            return;
        }
        printNumbers(range - 1); // Hypothesis
        System.out.println(range); // Induction step
    }

    public static void main(String[] args) {
        printNumbers(7);
    }
}
