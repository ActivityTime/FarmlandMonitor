package neau.cekong.test;

import neau.cekong.util.JsonTranstor;
import org.junit.Test;

import java.util.Map;

public class JsonTest {

    @Test
    public void test(){
        Map<String, String> maps = JsonTranstor.transToMap("{a:a,b:b,f:123}");
        System.out.println(maps);
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
