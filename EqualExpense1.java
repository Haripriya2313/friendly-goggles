package com.workattech.splitwise.models.expense1;

import com.workattech.splitwise.models.User1;
import com.workattech.splitwise.models.split.EqualSplit1;
import com.workattech.splitwise.models.split.Split1;

import java.util.List;

public class EqualExpense1 extends Expense1 {
    public EqualExpense(double amnt, User1 paidBy, List<Split> splits, ExpenseMetadata1 expenseMetadata) {
        super(amnt, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}
