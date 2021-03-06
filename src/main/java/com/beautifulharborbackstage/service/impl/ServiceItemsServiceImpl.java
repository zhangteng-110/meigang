package com.beautifulharborbackstage.service.impl;

import com.beautifulharborbackstage.pojo.dto.ServiceItemsDTO;
import com.beautifulharborbackstage.pojo.dto.ServiceItemsResultDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceItemsServiceImpl {

    List<ServiceItemsResultDTO> getManProjectList();

    List<ServiceItemsResultDTO> getWemanProjectList();

    List<ServiceItemsResultDTO> getProjectList();

    Object updateStatusById(ServiceItemsDTO serviceItemsDTO);

    Object addServiceItem(ServiceItemsDTO serviceItemsDTO);

    Object updateNameById(ServiceItemsDTO serviceItemsDTO);

    ServiceItemsResultDTO getProjectById(ServiceItemsDTO serviceItemsDTO);

    Object deleteProjectById(ServiceItemsDTO serviceItemsDTO);
}