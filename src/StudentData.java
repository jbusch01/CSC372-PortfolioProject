import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
public class StudentData {
    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();
        Scanner scnr = new Scanner(System.in);
        int nextID = 1; // Starting studentID at 1

        while (true) {
            System.out.println("Please enter the student's information. Type 'done' to finish.\n");
            System.out.println("Student Name:");
            String name = scnr.nextLine().trim();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Address:");
            String address = scnr.nextLine().trim();

            double gpa = -1;
            while (true) {
                System.out.println("Enter Students GPA (0.0 - 4.0): ");
                String gpaInput = scnr.nextLine().trim();
                try {
                    gpa = Double.parseDouble(gpaInput);
                    if (gpa >= 0.0 && gpa <= 4.0) {
                        break;
                    } else {
                        System.out.println("GPA must be between 0.0 and 4.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            studentList.add(new Student(name, address, gpa, nextID));
            nextID++;

            System.out.println("Student added successfully!\n");;
        }

        // List Sorter
        Collections.sort(studentList, Comparator.comparing(Student::getName));

        // File writer
        try (FileWriter writer = new FileWriter("students.txt")) {
            for (Student s : studentList) {
                writer.write("Student ID: " + s.getStudentID() + "\n");
                writer.write("Name: " + s.getName() + "\n");
                writer.write("Address: " + s.getAddress() + "\n");
                writer.write("GPA: " + s.getGPA() + "\n");
                writer.write("---------------------\n");
            }

            System.out.println("Student data saved to students.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        scnr.close();
    }
}