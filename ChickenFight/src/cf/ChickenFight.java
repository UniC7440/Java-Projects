package cf;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class ChickenFight implements ChickenInterface {
	private static double money;
	
	public ChickenFight(double money) {
		ChickenFight.money = money;
	}
	
	public void start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please give the amount of bet.\n"
		+ "Money: " + ChickenFight.money);
		
		String input1 = scan.next();
		int bet;
						
		try {
			Integer.parseInt(input1);
		} catch(Exception e) {
			System.out.println("Invalid bet is given!");
			scan.close();
			return;
		};
		
		bet = Integer.parseInt(input1);
		
		if (bet > maxBet) {
			System.out.println("Bet is too high!");
			scan.close();
		} else {
			Random rand = new Random();
			double randDouble = (rand.nextDouble()) * chance;
			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setMaximumFractionDigits(2);
			double rounded = Double.valueOf(nf.format(randDouble));
						
			if (rounded > requiredResult) {
				// means win
				ChickenFight.money += bet;
				System.out.println("\nCongrats you won!");
			} else {
				// means lose
				ChickenFight.money -= bet;
				System.out.println("\nAww you lost!");
			}
			
			System.out.println("Would you like to try again? (yes/no default: no)");
			String input2 = scan.next();
			
			if (input2.equalsIgnoreCase("yes")) {
				System.out.println("\n");
				this.start();
			} else {
				System.out.println("\nThank you for playing!");
				scan.close();
			};
		}
	}
}