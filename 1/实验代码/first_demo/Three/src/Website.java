import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Website {
    public static void main(String[] args){
        String website =  "<html><body><a href=\\\"http://www.baidu.com\\\">百度</a>，<a href='http://www.163.com' target='_blank'>网易</a></body></html>";
        Pattern p = Pattern.compile("\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" +
                "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" +
                "|mil|biz|info|mobi|name|aero|jobs|museum" +
                "|travel|[a-z]{2}))");
        Matcher m = p.matcher(website);
            while(m.find()){
                System.out.println(m.group());
            }
    }
}