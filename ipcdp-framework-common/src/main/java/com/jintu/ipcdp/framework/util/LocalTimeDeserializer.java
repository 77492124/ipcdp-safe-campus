package com.jintu.ipcdp.framework.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author 常培兵
 * @Description: 自定义时间转换器 ，时间反序列化
 * @Date 2019/5/8 18:22
 * @Version 1.0
 */
public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {

    @Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(jsonParser.getText(),df);
    }
}
