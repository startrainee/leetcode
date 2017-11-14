package addSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 解析字符串
 *
 * */
public class ParseString {

    private static final int BEFORE_TAKEOFF = 0;
    private static final int AFTER_TAKEOFF = 1;

    public static void main(String[] args) {
        String[] input = new String[]{
                "0",
                "10-0-10-10",
                "10-0-10",
                "10-2-20",
                "10-4-20-2-20-0-14"
        };
        System.out.println(Arrays.toString("09999-9999".split("-")));
        for (String str : input) {
            parsString(str).forEach(System.out::println);
            System.out.println("———————————");
        }
    }


    public static List<String> parsString(String inputStr) {
        List<String> list = new ArrayList<>();
        String[] arrayOfInputStr = inputStr.split("-");
        if (arrayOfInputStr.length <= 0 || arrayOfInputStr.length % 2 == 0) {
            list.add("输入字符串有误！");
            return list;
        }
        if (arrayOfInputStr.length == 1) {
            list.add("暂不提供退票");
            return list;
        }
        for (int i = 1; i < arrayOfInputStr.length; i += 2) {

            list.add(getChargeString(arrayOfInputStr[i], arrayOfInputStr[i - 1], BEFORE_TAKEOFF));
            if (i == arrayOfInputStr.length - 2) {
                list.add(getChargeString(arrayOfInputStr[i], arrayOfInputStr[i + 1], AFTER_TAKEOFF));
            }
        }
        return list;
    }

    private static String getChargeString(String hour, String money, int type) {
        int numOfHour = Integer.valueOf(hour);
        int numOfMoney = Integer.valueOf(money + "0");
        if (type == BEFORE_TAKEOFF) {
            if (numOfHour == 0) return "起飞前，收费¥" + numOfMoney + "人";
            return "起飞前" + numOfHour + "小时之前，收费¥" + numOfMoney + "/人";

        }
        if (type == AFTER_TAKEOFF) {
            if (numOfHour == 0) return "起飞后，收费¥" + numOfMoney + "人";
            return "起飞前" + numOfHour + "小时之后，收费¥" + numOfMoney + "/人";
        }
        return "";
    }
}
