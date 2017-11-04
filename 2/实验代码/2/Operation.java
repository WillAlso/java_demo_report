
abstract class Operation {
    abstract double operation(double a,double b);
}
class Addtion extends Operation{
    public double operation(double a, double b){
        return a+b;
    }
}
class Subtraction extends Operation{
    public double operation(double a,double b){
        return a-b;
    }
}
class Multiplication extends Operation{
    public double operation(double a,double b){
        return a*b;
    }
}
class Division extends Operation{
    public double operation(double a,double b){
        return a/b;
    }
}
