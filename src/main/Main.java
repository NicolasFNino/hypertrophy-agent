package main;

import java.util.Scanner;

import main.UserProfile;

public class Main {
    public static void main(String[] args) {
        UserProfile profile = setupProfile();
        System.out.println("\nUser Profile Created:" + profile.toString());

        profile.workoutPlan = profile.generateWorkoutPlan();
        profile.workoutPlan.populatePlan();
        System.out.println("\nGenerated Workout Plan:" + profile.workoutPlan.toString());
    }

    /***
     * Sets up the user profile by collecting user input.
     * @return A UserProfile object populated with user data.
     */
    private static UserProfile setupProfile() {
        System.out.println("Hello, Hypertrophy Agent here!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Welcome, " + name + "!\nLet's get started with your fitness journey.");

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Great! At " + age + " years old, you're at a perfect age to build muscle and strength.");

        System.out.println("\nEnter the number corresponding to your target program: \n" +
         "1. Muscle Gain\n2. Fat Loss\n3. Strength trainning\n4. Not sure yet");
        int targetProgram = scanner.nextInt();
        String programName = switch (targetProgram) {
            case 1 -> "Muscle Gain";
            case 2 -> "Fat Loss";
            case 3 -> "Strength Training";
            default -> "Undecided";
        };

        System.out.println("You've chosen the " + programName + " program. Excellent choice!");
        System.out.print("\nWhat would you say is your experience level in training? (1-5): ");
        int experienceLevel = scanner.nextInt();
        System.out.println("Thanks for sharing your experience level of " + experienceLevel + ". This will help us tailor your program to suit your needs.");

        System.out.print("\nEnter your weight (in Lbs): ");
        double weight = scanner.nextDouble();
        System.out.println("Awesome! Weighing " + weight + " Lbs gives us a good starting point for your training plan.");

        System.out.print("\nEnter the number of days you can realistacaslly train per week (1-7): ");
        int trainingDays = scanner.nextInt();
        System.out.println("Perfect! Training " + trainingDays + " days a week will allow us to create an effective workout schedule.");

        System.out.print("\nEnter the number of hours you can commit to training each day: ");
        int trainingHours = scanner.nextInt();
        System.out.println("Excellent! Committing " + trainingHours + " hours per day will help us maximize your progress.");

        System.out.println("\nThank you for providing your details, " + name + "! Let's embark on this fitness journey together and achieve your goals.");  
        scanner.close();

        UserProfile profile = new UserProfile(name, age, weight, programName, trainingDays, trainingHours, experienceLevel);
        return profile;
    }
}