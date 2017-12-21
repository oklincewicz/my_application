package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private CompanyConfig companyConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview", "Info about create new card");
        context.setVariable("goodbye", "See you later :)");
        context.setVariable("companyName", companyConfig.getCompanyName());
        context.setVariable("companyMail", "mail: " + companyConfig.getCompanyMail());
        context.setVariable("companyPhone", "tel: " + companyConfig.getCompanyPhone());
        context.setVariable("companyMotto", "device: " + companyConfig.getCompanyMotto());
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
