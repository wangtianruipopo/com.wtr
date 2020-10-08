package com.wtr.auth.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wtr.common.vo.WrappedResult;

/**
 * 未登录
 * @author wangtianrui
 *
 */
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		WrappedResult<AuthenticationException> result = WrappedResult.success(WrappedResult.NO_AUTHENTICATION_CODE, "无访问权限，请先登录", authException);
		response.getWriter().write(JSON.toJSONString(result, SerializerFeature.BrowserCompatible));
	}
	
}
