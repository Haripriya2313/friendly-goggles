package com.workattech.splitwise;

import com.workattech.splitwise.models.User1;
import com.workattech.splitwise.models.expense.Expense1;
import com.workattech.splitwise.models.expense.ExpenseMetadata1;
import com.workattech.splitwise.models.expense.ExpenseType1;
import com.workattech.splitwise.models.split.Split1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager1 {
    List<Expense> expenses;
    Map<String, User> userMap;
    Map<String, Map<String, Double> > balanceSheet;

    public ExpenseManager1() {
        expenses = new ArrayList<Expense>();
        userMap = new HashMap<String, User>();
        balanceSheet = new HashMap<String, Map<String, Double>>();
    }

    public void addUser(User1 user) {
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<String, Double>());
    }

    public void addExpense1(ExpenseType1 expenseType, double amnt, String paidBy, List<Split> splits, ExpenseMetadata1 expenseMetadata) {
        Expense1 expense = ExpenseService1.createExpense(expenseType, amnt, userMap.get(paidBy), splits, expenseMetadata);
        expenses.add(expense);
        for (Split1 split : expense.getSplits()) {
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = balanceSheet.get(paidBy);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }

    public void showBalance1(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance1(userId, userBalance.getKey(), userBalance.getValue());
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void showBalances1() {
        boolean isEmpty = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance1(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    private void printBalance1(String user1, String user2, double amount) {
        String user1Name = userMap.get(user1).getName();
        String user2Name = userMap.get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amnt));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amnt));
        }
    }
}
