strings = ['[]', # balanced
           '{}', # balanced
           '[[]', # not balanced
           '{{}}', # balanced
           '{]', # not balanaced
           '{[}]', # not balacned
           '()', # not balacned
           '((()', # not balacned
           '}[}]', # not balacned
           '{[}{]'] # not balacned


def is_balanced(string):
    brace_stack = []
    braces = {'}':'{', ']':'[', ')':'('}
    for char in string:
        # opening bracket
        if char in braces.values():
            brace_stack.append(char)

        # closing bracket
        if char in braces:
            # if we start with a closing bracket we're not gonna have luck
            if len(brace_stack) == 0:
                return False
            if brace_stack[-1] == braces[char]:
                brace_stack.pop()

    if len(brace_stack) != 0:
        return False
    else:
        return True


for string in strings:
    if is_balanced(string):
        print "%s is balanced" % string
    else:
        print "%s is not balanced" % string
