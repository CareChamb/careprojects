/*
  Programmer:    Caroline Chamberlain
  Date:     02/23/2024
  Purpose:  This program asks a user for an e-mail and test grade parses out if the e-mail is in the correct format and returns a letter grade accordingly
*/
import javax.swing.*;
public class CarolineChamberlain_EmailandGrade {
	
	public static void main(String[] args) {
		//Build prompt
		JPanel pnlEmailTestPrompt  = new JPanel();
		
		JLabel  lblEmailPrompt = new JLabel("Enter a user email:");
		JTextField txtEmailPrompt = new JTextField(15);
		
		JLabel  lblTestGradePrompt = new JLabel("Enter test grade:");
		JTextField txtTestGradePrompt = new JTextField(5);
		
		String sEmail = "",
			   sEmailErrors = "",
			   sLetterGrade = "";	
		//Initiate variables
		int iReturnValue = 0;
		
		float fTestGrade = 0.0f;
		
		boolean bEmailEmpty = true,
				bCharLength = true,
				bEndsWith = true,
				bAtCount = true,
				bStartingChar = true,
				bBadChars = true;
			
		pnlEmailTestPrompt.add(lblEmailPrompt);
		pnlEmailTestPrompt.add(txtEmailPrompt);
		
		pnlEmailTestPrompt.add(lblTestGradePrompt);
		pnlEmailTestPrompt.add(txtTestGradePrompt);
		//Display input box
		iReturnValue = JOptionPane.showConfirmDialog(null, 
													 pnlEmailTestPrompt,
													 "Input",
													 JOptionPane.OK_CANCEL_OPTION);
		//If statement to check click option
		if (iReturnValue == JOptionPane.OK_OPTION)
	      {
			//Check if grade input is empty and replace with 0
			fTestGrade = (txtTestGradePrompt.getText().isEmpty() ) ? 0.0f : Float.valueOf(txtTestGradePrompt.getText());
			//If statement to check if email is empty
			if (! txtEmailPrompt.getText().isEmpty()) 
			{	
				//If not empty pull email from text and check for failing values
				sEmail = txtEmailPrompt.getText();	
				
				bCharLength = (sEmail.length() > 30 ) ? false : true;
				bEndsWith = (sEmail.endsWith("@student.stcc.edu") ) ? true : false;
				bAtCount = (sEmail.lastIndexOf("@") == sEmail.indexOf("@")  ) ? true : false;
				bStartingChar = (Character.isAlphabetic(sEmail.charAt(0)) ) ? true : false;
				bBadChars = (sEmail.indexOf("#") != -1 || 
							 sEmail.indexOf("$") != -1 ||
							 sEmail.indexOf("%") != -1 ||
							 sEmail.indexOf(",") != -1 ||
							 sEmail.indexOf("&") != -1 ) ? false : true;
			} //end if statement to check if email is empty
			//Else statement to run if email is empty 
			else 
			{			
				bEmailEmpty = false;
			}//end else statement to run if email is empty
	      }//end if statement to check click option
		//If else statements to assign letter grade
		if (fTestGrade < 60.0f) 
		{
			sLetterGrade = "F";
		}
		else if (fTestGrade < 64.0f)
		{
			sLetterGrade = "D-";
		}
		else if (fTestGrade < 67.0f)
		{
			sLetterGrade = "D";
		}
		else if (fTestGrade < 70.0f)
		{
			sLetterGrade = "D+";
		}
		else if (fTestGrade < 74.0f)
		{
			sLetterGrade = "C-";
		}
		else if (fTestGrade < 77.0f)
		{
			sLetterGrade = "C";
		}
		else if (fTestGrade < 80.0f)
		{
			sLetterGrade = "C+";
		}
		else if (fTestGrade < 84.0f)
		{
			sLetterGrade = "B-";
		}
		else if (fTestGrade < 87.0f)
		{
			sLetterGrade = "B";
		}
		else if (fTestGrade < 90.0f)
		{
			sLetterGrade = "B+";
		}
		else if (fTestGrade < 94.0f)
		{
			sLetterGrade = "A-";
		}
		else if (fTestGrade < 97.0f)
		{
			sLetterGrade = "A";
		}
		else 
		{
			sLetterGrade = "A+";
		}//End if else statements to assign letter grade
		//If statements to apply failing values to output	
		if(bEmailEmpty == false)
		{
			sEmailErrors = "Email is empty.\n";
		}
		else if (bCharLength == false || bEndsWith == false || bAtCount == false || bStartingChar == false || bBadChars == false)
		{
			if (bCharLength == false)
			{
				sEmailErrors += "Email must be less than 30 characters.\n";
			}
			if (bEndsWith == false)
			{
				sEmailErrors += "Email must end in: @student.stcc.edu. \n";
			}
			if (bAtCount == false)
			{
				sEmailErrors += "Email can only have one @. \n";
			}	
			if (bStartingChar == false)
			{
				sEmailErrors += "Email must start with A through Z or a through z. \n";
			}	
			if (bBadChars == false)
			{
				sEmailErrors += "Email can not have: # $ % & ,. \n";
			}
		}//End if statements to apply failing values to output
		// Else statement if email is valid
		else
		{
			sEmailErrors = "Email is Valid. \n";
	    }//End else statement if email is valid
		//Output of email, letter grade, and all failing validators, if any
		JOptionPane.showMessageDialog(null,
                "For User: " + sEmail + "\n" +
                sEmailErrors + 
                "\nTest Score is: " + fTestGrade + 
                "\nLetter Grade is: " + sLetterGrade,
                "Prompt Email Grade",
                JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);
	
	}// end main
}
