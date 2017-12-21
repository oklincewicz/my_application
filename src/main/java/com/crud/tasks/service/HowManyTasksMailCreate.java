package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class HowManyTasksMailCreate {
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private CompanyConfig companyConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String createMailHowManyTasks(String message) {
        List<String> howManyTasks = new ArrayList<>();
        howManyTasks.add("Task to do");
        howManyTasks.add("Task to do");
        howManyTasks.add("Task to do");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("howManyTasks", howManyTasks);
        context.setVariable("preview", "Info about create new card");
        context.setVariable("goodbye", "See you later :)");
        context.setVariable("companyName", companyConfig.getCompanyName());
        context.setVariable("companyMail", "mail: " + companyConfig.getCompanyMail());
        context.setVariable("companyPhone", "tel: " + companyConfig.getCompanyPhone());
        context.setVariable("companyMotto", "device: " + companyConfig.getCompanyMotto());
        return templateEngine.process("mail/mail-howManyTaskYouHave", context);
    }

}
