package org.kahootcase;

public class TopDomains {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        if (args.length == 1) {
            try {
                Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }
            inputReader = new InputReader(Integer.parseInt(args[0]));
        }
        else if (args.length == 2) {
            try {
                Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }
            inputReader = new InputReader(Integer.parseInt(args[0]), args[1]);
        }
        inputReader.run();
    }
}