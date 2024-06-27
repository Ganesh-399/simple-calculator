a = int(input("Enter num1 value : "))
b = int(input("Enter num2 value : "))
operator = input("Enter operator : ")
if operator == '+':
    print("Addition of two numbers is : ", a+b)
elif operator == '-':
    print("Subtraction of two numbers is : ", a-b)
elif operator == '*':
    print("Multiplication of two numbers is : ", a*b)
elif operator == '/':
    print("Division of two numbers is : ", a/b)
else:
    print("Invalid Operation")
