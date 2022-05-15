package org.mcc.azuremail.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TimeoutProperties {
    Long call;
    Long connect;
    Long read;
    Long wirte;
}
