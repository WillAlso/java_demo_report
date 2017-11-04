import java.util.Scanner;

public class TestCalc {
    public static void main(String[] args){
        double num1,num2;
        String operate = "";
        Calculator cal = new Calculator();
        Scanner input = new Scanner(System.in);
        num1 = input.nextDouble();
        operate = input.next();
        num2 = input.nextDouble();
        switch (operate){
            case "+":System.out.println("结果："+cal.add(num1,num2));break;
            case "-":System.out.println("结果："+cal.minus(num1,num2));break;
            case "*":System.out.println("结果："+cal.multiple(num1,num2));break;
            case "/":{
                if(num2 != (double) 0 ) {
                    System.out.println("结果："+cal.divide(num1, num2));
                    break;
                }
                else {
                    System.out.println("num2 is zero!");break;
                }
            }
            default:System.out.println("The input is wrong!");break;
        }
    }
}
