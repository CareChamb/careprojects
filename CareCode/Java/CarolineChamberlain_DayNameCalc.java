/*
  Programmer:    Caroline Chamberlain
  Date:     03/09/2024
  Purpose:  This program asks the user for a date, and calculate the day of the week it falls on.
*/
import javax.swing.*;

public class CarolineChamberlain_DayNameCalc {
	
	public static void main(String[] args) 
	{
		//Initiate variables
		String sDate 	= "",
			   sWeekday = "";
			 
		int	iMonth 			 = 0,
			iDay 			 = 0,
			iYear 			 = 0,
			iCenturyYear 	 = 0,
			iCenturyYearCode = 0,
			iMonthCode 		 = 0,
			iDayCode 		 = 0,
			iReturnValue 	 = 0,
			iMonthMax 		 = 0;
		
		boolean bIsLeapYear = false;

		//While loop to show JOptionPane and ask user for input
		while (iReturnValue == JOptionPane.OK_OPTION) 
		{		                                                               
			sDate = JOptionPane.showInputDialog("Enter a date in this format mm/dd/yyyy:");	
			
			//If statement to check button clicked
			if (sDate != null )
			{
				//Test catch to ensure date is in numeric format
				try 
				{
					Integer.valueOf(sDate.replace('/', '0'));
				}
				
					catch (NumberFormatException e) 
					{
						JOptionPane.showMessageDialog(null, 
													  "Only numbers alowed in date, please enter date in correct format (mm/dd/yyyy)",
													  "Only numbers alowed in date",
													  JOptionPane.ERROR_MESSAGE);
						continue;
					}
				
				//If else statement to ensure date was input in correct format and slice out individual date values 
				if (sDate.length() != 10 || sDate.indexOf('/') != 2 || sDate.lastIndexOf('/') != 5) 
				{
					JOptionPane.showMessageDialog(null, 
												  "Please enter date in correct format (mm/dd/yyyy)",
												  "Date formated incorectly",
												  JOptionPane.ERROR_MESSAGE);
					continue;
				}
				else
				{
					iMonth = Integer.valueOf(sDate.substring(0,2));
					iDay = Integer.valueOf(sDate.substring(3,5));
					iCenturyYear = Integer.valueOf(sDate.substring(6));
					iYear =Integer.valueOf(sDate.substring(8));
					
					//Calculation to see if year is leap year
					bIsLeapYear = (iCenturyYear % 4 == 0 && iCenturyYear % 100 != 0 || iCenturyYear % 400 == 0) ? true : false;
					
					//Test to see if day value corresponds with month entered 
					if (bIsLeapYear && iMonth == 2) 
					{
						iMonthMax = 29;
					}
					else 
					{
						switch (iMonth) 
						{
						case 1,3,5,7,8,10,12 -> iMonthMax = 31;
						case 4,6,9,11 -> iMonthMax = 30;
						case 2 -> iMonthMax = 28;
						}
					}
					if (iDay > iMonthMax || iDay < 0) 
					{
						JOptionPane.showMessageDialog(null, 
													  "Day is out of calculation range, please enter new date.",
													  "Day is out of calculation range",
													  JOptionPane.ERROR_MESSAGE);
						continue;
					}
						
					//If statement to test to if year is within valid range and assign code
					if (iCenturyYear < 1700 || iCenturyYear > 2699) 
					{
						JOptionPane.showMessageDialog(null, 
													  "Year is out of calculation range, please enter new date.",
													  "Year is out of calculation range",
													  JOptionPane.ERROR_MESSAGE);
						continue;
					}
					else if	(iCenturyYear < 1800) 
					{
						iCenturyYearCode = 4;
					}
					else if (iCenturyYear < 1900) 
					{
						iCenturyYearCode = 2;
					}
					else if (iCenturyYear < 2000) 
					{
						iCenturyYearCode = 0;
					}
					else if (iCenturyYear < 2100) 
					{
						iCenturyYearCode = 6;
					}
					else if (iCenturyYear < 2200) 
					{
						iCenturyYearCode = 4;
					}
					else if (iCenturyYear < 2300) 
					{
						iCenturyYearCode = 2;
					}
					else if (iCenturyYear < 2400) 
					{
						iCenturyYearCode = 0;
					}
					else if (iCenturyYear < 2500) 
					{
						iCenturyYearCode = 6;
					}
					else if (iCenturyYear < 2600) 
					{
						iCenturyYearCode = 4;
					}
					else if (iCenturyYear < 2700) 
					{
						iCenturyYearCode = 2;
					}
					
					//If else statements to assign month code and ensure month is in valid range 
					if (bIsLeapYear && iMonth < 3) 
					{
						switch (iMonth) 
						{
							case 1 -> iMonthCode = 6;
							case 2 -> iMonthCode = 2;
						}
					}
					else
					{
						switch (iMonth) 
						{
							case 1,10:
							{
								iMonthCode = 0;
								break;
							}
							case 5:
							{
								iMonthCode = 1;
								break;
							}
							case 8:
							{
								iMonthCode = 2;
								break;
							}
							case 2,3,11:
							{
								iMonthCode = 3;
								break;
							}
							case 6:
							{
								iMonthCode = 4;
								break;
							}
							case 9,12:
							{
								iMonthCode = 5;
								break;
							}
							case 4,7:
							{
								iMonthCode = 6;
								break;
							}
							default:
							{
								JOptionPane.showMessageDialog(null, 
															  "Month enterd is not valid, please enter new date.",
															  "Month enterd is not valid",
															  JOptionPane.ERROR_MESSAGE);
								continue;
							}
						}		
					}//End if else statements to assign month code and ensure month is in valid range
					
					//Calculate code for day of the week and assign.
					iDayCode =(iCenturyYearCode + iYear + (iYear/4) + iMonthCode + iDay) % 7;
					switch (iDayCode) 
					{
					case 0 -> sWeekday = "Sunday";
					case 1 -> sWeekday = "Monday";
					case 2 -> sWeekday = "Tuesday";
					case 3 -> sWeekday = "Wednesday";
					case 4 -> sWeekday = "Thursday";
					case 5 -> sWeekday = "Friday";
					case 6 -> sWeekday = "Saturday";
					}
					
					//Display date and day of the week date falls on
					JOptionPane.showMessageDialog(null, 
												  "The day of the week for " + sDate + " is " + sWeekday ,
												  "Day of week calculation",
												  JOptionPane.PLAIN_MESSAGE);
				}//End if else statement to ensure date was input in correct format and slice out individual date values 
				
			}//End if statement to check button clicked
			else 
			{
				System.exit(0);
			}
		}//End while to show JOptionPane and ask user for input
	}//End main
}//End class
