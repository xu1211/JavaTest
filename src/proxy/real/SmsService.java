package proxy.real;

public class SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    public String withdraw(String message) {
        System.out.println("withdraw message:" + message);
        return message;
    }
}
