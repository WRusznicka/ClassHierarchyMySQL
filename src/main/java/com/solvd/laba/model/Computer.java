package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    private String type;
    private String brand;
    private String model;
    private String specifications;
    private float price;
    private int quantity;
    private int displayId;
    private int batteryId;
    private int graphicCardId;
    private int  processorId;
    private int ramId;
    private int storageId;
    private int warrantyId;
}
