package com.uhms.uhms.enums;

import lombok.Getter;

@Getter
public enum SexEnum{
    MAN("man","男"),
    WOMAN("women","女");

    private String type;
    private String describe;

    SexEnum(String type,String describe){
        this.type=type;
        this.describe=describe;
    }

    public static  String getNameByType(String type){
        for (SexEnum sexEnum:SexEnum.values())
        {
            if (sexEnum.type.equals(type))
            {
                return sexEnum.describe;
            }
        }
        return null;
    }

}
