package com.wtr.auth.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wtr.common.vo.WrappedResult;

/**
 * 登录失败
 * @author wangtianrui
 *
 */
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		WrappedResult<AuthenticationException> result = WrappedResult.success(WrappedResult.LOING_FAULT_CODE, "登录失败", exception);
		response.getWriter().write(JSON.toJSONString(result, SerializerFeature.BrowserCompatible));
	}

}
