/**
 * @Author: jyh
 * @Date: 2019/12/24
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        char ch = '1';
        String str = "2";

        String a = str + ch;
        int b = ch - 48;

        System.out.println(a);
        System.out.println(b);
    }
}

class A{
    private static int a=0;

    public static void b(){
        System.out.println(a);
    }

}
