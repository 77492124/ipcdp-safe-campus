package com.jintu.ipcdp.framework.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @Author Parker
 * @Description: 自定义时间转换器，时间戳（毫秒）转LocalDateTime
 * @Date 2019/12/11 11:15
 * @Version 1.0
 */
public class DateTimeMillisecondDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (StringUtils.isEmpty(jsonParser.getText())){
            return null;
        }
        return Instant.ofEpochMilli(jsonParser.getLongValue()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }
}
