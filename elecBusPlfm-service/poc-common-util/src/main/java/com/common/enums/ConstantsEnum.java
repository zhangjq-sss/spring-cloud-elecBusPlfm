package com.common.enums;

public enum ConstantsEnum{
	
	//卡类型
	CUSTOMER_STATUS_VALID("生效", "0"), CUSTOMER_STATUS_EXPIRE("失效", "1"),
	//redis配置
	REDIS_MOBILE("手机号关键字", "MOBILE_"),
	//jwt秘银
	JWT_SECRET("手机号关键字", "SECRET_")
    ;

    // 成员变量
    private String name;
    private String index;

    // 构造方法
    private ConstantsEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(String index) {
        for (ConstantsEnum c : ConstantsEnum.values()) {
        if (c.getIndex().equals(index)) {
            return c.name;
        }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}

