package com.uhms.uhms.enums;

import lombok.Getter;

@Getter
public enum DivisionTypeEnum {

    PHYSICIAN("physician","内科"),
    SURGERY("surgery","外科"),
    GYNECOLOGY("gynecology","妇科"),
    ORTHOPEDICS("orthopedics","骨科"),
    OPHTHALMOLOGY("ophthalmology","五官科"),
    DERMATOLOGY("dermatology","皮肤科");

    private String type;
    private String describe;

    DivisionTypeEnum(String type, String describe){
        this.type=type;
        this.describe=describe;
    }

    public static  String getNameByType(String type){
        for (DivisionTypeEnum sexEnum: DivisionTypeEnum.values())
        {
            if (sexEnum.type.equals(type))
            {
                return sexEnum.describe;
            }
        }
        return null;
    }

    public static  String getTypeByName(String name){
        for (DivisionTypeEnum sexEnum: DivisionTypeEnum.values())
        {
            if (sexEnum.describe.equals(name))
            {
                return sexEnum.type;
            }
        }
        return null;
    }

}
