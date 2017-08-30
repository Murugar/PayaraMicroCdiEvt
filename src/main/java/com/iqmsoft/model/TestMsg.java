package com.iqmsoft.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TestMsg implements Serializable {
    private static final long serialVersionUID = 1L;

    private String msg;
}
