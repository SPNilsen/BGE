package org.bge.ccportal.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.bge.ccportal.model.Allocation;
import org.bge.ccportal.model.GlobalFlag;

import org.bge.ccportal.services.AllocationService;
import org.bge.ccportal.services.GlobalFlagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
public class AllocationController {

    private static final Logger logger = Logger.getLogger(Allocation.class);

    @Autowired
    AllocationService allocationService;
    
    @Autowired
    GlobalFlagService globalFlagService;

    @RequestMapping(value = "/Allocation", method = RequestMethod.GET)
    public String allocation(ModelMap model) {
        logger.info("Starting Allocation Method");

        List<Allocation> allocationList = allocationService.getList();

        for (Allocation a : allocationList) {
            System.out.println(a.describe());
            model.addAttribute(a.getProduct() + "Allocation", a);
        }
        
        GlobalFlag globalFlag = globalFlagService.getById(1);
        
        model.addAttribute("globalFlag", globalFlag);
        
        return "allocation";
    }

    @RequestMapping(value = "/Allocation/OE", method = RequestMethod.POST)
    public String csAllocation(ModelMap model, @ModelAttribute Allocation oeAllocation) {
        System.out.println("find me: " + oeAllocation.describe());
        allocationService.update(oeAllocation);
        model.addAttribute("pageMsg", "Updated OE Settings!");
        
        return "allocation_msg";
    }

    @RequestMapping(value = "/Allocation/OS", method = RequestMethod.POST)
    public String osAllocation(ModelMap model, @ModelAttribute Allocation osAllocation) {
        allocationService.update(osAllocation);
        model.addAttribute("pageMsg", "Updated OS Settings!");
        
        return "allocation_msg";
    }

    @RequestMapping(value = "/Allocation/Global", method = RequestMethod.POST)
    public String globalAllocation(ModelMap model, @ModelAttribute GlobalFlag globalFlag) {
        globalFlagService.update(globalFlag);
        model.addAttribute("pageMsg", "Updated Global Settings!");
        return "allocation_msg";
    }
    
    @RequestMapping(value = "/Allocation/NY", method = RequestMethod.POST)
    public String nyAllocation(ModelMap model, @ModelAttribute Allocation nyAllocation) {
        allocationService.update(nyAllocation);
        model.addAttribute("pageMsg", "Updated NY Settings!");
        
        return "allocation_msg";
    }
}
