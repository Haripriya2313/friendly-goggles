package com.workattech.splitwise.models.split1;

import com.workattech.splitwise.models.User1;

public abstract class Split1 {
    private User user;
    double amnt;

    public Split(User1 user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User1 user) {
        this.user = user;
    }

    public double getAmount() {
        return amnt;
    }

    public void setAmount(double amnt) {
        this.amnt = amnt;
    }
}
