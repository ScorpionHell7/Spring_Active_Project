package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
@Data
public class ContactService {

//    private int counter = 0;
//    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    @Autowired
    private ContactRepository contactRepository;

    public ContactService(){
        System.out.println("ContactService constructor");
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean issaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result>0){
            issaved=true;
        }
        return issaved;
    }

    public List<Contact> findMsgWithOpenStatus() {
        List<Contact> contactMsgs = contactRepository.findMsgWithStatus(EazySchoolConstants.OPEN);
        return contactMsgs;
    }

}
