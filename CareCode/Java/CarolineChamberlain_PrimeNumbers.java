/*
  Programmer: Caroline Chamberlain
  Date: 03/22/2024
  Purpose: This program displays all the prime numbers between 1 and 100
*/
import javax.swing.JOptionPane;
public class CarolineChamberlain_PrimeNumbers {
	public static void main(String[] args) 
	{
		//Initiate variables
		String sPrimeOutput = "";
		boolean bIsPrime = true;
		
		//Outer for loop to initiate test variable
		for (int iTestNumber = 2; iTestNumber <= 100; iTestNumber++) 
		{
			//Set boolean to default
			bIsPrime = true;
			
			//Inner for loop to initiate prime variable and check against test variable excluding itself and 1
			for (int iPrimeCheck = 2; iPrimeCheck <= iTestNumber - 1; iPrimeCheck++)
			{
				//If statement to break loop if number is not prime
				if (iTestNumber % iPrimeCheck == 0) 
				{
					bIsPrime = false;
					break;
				}
					
			}//End inner loop
			
			//Add prime numbers to string
			sPrimeOutput += (bIsPrime == true) ? "\n" + iTestNumber : "";
		} //End outer loop
		
		//Add 1 back to string and output all prime numbers
		JOptionPane.showMessageDialog(null, 
				  					  "1"+sPrimeOutput ,
				  					  "Prime numbers between 1 and 100",
				  					  JOptionPane.PLAIN_MESSAGE);
	}//End main
}//End Class
