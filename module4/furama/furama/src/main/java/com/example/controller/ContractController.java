package com.example.controller;

import com.example.model.Contract;
import com.example.model.ContractDetail;
import com.example.model.Customer;
import com.example.model.Employee;
import com.example.model.Facility;
import com.example.service.IContractDetailService;
import com.example.service.IContractService;
import com.example.service.ICustomerService;
import com.example.service.IEmployeeService;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IContractDetailService contractDetailService;

    @ModelAttribute("facilityList")
    private List<Facility> showFacilityList() {
        return this.facilityService.findAll();
    }

    @ModelAttribute("employeeList")
    private List<Employee> showEmployeeList() {
        return this.employeeService.findAll();
    }

    @ModelAttribute("customerList")
    private List<Customer> showCustomerList() {
        return this.customerService.findAll();
    }

    @ModelAttribute("contractDetailList")
    private List<ContractDetail> showContractDetailList() {
        return this.contractDetailService.findAll();
    }


    @GetMapping("/contract")
    public String showContract(@PageableDefault(value = 7) Pageable pageable,Model model) {
        Page<Contract> contractList=contractService.findAll(pageable);
        model.addAttribute("contractList",contractList);
        return "contract/list";
    }
}
