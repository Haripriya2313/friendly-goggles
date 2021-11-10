package com.workattech.splitwise.models.expense1;

import com.workattech.splitwise.models.User1;
import com.workattech.splitwise.models.split1.Split;

import java.util.List;

public abstract class Expense1 {
    private String id;
    private double amnt;
    private User1 paidBy;
    private List<Split> splits;
    private ExpenseMetadata1 metadata;

    public Expense(double amnt, User paidBy, List<Split> splits, ExpenseMetadata1 metadata) {
        this.amnt = amnt;
        this.paidBy = paidBy;
        this.splits = splits;
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amnt;
    }

    public void setAmount(double amnt) {
        this.amnt = amnt;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ExpenseMetadata1 getMetadata() {
        return metadata;
    }

    public void setMetadata(ExpenseMetadata1 metadata) {
        this.metadata = metadata;
    }

    public abstract boolean validate();
}
