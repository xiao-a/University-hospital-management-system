package com.uhms.uhms.enums;

import lombok.Getter;

@Getter
public enum AppointmentStatusEnum {
    UNCONFIRM("unconfirm","确认中"),
    CONFIRMED("confirmed","已确认"),
    COMPLETE("complete","已完成"),
    OVERDUE("overdue","已过期");

    private String type;
    private String describe;

    AppointmentStatusEnum(String type, String describe){
        this.type=type;
        this.describe=describe;
    }

    public static  String getNameByType(String type){
        for (AppointmentStatusEnum sexEnum: AppointmentStatusEnum.values())
        {
            if (sexEnum.type.equals(type))
            {
                return sexEnum.describe;
            }
        }
        return null;
    }

    public static  String getTypeByName(String name){
        for (AppointmentStatusEnum sexEnum: AppointmentStatusEnum.values())
        {
            if (sexEnum.describe.equals(name))
            {
                return sexEnum.type;
            }
        }
        return null;
    }

}
