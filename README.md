# 8bit
[Ben Eater 8 bit computer](https://skirienkopanea.github.io/8bit) assembly compiler in java.

Takes a .txt file (first argument) in the same directory as the program and if the output name argument (second) is given saves the binary compiled output in the same directory as a .txt file. Eitherway the compiled binary code is always shown in the terminal. The input must be written in assembly code with the instruction set below.

| binary instruction | assembly opcode | has operand | meaning                                                                                                           |
| ------------------ | --------------- | ----------- | ----------------------------------------------------------------------------------------------------------------- |
| 0000               | NOP             | no          | Do nothing (no operation)                                                                                         |
| 0001               | LDA             | yes         | Load contents of operand address into register A                                                                  |
| 0010               | ADD             | yes         | Load contents of operand address into register B, and set ALU to sum (default), then store result into register A |
| 0011               | SUB             | yes         | Load contents of operand address into register B and set ALU to subtract, then store result into register A       |
| 0100               | STA             | yes         | Store the contents of register A into the address of the operand                                                  |
| 0101               | LDI             | yes         | Load immediate value of the operand into register A                                                               |
| 0110               | JMP             | yes         | Jump to the memory address of the operand (aka code line)                                                         |
| 0111               | JPC             | yes         | Jump to the memory address of the operand if last operation had a 9th bit carry                                   |
| 1000               | JPZ             | yes         | Jump to the memory address of the operand if the last operation resulted in zero                                  |
| 1110               | OUT             | no          | Load contents of register A into output register                                                                  |
| 1111               | HLT             | no          | Halt the system                                                                                                   |

*Line breaks are ignored, unknown opcodes are replaced with 0's and no operand is also defaulted with 0's. Anything after the operand (or opcode if there's no operand) is ignored (i.e. comments). Whitespace insensitive*

*Error messages will be shown when the program exceeds 16 lines of code and/or when the operands exceed 4 bits.*

*Constants have to be typed as decimal base integers between -128 and 255 or else error messages will be shown.
Negative numbers are converted automatically to 2's complement*

## Example input

```
LDA 14
SUB          12
JPC 6
LDA 13
OUT  // show on 7-segment display
HLT
STA 14
LDA 13
ADD 15
STA 13
JMP 0
.
1
.





-5
3
```

## Example output

```
address: contents    # assembly
---------------------------------
0000: 0001 1110      # 0.  LDA 14
0001: 0011 1100      # 1.  SUB 12
0010: 0111 0110      # 2.  JPC 6
0011: 0001 1101      # 3.  LDA 13
0100: 1110 0000      # 4.  OUT
0101: 1111 0000      # 5.  HLT
0110: 0100 1110      # 6.  STA 14
0111: 0001 1101      # 7.  LDA 13
1000: 0010 1111      # 8.  ADD 15
1001: 0100 1101      # 9.  STA 13
1010: 0110 0000      # 10. JMP 0
1011: 0000 0000      # 11. 0
1100: 0000 0001      # 12. 1
1101: 0000 0000      # 13. 0
1110: 1111 1011      # 14. 251 or -5
1111: 0000 0011      # 15. 3
```

## How to run
Install git https://git-scm.com/ and execute the following on the terminal:

```console
git clone https://github.com/skirienkopanea/8bit
```

Then save a txt file with the assembly code in `/8bit/src` if you run it from the terminal or probably `/8bit` if you run it from an IDE such as IntelliJ. Download java https://www.java.com if you don't have it. Make sure to "set the path" for "java" and "javac" and double check to have the jdk somewhere:
```
set "path=%path%"
echo %path
```

* Alternatively, you may give the full path of the txt file (without the ".txt" part) such that it's no longer necessary to store it in the same directory as the program

* The path for java and javac is usually in `C:\Program Files (x86)\Java\jdk1.8.0_281\bin`

If you run the program from the terminal then execute or save the following code as a .bat file in `/8bit` folder.

```
cd src
javac Main.java
java Main input_name output_name
pause
```

If the path variable doesn't work then just use:

```
"C:\Program Files (x86)\Java\jdk1.8.0_281\bin\javac.exe" Main.java
java Main input_name output_name
pause
```

### Run without saving output
Run the program without a second argument.
Either `java Main input_name` or `java Main` should do the trick.

## Batch file
I included a batch file example for Windows 10 users with an absolute path for the input file and with the compiled program in `/8bit/out/production/8bit`
