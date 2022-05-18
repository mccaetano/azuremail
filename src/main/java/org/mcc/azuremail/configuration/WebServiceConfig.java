package org.mcc.azuremail.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {


    private final String TRAGET_NAMESPACE = "http://mcc.org/azuremail/sender";

    @Bean
    public  ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/services/v1/*");
    }

    @Bean(name = "azure")
    public  DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema smtpSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("azurePort");
        wsdl11Definition.setLocationUri("/services/v1");
        wsdl11Definition.setTargetNamespace(TRAGET_NAMESPACE);
        wsdl11Definition.setSchema(smtpSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema smtpSchema() {
        return new SimpleXsdSchema(new ClassPathResource("MailSend.xsd"));
    }
}
