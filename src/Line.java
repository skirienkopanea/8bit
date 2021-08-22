public class Line {
    private int address;
    private Opcode instruction;
    private int operand;
    private int number;

    public Line(int address, Opcode instruction, int operand) {
        if (operand > 15 || operand < 0) {
            throw new IllegalArgumentException("operand is not a 4 bit unsigned integer");
        }
        this.address = address;
        this.instruction = instruction;
        this.operand = operand;
    }

    public Line(int address, int number) {
        if (number > 255 || number < -128) {
            throw new IllegalArgumentException("number is not supported by unsigned 8-bits nor signed 8-bits");
        }
        this.address = address;
        this.instruction = Opcode.NULL;
        this.operand = (byte) number & 0b00001111;
        this.number = number < 0 ? number + 256 : number;
    }

    public String getAddress() {
        return String.format("%4s", Integer.toBinaryString(address)).replace(' ', '0');
    }

    public String getInstruction() {
        switch (instruction) {
            case NOP:
                return "0000";
            case LDA:
                return "0001";
            case ADD:
                return "0010";
            case SUB:
                return "0011";
            case STA:
                return "0100";
            case LDI:
                return "0101";
            case JMP:
                return "0110";
            case JPC:
                return "0111";
            case JPZ:
                return "1000";
            case OUT:
                return "1110";
            case HLT:
                return "1111";
            default:
                return String.format("%4s", Integer.toBinaryString(number >> 4)).replace(' ', '0');
        }
    }

    public String getOperand() {
        return String.format("%4s", Integer.toBinaryString(operand)).replace(' ', '0');
    }

    @Override
    public String toString() {
        String op = "";
        switch (this.instruction) {
            case NULL:

                if (this.number > 127) {
                    op = String.valueOf(this.number + " or " + (this.number - 256));
                } else {
                    op = String.valueOf(this.number);
                }

                break;
            case OUT:
            case HLT:
                if (this.operand == 0) {
                    op = "";
                } else {
                    op = " " + String.valueOf(this.operand);
                }
                break;
            default:
                op = " " + this.operand;
        }
        return getAddress() + ": "
                + getInstruction() + " "
                + getOperand() + "      # " + address + (address < 10 ? ".  " : ". ")
                + (this.instruction != Opcode.NULL ? this.instruction : "")
                + op;
    }
}
