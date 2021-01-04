package com.beautifulharborbackstage.utils;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangteng
 * @date: Created in 11:02 2020/12/14
 */
public class JWTUtil {
    /**
     * APP登录Token的生成和解析
     *
     */

    /** token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj */
    public static final String SECRET = "JKKLJOoasdlfj";
    /** token 过期时间: 10天 */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;

    /**
     * JWT生成Token.<br/>
     *
     * JWT构成: header, payload, signature
     *
     * @param userCode
     *            登录成功后用户userCode, 参数userCode不可传空
     */
    public static String createToken(String userCode,String username,String password) throws Exception {
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        // build token
        // param backups {iss:Service, aud:APP}
        String token = JWT.create().withHeader(map) // header
                .withClaim("iss", "Service") // payload
                .withClaim("aud", "APP")
                .withClaim("userCode", null == userCode ? null : userCode)
                .withClaim("username", null == username ? null : username)
                .withClaim("password", null == password ? null : password)
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature

        return token;
    }

    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            // e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
        }
        return jwt.getClaims();
    }

    /**
     * 根据Token获取user_id
     *
     * @param token
     * @return user_id
     */
    public static Map<String, String> getAppUID(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim userCode_claim = claims.get("userCode");
        Claim username_claim = claims.get("username");
        Claim password_claim = claims.get("password");
        if (null == userCode_claim || StringUtils.isEmpty(userCode_claim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
        }
        if (null == username_claim || StringUtils.isEmpty(username_claim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
        }
        if (null == password_claim || StringUtils.isEmpty(password_claim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
        }
        Map<String, String> map = new HashMap<>();
        map.put("userCode",userCode_claim.asString());
        map.put("username",username_claim.asString());
        map.put("password",password_claim.asString());
        return map;
    }
}
