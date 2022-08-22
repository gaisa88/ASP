package com.example.asp;

import com.example.asp.wsdl.SendToASPResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AspApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AspApplication.class, args);

        AspClient aspClient = ctx.getBean(AspClient.class);

        String iin = "940331451224";
        if (args.length > 0) {
            iin = args[0];
        }
        SendToASPResponse response =  aspClient.getReturn(iin);
        aspClient.printResponse(response);
    }
}
