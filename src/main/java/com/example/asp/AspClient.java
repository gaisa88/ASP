package com.example.asp;

import com.example.asp.wsdl.CigWsHeader;
import com.example.asp.wsdl.SendToASP;
import com.example.asp.wsdl.SendToASPResponse;
import com.example.asp.wsdl.ServiceReturn;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class AspClient extends WebServiceGatewaySupport {
    public SendToASPResponse getReturn(String iin) {
        CigWsHeader header = new CigWsHeader();
        header.setUserName("7752217879");
        header.setPassword("7752217879");
        header.setCulture("ru-RU");
        header.setSecurityToken("0");
        header.setVersion("1");
        header.setUserId(0);
        SendToASP request = new SendToASP();
        request.setIIN(iin);
        request.setParentCode(1);
        request.setConsentConfirmed("1");
        System.out.println();
        System.out.println("Requesting scoring for iin: " + iin);

        JAXBElement<SendToASPResponse> obj = (JAXBElement<SendToASPResponse>) getWebServiceTemplate().marshalSendAndReceive("http://test2.1cb.kz/ASP/Service", request, new SecurityHeader(header));

        SendToASPResponse response = obj.getValue();
        return response;
    }

    public void printResponse(SendToASPResponse response) {
        ServiceReturn Return = response.getReturn();

        if (Return.getErrorCode() == "0") {
            System.out.println(Return.getErrorCode());
        } else {
            System.out.println("Error request " + Return.getErrorCode());
        }
    }

}

