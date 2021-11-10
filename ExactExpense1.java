package com.workattech.splitwise.models.expense1;

import com.workattech.splitwise.models.User1;
import com.workattech.splitwise.models.split.ExactSplit1;
import com.workattech.splitwise.models.split.Split1;

import java.util.List;

public class ExactExpense1 extends Expense1 {
    public ExactExpense(double amnt, User1 paidBy, List<Split> splits, ExpenseMetadata1 expenseMetadata) {
        super(amnt, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split1 split : getSplits()) {
            if (!(split instanceof ExactSplit1)) {
                return false;
            }
        }

        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for (Split1 split : getSplits()) {
            ExactSplit1 exactSplit = (ExactSplit1) split;
            sumSplitAmount += exactSplit.getAmount();
        }

        if (totalAmount != sumSplitAmount) {
            return false;
        }

        return true;
    }
}
