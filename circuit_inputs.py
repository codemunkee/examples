#!/usr/bin/python

# quick script to build potential input options for a circuit
# given a certain number of allowed inputs

import sys

inputs = int(sys.argv[1])

options = 2**inputs - 1

def convert_to_binary(number):
    binary = []
    if number == 0:
        binary.append(0)
    while number > 0:
        if number % 2 == 1:
            binary.append(1)
        else:
            binary.append(0)
        number /= 2
    return binary[::-1]

while options >= 0:
    binary_options = convert_to_binary(options)
    while len(binary_options) < inputs:
        binary_options.insert(0, 0)
    letter = 'A'
    for option in binary_options:
        print letter, option,
        letter = chr(ord(letter) + 1)

    print
    options -= 1
