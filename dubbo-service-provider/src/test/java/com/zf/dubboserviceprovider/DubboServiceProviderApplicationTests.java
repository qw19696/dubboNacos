package com.zf.dubboserviceprovider;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
class DubboServiceProviderApplicationTests {

    @Test
    void contextLoads() throws UnsupportedEncodingException {
        byte[] x = {41, 78, 10, 27, -26, 67, -79, -3, 14, 49, -68, -118, 12, -90, 7, -52, -25, 95, 61, -47, -64, -47, 41, -85, -45, -125, -110, 23, -26, -24, -63, 59, -49, 54, -62, 78, -13, 70, 22, -15, -66, -73, 31, -114, 97, -111, 11, -46, 37, 67, -40, -37, -25, 109, 70, -74, -43, -31, 74, -125, 24, 78, -15, 81};
        String aaa = new String(x,"ISO-8859-1");
        System.out.println(aaa);
    }

}
