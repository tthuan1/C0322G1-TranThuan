package com.example.repository;

import com.example.model.Mailbox;

public interface IMailboxRepository {
    Mailbox list();

    Mailbox update(Mailbox mailbox);
}
