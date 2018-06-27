package com.tour.group.twow.service.impl;

import com.tour.group.twow.entity.Admin;
import com.tour.group.twow.mapper.AdminMapper;
import com.tour.group.twow.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        return adminMapper.isExist(admin);
    }

    @Override
    public int insertNormal(Admin admin) {
        return adminMapper.insertNormal(admin);
    }

    @Override
    public int updateNormal(Admin admin) {
        return adminMapper.updateNormal(admin);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }
}
