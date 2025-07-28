package com.sahil;

import javax.swing.text.html.parser.TagElement;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String name;
    int rollnumber;
    int age;
    String course;
    String email;
    String phonenumber;
    Student(String name, int rollnumber, int age, String course, String email, String phonenumber){
        this.name = name;
        this.rollnumber=rollnumber;
        this.age = age;
        this.course = course;
        this.email = email;
        this.phonenumber = phonenumber;
    }




}
public class Main {

    static ArrayList<Student> List1 = new ArrayList<Student>();


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        List1.add(new Student("sidd mokal", 21,22,"java", "java@jav.com", "996756"));
        System.out.println("Welcome to Student management System");
        System.out.println("------------------------------------");
        System.out.println("Please select a below operation");
        System.out.println("1: Add a Student");
        System.out.println("2: View all records");
        System.out.println("3: Update a record");
        System.out.println("4: Delete a record");
        System.out.println("5. Total number of students");
        System.out.println("6: Exit");


        while(true){
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    countStudents();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        }

    }

    private static void deleteStudent() {
        System.out.println("Enter roll number of the student to delete:");
        int rollToDelete = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < List1.size(); i++) {
            if (List1.get(i).rollnumber == rollToDelete) {
                List1.remove(i);
                System.out.println("Student record deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with roll number " + rollToDelete + " not found.");
        }
    }


    private static void updateStudent() {
        System.out.println("Enter roll number of the student to update:");
        int rollToUpdate = sc.nextInt();
        boolean found = false;

        for (Student student : List1) {
            if (student.rollnumber == rollToUpdate) {
                found = true;
                sc.nextLine();
                System.out.println("Enter new name:");
                student.name = sc.nextLine();
                System.out.println("Enter new age:");
                student.age = sc.nextInt();
                System.out.println("Enter new course:");
                student.course = sc.next();
                System.out.println("Enter new email:");
                student.email = sc.next();
                System.out.println("Enter new phone number:");
                student.phonenumber = sc.next();
                System.out.println("Student record updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with roll number " + rollToUpdate + " not found.");
        }
    }


    private static void viewStudent() {
        System.out.println("Directory of Students");
        if(List1.isEmpty()){
            System.out.println("Currently there are no student records");
        }
        else{
            for(Student student: List1){
                System.out.println(
                        "Student Name: " + student.name +
                                ", Roll No: " + student.rollnumber +
                                ", Age: " + student.age +
                                ", Course: " + student.course +
                                ", Email: " + student.email +
                                ", Phone: " + student.phonenumber
                );

            }
        }

    }

    private static void addStudent() {
        sc.nextLine();
        System.out.println("Enter name");
        String names = sc.nextLine();  // ✅ Only one nextLine()

        System.out.println("Enter rollnumber");
        int rolls = sc.nextInt();
        // ✅ Clear buffer before reading nextLine or next with strings

        System.out.println("Enter age");
        int ages = sc.nextInt();


        System.out.println("Enter course");
        String courses = sc.next();

        System.out.println("Enter email");
        String emails = sc.next();

        System.out.println("Enter phone number");
        String phones = sc.nextLine();

        List1.add(new Student(names, rolls, ages, courses, emails, phones));
        System.out.println("Student added successfully");
        viewStudent();
    }

    public static void countStudents() {
        System.out.println("Total number of students: " + List1.size());
    }

}
