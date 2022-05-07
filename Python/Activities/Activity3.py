def user1Choice(user1):
    user1_choice = input(user1 + " choose rock or paper or scissor ").lower()
    if user1_choice not in input1:
        user1_choice = user1Choice(user1)
    return user1_choice


def user2Choice(user2):
    user2_choice = input(user2 + " choose rock or paper or scissor ").lower()
    if user2_choice not in input1:
        user2_choice = user2Choice(user2)
    return user2_choice


def rockPaperScissor():
    user1_choice = user1Choice(user1)
    user2_choice = user2Choice(user2)
    if user1_choice == user2_choice:
        print("It's a tie!")
    elif user1_choice == "rock":
        if user2_choice == "scissor":
            print(user1 + " won!!!")
        elif user2_choice == "paper":
            print(user2 + " won!!!")
    elif user1_choice == "scissor":
        if user2_choice == "paper":
            print(user1 + " won!!!")
        elif user2_choice == "rock":
            print(user2 + " won!!!")
    elif user1_choice == "paper":
        if user2_choice == "rock":
            print(user1 + " won!!!")
        elif user2_choice == "scissor":
            print(user2 + " won!!!")


user1 = input("Enter player1 name ")
user2 = input("Enter player2 name ")
input1 = ["rock", "paper", "scissor"]
rockPaperScissor()
play_again = input("Do you want to play another round? Yes/No ").lower()
if play_again == "yes" or play_again == "y":
    rockPaperScissor()
elif play_again == "no" or play_again == "n":
    raise SystemExit
else:
    print("You have entered invalid option. Exiting from game")
    raise SystemExit
