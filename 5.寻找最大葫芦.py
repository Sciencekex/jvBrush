# 问题描述
# 在一场经典的德州扑克游戏中，有一种牌型叫做“葫芦”。“葫芦”由五张牌组成，其中包括三张相同牌面值的牌
# a
# a 和另外两张相同牌面值的牌
# b
# b。如果两个人同时拥有“葫芦”，我们会优先比较牌
# a
# a 的大小，若牌
# a
# a 相同则再比较牌
# b
# b 的大小，牌面值的大小规则为：1 (A) > K > Q > J > 10 > 9 > ... > 2，其中 1 (A) 的牌面值为1，K 为13，依此类推。
#
# 在这个问题中，我们对“葫芦”增加了一个限制：组成“葫芦”的五张牌牌面值之和不能超过给定的最大值
# m
# a
# x
# max。
#
# 给定一组牌，你需要找到符合规则的最大的“葫芦”组合，并输出其中三张相同的牌面和两张相同的牌面。如果找不到符合条件的“葫芦”，则输出 “0, 0”。
#
# 测试样例
# 样例1：
#
# 输入：n = 9, max = 34, array = [6, 6, 6, 8, 8, 8, 5, 5, 1]
# 输出：[8, 5]
# 说明：array数组中可组成4个葫芦，分别为[6,6,6,8,8],[6,6,6,5,5],[8,8,8,6,6],[8,8,8,5,5]。其中[8,8,8,6,6]的牌面值为36，大于34不符合要求。剩下的3个葫芦的大小关系为[8,8,8,5,5]>[6,6,6,8,8]>[6,6,6,5,5],故返回[8,5]
#
# 样例2：
#
# 输入：n = 9, max = 37, array = [9, 9, 9, 9, 6, 6, 6, 6, 13]
# 输出：[6, 9]
# 说明：可组成2个葫芦，分别为[9,9,9,6,6]和[6,6,6,9,9],由于[9,9,9,6,6]的牌面值为39，大于37，故返回[6,9]
#
# 样例3：
#
# 输入：n = 9, max = 40, array = [1, 11, 13, 12, 7, 8, 11, 5, 6]
# 输出：[0, 0]
# 说明：无法组成任何葫芦，故返回[0,0]
#
# 样例4：
#
# 输入：n = 6, max = 50, array = [13, 13, 13, 1, 1, 1]
# 输出：[1, 13]
# 说明：可组成两个葫芦，分别为[A,A,A,K,K]和[K,K,K,A,A],两者牌面值都小于50，故都合法。因为三张相同牌面值的A > K,故[A,A,A,K,K]比[K,K,K,A,A]要大，返回[1,13]
def solution(n, max_sum, array):
    from collections import Counter

    count=Counter(array)

    candidates_b=[key for key, val in count.items() if val >= 2]
    candidates_a=[key for key, val in count.items() if val >= 3]

    possible_combinations=[]
    for a in candidates_a:
        for b in candidates_b:
            if a!= b:
                possible_combinations.append((a,b))

    valid_combinations=[]
    for a,b in possible_combinations:
        total=3*a+2*b
        if total<=max_sum:
            valid_combinations.append((a,b))

    if not valid_combinations:
        return [0,0]

    def get_priority(value):
        return 14 if value==1 else value

    def compare(combination):
        priority1=get_priority(combination[0])
        priority2=get_priority(combination[1])
        return (priority1,priority2)
    max_combination=max(valid_combinations,key=compare)

    return list(max_combination)


if __name__ == "__main__":
    # Add your test cases here

    print(solution(9, 34, [6, 6, 6, 8, 8, 8, 5, 5, 1]) == [8, 5])
    print(solution(9, 37, [9, 9, 9, 9, 6, 6, 6, 6, 13]) == [6, 9])
    print(solution(9, 40, [1, 11, 13, 12, 7, 8, 11, 5, 6]) == [0, 0])
