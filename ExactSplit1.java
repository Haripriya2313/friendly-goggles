package com.workattech.splitwise.models.split1;

import com.workattech.splitwise.models.User1;

public class ExactSplit1 extends Split1 {

    public ExactSplit1(User1 user, double amnt) {
        super(user);
        this.amnt = amnt;
    }
}
