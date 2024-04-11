import Numerology as n
def main():
    sName = ""
    sDOB = ""

    while sName =="":
        sName = "Care"
        #sName = input("Enter Name: ")

        if not sName.isalpha():
            print("Name can't be empty and letters only")
        else:
            break

    while sDOB=="": 
        sDOB = "08/15/1994"
        #sDOB = input("Enter DOB: ")

        try:
            if sDOB[2] in ["-", "/"] and sDOB[5] in ["-", "/"] and int(sDOB.replace("-", "").replace("/", "")):
                break
        except:
            print("Enter DOB in mm-dd-yyyy format")
            
            
    CareNum = n.Numerology(sName, sDOB)
    
    
    
    print(CareNum.getName())
    
    
    
main()
    
    
            
            
            
            
            
            
            
            
            
            
            
            
            