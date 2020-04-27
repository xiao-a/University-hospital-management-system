package com.uhms.uhms.enums;

import lombok.Getter;

@Getter
public enum DayWeekEnum {

    MONDAY("monday","星期一"),
    TUESDAY("tuesday    ","星期二"),
    WEDNESDAY("wednesday","星期三"),
    THURSDAY("thursday","星期四"),
    FRIDAY("friday ","星期五"),
    SATURDAY("saturday","星期六"),
    Sunday ("sunday ","星期日");

    private String type;
    private String describe;

    DayWeekEnum(String type, String describe){
        this.type=type;
        this.describe=describe;
    }

    public static  String getNameByType(String type){
        for (DayWeekEnum sexEnum: DayWeekEnum.values())
        {
            if (sexEnum.type.equals(type))
            {
                return sexEnum.describe;
            }
        }
        return null;
    }

    public static  String getTypeByName(String name){
        for (DayWeekEnum sexEnum: DayWeekEnum.values())
        {
            if (sexEnum.describe.equals(name))
            {
                return sexEnum.type;
            }
        }
        return null;
    }

}
