package com.cheng.springboot.handler;

import com.cwhlj.common.web.handler.DefaultExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author chengwei
 * @date 2019-08-29 15:06
 */
@Order
@ControllerAdvice
public class GlobalExceptionHandler extends DefaultExceptionHandler {
}
