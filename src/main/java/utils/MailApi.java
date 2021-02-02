package utils;

import org.jsoup.Jsoup;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class MailApi {

    public static void test() throws MessagingException, IOException {

        String user = "postavshik.demo1@gmail.com";
        String password = "Xarid123!";
        String host = "imap.gmail.com";

        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");

        Store store = Session.getInstance(properties).getStore();
        store.connect(host, user, password);
        Folder inbox = store.getFolder("INBOX");

        inbox.open(Folder.READ_WRITE);
        System.out.println("Количество писем: " + inbox.getMessageCount());

        Message message = inbox.getMessage(inbox.getMessageCount());

        Multipart multipart = (Multipart) message.getContent();

        BodyPart body = multipart.getBodyPart(1);

        System.out.println(Jsoup.parse(body.getContent().toString()).text());
        //System.out.println(Jsoup.parse(message.getContent().toString()).text());

//        Message[] messages = inbox.getMessages();
//
//        for(int i = 0; i < messages.length; i++){
//            message = messages[i];
//            message.setFlag(Flags.Flag.DELETED, true);
//        }


        inbox.close();
        store.close();
    }

}