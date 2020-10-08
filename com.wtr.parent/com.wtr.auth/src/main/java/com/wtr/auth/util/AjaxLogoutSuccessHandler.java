package com.wtr.auth.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wtr.common.vo.WrappedResult;

/**
 * 注销
 * @author wangtianrui
 *
 */
@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		WrappedResult<Authentication> result = WrappedResult.success(WrappedResult.LOGOUT_CODE, "注销成功", authentication);
		response.getWriter().write(JSON.toJSONString(result, SerializerFeature.BrowserCompatible));
	}

}
