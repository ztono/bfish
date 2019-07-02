package utils;
 
import java.util.List;
import java.util.TimerTask;

import javax.mail.internet.InternetAddress;
import javax.servlet.ServletContext;

import dao.BorrowDao;
import dao.Tool;
 
/**
 * @author  szy
 * @version ����ʱ�䣺2018-4-5 ����10:50:00
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
        System.out.println("�����ʼ��У�");
        List<String> emails = BorrowDao.getEmails();
        Tool.remind(emails);
    }
}