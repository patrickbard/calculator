# PostFix Calculator

This project was created for practicing only and it's based on the problem proposed [here](http://www.inf.pucrs.br/~oliveira/alestI/t2.pdf) (pt-BR).

# Objective

Create a [postfix calculator](https://en.wikipedia.org/wiki/Reverse_Polish_notation) capable of reading a file with some commands and executing these commands.
It should read a file with integer numbers and perform all calculations required from the file.

# Possible Commands

## Math Operations

  * `+`: Add the first two most recent numbers
  * `-`: Subtract the first two most recent numbers
  * `*`: Multiply the first two most recent numbers
  * `/`: Divide the first two most recent numbers
  * `sin`: Calculate the Sine of the most recent number
  * `cos`: Calculate the Cosine of the most recent number
  * `atan`: Calculate the Arctangent of the first two most recent numbers

## Stack Operations

  * `pop`: Remove the most recent number
  * `dup`: Duplicate the most recent number
  * `swap`: Swap the position of the first two most recent number

# OBS

For some reason the problem request a different order for the operands when performing 
non commutative operations (subtraction, division) compared to a normal postfix implementation.

So the given example:

    2
    3
    /

Will create a stack:

    3
    2

And will result `1.5` isntead of `0.66666...`

Don't blame me, ask [JB](http://www.inf.pucrs.br/~oliveira/) why :)

# Results

Here are the results I found when reading the files inside `test_cases`:

    ----------------- x1 -----------------
     Largest size reached:     499
    Stack size at the end:       1
             Value on top:      -2.7916030
    ----------------- x2 -----------------
     Largest size reached:    1465
    Stack size at the end:       1
             Value on top:    3414.0000000
    ----------------- x3 -----------------
     Largest size reached:    2555
    Stack size at the end:       1
             Value on top:   -5519.8895911
    ----------------- x4 -----------------
     Largest size reached:    3539
    Stack size at the end:       1
             Value on top:    1632.3399383
    ----------------- x5 -----------------
     Largest size reached:    4497
    Stack size at the end:       1
             Value on top:   10093.3037923
    ----------------- x6 -----------------
     Largest size reached:    5478
    Stack size at the end:       1
             Value on top:    7341.6012255
    ----------------- x7 -----------------
     Largest size reached:    6621
    Stack size at the end:       1
             Value on top:       1.4215463
    ----------------- x8 -----------------
     Largest size reached:    7577
    Stack size at the end:       1
             Value on top: 2356143.9998905  
