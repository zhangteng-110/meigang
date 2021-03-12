package com.beautifulharborbackstage.dao.mapper;

import com.beautifulharborbackstage.pojo.dto.StaffDTO;
import com.beautifulharborbackstage.pojo.dto.StaffReturnResultDTO;
import com.beautifulharborbackstage.pojo.dto.StorefrontDTO;
import com.beautifulharborbackstage.pojo.dto.StorefrontResultDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StorefrontMapper {

    List<StorefrontResultDTO> getAllStorefront();

    void addStorefront(StorefrontDTO storefrontDTO);

    void updateStatusById(StorefrontDTO storefrontDTO);

    List<StorefrontResultDTO> getStorefront();

    void deleteStorefrontById(StorefrontDTO storefrontDTO);

    StorefrontResultDTO getStorefrontById(StorefrontDTO storefrontDTO);

    void updateStorefrontById(StorefrontDTO storefrontDTO);






}