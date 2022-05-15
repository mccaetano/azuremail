package org.mcc.azuremail.controller;

import org.mcc.azuremail.model.ApplicationProperties;
import org.mcc.azuremail.sender.MailSenderRequest;
import org.mcc.azuremail.sender.MailSenderResponse;
import org.mcc.azuremail.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class SendMailEndpoint {

    @Autowired
    private ApplicationProperties properties;

    @Autowired
    private SendMailService service;

    private final String TRAGET_NAMESPACE = "http://mcc.org/azuremail/sender";


    @PayloadRoot(namespace = TRAGET_NAMESPACE, localPart = "mailSenderRequest")
    @ResponsePayload
    public MailSenderResponse mailSenderRequest(@RequestPayload MailSenderRequest mailSenderRequest) {
        String response = "send Ok";
        try {
            service.sendMail(mailSenderRequest);
        } catch (Exception ex) {
            response = ex.getLocalizedMessage();
        }

        MailSenderResponse mailSenderResponse = new MailSenderResponse();
        mailSenderResponse.setResponse(response);
        return mailSenderResponse;
    }
}
