import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // Once the window reaches size m
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, countMap.size());
                
                // Remove the oldest element from the left of the deque
                int removed = deque.remove();
                int count = countMap.get(removed);
                if (count == 1) {
                    countMap.remove(removed);
                } else {
                    countMap.put(removed, count - 1);
                }
            }
        }
        
        System.out.println(maxUnique);
        in.close();
    }
}