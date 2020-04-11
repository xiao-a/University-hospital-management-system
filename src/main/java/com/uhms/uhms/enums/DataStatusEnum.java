package com.uhms.uhms.enums;

import lombok.Getter;

@Getter
public enum  DataStatusEnum {

    VALID("valid","生效"),
    NOT_VALID("not_valid","失效");

    private String type;
    private String describe;

    DataStatusEnum(String type,String describe){
        this.type=type;
        this.describe=describe;
    }

    public static  String getNameByType(String type){
        for (DataStatusEnum sexEnum:DataStatusEnum.values())
        {
            if (sexEnum.type.equals(type))
            {
                return sexEnum.describe;
            }
        }
        return null;
    }

}
