package com.tour.group.twow.service;

import com.tour.group.twow.entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin login(Admin admin);
    public int insertNormal(Admin admin);
    public int updateNormal(Admin admin);
    public List<Admin> selectAll();
}
