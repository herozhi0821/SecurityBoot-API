package net.cnki.mail.send;

public interface IMailService {
	
	/**
     * 发送文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String to, String subject, String content);
    
    /**
     * 发送HTML邮件,无静态资源
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlMail(String to, String subject, String content);
    
    /**
     * 发送HTML邮件，带有图片资源
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param reid 静态资源标识
     * @param resource 静态资源路径，如图片
     */
    public void sendHtmlMail(String to, String subject, String content, String reid, String resource);
    
    /**
     * 发送HTML模板邮件
     * @param to 收件人
     * @param subject 主题
     * @param name 参数1
     * @param posName 参数2
     * @param joblevelName 参数3
     * @param departmentName 参数4
     */
    public void sendHtmlModelMail(String to, String subject, String name, String posName, String joblevelName, String departmentName);
    
    /**
     * 发送带附件的邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);
    
}
