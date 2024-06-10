package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.model.Contact;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
@Data
public class ContactService {

    private int counter = 0;
//    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    public ContactService(){
        System.out.println("ContactService constructor");
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean issaved = true;
        log.info(String.valueOf(contact));
        return issaved;
    }
}
