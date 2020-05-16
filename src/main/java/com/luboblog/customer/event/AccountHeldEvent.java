package com.luboblog.customer.event;

import com.luboblog.customer.aggregate.Status;

public class AccountHeldEvent extends BaseEvent<String> {

    public final Status status;

    public AccountHeldEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
    
}