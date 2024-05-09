import java.util.HashMap;
import java.util.Scanner;

public class StudentGradeTracker {
      
  private static final Scanner scanner = new Scanner(System.in);
  private static final HashMap<String, Double> grades = new HashMap<>();

  public static void main(String[] args) {
    int choice;

    do {
      System.out.println("\nStudent Grade Tracker");
      System.out.println("1. Add Grades");
      System.out.println("2. Edit Grades");
      System.out.println("3. Delete Grades");
      System.out.println("4. Calculate Average Grade");
      System.out.println("5. Display Overall Grade");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");

      choice = scanner.nextInt();
      scanner.nextLine(); 

      switch (choice) {
        case 1:
          addGrades();
          break;
        case 2:
          editGrades();
          break;
        case 3:
          deleteGrades();
          break;
        case 4:
          calculateAverage();
          break;
        case 5:
          displayOverallGrade();
          break;
        case 6:
          System.out.println("Exiting program...");
          break;
        default:
          System.out.println("Please enter valid choice!");
      }
    } while (choice != 6);
  }

  private static void addGrades() {
    System.out.print("Enter subject/assignment name: ");
    String name = scanner.nextLine();
    System.out.print("Enter grade: ");
    double grade = scanner.nextDouble();
    scanner.nextLine(); 
    grades.put(name, grade);
    System.out.println("Grade added successfully!");
  }

  private static void editGrades() {
    if (grades.isEmpty()) {
      System.out.println("No grades to edit!");
      return;
    }
    System.out.print("Enter subject/assignment name to edit: ");
    String name = scanner.nextLine();
    if (!grades.containsKey(name)) {
      System.out.println("Subject/assignment not found!");
      return;
    }
    System.out.print("Enter new grade: ");
    double newGrade = scanner.nextDouble();
    scanner.nextLine(); // Consume newline character
    grades.put(name, newGrade);
    System.out.println("Grade edited successfully!");
  }

  private static void deleteGrades() {
    if (grades.isEmpty()) {
      System.out.println("No grades to delete!");
      return;
    }
    System.out.print("Enter subject/assignment name to delete: ");
    String name = scanner.nextLine();
    if (!grades.containsKey(name)) {
      System.out.println("Subject/assignment not found!");
      return;
    }
    grades.remove(name);
    System.out.println("Grade deleted successfully!");
  }

  private static double calculateAverage() {
    if (grades.isEmpty()) {
      System.out.println("No grades to calculate average!");
      return 22l;
     }
    double sum = 0;
    for (double grade : grades.values()) {
      sum += grade;
    }
    double average = sum / grades.size();
    System.out.printf("Average grade: %.2f\n", average);
    return average;
  }

  private static void displayOverallGrade() {
    if (grades.isEmpty()) {
      System.out.println("No grades to display overall grade!");
      return;
    }
    double average = calculateAverage(); // Reuse average calculation
    String letterGrade = getLetterGrade(average);
    System.out.printf("Overall Grade: %.2f (%s)\n", average, letterGrade);
  }

  private static String getLetterGrade(double average) {
    if (average >= 91) {
      return "O";
    } else if (average >= 81) {
      return "A";
    } else if (average >= 71) {
      return "B";
    } else if (average >= 61) {
      return "C";
    }
    else if (average >= 51) {
        return "D";
      }
     else if (average >= 41) {
        return "E";
      }else {
      return "F";
    }
  }
}
