package com.jintu.file.config;

import com.jintu.ipcdp.framework.exception.ExceptionCatch;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FileExceptionCatch extends ExceptionCatch {
	static {
		builder.put(IllegalArgumentException.class, CommonCode.INVALID_PARAM);
	}
}
