package com.tour.group.twow.mapper;

import com.tour.group.twow.entity.Admin;

import java.util.List;

public interface AdminMapper {
    public List<Admin> selectAll();
    public Admin isExist(Admin admin);
    public int insertNormal(Admin admin);
    public int update(Admin admin);
}
