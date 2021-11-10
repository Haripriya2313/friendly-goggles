package com.workattech.splitwise;

import com.workattech.splitwise.models.User1;
import com.workattech.splitwise.models.expense1.*;
import com.workattech.splitwise.models.split.PercentSplit1;
import com.workattech.splitwise.models.split.Split1;

import java.util.List;

public class ExpenseService1 {
    public static Expense createExpense1(ExpenseType1 expenseType, double amnt, Use1r paidBy, List<Split> splits, ExpenseMetadata1 expenseMetadata) {
        switch (expenseType) {
            case EXACT:
                return new ExactExpense1(amnt, paidBy, splits, expenseMetadata);
            case PERCENT:
                for (Split1 split : splits) {
                    PercentSplit1 percentSplit = (PercentSplit1) split;
                    split.setAmount((amnt*percentSplit.getPercent())/100.0);
                }
                return new PercentExpense1(amnt, paidBy, splits, expenseMetadata);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amnt*100/totalSplits))/100.0;
                for (Split1 split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + (amnt - splitAmount*totalSplits));
                return new EqualExpense1(amnt, paidBy, splits, expenseMetadata);
            default:
                return null;
        }
    }
}
