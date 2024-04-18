import pickle

#Main function
def main():
    #Initiate variables
    sName = "x"
    sResponse = "x"
    fWeight = 0.0
    endofFile = False
    dictPlanetHistory = {}
    dictPersonWeights = {}
    dictPlanetFactors = {
        "Mercury" : 		0.38,
        "Venus" : 		0.91,
        "our Moon" : 	0.165,
        "Mars" : 		0.38,
        "Jupiter" : 		2.34,
        "Saturn" : 		0.93,
        "Uranus" : 		0.92,
        "Neptune" : 		1.12,
        "Pluto" : 		0.066
        }

    #Try and while loop to open DB file if it exists, load dictionary, and surpress errors 
    try:
        input_file = open('ccPlanetaryWeights.db', 'rb')
        while not endofFile:
            try:
                dictPlanetHistory = pickle.load(input_file)
            except EOFError:
                endofFile = True
        input_file.close()
    except FileNotFoundError:
        pass
    #End try and while loop to open DB file if it exists, load dictionary, and surpress errors
    
    #While loop to ask user if they would like to see history and print dictionary
    while sResponse == "x":
        sResponse = input ("Would you like to see the history y/n: ").lower()
        if sResponse == "y":
            for key in dictPlanetHistory:
                sName  = key
                print(f"{sName}, here are your weights on our Solar System's planets.")
                for key, value in dictPlanetHistory[sName].items():                   
                    iPaddingValue = ' ' * ((len(str(key)) - 8)*-1)
                    print(f"Weight on {key}:{iPaddingValue}{value:10.2f}")          
        elif sResponse == "n": break
        #Else statement to repeat loop if user enters improper input
        else:
            print("Please enter y or n.")
            sResponse = "x"
            continue
    #End while loop to ask user if they would like to see history and print dictionary
    
    #While loop to ask user for unique name and weight with correct input and suppress errors
    while sName != "":
        sName = input("What is your name (enter key to quit): ").title()
        if sName == "": break
        elif sName in dictPlanetHistory:
            print(f"{sName} is already in the history file. Enter an unique name.")
            continue
        fWeight =0
        while fWeight == 0:
            try:
                fWeight = float(input ("What is your weight: "))
                if fWeight <=0:
                    print("Please enter a positive weight value.")
                    fWeight =0
                    continue
            except ValueError:
                continue
            
        #For loop to populate dictionary with name and planetary weight value
        dictPlanetHistory[sName] = {}
        for key, value in dictPlanetFactors.items():                
            dictPersonWeights[value] = (fWeight * value)       
            #Populate dictionary with name and other dictionary
            dictPlanetHistory[sName].update({key:nPlanetWeight})
        #End for loop to populate dictionary with name and planetary weight value
            
        #Print new dictionary input
        print(f"{sName}, here are your weights on our Solar System's planets.")       
        for key, value in dictPlanetHistory[sName].items():                   
            iPaddingValue = ' ' * ((len(str(key)) - 8)*-1)
            print(f"Weight on {key}:{iPaddingValue}{value:10.2f}") 
    #End while loop to ask user for name and weight with correct input suppressing errors
 
    #Write dictionary to output file and close file
    output_file = open('ccPlanetaryWeights.db', 'wb')
    pickle.dump(dictPlanetHistory, output_file)
    output_file.close()
    
#Call to main
main()