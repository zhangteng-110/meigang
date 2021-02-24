package com.beautifulharborbackstage.service;

import com.beautifulharborbackstage.dao.mapper.ServiceItemsMapper;
import com.beautifulharborbackstage.pojo.dto.ServiceItemsResultDTO;
import com.beautifulharborbackstage.service.impl.ServiceItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangteng
 * @date: Created in 16:07 2021/1/11
 */
@Service
public class ServiceItemsService implements ServiceItemsServiceImpl {
    @Autowired
    private ServiceItemsMapper serviceItemsMapper;

    @Override
    public List<ServiceItemsResultDTO> getManProjectList() {
        return serviceItemsMapper.getManProjectList();
    }

    @Override
    public List<ServiceItemsResultDTO> getWemanProjectList() {
        return serviceItemsMapper.getWemanProjectList();
    }

    @Override
    public List<ServiceItemsResultDTO> getProjectList() {
        return serviceItemsMapper.getProjectList();
    }
}
