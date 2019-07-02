package dao;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Tool{
	
	public static String sendSecurity(String to) {
		
		/*// ����6λ����֤��
		String security = String.valueOf(new Random().nextInt(899999) + 100000);
		
		String from = "1310985307@qq.com";
		String to = UserDao.getEmail(user_id);      
		String host = "smtp.qq.com";
		String password = "qnqxmbwjqwuoigbd";
		// ��ȡϵͳ���Զ���    
		Properties properties = System.getProperties();     
		// �����ʼ�������   
		properties.setProperty("mail.smtp.host", host);     
		properties.setProperty("mail.smtp.auth","true");
		//��ȡĬ�ϵ�Session����   
		Session mailSession = Session.getDefaultInstance(properties);

		try{       
			// ����һ��Ĭ�ϵ�MimeMessage����      
			MimeMessage message = new MimeMessage(mailSession);       
			// ���� From: ͷ����header�ֶ�      
			message.setFrom(new InternetAddress(from));       
			// ���� To: ͷ����header�ֶ�      
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));       
			// ���� Subject: header�ֶ�      
			message.setSubject("��֤��");       
			// �������õ�ʵ����Ϣ       
			message.setText("�����֤����:" + security);
			
			Transport transport=mailSession.getTransport("smtp");
			transport.connect(host,"1310985307",password); 
			// ������Ϣ       
			transport.sendMessage(message,message.getAllRecipients());  
			transport.close();
		}catch (MessagingException mex) {   
			System.out.println("sendSecurity()��������");
			mex.printStackTrace();         
		}
		System.out.println(security);
		return security;*/
		String security = String.valueOf(new Random().nextInt(899999) + 100000);
		
	    Properties prop = new Properties();
	    prop.setProperty("mail.host","smtp.qq.com");
	    prop.setProperty("mail.smtp.auth","true");
	 
	    Authenticator aut = new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		    	return new PasswordAuthentication("1310985307@qq.com","qnqxmbwjqwuoigbd");
		    }
	    };
	 
	   Session session = Session.getInstance(prop,aut);
	   MimeMessage msg = new MimeMessage(session);
	   try {
			msg.setFrom(new InternetAddress("1310985307@qq.com"));
			msg.setRecipients(Message.RecipientType.TO, to);//recipients
			msg.setSubject(security);
			msg.setContent("your security is " + security,"text/html;charset=utf-8");
			Transport.send(msg);
	   } catch (MessagingException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	   System.out.println(security);
	   return security;
	}
	
	public static void remind(List<String> tos){
		
	    Properties prop = new Properties();
	    prop.setProperty("mail.host","smtp.qq.com");
	    prop.setProperty("mail.smtp.auth","true");
	 
	    Authenticator aut = new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		    	return new PasswordAuthentication("1310985307@qq.com","qnqxmbwjqwuoigbd");
		    }
	    };
	 
	   Session session = Session.getInstance(prop,aut);
	   MimeMessage msg = new MimeMessage(session);
	   try {
			msg.setFrom(new InternetAddress("1310985307@qq.com"));
			for(String to : tos){
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));//recipients
			}
			
			msg.setSubject("Bibliosoft");
			msg.setContent("The book you borrowed have expired, please return it in time.","text/html;charset=utf-8");
			Transport.send(msg);
	   } catch (MessagingException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	}
	
	public static String dateTimeChange(Date date){
		String strDate="";
		if(date!=null){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			strDate=format.format(date);		
		}
		return strDate;
	}
	public static String dateChange(Date date){
		String strDate="";
		if(date!=null){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			strDate=format.format(date);		
		}
		return strDate;
	}

}
