package com.example.service;

import com.example.model.Mailbox;

public interface IMailboxService {
    Mailbox list();

    Mailbox update(Mailbox mailbox);

    String[] languagesList();

    String[] pageSizeList();
}
