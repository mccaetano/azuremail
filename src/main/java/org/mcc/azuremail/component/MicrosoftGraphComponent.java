package org.mcc.azuremail.component;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.httpcore.HttpClients;
import com.microsoft.graph.models.*;
import com.microsoft.graph.requests.AttachmentCollectionPage;
import com.microsoft.graph.requests.AttachmentCollectionResponse;
import com.microsoft.graph.requests.GraphServiceClient;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.mcc.azuremail.sender.MailSenderRequest;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Base64;
import java.util.LinkedList;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MicrosoftGraphComponent {

    public void sendMail(MailSenderRequest mailModel) {
        log.info("Azure Send Mail form: " + mailModel.getMessage().getFrom() + ", to: " + mailModel.getMessage().getTo());
        Message message = new Message();
        message.subject = mailModel.getMessage().getSubject();
        ItemBody body = new ItemBody();
        body.contentType = BodyType.valueOf(mailModel.getMessage().getContentType().value());
        body.content = mailModel.getMessage().getBody();
        message.body = body;


        LinkedList<Recipient> toRecipientsList = new LinkedList<>();
        Recipient toRecipients = new Recipient();
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.address = mailModel.getMessage().getTo();
        toRecipients.emailAddress = emailAddress;
        toRecipientsList.add(toRecipients);
        message.toRecipients = toRecipientsList;
        LinkedList<Attachment> attachments = mailModel.getMessage().getAttachments().getAttachment()
                .stream()
                .map(attach -> {
                    FileAttachment attachment = new FileAttachment();
                    attachment.contentType = attach.getContentType();
                    attachment.name = attach.getName();
                    attachment.contentBytes = Base64.getDecoder().decode(attach.getBinary());
                    attachment.oDataType = "#microsoft.graph.fileAttachment";
                    return attachment;
                })
                .collect(Collectors.toCollection(LinkedList::new));
        AttachmentCollectionResponse attachmentCollectionResponse = new AttachmentCollectionResponse();
        attachmentCollectionResponse.value = attachments;
        AttachmentCollectionPage attachmentCollectionPage = new AttachmentCollectionPage(attachmentCollectionResponse, null);
        message.attachments = attachmentCollectionPage;


        boolean saveToSentItems = false;

        log.info("Start Azure Authentication: id - " + mailModel.getConfig().getClientId());
        final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId(mailModel.getConfig().getClientId())
                .clientSecret(mailModel.getConfig().getClientSecret())
                .tenantId(mailModel.getConfig().getTenantId())
                .build();

        final TokenCredentialAuthProvider authProvider = new TokenCredentialAuthProvider(mailModel.getConfig().getScopes(), clientSecretCredential);

        final OkHttpClient httpClient = HttpClients.createDefault(authProvider)
                .newBuilder()
                .callTimeout(Duration.ofSeconds(mailModel.getConfig().getCallTimeout()))
                .connectTimeout(Duration.ofSeconds(mailModel.getConfig().getConnectTimeout()))
                .followRedirects(false)
                .readTimeout(Duration.ofSeconds(mailModel.getConfig().getReadTimeout()))
                .retryOnConnectionFailure(true)
                .writeTimeout(Duration.ofSeconds(mailModel.getConfig().getWriteTimeout()))
                .build();

        final GraphServiceClient<Request> graphClient = GraphServiceClient
                .builder()
                .authenticationProvider(authProvider)
                .httpClient(httpClient)
                .buildClient();


        /* TODO - utilizando conta de serviço */
        graphClient.users(mailModel.getMessage().getFrom())
                .sendMail(UserSendMailParameterSet
                        .newBuilder()
                        .withMessage(message)
                        .withSaveToSentItems(saveToSentItems)
                        .build())
                .buildRequest()
                .post();


    }
}
