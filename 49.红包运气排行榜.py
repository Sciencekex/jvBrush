# 问题描述
# 小C参与了一场抢红包的游戏，现在他想要对所有参与抢红包的人进行一次运气排名。排名规则如下：抢到的金额越多，排名越靠前；如果两个人抢到的金额相同，则按照他们抢红包的顺序进行排名。比如，如果小C和小U抢到的金额相同，但小C比小U先抢，则小C排在小U前面。

# 测试样例
# 样例1：

# 输入：n = 4 ,s = ["a", "b", "c", "d"] ,x = [1, 2, 2, 1]
# 输出：['b', 'c', 'a', 'd']

# 样例2：

# 输入：n = 3 ,s = ["x", "y", "z"] ,x = [100, 200, 200]
# 输出：['y', 'z', 'x']

# 样例3：

# 输入：n = 5 ,s = ["m", "n", "o", "p", "q"] ,x = [50, 50, 30, 30, 20]
# 输出：['m', 'n', 'o', 'p', 'q']

def solution(n: int, s: list, x: list) -> list:
    data = {}
    for i in range(n):
        char=s[i]
        value=x[i]
        if char in data:
            data[char][1]+=value
        else:
            data[char]=[i+1,value]

    print(data)

    items=list(data.items())
    print(items)

    def sort_key(item):
        return (-item[1][1],item[1][0])

    sorted_items=sorted(items,key=sort_key)
    print(sorted_items)

    result=[]
    for item in sorted_items:
        result.append(item[0])

    return result

if __name__ == '__main__':
    print(solution(4, ["a", "b", "c", "d"], [1, 2, 2, 1]) == ['b', 'c', 'a', 'd'])
    print(solution(3, ["x", "y", "z"], [100, 200, 200]) == ['y', 'z', 'x'])
    print(solution(5, ["m", "n", "o", "p", "q"], [50, 50, 30, 30, 20]) == ['m', 'n', 'o', 'p', 'q'])
    print(solution(12, ["aa","aaaaaaa","aaaa","aaaa","aaaa","aaaaaaaaaa","aaaaaaaaa","aaaa","aaaaaaaaaa","aaaaaaaaa","aaaaa","aaaa"], [17,14,11,2,8,16,14,17,10,6,5,12]) == ["aaaa","aaaaaaaaaa","aaaaaaaaa","aa","aaaaaaa","aaaaa"]) 
#     ["aa","aaaaaaa","aaaa","aaaa","aaaa","aaaaaaaaaa","aaaaaaaaa","aaaa","aaaaaaaaaa","aaaaaaaaa","aaaaa","aaaa"]
# [17,14,11,2,8,16,14,17,10,6,5,12]

# data = {}
#     for i in range(n):
#         char=s[i]
#         value=x[i]
#         data[char]=[i+1,value]
#     print(data)

# 在这个阶段优化一下, 把同名的红包金额合并在一起