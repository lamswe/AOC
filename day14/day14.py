
insertion = {}
def readInput():
    global insertion
    lines = open("input.txt", "r").readlines()
    template = lines[0]
    lines = lines[2:]
    for line in lines:
        pair, ins = line.strip().split(" -> ")
        insertion[pair] = ins
    insertion = {k : v for k, v in sorted(insertion.items(), key=lambda x : x[0])}
    return template

def part1(template):
    nr = 10
    for i in range(nr):
        template = insert(template)
        #print(i, ":", template)

    freq = {}
    for i in template.strip():
        if i not in freq:
            freq[i] = 1
        else:
            freq[i] += 1
    mostCommon = max(freq.values())
    leastCommon = min(freq.values())
    print(mostCommon, leastCommon)
    print("Part 1: ", mostCommon - leastCommon)
    return

# def insert(template):
#     res = template
#     index = 1
#     for i in range(len(template)-2):
#         res = res[0:index] + insertion[template[i:i+2]] + template[i+1:]
#         index += 2
#     return res

def insert(template):
    template = template.strip()
    res = template[0]
    index = 1
    for i in range(len(template)-1):
        res += insertion[template[i:i+2]] + template[i+1:i+2]
        index += 2 
    return res

def interate(dic):
    new_dic = {key:0 for key in insertion.keys()}
    dublicate = {value : 0 for value in insertion.values()}
    
    for key in dic.keys():
        inserted = insertion[key]
        dublicate[inserted] -= dic[key]
        dublicate[key[0]] -= dic[key]
        pair1 = key[0] + inserted
        pair2 = inserted + key[1]
        new_dic[pair1] += dic[key]
        new_dic[pair2] += dic[key]
    return new_dic, dublicate

def part2(template):
    nr = 10
    dic = {key:0 for key in insertion.keys()}
    for i in range(len(template)-2):
        dic[template[i:i+2]] += 1

    for i in range(nr):
        dic, dub = interate(dic)
    print(dub)
 
    freq = dub
    freq[template[0]] += 1
    freq[template[-2]] += 1

    for key in dic.keys():
        freq[key[0]] += dic[key]
        freq[key[1]] += dic[key]

    mostCommon = max(freq.values())
    leastCommon = min(freq.values())
    print(mostCommon, leastCommon)
    print("Part 2: ", mostCommon - leastCommon)
    return

def main():
    print("Day 14 - ")
    template = readInput()
    #part1(template)
    part2(template)


if __name__ == '__main__':
    main()