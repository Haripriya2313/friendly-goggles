package com.workattech.splitwise.models.expense1;

import com.workattech.splitwise.models.User1;
import com.workattech.splitwise.models.split.PercentSplit1;
import com.workattech.splitwise.models.split.Split1;

import java.util.List;

public class PercentExpense1 extends Expense1 {
    public PercentExpense1(double amnt, User1 paidBy, List<Split> splits, ExpenseMetadata1 expenseMetadata) {
        super(amnt, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split1 split : getSplits()) {
            if (!(split instanceof PercentSplit1)) {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split1 split : getSplits()) {
            PercentSplit1 exactSplit = (PercentSplit1) split;
            sumSplitPercent += exactSplit.getPercent();
        }

        if (totalPercent != sumSplitPercent) {
            return false;
        }

        return true;
    }
}
