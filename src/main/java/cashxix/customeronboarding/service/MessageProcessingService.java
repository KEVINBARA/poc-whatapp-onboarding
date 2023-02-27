package cashxix.customeronboarding.service;


import cashxix.customeronboarding.MessageTemplates;
import cashxix.customeronboarding.model.MessageData;
import cashxix.customeronboarding.repository.BankCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;



@Service
public class MessageProcessingService {

    @Autowired
    private BankCustomerRepository bankCustomerRepository;

    @Autowired
    private MessageResponse messageResponse;

    @Autowired
    private DownloadMedia downloadMedia;




    public void  run(MessageData messageData)  {


        String mediaType = messageData.getMediaContentType0();


            String body = messageData.getBody();

            System.out.println(body.toLowerCase());
            if(body.toLowerCase().contains("yes")){

                MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
                bodyMap.add("To", messageData.getFrom());
                bodyMap.add("From", messageData.getTo());
                bodyMap.add("Body", MessageTemplates.REGISTRATION_ONBOARD_NAME.message());

                messageResponse.send(bodyMap);
            } else if (body.toLowerCase().contains("[name]")) {
                MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
                bodyMap.add("To", messageData.getFrom());
                bodyMap.add("From", messageData.getTo());
                bodyMap.add("Body", MessageTemplates.REGISTRATION_ONBOARD_DOB.message());
                messageResponse.send(bodyMap);
            } else {

                MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
                bodyMap.add("To", messageData.getFrom());
                bodyMap.add("From", messageData.getTo());
                bodyMap.add("Body", MessageTemplates.WELCOME.message());

                messageResponse.send(bodyMap);
            }


        }



    }

