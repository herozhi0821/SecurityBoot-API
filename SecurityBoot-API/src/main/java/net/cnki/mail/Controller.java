package net.cnki.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.cnki.mail.send.IMailService;

@RestController
public class Controller {

	@Autowired
	IMailService mailService;
	
	@RequestMapping("sendMail")
	public void sendMail() {
//		mailService.sendSimpleMail("xxx@qq.com", "title", "content");
//		mailService.sendHtmlMail("xxx@qq.com","test","<html><body><h1>helloWorld</h1></body></html>");
//		mailService.sendHtmlMail("xxx@qq.com","test","<html><body><h1>helloWorld</h1><img src='cid:tpid' width='80%' height='600px'></body></html>","tpid","E:\\格物致知001.png");
//		mailService.sendAttachmentsMail("xxx@qq.com", "woden23", "<h1>ceshi</h1>", "E:\\格物致知001.png");
	}
}
