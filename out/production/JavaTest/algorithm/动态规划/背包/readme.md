
# 递归
```java
求最大价值(背包.重量, 物品.重量数组, 物品.用n个){
    // 放不进去
    if 第n个物品.重量 > 背包.重量 : 不用第n个物品
    // 放的进去
    else 最大价值 = max(用第n个物品, 不用第n个物品)
}

// 放的进去,用
用第n个物品 = 求背包最大价值( 背包.重量-第n个物品.重量, 物品.重量数组, 物品.用n-1个) + 第n个物品价值
// 放的进去,但不用
不用第n个物品 = 求背包最大价值(背包.重量, 物品.重量数组, 物品.用n-1个)
```

# 记忆递归值


# 迭代实现