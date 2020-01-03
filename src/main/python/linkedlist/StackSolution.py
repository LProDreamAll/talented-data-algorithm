def isVaild(self, s):
    '''
    判断字符串 '[(())]' 是否合理
    时间复杂度O(n) 空间复杂度O(n)
    :param self:
    :param s:
    :return:
    '''
    stack = []
    # key都是左括号 value都是右括号
    paren_map = {')': '(', ']': '[', '}': '{'}
    for c in s:
        if c not in paren_map:  # 不是右括号 比较的是key
            stack.append(c)  # 放到stack中
        elif not stack or paren_map[c] != stack.pop():  # 和栈顶元素进行匹配判断是否是
            return False
        # null合法
    return not stack



