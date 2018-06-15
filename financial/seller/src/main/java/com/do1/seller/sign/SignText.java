package com.do1.seller.sign;

import com.do1.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 签名明文
 */
@JsonInclude(JsonInclude.Include.NON_NULL)   //json序列化
@JsonPropertyOrder(alphabetic = true)      //json排序
public interface SignText {
    default String toText(){
        return JsonUtil.toJson(this);
    }
}
