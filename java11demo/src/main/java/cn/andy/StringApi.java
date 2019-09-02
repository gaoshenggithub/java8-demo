package cn.andy;

import org.junit.Test;

public class StringApi {

    @Test
    public void test() {
        String str = "\t \r \n";
        System.out.println(str.isBlank());//判断字符串是否都空白

        str = "\t  asdf \r \n  \t ";
        String strip = str.strip(); //去除字符串首尾空白字符（可以去除所有空白字符）
        System.out.println(strip);
        System.out.println(strip.length());

        String trim = str.trim();
        System.out.println(trim);
        System.out.println(trim.length());

        str.stripLeading();//去除头的字符串
        str.stripTrailing();//去除尾的字符串
        str.lines().count();//计算行数
        str.repeat(4);//复制字符串
    }
}
