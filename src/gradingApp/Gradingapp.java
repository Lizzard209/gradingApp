package gradingApp;

import java.util.Scanner;

public class Gradingapp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int number = 0;

		System.out.println("How many students are being graded?");
		number = scan.nextInt();
		double studentSum[] = new double[number];
		double[][] grades = new double[number][8];
		for (int row = 0; row < grades.length; row++)
			for (int col = 0; col < grades[row].length; col++)
				if (col < 4) {
					System.out.println("Enter the grades for exam " + (col + 1) + " for student " + (row + 1)
							+ " (Must be between 0 and 50)");
					grades[row][col] = scan.nextInt();
				} else {
					int assignmentNumber = (col - 3);
					System.out.println("Enter the grades for assignment " + assignmentNumber + " for student "
							+ (row + 1) + " (Must be between 0 and 75)");

					grades[row][col] = scan.nextInt();
				}
		for (int row = 0; row < grades.length; row++) {
			for (int col = 0; col < grades[row].length; col++) {
				studentSum[row] = studentSum[row] + grades[row][col];
			}
		}
		// to print table
		System.out.println("This is your array:");
		for (int row = 0; row < grades.length; row++) {
			for (int col = 0; col < grades[row].length; col++)
				System.out.print(grades[row][col] + "\t");
			System.out.println();
		}
		for (int i = 0; i < studentSum.length; i++) {
			System.out.println("The sum of student " + (i + 1) + " before curve is: ");
			System.out.print(studentSum[i] + "\n");

			String letterGrade="";
			if (studentSum[i] >= 450) {
				letterGrade = "A";
				System.out.print(studentSum[i] + "\n");
			}
			else if (studentSum[i] >= 400 && studentSum[i] < 450) {
				letterGrade = "B";
				System.out.print(studentSum[i] + "\n");
			}
			else if (studentSum[i] >= 350 && studentSum[i] < 400) {
				letterGrade = "C";
				System.out.print(studentSum[i] + "\n");
			}
			else if (studentSum[i] >= 300 && studentSum[i] < 350) {
				letterGrade = "D";
				System.out.print(studentSum[i] + "\n");
			}
			else if (studentSum[i] < 300) {
				letterGrade = "F";
				System.out.print(studentSum[i] + "\n");

				

			}
			System.out.println("Student " + (i + 1) + " grade: " + (letterGrade));
		}
		calculateSD(studentSum);

	}

	public static void calculateSD(double studentSum[]) {
		double sum = 0.0, standardDeviation = 0.0;
		int length = studentSum.length;

		for (double num : studentSum) {
			sum += num;
		}

		double mean = sum / length;

		for (double num : studentSum) {
			standardDeviation += Math.pow(num - mean, 2);
		}
		double SD = Math.sqrt(standardDeviation / length);
		for (int i = 0; i < studentSum.length; i++) {
			System.out.println("The sum of student " + (i + 1) + " after curve is: ");
			System.out.print(studentSum[i] + "\n");

			String letterGrade="";
			if (studentSum[i] >= (mean + 2 * SD)) {
				letterGrade = "A";
			}
			else if(studentSum[i] >= (mean + 1 * SD) && (studentSum[i] < (mean + 2 * SD))) {
				letterGrade = "B";
			}
			else if (studentSum[i] >= (mean) && (studentSum[i] < (mean + 1 * SD))) {
				letterGrade = "C";
			}
			else if (studentSum[i] >= (mean - 1 * SD) && (studentSum[i] < (mean))) {
				letterGrade = "D";
			}
			else if (studentSum[i] < 300) {
				letterGrade = "F";


			}
			System.out.println("Student " + (i + 1) + " grade: " + (letterGrade));
		}

	}
}
