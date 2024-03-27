package com.green.pro29;

import com.green.pro29.ex01.MemberVO;
import com.green.pro29.ex01.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test/*")
public class TestController {

    @RequestMapping("/hi")
    String hello() {
        return "hi";
    }

    @RequestMapping("/member")
    MemberVO member() {
        MemberVO vo = new MemberVO();
        vo.setId("hong");
        vo.setPwd("1212");
        vo.setName("홍길동");
        vo.setEmail("hong@naver.com");

        return vo;
    }

    @RequestMapping("/student")
    List<Student> Student() {
        List<Student> stuList = Arrays.asList(new Student("홍길동", 90),
                new Student("홍이동", 80),
                new Student("홍삼동", 50));

        return stuList;
    }

    @RequestMapping("/avg")
    Double Avg() {
        List<Student> stuList2 = Arrays.asList(new Student("홍길동", 90),
                new Student("홍이동", 80),
                new Student("홍삼동", 50));
        Double average = stuList2.stream().mapToDouble((obj)->{return obj.getScore();}).average().getAsDouble();

        return average;
    }
    @RequestMapping("/mapTest")
    String studentMap() {
        Map<String, String> map = new HashMap<>();

        map.put("a", "apple");
        map.put("b", "banana");

        return map.get("a");
    }

    @RequestMapping("/mapTest2")
    Student mapTest2() {
        Map<String, Student> map = new HashMap<>();

        map.put("a", new Student("하하1", 100));
        map.put("b", new Student("하하1", 100));

        return map.get("b");
    }

    @RequestMapping("/mapTest3")
    List<Student> mapTest3() {
        List<Student> stuList5 = Arrays.asList(new Student("홍길동", 90),
                new Student("홍이동", 70),
                new Student("홍삼동", 80));

        Map<String, List<Student>> map = new HashMap<>();

        map.put("stu",stuList5);

        return map.get("stu");
    }


}
