package com.workattech.splitwise;

import com.workattech.splitwise.models.User1;
import com.workattech.splitwise.models.expense.ExpenseType1;
import com.workattech.splitwise.models.split.EqualSplit1;
import com.workattech.splitwise.models.split.ExactSplit1;
import com.workattech.splitwise.models.split.PercentSplit1;
import com.workattech.splitwise.models.split.Split1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        ExpenseManager1 expenseManager = new ExpenseManager();

        expenseManager.addUser(new User("u1", "User1", "hari@workat.tech", "9875436789"));
        expenseManager.addUser(new User("u2", "User2", "priya@workat.tech", "9875436789"));
        expenseManager.addUser(new User("u3", "User3", "hi@workat.tech", "9875436789"));
        expenseManager.addUser(new User("u4", "User4", "interviews@workat.tech", "9875436789"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (commandType) {
                case "SHOW":
                    if (commands.length == 1) {
                        expenseManager.showBalances();
                    } else {
                        expenseManager.showBalance(commands[1]);
                    }
                    break;
                case "EXPENSE":
                    String paidBy = commands[1];
                    Double amnt = Double.parseDouble(commands[2]);
                    int noOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    List<Split> splits = new ArrayList<>();
                    switch (expenseType) {
                        case "EQUAL":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new EqualSplit1(expenseManager.userMap.get(commands[4 + i])));
                            }
                            expenseManager.addExpense(ExpenseType1.EQUAL, amnt, paidBy, splits, null);
                            break;
                        case "EXACT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new ExactSplit1(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType1.EXACT, amnt, paidBy, splits, null);
                            break;
                        case "PERCENT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new PercentSplit1(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.PERCENT, amnt, paidBy, splits, null);
                            break;
                    }
                    break;
            }
        }
    }
}
