public class Opera {
    public static double opera(double a, char theta, double b){
		Operation t = null;
        switch (theta){
            case '+':
                t = new Addtion();break;
            case '-':
                t = new Subtraction();break;
            case '*':
                t = new Multiplication();break;
            case '/':
                t = new Division();break;
        }
		return t.operation(a,b);
    }
}
