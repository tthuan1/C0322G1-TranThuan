package com.sprint2.demo.controller;


import com.sprint2.demo.dto.CustomerDto;
import com.sprint2.demo.dto.cart.CartAndDetailDto;
import com.sprint2.demo.models.Book;
import com.sprint2.demo.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@RestController
@RequestMapping("/mail")
@CrossOrigin
public class EmailSendController {

    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/send")
    public ResponseEntity<String> sendSimpleEmail(@RequestBody CartAndDetailDto cartAndDetailDto) throws MessagingException {
        CustomerDto customer1 = cartAndDetailDto.getCustomer();
//            Customer customer1 = modelMapper.map(customer, Customer.class);
//        Double total = cartAndDetailDto.getTotal();
//        System.out.println(total);
        CartAndDetailDto cartAndDetailDto1 = modelMapper.map(cartAndDetailDto, CartAndDetailDto.class);
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        String htmlMsg = "<div style=\"background: url('https://glints.com/vn/blog/wp-content/uploads/2022/07/ca%CC%81ch-no%CC%81i-lo%CC%9B%CC%80i-ca%CC%89m-o%CC%9Bn.jpg') white; background-size: 100% 100%; background-position:right; min-height: 800px; background-repeat: no-repeat;\">" +
                "<p>Dear <b>" + customer1.getName() + "</b>,</p>\n" +
                "<p>Cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi. Cửa hàng sách gửi bạn hoá đơn đã thanh toán.</p>\n" +
                "<p>Xin vui lòng kiểm tra thông tin bên dưới. Mọi thắc mắc vui lòng liên hệ số điện thoại: 0905386737 (Quang Trường).</p>\n" +
                "<table class=\"table\" style=\"border: 1px solid; padding: 10px 10px; border-collapse: collapse;\">\n" +
                "  <thead>\n" +
                "  <tr style=\"background-color: #838383;\">\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Mã sách</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Trạng thái</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Tổng tiền</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Thư điện tử</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Họ và tên</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Địa chỉ</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Số điện thoại</th>\n" +


                "  </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                "  <tr style=\"background-color: aliceblue;\n\">\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + customer1.getId() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Hoàn thành</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + cartAndDetailDto1.getTotal() + "VNĐ" + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + customer1.getEmail() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + customer1.getName() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + customer1.getAddress() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + customer1.getPhone() + "</td>\n" +
                "  </tr>\n" +
                "  </tbody>\n" +
                "</table>" +
                "<p style=\"font-size: 11px; color: blue;\"><i>Thanks and best regards</i><br>\n" +
                "_____________________________<br>\n" +
                "<i>Nguyen Quang Truong ( Mr.).</i><br>\n" +
                "<i>Phone: 0905386737.</i><br>\n" +
                "<i>Email: chantraitre2000@gmail.com.</i></p>\n" +
                "</div>";
        message.setContent(htmlMsg, "text/html; charset=UTF-8");
        helper.setTo(customer1.getEmail());
        helper.setSubject("Thanh toán thành công!");
        this.emailSender.send(message);
        System.out.println("ok");
        return new ResponseEntity<>("Email Sent!", HttpStatus.OK);
    }
}
