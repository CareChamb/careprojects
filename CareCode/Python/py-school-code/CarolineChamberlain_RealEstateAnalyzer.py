import csv

#Function to bulk pull data from file and return skipping first index
def getDataInput ():
    with open('RealEstateData.csv', 'r') as file:
        reader = csv.reader(file)
        data = [row for row in reader][1:]
        return data
#End data input function
    
#Function to return median from list
def getMedian(listPrices):
    if (len(listPrices) % 2 != 0):
        return listPrices[len(listPrices)//2] 
    else:
        return (listPrices[len(listPrices)//2 - 1]  + listPrices[len(listPrices)//2]) / 2
#End median function

#Main function
def main():
    #Initiate variables
    listMain = getDataInput()
    listPrices = []
    
    dictCityPrices = {}
    dictPropertyTypePrices = {}
    dictZipPrices = {}
    
    fMin = 0.0
    fMax = 0.0
    fTotal = 0.0
    fAvg = 0.0

     #For loop to process main list
    for record in listMain:
        #Populate list of prices
        listPrices.append (float(record[8]))
        
        #Populate city dictionary with citys and price totals
        if (record[1] not in dictCityPrices):
            dictCityPrices [record[1]] = float(record[8])
        else:
            dictCityPrices [record[1]] += float(record[8])
            
        #Populate property dictionary with property types and price totals  
        if (record[7] not in dictPropertyTypePrices):
            dictPropertyTypePrices [record[7]] = float(record[8])
        else:
            dictPropertyTypePrices [record[7]] += float(record[8])
        
        #Populate zip dictionary with zip codes and price totals
        if (record[2] not in dictZipPrices):
            dictZipPrices [record[2]] = float(record[8])
        else:
            dictZipPrices [record[2]] += float(record[8])
         
         #Calculate sum of all prices
        fTotal +=  float(record[8])
    #End for loop to process main list
    
    #Sort price list and print min, max, sum, average, and median
    listPrices.sort()
    print("Overall Summary:")
    print(f"Minimum {listPrices[0]:25,.2f}")
    print(f"Maximum {listPrices[-1]:25,.2f}")
    print(f"Sum {fTotal :29,.2f}")
    print(f"Avg {fTotal/len(listPrices):29,.2f}")
    print(f"Median {getMedian(listPrices) :26,.2f}")
    print("")
    
    print("Summary by Property Type:")
    #For loop to print property type dictionary
    for key, value in dictPropertyTypePrices.items():
        iPaddingValue = ' ' * ((len(key) - 12)*-1)
        print(f"{key}{iPaddingValue}{value:21,.2f}")
    print("")
    
    print("Summary by City")
    #For loop to print city dictionary
    for key, value in dictCityPrices.items():
        iPaddingValue = ' ' * ((len(key) - 15)*-1)
        print(f"{str.title(key)}{iPaddingValue}{value:18,.2f}")
        
#End main        
        
#Call to main
main()