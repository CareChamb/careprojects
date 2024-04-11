/*
  Programmer: Caroline Chamberlain
  Date: 03/21/2024
  Programming Assignment 7 
  Purpose: This program asks the user for a lottery pool and how many numbers do you pull out of that pool then calculates the chances of winning those odds.
*/
import javax.swing.*;
import java.awt.*;

public class CarolineChamberlain_LotteryOdds {

	public static void main(String[] args) 
	{
		//Build prompt
		JPanel pnlLotteryOddsPrompt  = new JPanel(new GridLayout(2,2));
		
		JLabel  lblMaxLengthPrompt = new JLabel("Enter an amount of numbers in the pool(Max 100): ");
		JTextField txtMaxLengthPrompt = new JTextField(5);
		
		JLabel  lblNumberAmtPrompt = new JLabel("\nEnter an amount of numbers to pull(Max 10): ");
		JTextField txtNumberAmtPrompt = new JTextField(5);
		
		//Initiate variables
		String sFinalOdds = "";
		
		int iReturnValue = 0,
			iMaxLength = 0 ,
			iNumberAmt = 0 ;
		
		long lOdds1 = 1L,
			 lOdds2 = 1L;
		
		double dFinalOdds = 0d;
		
		pnlLotteryOddsPrompt.add(lblMaxLengthPrompt);
		pnlLotteryOddsPrompt.add(txtMaxLengthPrompt);
		
		pnlLotteryOddsPrompt.add(lblNumberAmtPrompt);
		pnlLotteryOddsPrompt.add(txtNumberAmtPrompt);
		
		//While loop to get user input, validate and ensure values are in range
		while (iReturnValue == JOptionPane.OK_OPTION)
		{
			
			//Display input box
			iReturnValue = JOptionPane.showConfirmDialog(null,
					pnlLotteryOddsPrompt,
					"Calculate Lottory Odds",
					JOptionPane.OK_CANCEL_OPTION);
			
			//If to close program if cancel is clicked
			if (iReturnValue == JOptionPane.CANCEL_OPTION) 
			{
				break;
			}
			
			//Else to validate proper format and catch errors 
			else
			{
				try {
					iMaxLength = Integer.valueOf(txtMaxLengthPrompt.getText());
					iNumberAmt = Integer.valueOf(txtNumberAmtPrompt.getText());
				}
					catch (NumberFormatException e) 
					{
						JOptionPane.showMessageDialog(null, 
								  "Input is in improper format, please re-enter",
								  "Improper Format",
								  JOptionPane.ERROR_MESSAGE);
						continue;
						
					}
			}
			
			//If to check if numbers are in range	
			if (iMaxLength <= 0 || iMaxLength > 100 ||iNumberAmt <= 0 || iNumberAmt > 10) 
			{
				JOptionPane.showMessageDialog(null, 
						  "One of the numbers entered is out of range, please re-enter",
						  "Numbers Out of Range",
						  JOptionPane.ERROR_MESSAGE);
				continue;
			}
			
			//Set odds back to default 
			lOdds1 = 1;
			lOdds2 = 1;
			//For loop to calculate odds
			for (int i = 0; i < iNumberAmt; i++) 
			{
				lOdds1 *= iMaxLength - i;
				lOdds2 *= iNumberAmt - i;
			}
			
			//Divide odds together to get final odds
			dFinalOdds = (lOdds1 / lOdds2);
			//Format final odds 
			sFinalOdds = String.format("%,.0f", dFinalOdds);
			
			//Display Output 
			JOptionPane.showMessageDialog(null, 
					  "The odds for you winning a " + iNumberAmt + " in a " + iMaxLength + " lottery pull are: " + sFinalOdds ,
					  "Odds of winning",
					  JOptionPane.PLAIN_MESSAGE);
	
		}//End while loop to get user input, validate and ensure values are in range
		
	}//End main
	
}//End Class
