package com.beautifulharborbackstage;

import com.auth0.jwt.interfaces.Claim;
import com.beautifulharborbackstage.utils.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class BeautifulharborbackstageApplicationTests {

    @Test
    public void test() throws Exception {
        String token = JWTUtil.createToken("13072320001121381X","_admin"," admin");
        System.out.println(token);
        Map<String, String> map = JWTUtil.getAppUID(token);
        for (String key: map.keySet()) {
            System.out.println(key+":"+map.get(key));
        }
    }


}
