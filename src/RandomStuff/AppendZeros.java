package RandomStuff;

// I performed below what I expected from myself in an interview and wanted to check the solution I was focusing on would wor

// --------------------------------THE PROBLEM--------------------------------
// given an array of integers, take out all the 0's and append them to the end
public class AppendZeros {
    // this solution is the one I was hinted at and eventually produced. It uses a copy of the array and seemed not as memory efficient as it could be
    public static int[] appendZeros(int[] array) {
        int[] result = new int[array.length];
        int index = 0;
        for (int n: array) {
            if (n != 0) {
                result[index++] = n;
            }
        }
        for(;index < array.length; index++) {
            result[index] = 0;
        }
        return result;
    }

    // this is the solution I was trying (and failing) to produce. This utilises the single array and doesn't use a copy: this is done by shifting non-zero values left by z
    public static int[] appendZerosMyWay(int[] array) {
        int zeroCount = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeroCount++;
            }
            else {
                array[i - zeroCount] = array[i];
            }
        }
        for (; zeroCount < array.length; zeroCount++) {
            array[zeroCount] = 0;
        }
        return array;
    }
}
