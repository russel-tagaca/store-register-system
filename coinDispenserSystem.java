import java.util.*;
import java.text.DecimalFormat;

public class coinDispenserSystem
{
	static Scanner input = new Scanner(System.in); // statis Scanner outside the main method for other method use
	static DecimalFormat deciFormat = new DecimalFormat("####################.##"); // Decimal Formatting to adjust to # decimals

	public static void main(String[] args){

		int quarter = 0, dime = 0, nickel = 0, penny = 0; // initizalied & declared coin count to dispense
		boolean coinTrayInsert; // initialized coin count to dispense
		String ans; // string indicator (from user) if coin tray is available
		double payment = 0, price = 0, change; // variables for transactions

   		ans = getCoinTray(); // receive indication if coin tray is on/off

   		coinTrayInsert = evalTray(ans, coinTrayInsert = false); // evaluating user's answer

   		while (coinTrayInsert != true) // System beeps continously when tray is unavailable.
   		{
			System.out.println();
			System.out.println("******BEEP****** \nInsert Coin Tray IMMEDIATELY.. \n******BEEP******");
			System.out.println();
			ans = getCoinTray();
			coinTrayInsert = evalTray(ans, coinTrayInsert);
			System.out.println();
   		}

   		while (coinTrayInsert = true)// System runs continously when tray is available.
   		{
			int j = 0;

			if (j == 0) // condition to run the print statement once
			{
				System.out.println("******BEEP***** \nSystem Online.. \n******BEEP*****\n");

			}
			j = 1; // condition to end print statement in while loop

			change = RoundTo2Decimals(getChange(price, payment)); // converting change to only 2 decimals
			System.out.println("Your change in coins are: " + change + " cents."); // prints overall change in cents

			while (change != 0) // loops until change is 0
			{
				if (change >= .25)
				{
					quarter++;
					change -= .25;
					change = RoundTo2Decimals(change);
				}
				else if (change >= .10)
				{
					dime++;
					change -= .10;
					change = RoundTo2Decimals(change);
				}
				else if (change >= .05)
				{
					nickel++;
					change -= .05;
					change = RoundTo2Decimals(change);
				}
				else if (change < .05)
				{
					penny++;
					change -= .01;
					change = RoundTo2Decimals(change);
				}
			}
			System.out.println("Dispensing: [" + quarter + "] Quarters, ["+ dime + "] Dimes, ["+ nickel + "] Nickels, ["+ penny + "] Pennies.\n"); // prints how much coins are dispensed
		}
}

   public static String getCoinTray()
   		{
	   		System.out.println("Is the Coin Tray Inserted? [(Y)es / (N)o]");
	   		String tray = input.next();

	   		return tray;
   		}

   	public static double getChange(double paid, double balance)
	   	{
			System.out.println("How much is the customer's balance?");
			balance = input.nextDouble();
			System.out.println("How much did the customer pay?");
			paid = input.nextDouble();


		   	double change = paid - balance;
		   	System.out.println("Change is: " + deciFormat.format(change));

		   	long coinChange = (long) change;
		   	double onlyCoins = change - coinChange;

		   	return onlyCoins;
   		}

   	public static boolean evalTray(String response, boolean insert)
   		{
			if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("YES"))
			   		{
			   			insert = true;
			   			System.out.println("Coin Tray Inserted.");
			   		}

			else if (response.equalsIgnoreCase("N") || response.equalsIgnoreCase("NO"))
			   		{
			   			insert = false;
			   		}

			else
			   		{
						insert = false;
			   			System.out.println("Wrong input... Try again.");
   					}

			return insert;
   		}
   	public static double RoundTo2Decimals(double val)
   		{

	        DecimalFormat df2 = new DecimalFormat("###.##");
	        return Double.valueOf(df2.format(val));
		}

}