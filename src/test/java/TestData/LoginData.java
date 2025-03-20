package TestData;

public class LoginData {

    public static String testUrl = "https://applimetier.com/loginpreprod/#/";
    //"https://applimetier.com/login/#/";
    //"https://www.queoval.fr/login/";
    //"http://localhost/login/#/";

    public enum User_Rishabh {

        USER_EMAIL("Rishabh@novity.io"),
        USER_PASSWORD("Azerty34/"),
        //USER_PASSWORD("Rishabh34@novity.io");
        WEBSTORE_URL("https://inscriptionformation.com/WebStore/?info=UVVFT0RFVl9PRjphemVydHkxMjM");

        private final String value;

        User_Rishabh(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
