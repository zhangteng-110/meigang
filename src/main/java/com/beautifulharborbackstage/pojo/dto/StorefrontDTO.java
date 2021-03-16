package com.beautifulharborbackstage.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhangteng
 * @date: Created in 17:14 2020/12/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorefrontDTO {
   private int storefrontId;
   private String storefrontName;
   private String storefrontAddress;
   private String detailedAddress;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date startDate;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date endDate;
   private int status;
   private int[] storefrontIds;
   private String addressCode;
}
