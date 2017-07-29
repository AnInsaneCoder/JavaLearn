package top.insanecoder.netty.enums;

/**
 * @author shaohang.zsh
 * @version 0.1 创建时间: 2017-07-22
 */
public enum HandlerTypeEnum {

    LINE_BASED_DECODER("01", "line based Handler"),

    DELIMITER_BASED_DECODER("02", "delimiter based Handler"),

    MESSAGE_PACK("03", "message pack based encoder and decoder");

    private String code;
    private String description;

    HandlerTypeEnum (String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
