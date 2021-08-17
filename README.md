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
| 0110               | JPC             | yes         | Jump to the memory address of the operand if last operation had a 9th bit carry                                   |
| 0111               | JPZ             | yes         | Jump to the memory address of the operand if the last operation resulted in zero                                  |
| 1110               | OUT             | no          | Load contents of register A into output register                                                                  |
| 1111               | HLT             | no          | Halt the system                                                                                                   |

## Example input

```
LDI 5
OUT
HLT
```

## Example output

```
address: contents
-----------------
0000: 0101 0101
0001: 1110 0000
0010: 1111 0000
```
