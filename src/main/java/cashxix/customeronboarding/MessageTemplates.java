package cashxix.customeronboarding;

import java.util.ArrayList;
import java.util.List;

public enum MessageTemplates {

    WELCOME{
        @Override
        public String message() {
            List<String> bodyMessageList = new ArrayList<>();

            bodyMessageList.add("Habari \n");
            bodyMessageList.add("Welcome to XYZ Bank  \n");
            bodyMessageList.add("We won’t ask you to visit a branch or bury you");
            bodyMessageList.add("in paperwork. Opening an account with us takes");
            bodyMessageList.add("a few minutes, and you can do everything");
            bodyMessageList.add("straight from your phone \n");
            bodyMessageList.add("Would you like to open a bank account ?");


            return getBody(bodyMessageList);
        }
    },
    ALREADY_CUSTOMER{
        @Override
        public String message() {
            return null;
        }
    },
    REGISTRATION_ONBOARD_NAME{
        @Override
        public String message() {

            return  "Please could you provide your full name as specified on a government ID?";

        }
    },

    REGISTRATION_ONBOARD_DOB{
        @Override
        public String message() {


            return  "Please could you provide your Date of Birth as specified on a government ID?";

        }
    };


  public   abstract String message();

    private static String getBody(List<String> bodyMessageList){


        StringBuilder buildBody  = new StringBuilder();

        for(String message : bodyMessageList){

            buildBody.append(message).append("\n");

        }

        return buildBody.toString();
    }


}
