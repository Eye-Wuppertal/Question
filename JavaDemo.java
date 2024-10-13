import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDemo {
    // long型字符串转yyyy-MM-dd HH:mm:ss格式
    public static String longStrFormate(String time) {    
        Date date=new Date(Long.parseLong(time));
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        time=formatter.format(date);
        return time;
    }
    // String 转 Date
    public static Date str2Date(String time) throws Exception{
        Date date=null;
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date=formatter.parse(time);
        return date;
    }
    public static void main(String argsp[]) throws Exception{
        // String time="1256006105375";
        String time="2010-11-20 11:10:10";
        String time1 = "2020-12-20 11:10:10";
        System.out.println(str2Date(time).compareTo(str2Date(time1)));
    }   
}
