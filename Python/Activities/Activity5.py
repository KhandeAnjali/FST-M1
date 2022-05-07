def multiplication(num2):
    for j in range(1, 11):
        print(num2, "*", j, "=", num2 * j)


num1 = int(input("Enter a number: "))
print(type(num1))
if num1 == 0:
    num1 = int(input("Enter a number greater than 0"))
elif num1 > 0:
    multiplication(num1)
else:
    num1 = int(input("Enter valid input"))
