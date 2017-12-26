package com.test;

public enum  TestEnums {

    AAA(1),
    BBB(2),
    CCC(3);

    private Integer code;
    private String ms;

    public TestEnums(Integer code) {
        this.code = code;
    }

    public TestEnums(Integer code, String ms) {
        this.code = code;
        this.ms = ms;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }
}
