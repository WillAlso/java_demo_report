import java.util.Scanner;

public class Administrators{
	private String name;
    private String password;
	Administrators(String name_temp,String password_temp){
        name = name_temp;
        password = password_temp;
    }
    public void show(){
	    System.out.println("姓名:" +name +"\t密码:"+password);
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入第一个管理员信息：\n姓名：");
        String name1 = input.next();
        System.out.print("\n密码：");
        String password1 = input.next();
        System.out.print("\n请输入第二个管理员信息：\n姓名：");
        String name2= input.next();
        System.out.print("\n密码：");
        String password2= input.next();
        Administrators admin1 = new Administrators(name1,password1);
        Administrators admin2 = new Administrators(name2,password2);
        System.out.print("管理员信息：\n");
        admin1.show();
        admin2.show();
    }
}