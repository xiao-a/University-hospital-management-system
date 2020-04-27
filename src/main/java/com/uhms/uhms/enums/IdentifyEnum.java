package com.uhms.uhms.enums;

import lombok.Getter;

@Getter
public enum IdentifyEnum {
    PATIENT("patient","病人"),
    DOCTOR("doctor","医生"),
    ADMIN("admin","管理员");

    private String type;
    private String describe;

    IdentifyEnum(String type, String describe){
        this.type=type;
        this.describe=describe;
    }

    public static  String getNameByType(String type){
        for (IdentifyEnum sexEnum: IdentifyEnum.values())
        {
            if (sexEnum.type.equals(type))
            {
                return sexEnum.describe;
            }
        }
        return null;
    }

    public static  String getTypeByName(String name){
        for (IdentifyEnum sexEnum: IdentifyEnum.values())
        {
            if (sexEnum.describe.equals(name))
            {
                return sexEnum.type;
            }
        }
        return null;
    }

}
