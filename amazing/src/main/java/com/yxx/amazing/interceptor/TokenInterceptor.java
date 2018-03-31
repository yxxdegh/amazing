package com.yxx.amazing.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;




/*public class TokenInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		    response.setCharacterEncoding("utf-8");
	        String token = request.getParameter("token");
	        ResponseData responseData = ResponseData.ok();
	        //token不存在
	        if(null != token) {
	            User user = JWT.unsign(token, User.class);
	            String loginId = request.getParameter("loginId");
	            //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
	            if(null != loginId && null != user) {
	                if(Integer.parseInt(loginId) == user.getId()) {
	                    return true;
	                }
	                else{
	                    responseData = ResponseData.forbidden();
	                    responseMessage(response, response.getWriter(), responseData);
	                    return false;
	                }
	            }
	            else
	            {
	                responseData = ResponseData.forbidden();
	                responseMessage(response, response.getWriter(), responseData);
	                return false;
	            }
	        }
	        else
	        {
	            responseData = ResponseData.forbidden();
	            responseMessage(response, response.getWriter(), responseData);
	            return false;
	        }
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

    //请求不通过，返回错误信息给客户端
   private void responseMessage(HttpServletResponse response, PrintWriter out, ResponseData responseData) {
        responseData = ResponseData.forbidden();
        response.setContentType("application/json; charset=utf-8");  
        String json = JSONObject.toJSONString(responseData);
        out.print(json);
        out.flush();
        out.close();
    }
}
*/