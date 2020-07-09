package dataStructure.collection.List;

import java.util.*;

public class linkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 100;
        int M = sc.nextInt();
        LinkedList p = new LinkedList();

        if (M <= 1 && M >= 100) {
            System.out.println("ERROR!");
        } else {
            //初始化圈
            for (int i = 0; i < n; i++) {
                p.offer(i + 1);
            }
            //退圈
            int q = 0;
            while (!p.isEmpty()) {
                for (int j = 0; j < M - 1; j++) {
                    p.offer(p.poll());
                }
                q++;
                if (q > n - M + 1) {
                    System.out.print(p.poll());
                    if (!p.isEmpty()) {
                        System.out.print(",");
                    }
                } else {
                    p.poll();
                }
            }
        }
    }
}