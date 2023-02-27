package cashxix.customeronboarding.controller;


import cashxix.customeronboarding.model.MessageData;
import cashxix.customeronboarding.service.MessageProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/webhooks")
public class WebHookController {

    @Autowired
    private MessageProcessingService messageProcessingService;

    @PostMapping( consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addMessage(@ModelAttribute MessageData payload){

        messageProcessingService.run(payload);

    }
}
