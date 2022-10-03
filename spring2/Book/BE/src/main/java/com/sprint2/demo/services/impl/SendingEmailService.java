//package com.sprint2.demo.services.impl;
//
//
//import com.sprint2.demo.dto.CustomerDto;
//import com.sprint2.demo.dto.MailRequest;
//import com.sprint2.demo.dto.MailResponse;
//import com.sprint2.demo.dto.cart.CartAndDetailDto;
//import com.sprint2.demo.models.Customer;
//import com.sprint2.demo.services.ICartDetailService;
//import com.sprint2.demo.services.ICheckOutService;
//import com.sprint2.demo.services.ICustomerService;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
//@Service
//public class SendingEmailService {
//    @Autowired
//    private ICheckOutService iCheckOutService;
//    @Autowired
//    private ICartDetailService iCartDetailService;
//    @Autowired
//    private ICustomerService iCustomerService;
//    @Autowired
//    private JavaMailSender sender;
//
//    @Autowired
//    private Configuration config;
//
//    public MailResponse sendEmail(MailRequest request, Map<String, Object> model, Customer customer) {
//        MailResponse response = new MailResponse();
//        MimeMessage message = sender.createMimeMessage();
//        try {
//            // set mediaType
//            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                    StandardCharsets.UTF_8.name());
//            // add attachment
////            helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
//
//            Template t = config.getTemplate("email.ftl");
//            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
//
//            helper.setTo(request.getTo());
//            helper.setText(html, true);
//            helper.setSubject(request.getSubject());
//            helper.setFrom(request.getFrom());
//            sender.send(message);
//
//            response.setMessage("mail send to : " + request.getTo());
//            response.setStatus(Boolean.TRUE);
//
//        } catch (MessagingException | IOException | TemplateException e) {
//            response.setMessage("Mail Sending failure : " + e.getMessage());
//            response.setStatus(Boolean.FALSE);
//        }
//
//        return response;
//    }
//
//
//}