package org.mcc.azuremail.configuration;

import org.mcc.azuremail.model.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.Properties;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Autowired
    private ApplicationProperties properties;

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
        wsdl11Definition.setTargetNamespace(properties.getTargetnamespace());
        wsdl11Definition.setSchema(smtpSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema smtpSchema() {
        return new SimpleXsdSchema(new ClassPathResource("MailSend.xsd"));
    }
}
