package com.isnico.api.component;

import org.nico.noson.Noson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Component
public class MailUtil {
	
	Logger logger = LoggerFactory.getLogger(MailUtil.class);
	
	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String from;
	
	/**
	 * 发送纯文本邮件
	 * @param to
	 * @param subject
	 * @param content
	 */
	public boolean sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		try {
			mailSender.send(message);
			logger.info("文本邮件发送成功: "+ Noson.reversal(message));
			return true;
		} catch (Exception e) {
			logger.info("文本邮件发送失败: "+ Noson.reversal(message));
			logger.info("文本邮件发送失败: "+e);
			return false;
		}
	}
	
	/**
	 * 发送html类型邮件
	 * @param to
	 * @param subject
	 * @param content
	 */
	public boolean sendHtmlMail(String to, String subject, String content) {
	    MimeMessage message = mailSender.createMimeMessage();
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);   //true表示需要创建一个multipart message
	        helper.setFrom(from);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(content, true);
	        mailSender.send(message);
	        logger.info("发送html邮件发送成功: "+ Noson.reversal(message));
	        return true;
	    } catch (MessagingException e) {
	    	logger.info("发送html邮件发送失败: "+ Noson.reversal(message));
			logger.info("发送html邮件发送失败: "+e);
			return true;
	    }
	}
	
	/**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    public boolean sendAttachmentsMail(String to, String subject, String content, String filePath){
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
            logger.info("带附件邮件发送成功: "+ Noson.reversal(message));
            return true;
        } catch (MessagingException e) {
        	logger.info("发送带附件的邮件发送失败: "+ Noson.reversal(message));
			logger.info("发送带附件的邮件发送失败: "+e);
			return true;
        }
    }


}
