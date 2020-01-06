package hhl.lombok;

import com.alibaba.fastjson.JSON;
import model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.OS.*;

@DisplayName("lombok、fastJson 测试类")
class TestPersonAndFastJson {

    @Test
    @DisplayName("测试fastJson")
    @EnabledOnOs({WINDOWS, MAC})
    @EnabledOnJre(JAVA_8)
    void test_pf() {
        Person person = new Person(10, "小黄");
        assertNotNull(person);
        assertEquals(person.getAge(), 10);
        assertEquals(person.getName(), "小黄");
        String personString = JSON.toJSONString(person);
        assertEquals(personString, "{\"age\":10,\"name\":\"小黄\"}");
        assertEquals(person, JSON.parseObject(personString, Person.class));
    }


}
