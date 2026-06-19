import java.util.Scanner;

class Student {

    String name;
    String[] subjects;
    int[] marks;

    Student(String name, int subjectCount) {
        this.name = name;
        this.subjects = new String[subjectCount];
        this.marks = new int[subjectCount];
    }

    void calculateAndDisplay() {

        System.out.println("\n===============================");
        System.out.println("Student Name: " + name);

        int sum = 0;
        int highest = marks[0];
        int lowest = marks[0];

        for (int i = 0; i < marks.length; i++) {

            System.out.println(subjects[i] + " : " + marks[i]);

            sum += marks[i];

            if (marks[i] > highest) highest = marks[i];
            if (marks[i] < lowest) lowest = marks[i];
        }

        double average = (double) sum / marks.length;

        System.out.println("Total Marks: " + sum);
        System.out.printf("Average    : %.2f%n", average);
        System.out.println("Highest    : " + highest);
        System.out.println("Lowest     : " + lowest);
        System.out.println("===============================");
    }

    double getAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }
}

 class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== STUDENT GRADE MANAGEMENT SYSTEM =====");

        System.out.print("Enter number of students: ");
        int studentCount = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[studentCount];

        // INPUT
        for (int i = 0; i < studentCount; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Number of subjects: ");
            int subjectCount = sc.nextInt();
            sc.nextLine();

            Student s = new Student(name, subjectCount);

            for (int j = 0; j < subjectCount; j++) {

                System.out.print("Enter subject " + (j + 1) + ": ");
                s.subjects[j] = sc.nextLine();

                System.out.print("Enter marks: ");
                s.marks[j] = sc.nextInt();
                sc.nextLine();
            }

            students[i] = s;
        }

        // REPORT
        System.out.println("\n\n========== ALL STUDENTS REPORT ==========");

        for (int i = 0; i < studentCount; i++) {
            students[i].calculateAndDisplay();
        }

        // CLASS SUMMARY
        System.out.println("\n========== CLASS SUMMARY ==========");

        Student top = students[0];

        for (int i = 1; i < studentCount; i++) {
            if (students[i].getAverage() > top.getAverage()) {
                top = students[i];
            }
        }

        System.out.println("Top Student: " + top.name);
        System.out.printf("Highest Average: %.2f%n", top.getAverage());

        sc.close();
    }
}