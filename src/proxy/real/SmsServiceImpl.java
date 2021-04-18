package proxy.real;

/**
 * 发送短信
 */
public class SmsServiceImpl implements SmsServiceInterface {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    @Override
    public String withdraw(String message) {
        System.out.println("withdraw message:" + message);
        return message;
    }
}
