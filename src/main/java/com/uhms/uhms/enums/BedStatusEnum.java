package com.uhms.uhms.enums;

import lombok.Getter;

@Getter
public enum BedStatusEnum {

    IN_USE("in_use","使用中"),
    IDLE("idle","闲置");

    private String type;
    private String description;

    BedStatusEnum(String type,String description)
    {
        this.type=type;
        this.description=description;
    }

    public static String getNameByType(String type){
        for (BedStatusEnum bedStatusEnum:BedStatusEnum.values())
        {
            if(bedStatusEnum.type.equals(type))
            {
                return bedStatusEnum.description;
            }
        }
        return null;
    }
}
