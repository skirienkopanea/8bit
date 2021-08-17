# 8bit
[Ben Eater 8 bit computer](https://eater.net/8bit/) assembly compiler in java.

Takes a txt file with assembly code with the instruction set below and saves a copy in binary.

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

*Line breaks are ignored, unknown opcodes are replaced with 0's and no operand is also defaulted with 0's. Anything after the operand (or opcode if there's no operand) is ignored (i.e. comments)*

## Example input

```
LDA 14
SUB 12
JPC 6
LDA 13
OUT // show on 7-segment display
HLT
STA 14
LDA 13
ADD 15
STA 13
JMP 0
.
1
.





250
3
```

## Example output

```
address: contents
-----------------
0000: 0001 1110
0001: 0011 1100
0010: 0111 0110
0011: 0001 1101
0100: 1110 0000
0101: 1111 0000
0110: 0100 1110
0111: 0001 1101
1000: 0010 1111
1001: 0100 1101
1010: 0110 0000
1011: 0000 0000
1100: 0000 0001
1101: 0000 0000
1110: 1111 1010
1111: 0000 0011
```
