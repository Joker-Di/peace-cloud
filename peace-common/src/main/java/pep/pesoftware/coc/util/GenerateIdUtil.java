package pep.pesoftware.coc.util;

import pep.pesoftware.coc.constant.PeaceConstant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * 生成随机数工具类
 */
public class GenerateIdUtil {
    public static void main(String[] args) {
        System.out.println(GenerateIdUtil.randomAlphanumeric(PeaceConstant.KEY_RANDOM_COUNT, PeaceConstant.DATA_FORMAT_DATA_TIME_SHORT));
    }

    /**
     * 随机数类
     */
    private static final Random RANDOM = new Random();
    /**
     * 产生随机字母
     *
     * @param count 随机字符串部分长度
     * @return  随机字符串
     */
    public static String randomAlphabetic(final int count) {
        return random(count, 0, 0, true, false, null, RANDOM, null);
    }

    /**
     * 产生随机字母和数字
     *
     * @param count 随机字符串部分长度
     * @return  随机字符串
     */
    public static String randomAlphanumeric(final int count) {
        return random(count, 0, 0, true, true, null, RANDOM, null);
    }

    /**
     * 产生随机数字
     *
     * @param count 随机字符串部分长度
     * @return  随机字符串
     */
    public static String randomNumeric(final int count) {
        return random(count, 0, 0, false, true, null, RANDOM, null);
    }

    /**
     * 产生随机字母
     *
     * @param count 随机字符串部分长度
     * @param dateFormat 日期部分的格式，为null时不包含日期
     * @return 随机字符串
     */
    public static String randomAlphabetic(final int count, final String dateFormat) {
        return random(count, 0, 0, true, false, null, RANDOM, dateFormat);
    }

    /**
     * 产生随机字母和数字
     *
     * @param count 随机字符串部分长度
     * @param dateFormat 日期部分的格式，为null时不包含日期
     * @return  随机字符串
     */
    public static String randomAlphanumeric(final int count, final String dateFormat) {
        return random(count, 0, 0, true, true, null, RANDOM, dateFormat);
    }

    /**
     * 产生随机数字
     *
     * @param count 随机字符串部分长度
     * @param dateFormat 日期部分的格式，为null时不包含日期
     * @return 随机字符串
     */
    public static String randomNumeric(final int count, final String dateFormat) {
        return random(count, 0, 0, false, true, null, RANDOM, dateFormat);
    }

    /**
     * 产生随机字符串
     *
     * @param count 随机字符串部分长度
     * @param chars 有效字符
     * @param dateFormat 日期部分的格式，为null时不包含日期
     * @return 随机字符串
     */
    public static String random(int count, final String chars, String dateFormat) {
        return random(count, 0, 0, false, false, chars.toCharArray(), RANDOM, dateFormat);
    }

    /**
     * 产生随机字符串
     *
     * @param count 随机字符串部分长度
     * @param start 产生随机整数时的最小值
     * @param end 产生随机整数时的最大值
     * @param letters 是否只包含字母
     * @param numbers 是否只包含数字
     * @param chars 有效字符
     * @param random 随机工具类
     * @param dateFormat 日期部分的格式，为null时不包含日期
     * @return 随机字符串
     */
    private static String random(int count, int start, int end, final boolean letters, final boolean numbers, final char[] chars, final Random random, String dateFormat) {
        if (count == 0) {
            return "";
        } else if (count < 0) {
            throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
        }
        if (chars != null && chars.length == 0) {
            throw new IllegalArgumentException("The chars array must not be empty");
        }

        if (start == 0 && end == 0) {
            if (chars != null) {
                end = chars.length;
            } else {
                if (!letters && !numbers) {
                    end = Integer.MAX_VALUE;
                } else {
                    end = 'z' + 1;
                    start = ' ';
                }
            }
        } else {
            if (end <= start) {
                throw new IllegalArgumentException("Parameter end (" + end + ") must be greater than start (" + start + ")");
            }
        }

        final char[] buffer = new char[count];
        final int gap = end - start;

        while (count-- != 0) {
            char ch;
            if (chars == null) {
                ch = (char) (random.nextInt(gap) + start);
            } else {
                ch = chars[random.nextInt(gap) + start];
            }
            if (letters && Character.isLetter(ch) || numbers && Character.isDigit(ch) || !letters && !numbers) {
                if (ch >= 56320 && ch <= 57343) {
                    if (count == 0) {
                        count++;
                    } else {
                        // low surrogate, insert high surrogate after putting it in
                        buffer[count] = ch;
                        count--;
                        buffer[count] = (char) (55296 + random.nextInt(128));
                    }
                } else if (ch >= 55296 && ch <= 56191) {
                    if (count == 0) {
                        count++;
                    } else {
                        // high surrogate, insert low surrogate before putting it in
                        buffer[count] = (char) (56320 + random.nextInt(128));
                        count--;
                        buffer[count] = ch;
                    }
                } else if (ch >= 56192 && ch <= 56319) {
                    // private high surrogate, no effing clue, so skip it
                    count++;
                } else {
                    buffer[count] = ch;
                }
            } else {
                count++;
            }
        }
        String rs = new String(buffer);
        if (null != dateFormat) {
            SimpleDateFormat df = new SimpleDateFormat(dateFormat);
            rs = df.format(new Date()) + rs;
        }
        return rs;
    }

}
