package net.cnki.token.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import net.cnki.util.UUIDUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserTokenService {
	private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;//24小时内有效
	
	/**
	 * 生成令牌
	 * @param client_id 账号
	 * @param client_secret 秘钥
	 * @return
	 */
    public String getToken(String client_id,String client_secret) {
    	
        String token="";
        try {
        	Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            header.put("only", UUIDUtil.getUUID());
        	Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token= JWT.create()
            		.withHeader(header)
            		.withAudience(client_id)// 将 client_id 保存到 token 里面
            		.withExpiresAt(date)
                    .sign(Algorithm.HMAC256(client_secret));// 以 client_secret 作为 token 的密钥
		} catch (Exception e) {
			token = null;
		}
        
        return token;
    }
}
