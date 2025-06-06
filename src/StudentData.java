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

        System.out.println("Please enter the student's information, or type 'done' to finish.");
        while (true) {
            System.out.println("Student First Name:");
            String name = scnr.nextLine().trim();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Street address:");
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

            studentList.add(new Student(name, address, gpa));
            System.out.println("Student added successfully!\n");;
        }

        Collections.sort(studentList, Comparator.comparing(Student::getFirstName));

        try (FileWriter writer = new FileWriter("students.txt"(( {
            for (Student s : studentList) {
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
