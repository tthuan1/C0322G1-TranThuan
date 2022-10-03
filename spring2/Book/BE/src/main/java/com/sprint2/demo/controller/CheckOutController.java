package com.sprint2.demo.controller;

import com.sprint2.demo.dto.CustomerDto;
import com.sprint2.demo.dto.cart.CartAndDetailDto;
import com.sprint2.demo.models.Book;
import com.sprint2.demo.models.Cart;
import com.sprint2.demo.models.CartDetail;
import com.sprint2.demo.models.Customer;
import com.sprint2.demo.services.IBookService;
import com.sprint2.demo.services.ICartDetailService;
import com.sprint2.demo.services.ICheckOutService;
import com.sprint2.demo.services.ICustomerService;
import freemarker.template.Configuration;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/check-out")
public class CheckOutController {
    @Autowired
    private ICheckOutService iCheckOutService;
    @Autowired
    private ICartDetailService iCartDetailService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IBookService iBookService;


    @Autowired
    private Configuration config;

    @PostMapping("/check")
    public ResponseEntity<CartAndDetailDto> checkCartAndDetailFromClient(@Validated @RequestBody CartAndDetailDto cartAndDetailDto,
                                                                         BindingResult bindingResult) throws MethodArgumentNotValidException {
        this.iCheckOutService.checkExistOfLinksObject(cartAndDetailDto.getCartDtoList(), bindingResult);
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        Customer customer =
                this.iCustomerService.findCustomerByEmail(cartAndDetailDto.getCustomer().getEmail());
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        cartAndDetailDto.setCustomer(customerDto);

        return new ResponseEntity<>(cartAndDetailDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CartAndDetailDto> saveCheckOut(@RequestBody CartAndDetailDto cartAndDetailDto) {
        Cart cart = this.iCheckOutService.saveCart(cartAndDetailDto.getCustomer());
        System.out.println("success");
        List<CartDetail> cartDetailList = new ArrayList<>();
        for (int i = 0; i < cartAndDetailDto.getCartDtoList().size(); i++) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCart(cart);
            cartDetail.setQuantity(cartAndDetailDto.getCartDtoList().get(i).getQuantity());
            cartDetail.setBook(cartAndDetailDto.getCartDtoList().get(i).getBook());
            cartDetailList.add(cartDetail);
        }
        this.iCartDetailService.saveDetailList(cartDetailList);

        List<Book> bookList = new ArrayList<>();
        for (CartDetail elt : cartDetailList) {
            Book book = elt.getBook();
            book.setQuantity(book.getQuantity() - elt.getQuantity());
            bookList.add(book);
        }

        this.iBookService.updateAll(bookList);


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

//        return response;
//        int quantity = 0;
//        double discount = 0;
//        if (cartAndDetailDto.getDiscount() != null) {
//            discount = cartAndDetailDto.getDiscount().getPercent();
//        }
//        Cart cart1 = new Cart();
//        cart1.setCartList(cartDetailList);
//        this.iCartDetailService.saveDetailList(cartDetailList);
//        try {
//            this.iSendingEmailService.sendEmail(cartAndDetailDto);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        System.out.println("success");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
