import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class URLDemo {
    private static String savepath="/home/jarvis/home";
    private static List<String> allwaiturl=new ArrayList<>();
    private static List<String> waiturl = new ArrayList<>();
    private static Set<String> alloverurl=new HashSet<>();
    private static int maxdepth=10;
    public static void main(String args[]){
        String strurl="http://book.dangdang.com/";
        allwaiturl.add(strurl);
        workurl(strurl,1);
    }
    public static void workurl(String strurl,int depth){
    	if(depth > maxdepth)
    		return;
    	while(!allwaiturl.isEmpty())
    	{
    		strurl=allwaiturl.get(0);
        if(!alloverurl.contains(strurl)){
        try {
            URL url=new URL(strurl);
            URLConnection con = url.openConnection();
            InputStream is=con.getInputStream();
            System.out.println(con.getContentEncoding());
            BufferedReader br=new BufferedReader(new InputStreamReader(is,"utf-8"));
            String line=null;
            Pattern p=Pattern.compile("<a .*href=.+</a>");
            PrintWriter pw=new PrintWriter(new File(savepath+System.currentTimeMillis()+".txt"));
            while((line=br.readLine())!=null){
                pw.println(line);
                Matcher m=p.matcher(line);
                while(m.find()){
                    String href=m.group();
                    href=href.substring(href.indexOf("href="));
                    if(href.charAt(5)=='\"'){
                        href=href.substring(6);
                    }else{
                        href=href.substring(5);
                    }
                try{
                    href=href.substring(0,href.indexOf("\""));
                }catch(Exception e){
                    try{
                        href=href.substring(0,href.indexOf(" "));
                    }catch(Exception e1){
                        href=href.substring(0,href.indexOf(">"));
                    }
                }
                if(href.startsWith("http:")||href.startsWith("https:")){
                	if(!(alloverurl.contains(href)))
                		waiturl.add(href);
                        }
                    }
                }
            pw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        alloverurl.add(strurl);
        allwaiturl.remove(strurl);
        System.out.println(waiturl.size());
        System.out.println(strurl+" download! Remain:"+allwaiturl.size());
        	}    
    	}    	
    	allwaiturl.addAll(waiturl);
    	waiturl.clear();
       String nexturl=allwaiturl.get(0);
       allwaiturl.remove(0);
       workurl(nexturl,depth+1);
       }
}