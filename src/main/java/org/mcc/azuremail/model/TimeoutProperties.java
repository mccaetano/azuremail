package org.mcc.azuremail.model;

import lombok.Data;

@Data
public class TimeoutProperties {
    Long call;
    Long connect;
    Long read;
    Long wirte;
}
