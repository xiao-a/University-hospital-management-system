package com.uhms.uhms.enums;

import lombok.Getter;

@Getter
public enum LogGradeEnum {

    ALL("[]", 0), INFO("[INFO]", 1), WARN("[WARN]", 2), ERROR("[ERROR]", 3);

    private String name;
    private int level;

    LogGradeEnum(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
    /**
     * <pre>
     * 判断是否允许打印
     * </pre>
     * @author ygr
     * @date 2018年4月9日 上午9:36:47
     * @param minLevel 最低日志级别
     * @return
     */
    public boolean isAllow(LogGradeEnum minLevel){
        if(level >= minLevel.getLevel()){
            return true;
        }

        return false;
    }

}
