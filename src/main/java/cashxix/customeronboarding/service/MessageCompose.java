package cashxix.customeronboarding.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MessageCompose {


    public String welcome(String body){

        List<String> bodyMessageList = new ArrayList<>();

        bodyMessageList.add("Habari ");
        bodyMessageList.add("Would you like to open a bank account ?");

        return getBody(bodyMessageList);
    }


    private String getBody(List<String> bodyMessageList){


        StringBuilder buildBody  = new StringBuilder();

        for(String message : bodyMessageList){

            buildBody.append(message).append("\n");

        }

        return buildBody.toString();
    }
}
