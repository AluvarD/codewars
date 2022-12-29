package tasks;

import java.util.ArrayList;
import java.util.List;

public class JosephusSurvivor {
    //https://www.codewars.com/kata/555624b601231dc7a400017a/train/java

    public static int josephusSurvivor(final int n, final int k) {
        if (n == 0) {
            return 0;
        }
        List<Integer> arrayList = createMap(n);
        int removeKey = 0;
        do {
            removeKey = getRemoveIndex(arrayList.size(), removeKey, k);
            arrayList.remove(removeKey);
        } while (arrayList.size() > 1);

        if (arrayList.isEmpty()) {
            return 0;
        } else {
            return arrayList.get(0);
        }
    }

    private static List<Integer> createMap(int length) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arrayList.add(i + 1);
        }
        return arrayList;
    }

    private static int getRemoveIndex(int arrayLength, int currentIndex, int k) {
        int result = currentIndex + k - 1;
        while (result >= arrayLength) {
            result = result - arrayLength;
        }
        return result;
    }
}
