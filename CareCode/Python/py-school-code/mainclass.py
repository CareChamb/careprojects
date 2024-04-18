import Numerology as n
def main():
    sName = ""
    sDOB = ""

    while sName =="":
        sName = "CARE"
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
    
    
    
    print(f"Client Name: {CareNum.getName()}")
    print(f"Client D.O.B: {CareNum.getDOB()}")
    print(f"Life Path: {CareNum.getLifePath()}")
    print(f"Attitude: {CareNum.getAttitude()}")
    print(f"Birthday: {CareNum.getBirthday()}")
    print(f"Personality: {CareNum.getPersonality()}")
    print(f"Power Name: {CareNum.getPower()}")
    print(f"Soul: {CareNum.getSoul()}")
    
    
    
    
    
    
main()
    
