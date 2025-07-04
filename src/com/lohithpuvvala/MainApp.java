package com.lohithpuvvala;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        // Create a list of quiz questions
        List<Question> questions = new ArrayList<>();

        // Add questions with options and correct answer index
        questions.add(new Question("What is the capital of India?",
                new String[]{"New Delhi", "Delhi", "Mumbai", "Pune"}, 0));
        questions.add(new Question("What is the capital of USA?",
                new String[]{"New York", "Washington", "Los Angeles", "Chicago"}, 1));
        questions.add(new Question("What is the capital of France?",
                new String[]{"Paris", "London", "Berlin", "Rome"}, 0));
        questions.add(new Question("What is the capital of Australia?",
                new String[]{"Canberra", "Sydney", "Melbourne", "Brisbane"}, 0));
        questions.add(new Question("What is the capital of China?",
                new String[]{"Beijing", "Shanghai", "Guangzhou", "Shenzhen"}, 0));
        questions.add(new Question("What is the capital of Japan?",
                new String[]{"Tokyo", "Osaka", "Nagoya", "Kyoto"}, 0));
        questions.add(new Question("What is the capital of Russia?",
                new String[]{"Moscow", "Saint Petersburg", "Kiev", "Samara"}, 0));
        questions.add(new Question("What is the capital of Indonesia?",
                new String[]{"Jakarta", "Semarang", "Bandung", "Pekanbaru"}, 0));
        questions.add(new Question("What is the capital of Netherlands?",
                new String[]{"Amsterdam", "Berlin", "Rotterdam", "Utrecht"}, 0));

        Scanner in = new Scanner(System.in); // Scanner declared outside the loop

        int userAnswer;

        while (true) {
            // Shuffle questions to show in random order each time
            Collections.shuffle(questions);
            int score = 0;

            System.out.println("\n===== Welcome to the Quiz! =====\n");

            // Loop through each question
            for (int i = 0; i < questions.size(); i++) {
                Question question = questions.get(i);
                System.out.println("Question " + (i + 1) + ":");
                question.displayQuestion();

                // Get and validate user input
                while (true) {
                    System.out.print("Enter your answer (1-4): ");
                    if (in.hasNextInt()) {
                        userAnswer = in.nextInt();
                        if (userAnswer >= 1 && userAnswer <= 4) {
                            break;
                        }
                    } else {
                        in.next(); // clear invalid input
                    }
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }

                // Check answer correctness
                if (question.isCorrectAnswer(userAnswer)) {
                    score++;
                    System.out.println("✅ Your answer is correct!\n");
                } else {
                    System.out.println("❌ Your answer is incorrect!\n");
                }
            }

            // Display final score
            System.out.println("===== Quiz Completed! =====");
            System.out.println("Your Score: " + score + "/" + questions.size());

            // Congratulate if full score
            if (score == questions.size()) {
                System.out.println("🎉 Congratulations! You got all answers correct!");
                break;
            }

            // Ask if the user wants to retry
            in.nextLine(); // clear newline
            System.out.print("Do you want to retry the quiz? (y/n): ");
            String continueQuiz = in.nextLine();
            if (!continueQuiz.equalsIgnoreCase("y")) {
                break;
            }
        }

        // Close scanner at the end
        in.close();
        System.out.println("Thank you for playing the quiz! 😊");
    }
}
