//import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.Email;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.SimpleEmail;

import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
//import org.apache.commons.mail.SimpleEmail;

//import javax.mail;

public class SendEmail {

    private static String userEmail = "YourEmail";
    private static String password = "YourPassword";
    
    public static void main(String[] args) {
        //Email email = new SimpleEmail();
        MultiPartEmail email = new MultiPartEmail();

        try {

            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath("C:\\Users\\user\\Desktop\\azbW3zq_460sa_v1.gif");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("a horse");
            attachment.setName("John");


            
            //email.setHostName("mail.myserver.com");
            //email.addTo("jdoe@somewhere.org", "John Doe");
            //email.setFrom("me@apache.org", "Me");
            //email.setSubject("The picture");
            //email.setMsg("Here is the picture you wanted");
            
            
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(userEmail, password));
            email.setSSLOnConnect(true);

            email.setSubject("TestMail");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("erebusbg@gmail.com");
            
            email.attach(attachment);
            
            email.send();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
