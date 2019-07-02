package dao;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Tool{
	
	public static String sendSecurity(String to) {
		
		/*// 生成6位数验证码
		String security = String.valueOf(new Random().nextInt(899999) + 100000);
		
		String from = "1310985307@qq.com";
		String to = UserDao.getEmail(user_id);      
		String host = "smtp.qq.com";
		String password = "qnqxmbwjqwuoigbd";
		// 获取系统属性对象    
		Properties properties = System.getProperties();     
		// 设置邮件服务器   
		properties.setProperty("mail.smtp.host", host);     
		properties.setProperty("mail.smtp.auth","true");
		//获取默认的Session对象。   
		Session mailSession = Session.getDefaultInstance(properties);

		try{       
			// 创建一个默认的MimeMessage对象。      
			MimeMessage message = new MimeMessage(mailSession);       
			// 设置 From: 头部的header字段      
			message.setFrom(new InternetAddress(from));       
			// 设置 To: 头部的header字段      
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));       
			// 设置 Subject: header字段      
			message.setSubject("验证码");       
			// 现在设置的实际消息       
			message.setText("你的验证码是:" + security);
			
			Transport transport=mailSession.getTransport("smtp");
			transport.connect(host,"1310985307",password); 
			// 发送消息       
			transport.sendMessage(message,message.getAllRecipients());  
			transport.close();
		}catch (MessagingException mex) {   
			System.out.println("sendSecurity()方法出错");
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
