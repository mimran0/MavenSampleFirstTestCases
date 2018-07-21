import java.util.Scanner;

/**
 * @author md shahajada imran
 *
 */
public class StockApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter 52 weeks High");
		double v52WeeksHigh = sc.nextDouble();
		System.out.println("Please Enter 52 weeks low");
		double v52WeeksLow = sc.nextDouble();
		System.out.println("Please Enter Current Price");
		double vCurrentPrice = sc.nextDouble();
		Valiation(v52WeeksHigh, v52WeeksLow, vCurrentPrice);
	}

	public static void Valiation(double v52WeeksHigh, double v52WeeksLow, double vCurrentPrice) {
		double Gap = v52WeeksHigh - v52WeeksLow;
		if (vCurrentPrice < (v52WeeksLow + Gap / 2) == true) {
			System.out.println("Please Buy");
		} else {
			System.out.println("Do Not Buy");
		}
	}

}