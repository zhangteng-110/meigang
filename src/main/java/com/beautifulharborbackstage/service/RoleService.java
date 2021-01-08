package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.RoleMapper;
import com.beautifulharborbackstage.pojo.dto.RoleReturnResultDTO;
import com.beautifulharborbackstage.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 10:28 2021/1/8
 */
@Service
public class RoleService implements RoleServiceImpl {
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<RoleReturnResultDTO> getRoleList() {
        return roleMapper.getRoleList();
    }
}
