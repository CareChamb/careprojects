#This program prompts the user for a name and a password and validates it according to specific parameters

#Main function 
def main():
    #Ask user for name first and last
    sName = input("Please enter your first and last name: ")
    #Call GetInitials function and assign to variable 
    sInitials = GetInitials(sName)
    #Call GetPassword function and assign to variable
    sValidPassword = GetPassword(sInitials)
    
#End main function
    
#Function to slice out initials from first and last name
def GetInitials(sName):
    return sName[0] + sName[sName.find(" ") + 1]

#End function to slice out initials from first and last name

#Function to ask for a password from the user and validate 
def GetPassword(sInitials):
    #Initiate checks and variables
    chkLength= chkPass = chkUpper = chkLower = chkDigit = chkSpecChar = chkInitials = sPasswordValid = False
    chkCharCount = True
    
    #Enter while loop to validate password
    while sPasswordValid == False:
        #Ask user for password
        sPassword = input ("Please enter a new password: ")
        
        #Test password length    
        if len(sPassword) >=8 and len(sPassword) <= 12:
            chkLength = True          
        
        #Test to check if Password begins with "pass"
        if sPassword[:4].lower() != "pass":
            chkPass = True 
            
        #Test password containing users initials  
        if sPassword.lower().find(sInitials.lower()) == -1:
            chkInitials = True 
            
        #Enter for loop to check individual characters and initiate dictionary
        dictCharCount = {}
        for i in sPassword:
            #Populate dictionary with characters and counts         
            dictCharCounts = sPassword.count(i)
            dictCharCount [i] = dictCharCounts
            
            #Test for multiple characters in password   
            if dictCharCount.get(i) >= 2:
                chkCharCount = False               
            #Test if password contains 1 upper case letter
            if i.isupper():
                chkUpper = True                
            #Test if password contains 1 lower case letter
            elif i.islower():
                chkLower = True               
            #Test if password contains 1 number
            elif i.isdigit():
                chkDigit = True                
            #Test if password contains 1 special character
            elif i == "!" or i == "@" or i == "#" or i == "$" or i == "%" or i == "^":
                chkSpecChar = True
                
        #End for loop to check individual characters
                
        #Check all validators for true and validate password      
        if chkLength and chkPass and  chkLower and chkUpper and chkDigit and chkSpecChar and chkInitials and chkCharCount:
            print("Password is valid and OK to use.")
            sPasswordValid = True
            
        #Print all failing validators
        else:
            if not chkLength:
                print("Password must be between 8 and 12 characters.")
            if not chkPass:
                print("Password can’t start with Pass.")
            if not chkUpper:
                print("Password must contain at least 1 uppercase letter.")
            if not chkLower:
                print("Password must contain at least 1 lowercase letter.")
            if not chkDigit:
                print("Password must contain at least 1 number.")
            if not chkSpecChar:
                print("Password must contain at least 1 of these special characters: ! @ # $ % ^")
            if not chkInitials:
                print("Password must not contain user initials.")               
            if not chkCharCount:
                print("These characters appear more than once: ")
                #Sort dictionary
                dictCharCount = dict(sorted(dictCharCount.items()))
                #Enter for loop to print dictionary
                for i in dictCharCount:
                    if dictCharCount.get(i) >= 2:
                        print(f"{i}: {dictCharCount.get(i)} times")
                        
                #End for loop to print dictionary              
        
        #Reset all validators to default
        chkLength= chkPass = chkUpper = chkLower = chkDigit = chkSpecChar = chkInitials = False
        chkCharCount = True
        
        #End while loop to validate password
        
    #Return validated password 
    return sPassword

#End of Password Function

#Call to main   
main()