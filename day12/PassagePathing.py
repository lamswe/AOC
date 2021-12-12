paths = []


def readInput():
    caves = {}
    lines = open("input.txt", "r").readlines()
    for line in lines:
        key, value = line.strip().split("-")
        if key not in caves:
            caves[key] = [value]
        else:
            list = []
            for v in caves[key]:
                list.append(v)
            list.append(value)
            caves[key] = list

        if value not in caves:
            caves[value] = [key]
        else:
            list = []
            for v in caves[value]:
                list.append(v)
            list.append(key)
            caves[value] = list

    print("Paths:", caves)
    print("-------------------------------")
    return caves


def part1(caves):
    findPath1(caves)
    # for path in paths:
    #     print(path)
    print("Paths's size:", len(paths))


def part2(caves):
    findPath2(caves)
    # for path in paths:
    #     print(path)
    print("Paths's size:", len(paths))


def findPath1(caves, passedNodes=['start'], node='start'):
    if node not in caves:
        return
    for nextNode in caves[node]:
        if nextNode == 'end':
            nodes = passedNodes + [nextNode]
            paths.append(nodes)
        elif nextNode.isupper() or nextNode not in passedNodes:
            nodes = passedNodes + [nextNode]
            findPath1(caves, nodes, nextNode)


def findPath2(caves, passedNodes=['start'], node='start', passedSmall=False):
    if node not in caves:
        return
    for nextNode in caves[node]:
        if nextNode == 'end':
            nodes = passedNodes + [nextNode]
            paths.append(nodes)
        elif nextNode.isupper() or nextNode not in passedNodes:
            nodes = passedNodes + [nextNode]
            findPath2(caves, nodes, nextNode, passedSmall)
        elif not passedSmall and nextNode != 'start':
            nodes = passedNodes + [nextNode]
            findPath2(caves, nodes, nextNode, True)


def main():
    print("Day11 - Dumbo Octopus")
    caves = readInput()
    # part1(caves)
    part2(caves)


if __name__ == "__main__":
    main()
