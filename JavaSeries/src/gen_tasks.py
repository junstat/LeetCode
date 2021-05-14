import os
import re


def pre_process_target():
    with open("source.txt") as f:
        source = [int(line.strip()) for line in f]
    source = list(set(source))
    return source


def gen(goal):
    source = pre_process_target()

    done_nos = [int(re.search(r'\d+', x).group()) for x in os.listdir(f"Q0{goal}")]
    done_nos.sort()

    for x in source:
        if x <= (goal - 100):
            continue
        if x > goal:
            break
        if x not in done_nos:
            print(x)


if __name__ == '__main__':
    import sys

    goal = sys.argv[1]
    gen(int(goal))
