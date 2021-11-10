package com.workattech.splitwise.models.split1;

import com.workattech.splitwise.models.User1;

public class PercentSplit1 extends Split1 {
    double percent1;

    public PercentSplit1(User1 user, double percent1) {
        super(user);
        this.percent1 = percent1;
    }

    public double getPercent() {
        return percent1;
    }

    public void setPercent(double percent1) {
        this.percent1 = percent1;
    }
}
