import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println(camelCase("camelCase"));

//        System.out.println(revRot("1234569876541", 6));

//        System.out.println(Arrays.toString(arrayDiff(new int[]{1, 2, 2, 2, 3}, new int[]{2})));

        List<String> a = new ArrayList<>();
        a.add(":)"); a.add(":D"); a.add(":-}"); a.add(":-()");

//        System.out.println(countSmileys(a));

//        System.out.println(greedy(new int[] {1,1,1,3,1}));
        System.out.println(Arrays.toString(productFib(4895)));
    }

    public static String camelCase(String input) {
        String[] result = input.split("(?=[A-Z])");
        StringBuilder resultString = new StringBuilder();
        for (String s : result) {
            resultString.append(s).append(" ");
        }
        resultString.deleteCharAt(resultString.length() - 1);
        return resultString.toString();
    }

    public static String revRot(String strng, int sz) {
        // your code
        StringBuilder result = new StringBuilder();
        String[] array;
        double sum;

        if(strng.isEmpty() || sz <= 0 || sz > strng.length()) {
            return "";
        }

        for (int i = 0; i < strng.length();) {
            if (i + sz > strng.length()){
                break;
            }

            sum = 0;

            String part = strng.substring(i, i + sz);

            array = part.split("");
            for (int k = 0; k < sz; k++){
                sum = sum + Math.pow(Double.parseDouble(array[k]), 3);
            }

            if(sum % 2 == 0) {
                for (int j = sz - 1; j >= 0; j--){
                    result.append(array[j]);
                }
            } else {
                for (int j = 1; j < sz; j++){
                    result.append(array[j]);
                }
                result.append(array[0]);
            }
            i = i + sz;
        }

        return result.toString();
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        String[] aString = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            aString[i] = String.valueOf(a[i]);
        }
        List<String> aTemp = new ArrayList<>(Arrays.asList(aString));
        for (int j : b) {
            aTemp.removeAll(Collections.singleton(String.valueOf(j)));
        }

        return aTemp.stream().mapToInt(Integer::parseInt).toArray();
    }

    public static int countSmileys(List<String> arr) {
        // Just Smile :)
        List<String> smile = new ArrayList<>();
        smile.add(":)");
        smile.add(";)");
        smile.add(":-)");
        smile.add(";-)");
        smile.add(":~)");
        smile.add(";~)");
        smile.add(":D");
        smile.add(";D");
        smile.add(":-D");
        smile.add(";-D");
        smile.add(":~D");
        smile.add(";~D");

        int count = (int) smile.stream().filter(s -> arr.equals(s)).count();
        return count;
    }

    public static int greedy(int[] dice){
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int result = 0;

        for (int die : dice) {
            if (die == 1) {
                count1++;
            } else if (die == 2) {
                count2++;
            } else if (die == 3) {
                count3++;
            } else if (die == 4) {
                count4++;
            } else if (die == 5) {
                count5++;
            } else if (die == 6) {
                count6++;
            }
        }

        if (count1 >= 3) {
            result += 1000;
            count1 -= 3;
        }

        if (count2 >= 3) {
            result += 200;
        }

        if (count3 >= 3) {
            result += 300;
        }

        if (count4 >= 3) {
            result += 400;
        }

        if (count5 >= 3) {
            result += 500;
            count5 -= 3;
        }

        if (count6 >= 3) {
            result += 600;
        }

        result += count1 * 100 + count5 * 50;

        return result;
    }

    public static long[] productFib(long prod) {
        long n1 = 0;
        long n2 = 1;
        long n3;
        while (n1 * n2 <= prod) {
            if (n1 * n2 < prod) {
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;
            } else if (n1 * n2 == prod) {
                break;
            } else if (n1 * n2 > prod){
                break;
            }
        }
        if (n1 * n2 == prod) {
            return new long[] {n1, n2, 1};
        } else {
            return new long[] {n1, n2, 0};
        }
    }

    public static String longestConsec(String[] strarr, int k) {
        StringBuilder tempString = new StringBuilder();
        String result = "";
        if (k == 1) {
            for (String s : strarr) {
                if (s.length() > result.length()) {
                    result = s;
                }
            }
        } else if (k <= 0) {
            return result;
        } else {
            for (int i = 0; i <= strarr.length - k; i++) {
                for (int j = 0; j < k; j++) {
                    tempString.append(strarr[i + j]);
                }
                if (tempString.toString().length() > result.length()) {
                    result = tempString.toString();
                }
                tempString = new StringBuilder();
            }
        }
        return result;
    }
}
