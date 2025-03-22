public class LCMRecord {
    int num1, num2, num3, result;

    public LCMRecord(int num1, int num2, int num3, int result) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.result = result;
    }

    public boolean equals(int a, int b, int c) {
        return this.num1 == a && this.num2 == b && this.num3 == c;
    }
}
