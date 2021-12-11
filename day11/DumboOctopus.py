mapDim = 10

def readInput():
    lines = open("input.txt", "r").readlines()
    map = []
    for line in lines:
        for c in line.strip():
            map.append(int(c))
    return map

def flash(map):
    res = 0
    for i in range(len(map)):
        if map[i] > 9:
            res += 1
            map[i] = 0
            if i%mapDim > 0 and map[i-1] != 0:
                map[i-1] += 1
            if i%mapDim < mapDim-1 and map[i+1] != 0:
                map[i+1] += 1

            if (i-mapDim) >= 0:
                if map[i-mapDim] != 0:
                    map[i-mapDim] += 1
                if i%mapDim > 0 and map[i-mapDim-1] != 0:
                    map[i-mapDim-1] += 1
                if i%mapDim < mapDim-1 and map[i-mapDim+1] != 0:
                    map[i-mapDim+1] += 1

            if (i+mapDim) < len(map):
                if map[i+mapDim] != 0:
                    map[i+mapDim] += 1
                if i%mapDim > 0 and map[i+mapDim-1] != 0:
                    map[i+mapDim-1] += 1
                if i%mapDim < mapDim-1 and map[i+mapDim+1] != 0:
                    map[i+mapDim+1] += 1
    for i in map:
        if i > 9:
            res += flash(map)
    return res

def printMap(map):
    for i in range(len(map)):
        if i % mapDim == 0:
            print()
        print(map[i], end= " ")
    print()
    print("----------------------------")

def part1(map):
    step = 100
    #printMap(map)
    res = 0
    for j in range(step):
        for i in range(len(map)):
            map[i] += 1
        res += flash(map)
        #print ("After step ", j+1)
        #printMap(map)

    print("Part 1:", res)
    return

def part2(map):
    allFlash = False
    step = 1
    while not allFlash:
        print("Step:", step)
        for i in range(len(map)):
            map[i] += 1
        if flash(map) == 100:
            break
        step += 1
    print("Part 2:", step)

def main():
    print("Day11 - Dumbo Octopus")
    map = readInput()
    #part1(map)
    part2(map)



if __name__ == "__main__":
    main()