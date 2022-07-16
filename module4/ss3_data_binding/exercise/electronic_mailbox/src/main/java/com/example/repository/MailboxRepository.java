package com.example.repository;

import com.example.model.Mailbox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class MailboxRepository implements IMailboxRepository {
    static Mailbox mailbox1=new Mailbox("Vietnamese","25",true   ,"hello word");

    @Override
    public Mailbox list() {
        return mailbox1;
    }

    @Override
    public Mailbox update(Mailbox mailbox) {
        mailbox1=new Mailbox(mailbox.getLanguages(), mailbox.getPageSize(),mailbox.getSpamsFilter()   ,mailbox.getSignature());
        return mailbox1;
    }

}
