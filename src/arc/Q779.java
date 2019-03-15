package arc;

public class Q779 {
    public static int kthGrammar(int x, int y) {
        boolean t = true;
        for (;x!=1&&y!=1&&y!=0;){
            for (;y<=(1<<(x-2));){
                x--;
            }
            y = y - (1<<(x-2));
            t = !t;
        }
        if(y==0&&x%2==1){
            return 0;
        }
        return !t?1:0;
    }


    public static void main(String[] args) {
        System.out.println(kthGrammar(1,1));
        System.out.println(kthGrammar(4,5));
        System.out.println(kthGrammar(5,10));
        System.out.println(kthGrammar(30,417219134));
        System.out.println(kthGrammar(30,434991989));

    }

}
