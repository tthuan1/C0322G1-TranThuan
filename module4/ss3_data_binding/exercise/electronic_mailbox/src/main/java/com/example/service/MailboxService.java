package com.example.service;

import com.example.model.Mailbox;
import com.example.repository.IMailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailboxService implements IMailboxService {

    @Autowired
    private IMailboxRepository mailboxRepository;


    @Override
    public Mailbox list() {
        return mailboxRepository.list();
    }

    @Override
    public Mailbox update(Mailbox mailbox) {
        return mailboxRepository.update(mailbox);
    }
}
