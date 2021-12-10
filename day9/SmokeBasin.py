

def main():
    print ("Day9 - Smoke Basin")
    data, length = readInput()
    points, indexes = findLowPoint(data, length)
    #part1(output)
    part2(data,length, indexes)

def readInput():
    f = open("input.txt", "r")
    lines = f.readlines()
    length = len(lines[0]) - 1
    data = []
    for line in lines:
        for c in line.strip():
            data.append(int(c))
    f.close()
    return data, length

def findLowPoint (data, lineLen):
    lowPoints = []
    indexes = []
    for i in range(len(data)):
        if isLowPoint(i,data, lineLen):
            lowPoints.append(data[i])
            indexes.append(i)
    return lowPoints, indexes

def isLowPoint(index, data, lineLen):
    res = True
    res = res and (data[index] < data[index-lineLen] if index - lineLen >= 0 else True)
    res = res and (data[index] < data[index + lineLen] if index + lineLen < len(data) else True)
    res = res and (data[index] < data[index-1] if index % lineLen > (index - 1) % lineLen else True)
    res = res and (data[index] < data[index+1] if index % lineLen < (index + 1) % lineLen else True)
    return res



def part1(points):
    sum = 0
    for i in points:
        sum += i
    print ("Part 1:",sum + len(points))
    
def part2 (data, lineLen, indexes):
    basinSizes = []
    def findBasin(index):
        basinNr = 0
        if index - lineLen >= 0 and data[index-lineLen] != 9:
            data[index-lineLen] = 9
            basinNr += 1 + findBasin(index-lineLen)
        if index + lineLen < len(data) and data[index+lineLen] != 9:
            data[index+lineLen] = 9
            basinNr +=  1 + findBasin(index+lineLen)
        if index % lineLen > (index - 1) % lineLen and data[index-1] != 9:
            data[index-1] = 9
            basinNr +=  1 + findBasin(index-1)
        if index % lineLen < (index + 1) % lineLen and data[index+1] != 9:
            data[index+1] = 9
            basinNr +=  1 + findBasin(index+1)        
        return basinNr

    for index in indexes:
        basinSizes.append(findBasin(index))

    top3 = []
    for i in range(3):
        max = 0

        for j in range(len(basinSizes)):
            if basinSizes[j] > max:
                max = basinSizes[j]
        basinSizes.remove(max)
        top3.append(max)

    res = 1
    for i in top3:
        res = res * i
    print(res)

    return

if __name__ == "__main__":
    main()