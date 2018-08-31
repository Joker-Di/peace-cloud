package pep.pesoftware.coc.util;

import pep.pesoftware.coc.constant.PeaceConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PeaceDateUtil {

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param form
     *          开始时间
     * @param to
     *          结束时间
     * @return
     *          相差天数
     */
    public static int differentDays(Date form, Date to) {
        return (int) ((to.getTime() - form.getTime()) / (1000*3600*24));
    }

    /**
     * 判断两个时间相差多少个月
     * @param form
     *          开始时间
     * @param to
     *          结束时间
     * @return
     *          相差月数
     */
    public static int differentMonth(Date form, Date to){
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(form);
        aft.setTime(to);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result);
    }

    /**
     * 把日期格式化为字符串
     * @param date
     *          日期
     * @param format
     *          格式
     * @return
     *          返回格式化之后的字符串
     */
    public static String dateToString(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 把日期格式化为字符串
     * @param date
     *          日期
     * @param format
     *          格式
     * @return
     *          返回格式化之后的字符串
     */
    public static Date stringToDate(String date,String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 通过传入的日期加指定的天数
     * @param date
     *          日期
     * @param day
     *          天数
     * @return
     *          相加后的天数
     */
    public static Date getNextDay(Date date,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,day);
        return calendar.getTime();
    }

    /**
     * 通过传入的日期加指定的天数
     * @param date
     *          日期
     * @param day
     *          天数
     * @return
     *          相加后的天数
     */
    public static String getNextDay(String date ,int day,String format){
        return dateToString(getNextDay(stringToDate(date,format),day),format);
    }

    /**
     * 通过传入的日期加指定的年数
     * @param date
     *          日期
     * @param year
     *          年数
     * @return
     *          计算后的日期
     */
    public static Date getNextYear(Date date,int year){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,year);
        return calendar.getTime();
    }

    /**
     * 通过传入的日期加指定的月数
     * @param date
     *          日期
     * @param month
     *          月数
     * @return
     *          计算后的日期
     */
    public static Date getNextMonth(Date date,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,month);
        return calendar.getTime();
    }

    /**
     * 获取当前的时间
     * @return
     *          返回当前的时间
     */
    public static Date getNowDate(){
        return new Date();
    }

    /**
     * 获取当前的时间（yyyy-MM-dd）
     * @return
     *          返回当前的时间
     */
    public static String getNowDayString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(PeaceConstant.DATA_FORMAT_DATA_SHORT_SYMBOL);
        return dateFormat.format(getNowDate());
    }

    /**
     * 获取当前的时间
     * @return
     *          返回当前的时间
     */
    public static Date getNowDayDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(PeaceConstant.DATA_FORMAT_DATA_SHORT_SYMBOL);
        return stringToDate(dateFormat.format(getNowDate()),PeaceConstant.DATA_FORMAT_DATA_SHORT_SYMBOL);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getNextDay("2018-01-01" , 1 ,"yyyy-MM-dd"));
    }


}
