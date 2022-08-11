package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.TinTucDto;
import com.example.model.Customer;
import com.example.model.CustomerType;
import com.example.model.DanhMuc;
import com.example.model.TinTuc;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import com.example.service.IDanhMucService;
import com.example.service.ITinTucService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TinTucController {
    @Autowired
    private ITinTucService tinTucService;

    @Autowired
    private IDanhMucService danhMucService;

    @ModelAttribute("danhMucList")
    private List<DanhMuc> danhMucList(){
        return this.danhMucService.findAll();
    }

    @GetMapping("/tinTuc")
    public String showTinTuc(@RequestParam(value = "nameSearch", defaultValue = "") String search, @PageableDefault(value = 5) Pageable pageable, Model model){
        Page<TinTuc> tinTucList = tinTucService.findAll(search, pageable);
        model.addAttribute("nameSearch",search);
        model.addAttribute("tinTucList",tinTucList);
        return "tinTuc/list";
    }

    @GetMapping("/tinTuc/create")
    public String showFormCreate(Model model){
        model.addAttribute("tinTucDto",new TinTucDto());
        return "tinTuc/create";
    }

    @PostMapping("/tinTuc/create")
    public String create(RedirectAttributes redirectAttributes, @Valid @ModelAttribute TinTucDto tinTucDto, BindingResult bindingResult){
        new TinTucDto().validate(tinTucDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "tinTuc/create";
        }
        TinTuc tinTuc = new TinTuc();
        BeanUtils.copyProperties(tinTucDto,tinTuc);
        tinTucService.save(tinTuc);
        redirectAttributes.addFlashAttribute("mess","Thêm thành công!");
        return "redirect:/tinTuc";
    }

    @GetMapping("/tinTuc/delete/{maTinTuc}")
    public String showDeleteCustomer(@PathVariable int maTinTuc, RedirectAttributes redirectAttributes){
        tinTucService.remove(maTinTuc);
        redirectAttributes.addFlashAttribute("mess","Xoá thành công!");
        return "redirect:/tinTuc";
    }
    @GetMapping("/tinTuc/chiTiet/{maTinTuc}")
    public String showChiTiet(@PathVariable int maTinTuc,Model model){
        TinTuc tinTuc=tinTucService.findById(maTinTuc);
        model.addAttribute("tinTucChiTiet",tinTuc);
        return "redirect:/tinTuc";
    }


}
