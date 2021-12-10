# Day10 - Syntax Scoring
from os import closerange


parenScores ={')':3, ']':57, '}':1197, '>':25137, 'noError':0}
matchedParen = {'(':')', '[':']', '{':'}', '<':'>'}
fixScores = {'(':1, '{':3, '[':2, '<':4}
openParen = ['(', '[', '{', '<']

def readInput():
    lines = open("input.txt", "r").readlines()
    return lines

def part1(lines):
    # () [] {} <>
    scores = []
    for line in lines:
        line = line.strip()
        error, _ = seekError(line)
        scores.append(parenScores[error])
        print (scores)
    sum = 0
    for num in scores:
        sum += num
    print ("Part 1: sum =", sum)
    
def part2(lines):
    scores = []
    for line in lines:
        line = line.strip()
        lineScore = 0
        error, paren = seekError(line)
        if error == 'noError':
            paren.reverse()
            for p in paren:
                lineScore = lineScore* 5 + fixScores[p]
        scores.append(lineScore) if lineScore != 0 else None
    scores.sort()
    result = scores[round(len(scores)/2)]
    print ("Part 2: ", result)
    return

def seekError (line):
    paren = []
    for i in range(len(line)):
        if line[i] in openParen:
            paren.append(line[i])
        elif matchedParen[paren[-1]] == line[i]:
            paren.pop()
        else:
            #print ("return", i, line[i], paren)
            return line[i], paren
    return 'noError', paren

def main():
    print("Day10 - Syntax Scoring")
    data = readInput()
    #part1(data)
    part2(data)



if __name__ == "__main__":
    main()