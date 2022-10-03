package com.sprint2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void triggerMail() throws MessagingException {
//        senningEmailService.sendSimpleEmail("hainguyen13898@gmail.com",
//                "Rikkeisoft Đà Nẵng",
//                "Dear nhân viên !,\n" +
//                        "\n" +
//                        "Thứ Tư ngày 17/08/2022 vào lúc 8:30 AM, Công ty Rikkeisoft Đà Nẵng mời ứng viên đến làm việc  tại địa chỉ 81 Quang Trung với vị trí Fresher. Khi đi làm việc, ứng viên mang theo laptop cá nhân để cài đặt môi trường làm việc.\n" +
//                        "\n" +
//                        "Vui lòng liên hệ Miss Ngọc : 0905712697 để được hướng dẫn khi đến công ty làm việc. \n" +
//                        "\n" +
//                        "Thank you and best regards ");
//
//    }
}
