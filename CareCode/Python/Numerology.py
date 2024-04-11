class Numerology:

  def __init__(self, sName, sDOB):

    self.__sName = sName
    self.__sDOB = sDOB
    iTotal = 0
    
    for i in sDOB.replace("-", "").replace("/", ""):
      iTotal += int(i)
    self.__iLifePath = Numerology.__reduceNumber(self, iTotal)
    self.__iBirthday = Numerology.__reduceNumber(self, int(sDOB[3] + sDOB[4]))
    self.__iAttitude = Numerology.__reduceNumber(self, (int(sDOB[0])+int(sDOB[1])) + (int(sDOB[3])+int(sDOB[4]))) #ugly

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

  def __reduceNumber(self, iNumber): #recrusive
    if iNumber < 10:
      return iNumber
    return Numerology.__reduceNumber(self, int(str(iNumber)[0]) + int(str(iNumber)[1]))