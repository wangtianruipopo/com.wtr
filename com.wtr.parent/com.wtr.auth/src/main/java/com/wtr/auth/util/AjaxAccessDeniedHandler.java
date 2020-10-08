package com.wtr.auth.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wtr.common.vo.WrappedResult;

/**
 * 无权访问
 * @author wangtianrui
 *
 */
@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		WrappedResult<AccessDeniedException> result = WrappedResult.success(WrappedResult.LOING_DENIED_CODE, "无权访问", accessDeniedException);
		response.getWriter().write(JSON.toJSONString(result, SerializerFeature.BrowserCompatible));
	}

}
