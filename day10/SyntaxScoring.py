# Day10 - Syntax Scoring
from os import closerange


parenScores ={')':3, ']':57, '}':1197, '>':25137, 'noError':0}
matchedParen = {'(':')', '{':'}', '[':']', '<':'>'}
def readInput():
    lines = open("input.txt", "r").readlines()

    return lines

def part1(lines):
    # () [] {} <>
    scores = []
    for line in lines:
        line = line.strip()
        #print (seekError(line)[0], " - ", seekError(line)[1])
        errorIndex, error = seekError(line)
        scores.append(parenScores[error])
        print (scores)
    sum = 0
    for num in scores:
        sum += num
    print ("Part 1: sum =", sum)
    
            

def seekError (line):
    openParen = ['(', '[', '{', '<']
    paren = []
    for i in range(len(line)):
        if line[i] in openParen:
            paren.append(line[i])
        elif matchedParen[paren[-1]] == line[i]:
            paren.pop()
        else:
            return i, line[i]
    return 0, 'noError'

def main():
    print("Day10 - Syntax Scoring")
    data = readInput()
    part1(data)



if __name__ == "__main__":
    main()