import java.util.Scanner;

public class Assignment_2_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int totalBill = 0;
		String order = "";

		for (;;) {
			System.out.println("*************");
			System.out.println("Menu");
			System.out.println("1.Samosa\n2.Dosa\n3.Kolhapuri Misal\n4.Pav Bhaji\n5.VadaPav\n6.Tea\n7.Generate Bill");
			System.out.println("*************");

			int choice = sc.nextInt();
			int quantity = 1;

			switch (choice) {
			case 1:
				System.out.println("Enter Quantity");
				quantity = sc.nextInt();
				order = order + "\nSamosa";
				totalBill = totalBill + 15 * quantity;
				break;
			case 2:
				System.out.println("Enter Quantity");
				quantity = sc.nextInt();
				order = order + "\n" + "Dosa";
				totalBill = totalBill + 30 * quantity;
				break;
			case 3:
				System.out.println("Enter Quantity");
				quantity = sc.nextInt();
				order = order + "\n" + "Kolhapuri Misal";
				totalBill = totalBill + 20 * quantity;
				break;
			case 4:
				System.out.println("Enter Quantity");
				quantity = sc.nextInt();
				order = order + "\n" + "PavBhaji";
				totalBill = totalBill + 40 * quantity;
				break;
			case 5:
				System.out.println("Enter Quantity");
				quantity = sc.nextInt();
				order = order + "\n" + "VadaPav";
				totalBill = totalBill + 12 * quantity;
				break;
			case 6:
				System.out.println("Enter Quantity");
				quantity = sc.nextInt();
				order = order + "\n" + "Tea";
				totalBill = totalBill + 10 * quantity;
				break;
			case 7:
				System.out.println("Orders : " + order);
				System.out.println("Total Bill= " + totalBill + "rs");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}

}
