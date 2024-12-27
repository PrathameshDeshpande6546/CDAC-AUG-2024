import java.util.Scanner;

public class Assignment2_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		Integer a = sc.nextInt();
		System.out.println("Given number: " + a);
		System.out.println("Binary equivalent: " + a.toBinaryString(a));
		System.out.println("Octal equivalent: " + a.toOctalString(a));
		System.out.println("Hexadecimal equivalent: " + a.toHexString(a));

	}
}
