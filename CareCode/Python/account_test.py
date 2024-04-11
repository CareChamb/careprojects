# Author: Prof C.
# This program demonstrates the BankAccount class.

import bankaccount

def main():
    # Get the starting balance.
    start_bal = float(input('Enter your starting balance: '))

    # Create a BankAccount object by calling the def __init__()
    myAccount = bankaccount.BankAccount(start_bal)

    # Deposit the user's paycheck.
    pay = float(input('How much were you paid this week? '))
    print('I will deposit that into your account.')
    myAccount.deposit(pay)

    # Display the balance.
    print('Your account balance is $', \
          format(myAccount.get_balance(), ',.2f'),
          sep='')

    # Get the amount to withdraw.
    cash = float(input('How much would you like to withdraw? '))
    print('I will withdraw that from your account.')
    myAccount.withdraw(cash)

    # Display the balance.
    print('Your account balance is $', \
          format(myAccount.get_balance(), ',.2f'),
          sep='')

    # Or you can use the __str__ function to Display the balance.
    print(myAccount)

    

# Call the main function.
main()
