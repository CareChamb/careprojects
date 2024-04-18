
sName = "CARE"
iDOBTotal = 0
iSoulTotal = 0
iPersonalityTotal = 0
liVOWLES = ['A','E','I','O','U']




for i in sName:
        if (i in liVOWLES):
            print(i)
            match i:
                case 'A':
                    iSoulTotal += 1
                    print(iSoulTotal)
                    continue
                case 'U':
                    iSoulTotal += 3
                    print(iSoulTotal)
                    continue
                case 'E':
                    iSoulTotal += 5
                    print(iSoulTotal)
                    continue
                case 'O':
                    iSoulTotal += 6
                    print(iSoulTotal)
                    continue
                case 'I':
                    iSoulTotal += 9
                    print(iSoulTotal)
                    continue
        else:
            print(i)
            match i:
                case 'J' | 'S':
                    iPersonalityTotal += 1
                    print(iPersonalityTotal)
                    continue
                case 'B' | 'K' | 'T':
                    iPersonalityTotal += 2
                    print(iPersonalityTotal)
                    continue
                case 'C' | 'L':
                    iPersonalityTotal += 3
                    print(iPersonalityTotal)
                    continue
                case 'D' | 'M' | 'V':
                    iPersonalityTotal += 4
                    print(iPersonalityTotal)
                    continue
                case 'N' | 'W':
                    iPersonalityTotal += 5
                    print(iPersonalityTotal)
                    continue
                case 'F' | 'X':
                    iPersonalityTotal += 6
                    print(iPersonalityTotal)
                    continue
                case 'G' | 'P' | 'Y':
                    iPersonalityTotal += 7
                    print(iPersonalityTotal)
                    continue
                case 'H' | 'Q' | 'Z':
                    iPersonalityTotal += 8
                    print(iPersonalityTotal)
                    continue
                case 'R':
                    iPersonalityTotal += 9
                    print(iPersonalityTotal)
                    continue
            
print(iSoulTotal)
print(iPersonalityTotal)