package com.patrick.jb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> simpleOperations = Arrays.asList("+", "-", "/", "*");
    private static List<String> trigonometricOperations = Arrays.asList("cos", "sin", "atan");
    private static List<String> stackOperations = Arrays.asList("pop", "dup", "swap");
    private static File[] testCases = new File("test_cases/").listFiles();

    public static void main(String[] args) throws IOException {
        Arrays.sort(testCases);
        Deque<Double> stack;
        Scanner fileReader;
        int largestStackSize;

        for (File file : testCases) {
            if (file.isFile()) {
                stack = new ArrayDeque<>();
                fileReader = new Scanner(file, "UTF-8");
                largestStackSize = 0;

                while (fileReader.hasNext()) {
                    if (fileReader.hasNextDouble()) {
                        stack.push(fileReader.nextDouble());
                    } else {
                        String operation = fileReader.next();
                        Double x, y;
                        if (simpleOperations.contains(operation)) {
                            x = stack.pop();
                            y = stack.pop();
                            switch (operation) {
                                case "+":
                                    stack.push(x + y);
                                    break;
                                case "-":
                                    stack.push(x - y);
                                    break;
                                case "*":
                                    stack.push(x * y);
                                    break;
                                case "/":
                                    stack.push(x / y);
                                    break;
                            }
                        } else if (trigonometricOperations.contains(operation)) {
                            x = stack.pop();
                            switch (operation) {
                                case "sin":
                                    stack.push(Math.sin(x));
                                    break;
                                case "cos":
                                    stack.push(Math.cos(x));
                                    break;
                                case "atan":
                                    y = stack.pop();
                                    stack.push(Math.atan2(x, y));
                                    break;
                            }
                        } else if (stackOperations.contains(operation)) {
                            switch (operation) {
                                case "pop":
                                    stack.pop();
                                    break;
                                case "dup":
                                    stack.push(stack.getFirst());
                                    break;
                                case "swap":
                                    if (stack.size() >= 2) {
                                        x = stack.pop();
                                        y = stack.pop();
                                        stack.push(x);
                                        stack.push(y);
                                    } else System.exit(0);
                                    break;
                            }
                        } else System.exit(0);
                    }
                    largestStackSize = (largestStackSize < stack.size()) ? stack.size() : largestStackSize;
                }
                System.out.println("----------------- " + file.getName() + " -----------------");
                System.out.printf("%22s %7s%n", "Largest size reached:", largestStackSize);
                System.out.printf("%22s %7s%n", "Stack size at the end:", stack.size());
                System.out.printf("%22s %15.7f%n", "Value on top:", (!stack.isEmpty()) ? stack.getFirst() : null);
            }
        }
    }
}
