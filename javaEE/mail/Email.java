
// import java.net.Authenticator;
// import java.net.PasswordAuthentication;
// import java.util.Properties;

// public class Email {
   
//     // Sending a Plain Text and an HTML Email
//     /*First, we need to configure the library with our email service provider’s credentials. 
//     Then, we’ll create a Session that’ll be used to construct our message for sending.*/
//     Properties prop = new Properties();

//     public Email() {
//         prop.put("mail.smtp.auth", true);
//         prop.put("mail.smtp.starttls.enable", "true");
//         prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
//         prop.put("mail.smtp.port", "25");
//         prop.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");
//     }

//     Session session = Session.getInstance(prop, new Authenticator() {
//     @Override
//     protected PasswordAuthentication getPasswordAuthentication() {
//         return new PasswordAuthentication(username, password);
//     }
// });

//      Message message = new MimeMessage(session);
//      message.setFrom(new InternetAddress("from@gmail.com"));
//      message.setRecipients(
//      Message.RecipientType.TO, InternetAddress.parse("to@gmail.com"));
//      message.setSubject("Mail Subject");

//      String msg = "This is my first email using JavaMailer";

//     MimeBodyPart mimeBodyPart = new MimeBodyPart();
//     mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

//     Multipart multipart = new MimeMultipart();
//     multipart.addBodyPart(mimeBodyPart);

//     message.setContent(multipart);

//     Transport.send(message);

//     //Sending Email to Multiple Recipients

//     //To send emails to multiple recipients, we can use the setRecipients() and addRecipients() methods which take an array of recipient addresses and recipient types such as TO, CC, and BCC  :

//    //1. Using setRecipients() - We can set multiple recipients using the setRecipients() method. For the recipient list, we can pass the recipient type and the array of recipient addresses as arguments:
//     Address[] recipients = new InternetAddress[2];
//     recipients[0] = new InternetAddress("to@gmail.com");
//     recipients[1] = new InternetAddress("to1@gmail.com");
   
//    message.setRecipients(Message.RecipientType.TO, recipients);
// }
