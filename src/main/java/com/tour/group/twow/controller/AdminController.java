package com.tour.group.twow.controller;


import com.tour.group.twow.pojo.Result;
import com.tour.group.twow.pojo.StatusCode;
import com.tour.group.twow.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        try {
            List list = adminService.selectAll();
            return Result.successWithData(list);
        } catch (Exception e) {
            System.out.print(e);
            return Result.failed();
        }
    }
}
