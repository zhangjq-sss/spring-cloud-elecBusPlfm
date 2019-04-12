package com.gateway.client.fallback;

import org.springframework.stereotype.Component;

import com.gateway.client.AuthSeviceFeignClient;
import com.gateway.model.AuthResult;

import javax.servlet.http.HttpServletResponse;

@Component
public class AuthSeviceFeignClientFallback  implements  AuthSeviceFeignClient {

    @Override
	public AuthResult  checkToken(String  token) {
		AuthResult result = new AuthResult();
		result.setCode(HttpServletResponse.SC_UNAUTHORIZED+"");
		result.setMessage("out of auth service -checktoken");
		return result;
	}

    @Override
    public AuthResult userLogin(String userName, String password) {
        AuthResult result = new AuthResult();
        result.setCode(HttpServletResponse.SC_UNAUTHORIZED+"");
        result.setMessage("out of auth service-userLogin");
        return result;
    }

	@Override
	public AuthResult userOut(String token) {
		AuthResult result = new AuthResult();
		result.setCode(HttpServletResponse.SC_UNAUTHORIZED+"");
		result.setMessage("out of auth service-userOut");
		return result;
	}

}
