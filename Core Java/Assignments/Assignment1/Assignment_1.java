import java.util.Scanner;

public class Assignment_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1st value");
		double a;
		double b;
		if (sc.hasNextDouble() && !sc.hasNextInt()) {
			a = sc.nextDouble();
			System.out.println("Enter 2nd value");
			if (sc.hasNextDouble() && !sc.hasNextInt()) {
				b = sc.nextDouble();
				double avg = (a + b) / 2;
				System.out.println("Average of " + a + " and " + b + " is : " + avg);
			} else {
				System.out.println("Not a double value");
			}
		} else {
			System.out.println("Not a double value");
		}

	}

}
