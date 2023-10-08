package com.demo.ecommerce.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDao {

    private String message;
    private String reason;
    private int statusCode;

}
