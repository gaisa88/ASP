package com.example.asp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ASPClientConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.asp.wsdl");
        return marshaller;
    }

    @Bean
    public AspClient aspClient(Jaxb2Marshaller marshaller) {
        AspClient client = new AspClient();
        client.setDefaultUri("http://test2.1cb.kz/ASP/Service");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
