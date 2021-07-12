package cn.running4light.common;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/12 16:02
 */
public enum ServiceList {
    basis("basis"),
    basis2("basis2");
    public final String value;
    private ServiceList(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }
}
