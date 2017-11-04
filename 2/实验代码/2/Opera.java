
public class Opera {
    public static double opera(double a, char theta, double b){
        switch (theta){
            case '+':
                return (new Addtion()).operation(a,b);
            case '-':
                return (new Subtraction()).operation(a,b);
            case '*':
                return (new Multiplication()).operation(a,b);
            case '/':
                return (new Division()).operation(a,b);
        }
        return 0;
    }
}
