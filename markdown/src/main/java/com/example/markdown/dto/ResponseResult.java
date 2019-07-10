package com.example.markdown.dto;

/**
 * @author LB
 * @create 2019-07-09 20:50
 */
public class ResponseResult {
    private Integer success;
    private String Message;
    private String url;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
