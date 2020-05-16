package com.luboblog.customer.event;

import com.luboblog.customer.aggregate.Status;

public class AccountActivatedEvent extends BaseEvent<String> {
    
    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}