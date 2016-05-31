package com.demoqa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendEmail {
	public static void sendEmailThis(final String filePath) throws IOException, EmailException {
		File file = new File(filePath);
		String string = FileUtils.readFileToString(file);
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("testingauto15@gmail.com", "amitumise2015"));
		email.setSSLOnConnect(true);
		email.setFrom("testingauto15@gmail.com");
		email.setSubject("TestMail- Alternative message");
		email.setHtmlMsg(string);
		// set the alternative message
		// email.setTextMsg("This is a link:
		// http://pushpalankajaya.blogspot.com");
		email.addTo("pbarua224@gmail.com");
		email.send();
	}

	public static void main(final String[] args) {
		try {
			SendEmail.sendEmailThis(
					"C:\\WorkspaceGIT\\storedemoqa\\target\\surefire-reports\\emailable-report.html");
		} catch (IOException | EmailException e) {
			e.printStackTrace();
		}
	}
}
