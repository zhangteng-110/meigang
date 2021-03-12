package com.beautifulharborbackstage.service.impl;

import com.beautifulharborbackstage.pojo.dto.StorefrontDTO;
import com.beautifulharborbackstage.pojo.dto.StorefrontResultDTO;

import java.util.List;

public interface StorefrontServiceImpl {
    List<StorefrontResultDTO> getAllStorefront();

    Object addStorefront(StorefrontDTO storefrontDTO);

    Object updateStatusById(StorefrontDTO storefrontDTO);

    List<StorefrontResultDTO> getStorefront();

    Object deleteStorefrontById(StorefrontDTO storefrontDTO);

    StorefrontResultDTO getStorefrontById(StorefrontDTO storefrontDTO);

    Object updateStorefrontById(StorefrontDTO storefrontDTO);
}