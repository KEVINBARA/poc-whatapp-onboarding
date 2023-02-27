package cashxix.customeronboarding.model;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageData {


    private String smsMessageSid; // Twillio Id
    private String numMedia; // Don't know yet
    private String profileName; // Name as it appears on the customer's Whatsapp profile name
    private String smsSid;
    private String waId; // whatsapp number of the customer
    private String smsStatus;

    private String numSegments;

    private String referralNumMedia;

    private String messageSid;

    private String accountSid;

    private String body; // the message we receive from the customer
    private String to; // our whatsapp number
    private String from; // the customer whatsapp number

    private String mediaContentType0; // the type of media content we received

    private String mediaUrl0; // the url of where the media is stored

}
