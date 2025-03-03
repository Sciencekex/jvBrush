def add(a: int, b: int) -> int:
    return a + b
print(add("1", "2"))  # 运行时不会报错，但结果可能不符合预期

# def get_length(s: str | None) -> int:
#     return len(s)  # 如果 s 为 None，会抛出 AttributeError
# print(get_length(None))

# 1. 访问对象属性
class User:
    def __init__(self, name: str):
        self.name = name

def get_user_name(user: User | None) -> str:
    return user.name  # 如果 user 为 None，会抛出 AttributeError

print(get_user_name(None))  # AttributeError: 'NoneType' object has no attribute 'name'

# Python 的动态类型和缺乏空安全机制确实会导致一些潜在的问题，尤其是在处理可能为 None 的值时。以下是一些类似的例子，展示了 Python 中由于缺乏空安全机制而导致的常见问题：