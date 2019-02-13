package arc;

public class Q6 {
    public static String convert(String s, int numRows) {
        char []data = s.toCharArray();
        int position = 0;
        char []result = new char[data.length];
        for(int i=0;i<numRows;i++){
            int n=0;
            do{
                result[position++]=data[i+n*(2*numRows-2)];
                if(i%(numRows-1)!=0){
                    result[position++]=data[(n+1)*(2*numRows-2)-i];
                }
                n++;
            }while (i+n*(2*numRows-2)<data.length||(n+1)*(2*numRows-2)-i<data.length);

        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }
}
