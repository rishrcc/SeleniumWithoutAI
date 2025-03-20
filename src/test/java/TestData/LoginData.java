package TestData;

public class LoginData {

    public static String testUrl = "*****";

    public enum User_Rishabh {

        USER_EMAIL("*****"),
        USER_PASSWORD("*****"),
        WEBSTORE_URL("*****");

        private final String value;

        User_Rishabh(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
