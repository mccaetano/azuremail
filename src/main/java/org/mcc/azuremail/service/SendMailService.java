package org.mcc.azuremail.service;

import org.mcc.azuremail.component.MicrosoftGraphComponent;
import org.mcc.azuremail.sender.MailSenderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    @Autowired
    private MicrosoftGraphComponent graphComponent;

    public void sendMail(MailSenderRequest mailSenderRequest) {
        graphComponent.sendMail(mailSenderRequest);
    }
}
