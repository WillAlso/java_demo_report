import java.util.Scanner;
public class Area {
    public static void main(String[] args){
        System.out.print("形状类型\n1、长方形\n2、圆形\n3、三角形\n请输入选项(1/2/3)");
        Shape temp;
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch(choice) {
            case 1: {
               temp = new Rectangle();
               temp.Set();
               temp.Print();
               break;
            }
            case 2:{
                temp = new Circular();
                temp.Set();
                temp.Print();
                break;
            }
            case 3:{
                temp = new Triangle();
                temp.Set();
                temp.Print();
                break;
            }
            default:
                System.out.println("输入选项有误！");
        }
    }
}
class Shape{
    public void Set(){}
    public void Print(){}
}
class Rectangle extends Shape{
    private double length;
    private double width;
    Rectangle() {
        length = 0;
        width = 0;
    }
    public void Set(){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入长方形的详细信息\n长为：");
        length = input.nextDouble();
        System.out.print("宽为：");
        width = input.nextDouble();

    }
    public void Print(){
        System.out.print("该长方形的面积为：" + length*width+'\n');
    }
}
class Triangle extends Shape{
    private double hight;
    private double width;
    Triangle(){
        hight = 0;
        width = 0;
    }
    public void Set(){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入三角形的详细信息\n高为：");
        hight = input.nextDouble();
        System.out.print("底边为：");
        width = input.nextDouble();
    }
    public void Print(){
        System.out.print("该三角形的面积为："+0.5*hight*width+'\n');
    }
}
class Circular extends Shape{
    private double circle;
    Circular(){
        circle = 0;
    }
    public void Set(){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入三角形的详细信息\n半径为：");
        circle = input.nextDouble();
    }
    public void Print(){
        System.out.print("该圆形的面积为："+3.1415*circle*circle+'\n');
    }
}
