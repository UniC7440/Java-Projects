package cf;
import java.util.Random;
import java.util.Scanner;

public class ChickenFight implements ChickenInterface {
	public static double money = 100;
	
	public ChickenFight(double money) {
		ChickenFight.money = money;
	}
	
	public double GenerateNum() {
		Random rand = new Random();
		return rand.nextDouble();
	}
	
	public void start() {
		System.out.println("How much would you like to bet?");
		Scanner scan = new Scanner(System.in);
		
		if(!scan.hasNextDouble()) {
			System.out.println("Please give a proper amount of bet!");
			scan.close();
			return;
		} else {
			double bet = scan.nextDouble();
			
			if (bet > maxBet) {
				System.out.println("Cannot bet more than " + maxBet);
				scan.close();
				return;
			} else if (bet <= 0) {
				System.out.println("You can only bet more than 0");
				scan.close();
				return;
			} else {
				double res = this.GenerateNum() * chance;
				
				if (res < requiredNumber) {
					System.out.println("Aww you loss!");
					ChickenFight.money -= bet;
					System.out.println("Money now: " + ChickenFight.money);
					
					scan.close();
					return;
				} else {
					System.out.println("You won!");
					ChickenFight.money += bet;
					System.out.println("Money now: " + ChickenFight.money);
					
					scan.close();
					return;
				}
			}
		}
	}
}