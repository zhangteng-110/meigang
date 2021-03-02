package com.beautifulharborbackstage.dao.mapper;

import com.beautifulharborbackstage.pojo.dto.RoleReturnResultDTO;
import com.beautifulharborbackstage.pojo.dto.ServiceItemsDTO;
import com.beautifulharborbackstage.pojo.dto.ServiceItemsResultDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ServiceItemsMapper {

    List<ServiceItemsResultDTO> getManProjectList();

    List<ServiceItemsResultDTO> getWemanProjectList();

    List<ServiceItemsResultDTO> getProjectList();

    void updateStatusById(ServiceItemsDTO serviceItemsDTO);

    void addServiceItem(ServiceItemsDTO serviceItemsDTO);

    void updateNameById(ServiceItemsDTO serviceItemsDTO);

    ServiceItemsResultDTO getProjectById(ServiceItemsDTO serviceItemsDTO);

    void deleteProjectById(ServiceItemsDTO serviceItemsDTO);
}