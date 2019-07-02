package utils;
 
import java.util.List;
import java.util.TimerTask;

import javax.mail.internet.InternetAddress;
import javax.servlet.ServletContext;

import dao.BorrowDao;
import dao.Tool;
 
/**
 * @author  szy
 * @version 创建时间：2018-4-5 上午10:50:00
 *
 */
public class Remind extends TimerTask {
 
    private ServletContext context = null;
    public Remind(ServletContext context)
    {
     this.context = context;
    }
     
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("发送邮件中：");
        List<String> emails = BorrowDao.getEmails();
        Tool.remind(emails);
    }
}