package com.tour.group.twow.controller;


import com.tour.group.twow.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

    @Resource
    private AdminService adminService;

    /*
    * @function
    * @api
    * @params null
    * @return admin list
    * */
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public @ResponseBody Object onAll() {
        List list = adminService.selectAll();
        return list;
    }
}
