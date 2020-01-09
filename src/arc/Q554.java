package arc;

import java.util.*;

public class Q554 {
    public static int leastBricks(List <List <Integer>> wall) {
        if (wall.size() == 1 && wall.get(0).size()==1) return 1;
        if (wall.size() <= 1) return 0;
        Map<Integer, Integer> resultMap = new HashMap();
        for(List<Integer> list:wall){
            int tempSum = 0;
            for (int i = 0;i<list.size()-1;i++){
                tempSum+=list.get(i);
                if(resultMap.get(tempSum) == null){
                    resultMap.put(tempSum,1);
                }else {
                    resultMap.put(tempSum,resultMap.get(tempSum)+1);
                }
            }
        }
        int max = wall.size();
        int temp = 0;
        for(Map.Entry entry:resultMap.entrySet()){
            int value = (int)entry.getValue();
            if(value > temp) temp = value;
        }
        return max - temp;
    }


    public static void main(String[] args) {
//        List <List <Integer>> wall = new LinkedList <>();
//        wall.add(new LinkedList <>(){{add(1);add(2);add(2);add(1);}});
//        wall.add(new LinkedList <>(){{add(3);add(1);add(2);}});
//        wall.add(new LinkedList <>(){{add(1);add(3);add(2);}});
//        wall.add(new LinkedList <>(){{add(2);add(4);}});
//        wall.add(new LinkedList <>(){{add(3);add(1);add(2);}});
//        wall.add(new LinkedList <>(){{add(1);add(3);add(1);add(1);}});
//        wall.add(new LinkedList <>(){{add(1);add(1);add(1);add(1);}});
//        wall.add(new LinkedList <>(){{add(1);add(1);add(1);add(1);}});
//        wall.add(new LinkedList <>(){{add(1);add(1);add(1);add(1);}});
//        System.out.println(leastBricks(wall));


        List<Integer> a = new LinkedList();
        for (int i = 0; i<= 100;i++) a.add(i);
        System.out.println(System.currentTimeMillis());
        for (Integer i :a)
            System.out.print(i);
        System.out.println();
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i<= 100;i++)
            System.out.print(i);
        System.out.println();
        System.out.println(System.currentTimeMillis());
        a.stream().forEach(b-> System.out.print(b));
        System.out.println();
        System.out.println(System.currentTimeMillis());

    }
}


