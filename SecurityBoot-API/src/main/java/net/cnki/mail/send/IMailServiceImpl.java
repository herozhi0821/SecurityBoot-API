package net.cnki.mail.send;

import java.io.File;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class IMailServiceImpl implements IMailService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * Spring Boot 提供了一个发送邮件的简单抽象，使用的是下面这个接口，这里直接注入即可使用
	 */
	@Autowired
    JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
    private String from;
	
	/**
	 * 简单邮件
	 */
	@Override
	public void sendSimpleMail(String to, String subject, String content) {
		logger.info("");
		//创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom("herozhi0821@163.com");
        //邮件接收人
        message.setTo(to);
        //邮件主题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        //发送邮件
        mailSender.send(message);

	}

	/**
	 * HTML邮件
	 */
	@Override
	public void sendHtmlMail(String to, String subject, String content) {
		//获取MimeMessage对象
        MimeMessage message = mailSender.createMimeMessage();
        try {
        	MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            //邮件发送人
            messageHelper.setFrom(from);
            //邮件接收人
            messageHelper.setTo(to);
            //邮件主题
            messageHelper.setSubject(subject);
            //邮件内容，html格式
            messageHelper.setText(content, true);
            //发送
            mailSender.send(message);
            //日志信息
            logger.info("邮件已经发送。");
        } catch (MailSendException e) {
        	detectInvalidAddress(e);
            logger.error("发送邮件时发生异常！", e);
        } catch (MessagingException e) {
        	logger.error("发送邮件时发生异常！", e);
		}
	}
	
	/**
	 * HTML邮件+静态资源
	 */
	@Override
	public void sendHtmlMail(String to, String subject, String content, String reid, String resource) {
		//获取MimeMessage对象
        MimeMessage message = mailSender.createMimeMessage();
        try {
        	MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            //邮件发送人
            messageHelper.setFrom(from);
            //邮件接收人
            messageHelper.setTo(to);
            //邮件主题
            messageHelper.setSubject(subject);
            //邮件内容，html格式
            messageHelper.setText(content, true);
            //邮件html内容添加图片
            FileSystemResource res = new FileSystemResource(new File(resource));
            messageHelper.addInline(reid, res);
            //发送
            mailSender.send(message);
            //日志信息
            logger.info("邮件已经发送。");
        } catch (MailSendException e) {
        	detectInvalidAddress(e);
            logger.error("发送邮件时发生异常！", e);
        } catch (MessagingException e) {
        	logger.error("发送邮件时发生异常！", e);
		}
	}

	/**
	 * 附件邮件
	 */
	@Override
	public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
		MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            //日志信息
            logger.info("邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送邮件时发生异常！", e);
        }
	}
	
	private void detectInvalidAddress(MailSendException me) {
		Exception[] messageExceptions = me.getMessageExceptions();
		if (messageExceptions.length > 0) {
			Exception messageException = messageExceptions[0];
			if (messageException instanceof SendFailedException) {
				SendFailedException sfe = (SendFailedException) messageException;
				Address[] invalidAddresses = sfe.getInvalidAddresses();
				if(invalidAddresses != null) {
					StringBuilder addressStr = new StringBuilder();
					for (Address address : invalidAddresses) {
						addressStr.append(address.toString()).append("; ");
					}
					logger.error("发送邮件时发生异常！可能有无效的邮箱：{}", addressStr);
					return;
				}
			}
		}
		logger.error("发送邮件时发生异常！", me);
	}

}
