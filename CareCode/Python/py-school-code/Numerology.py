class Numerology:

  def __init__(self, sName, sDOB):

    self.__sName = sName
    self.__sDOB = sDOB
    iDOBTotal = 0
    iSoulTotal = 0
    iPersonalityTotal = 0
    sVOWLES = "AEIOU"
    
    
    for i in sDOB.replace("-", "").replace("/", ""):
      iDOBTotal += int(i)
    self.__iLifePath = Numerology.__reduceNumber(self, iDOBTotal)
    self.__iBirthday = Numerology.__reduceNumber(self, int(sDOB[3] + sDOB[4]))
    self.__iAttitude = Numerology.__reduceNumber(self, (int(sDOB[0])+int(sDOB[1])) + (int(sDOB[3])+int(sDOB[4]))) #ugly
    
    
    for i in sName.upper():
        if i in sVOWLES:
            iSoulTotal += Numerology.__getNameNum(i)
        else:
            iPersonalityTotal += Numerology.__getNameNum(i)
    self.__iSoul = Numerology.__reduceNumber(self,iSoulTotal)
    self.__iPersonality = Numerology.__reduceNumber(self,iPersonalityTotal)
    self.__iPower = Numerology.__reduceNumber(self,(iSoulTotal + iPersonalityTotal))
        
    

  def getName(self):      
    return self.__sName

  def getDOB(self):      
    return self.__sDOB

  def getLifePath(self):      
    return self.__iLifePath
  
  def getBirthday(self):      
    return self.__iBirthday

  def getAttitude(self):
    return self.__iAttitude

  def getSoul(self):
    return self.__iSoul
     
  def getPersonality(self):
    return self.__iPersonality

  def getPower(self):
      return self.__iPower

  def __reduceNumber(self, iNumber):
    if iNumber < 10:
      return iNumber
    return Numerology.__reduceNumber(self, int(str(iNumber)[0]) + int(str(iNumber)[1]))

  def __getNameNum(sLetter):
    match sLetter:
        case 'A' | 'J' | 'S':
            return 1
        case 'B' | 'K' | 'T':
            return 2
        case 'C' | 'L' | 'U':
            return 3
        case 'D' | 'M' | 'V':
            return 4
        case 'E' | 'N' | 'W':
            return 5
        case 'F' | 'O' | 'X':
            return 6
        case 'G' | 'P' | 'Y':
            return 7
        case 'H' | 'Q' | 'Z':
            return 8
        case 'I' | 'R':
            return 9

