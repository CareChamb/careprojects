def main():
    sName = "CARE"
    iDOBTotal = 0
    iSoul= 0
    iPer = 0
    sVOWLES = "AEIOU"
    dictName = {}


    for i in sName:
        if (i in sVOWLES):
            iSoul += getnum(i)
        else:
            iPer += getnum(i)
    print(iSoul)
    print(iPer)




def getnum(letter):
    match letter:
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
main()