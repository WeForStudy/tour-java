package com.tour.group.twow.controller;


import com.alibaba.fastjson.JSONObject;
import com.tour.group.twow.entity.Admin;
import com.tour.group.twow.pojo.Result;
import com.tour.group.twow.pojo.States;
import com.tour.group.twow.service.AdminService;
import org.springframework.web.bind.annotation.*;

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
    * @params void
    * @return admin list
    * */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public @ResponseBody Object onAll() {
        try {
            List list = adminService.selectAll();
            return Result.success(list);
        } catch (Exception e) {
            System.out.print(e);
            return Result.failed();
        }
    }


    /*
     * @function
     * @api
     * @params account, password
     * @return admin object
     * */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody Object onLogin(@RequestBody Admin params) {
        try {
            Admin obj = adminService.login(params);
            return Result.success(obj);
        } catch (Exception e) {
            System.out.print(e);
            return Result.failed();
        }

    }

    /*
     * @function
     * @api
     * @params account, password
     * @return void
     * */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody Object onAdd(@RequestBody Admin params) {
        try {
            int affect = adminService.insertNormal(params);
            if (affect > 0) {
                return Result.success();
            } else {
                return Result.failed();
            }
        } catch (Exception e) {
            System.out.print(e);
            return Result.failed();
        }
    }

    /*
     * @function
     * @api
     * @params admin object
     * @return void
     * */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody Object onUpdate(@RequestBody Admin params) {
        try {
            int affect = adminService.updateNormal(params);
            if (affect > 0) {
                return Result.success();
            } else {
                return Result.failed();
            }
        } catch (Exception e) {
            System.out.print(e);
            return Result.failed();
        }
    }

    /*
     * @function
     * @api
     * @params admin object
     * @return void
     * */
    @RequestMapping(value = "del", method = RequestMethod.POST)
    public @ResponseBody Object onDel(@RequestBody JSONObject value) {

        int id = Integer.parseInt(value.get("id").toString());
        try {
            Admin admin = new Admin();
            admin.setId(id);
            admin.setStatus(States.DATA_DELETE_STATE);
            int affect = adminService.updateNormal(admin);
            if (affect > 0) {
                return Result.success();
            } else {
                return Result.failed();
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            return Result.failed();
        }
    }
}
