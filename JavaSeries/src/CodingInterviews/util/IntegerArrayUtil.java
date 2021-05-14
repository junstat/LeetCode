package CodingInterviews.util;

public class IntegerArrayUtil {
    public static int partition(int[] data, int start, int end) throws Exception {
        if (data == null || data.length <= 0 || start < 0 || end >= data.length)
            throw new Exception("Invalid Parameters");

        // int index = randomInRange(start, end);
        // exchange(data, index, end);

        int small = start - 1;
        for (int index = start; index < end; ++index) {
            if (data[index] < data[end]) {
                ++small;
                if (small != index)
                    exchange(data, index, small);
            }
        }

        ++small;
        exchange(data, small, end);
        return small;
    }

    public static int randomInRange(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
