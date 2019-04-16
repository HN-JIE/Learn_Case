package arc;

public class Q1015 {
//    public static int numDupDigitsAtMostN(int N) {
//        int i = 1;
//        for (; Math.pow(10, i + 1) <= N; i++) ;
//        int temp = (int) (N / (Math.pow(10, i)));
//        if (temp >= 2) {
//            return workFor10((int) Math.pow(10, i), i ,temp) +
//        }
//    }

    public static int workFor10(int n, int count1, int count2) {
        int temp;
        if (count2 == 1) {
            if (count1 == 1) return 0;
            if (count1 == 2) return 10;
            temp = workFor10(n / 10, count1 - 1, 1);
            return  9 * (temp + workForNN(count1 - 1) * workForNN(9) / workForNN(9 - count1 + 2)) + temp;
        } else {
            temp = workFor10(n / count2, count1, 1);
            return (count2 - 1) * (temp -1 + workForNN(count1) * workForNN(9) / workForNN(9 - count1 + 1)) + temp;
        }
    }

    public static int workForNN(int n) {
        int result = 1;
        for (; n > 1; n--) {
            result = result * n;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(workFor10(10, 1, 1));
        System.out.println(workFor10(20, 1, 2));
        System.out.println(workFor10(40, 1, 4));
        System.out.println(workFor10(100, 2, 1));
        System.out.println(workFor10(400, 2, 4));
        System.out.println(workFor10(1000, 3, 1));


    }
}
