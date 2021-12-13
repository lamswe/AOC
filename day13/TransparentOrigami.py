foldInstr = []
points = []
coor = []

xMax = 1
yMax = 1

def readInput():
    global foldIntr, points, coor, xMax, yMax

    lines = open("input.txt", "r").readlines()
    for line in lines:
        if "fold along" in line:
            foldInstr.append(line.split(" ")[2].strip())
        elif "," in line:
            x,y = line.strip().split(",")
            coor.append((int(x),int(y)))
    xMax = max(coor, key = lambda i:i[0])[0]+1
    yMax = max(coor, key = lambda i:i[1])[1]+1
    for i in range(xMax*yMax):
        points.append(0)
 
    for p in coor:
        points[p[1]*xMax + p[0]] = 1
    return

def printMap(points, xMax):
    index = 0
    for i in range(len(points)):
        if points[index] == 0:
            print(".", end = " ")
        else:
            print("#", end = " ")
        # print(points[index], end = " ")
        index += 1
        if i % xMax == xMax-1:
            print()

# def fold(instr):
#     global points
#     new_points = []
#     instr, line = instr.split("=")
#     def foldUp(y):
#         global points, xMax, yMax
#         for i in range(xMax*(yMax-y-1)):
#             new_points.append(0)
#         for i in range(len(new_points)):
#             if (i >= xMax*y):
#                 break
#             new_points[i] = points[i] + points[i%xMax-int(i/xMax+1)*xMax]
#         yMax = yMax-y-1
# 
#     def foldRight(x):
#         global points, xMax, yMax
#         for i in range((xMax-x-1)*yMax):
#             new_points.append(0)
#         for i in range(len(new_points)):
#             new_points[i] =points[int(i/x)*xMax+i%x] + points[int(i/x)*xMax + xMax-(i%x)-1]
#         xMax = xMax-x-1
# 
#     if instr == "y":
#         foldUp(int(line))
#     else:
#         foldRight(int(line))
#     points = new_points
#     
#     #printMap(points, xMax)
#     return
def fold(instr):
    global points
    new_points = []
    instr, line = instr.split("=")
    def foldUp(y):
        global points, xMax, yMax
        new_yMax = max(yMax-y-1, y)
        for i in range(new_yMax*xMax):
            new_points.append(0)
        for i in range(new_yMax):
            for j in range(xMax):
                index = (new_yMax-i-1)*xMax+j
                if y-i-1 >= 0:
                    new_points[index] += points[(y-i-1)*xMax+j]
                if (y+1+i < yMax):
                    new_points[index] += points [(y+1+i)*xMax+j]
        yMax = new_yMax

    def foldRight(x):
        global points, xMax, yMax
        new_xMax = max(x, xMax-x-1)
        for i in range(new_xMax*yMax):
            new_points.append(0)
        for i in range(yMax):
            n = 0
            m = 1
            for j in range(new_xMax):
                index = i*new_xMax+j
                if j+x >= new_xMax:
                    new_points[index] += points[i*xMax+n]
                    n += 1
                if j+x >= xMax -x-1:
                    new_points[index] += points[(i+1)*xMax - m]
                    m += 1
        xMax = new_xMax


    if instr == "y":
        foldUp(int(line))
    else:
        foldRight(int(line))
    points = new_points
    
    #printMap(points, xMax)
    return

def part1():
    print(xMax, yMax)

    fold("x=655")
    count = 0
    #printMap(points, xMax)
    print(xMax, yMax)
    for i in points:
        if i > 0:
            count += 1
    print("Part 1:", count)

def part2():
    # printMap(points,xMax)
    # print(xMax, yMax)

    for instr in foldInstr:
        print(instr)
        fold(instr)

    printMap(points,xMax)
    # print(xMax, yMax)

def main():
    print ("Day 13: Transparent Origami")
    readInput()
    #printMap(points, xMax)
    #part1()
    part2()

if __name__ == '__main__':
    main()
