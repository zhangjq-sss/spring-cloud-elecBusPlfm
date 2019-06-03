package com.admin.service;

import java.util.List;

import com.admin.model.Mail;

public interface MailService {

	void save(Mail mail, List<String> toUser);
}
