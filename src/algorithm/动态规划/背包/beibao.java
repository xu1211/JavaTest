package algorithm.动态规划.背包;

import java.io.IOException;

/**
 * @author cosmoxu
 * @version beibao, v 0.1 2022/10/24 14:22
 */
public class beibao {

    public static void main(String[] args) throws IOException {
        int[] weight = new int[]{876, 560, 558, 518, 810, 516, 759, 867, 746, 523, 753, 830, 680, 511, 886, 611};
        int[] value = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.printf(ZeroOnePack(5000, 16, weight, value));
    }

    /**
     * 0-1背包问题
     *
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量
     * @param value  物品价值
     * @return
     */
    public static String ZeroOnePack(int V, int N, int[] weight, int[] value) {

        //初始化动态规划数组
        int[][] dp = new int[N + 1][V + 1];

        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < N + 1; i++) { //物品
            for (int j = 1; j < V + 1; j++) { //背包
                // 尝试第i件物品放入背包容量j
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j]; //放不进去, 最大价值 = 上一件物品的最大价值
                else
                    //放的进去, 最大价值 = 第i件物品价值 value[i - 1] + (背包容量-第i件物品重量)的价值 dp[i - 1][j - weight[i - 1]]
                    dp[i][j] = Math.max(
                            dp[i - 1][j], //第i件物品价值
                            dp[i - 1][j - weight[i - 1]] + value[i - 1] //不用第i件物品价值=(背包容量-第i件物品重量)的价值
                    );
            }
        }


        //则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        //逆推找出装入背包的所有商品的编号
        int j = V;
        StringBuilder numStr = new StringBuilder();
        for (int i = N; i > 0; i--) {
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            if (dp[i][j] > dp[i - 1][j]) {
                numStr.insert(0, i + ":" + weight[i - 1] + " ");
                j = j - weight[i - 1];
            }
            if (j == 0)
                break;
        }
        return numStr.toString();
    }
}
