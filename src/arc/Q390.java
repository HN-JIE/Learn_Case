package arc;

public class Q390 {
    public static int lastRemaining(int n) {
        if (n <= 1) {
            return n;
        }
        return work(1, n, 1, true);
    }

    public static int work(int start, int end, int interval, boolean isLeft) {
        if (end - start == interval||end==start) {
            if (isLeft) {
                return end;
            } else {
                return start;
            }
        }
        if (isLeft) {
            if ((end - start) % (interval * 2) == 0) {
                return work(start + interval, end - interval, interval * 2, false);
            } else {
                return work(start + interval, end, interval * 2, false);
            }
        } else {
            if ((end - start) % (interval * 2) == 0) {
                return work(start + interval, end - interval, interval * 2, true);
            } else {
                return work(start, end - interval, interval * 2, true);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
        System.out.println(lastRemaining(10));
        System.out.println(lastRemaining(4));
        System.out.println(lastRemaining(3));
    }
}
