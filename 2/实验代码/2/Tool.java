
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Stack;
public class Tool {
    static char Precede(char a,char b){
        int i,j;
        char[][] table={
                {' ','+','-','*','/','(',')','='},
                {'+','>','>','<','<','<','>','>'},
                {'-','>','>','<','<','<','>','>'},
                {'*','>','>','>','>','<','>','>'},
                {'/','>','>','>','>','<','>','>'},
                {'(','<','<','<','<','<','=',' '},
                {')','>','>','>','>',' ','>','>'},
                {'=','<','<','<','<','<',' ','='}};
        for(i=0;i<8;i++){
            if(table[0][i] == a)
                break;
        }
        for(j=0;j<8;j++){
            if(table[j][0] == b)
                break;
        }
        return table[i][j];
    }
    static boolean In(char a){
        if(a >='0' && a <= '9')
            return false;
        else
        if(a == '.')
            return false;
        else
            return true;
    }
    public static double EvaluateExpress() throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        char c;
        Stack<Character> OPTR = new Stack<Character>();
        Stack<Double> OPND = new Stack<Double>();
        OPTR.push('=');
        c = (char)in.read();
        double flag=1;
        boolean isPoint = false;
        while(c != '=' || OPTR.peek() != '='){
            if(!In(c)){
                double temp = 0;
                if(c == '.')
                {
                    isPoint = true;
                    flag*=0.1;
                    c = (char)in.read();
                    continue;
                }
                if(!isPoint)
                {
                    if(flag == 10)
                    {
                        if(!OPND.empty())
                            temp = OPND.peek();
                        OPND.pop();
                    }
                    temp = temp*flag + (double)(c-'0');
                    OPND.push(temp);
                    c = (char)in.read();
                    flag = 10;
                }
                else
                {
                    flag *= 0.1;
                    if(!OPND.empty())
                        temp = OPND.peek();
                    OPND.pop();
                    temp = temp + (double)(c-'0') * flag;
                    OPND.push(temp);
                    c = (char)in.read();
                }
            }
            else{
                isPoint = false;
                flag = 1;
                switch(Precede(OPTR.peek(),c)){
                    case '<':
                        OPTR.push(c);
                        c = (char)in.read();break;
                    case '=':
                        OPTR.pop();
                        c = (char)in.read();break;
                    case '>':
                        char thate = OPTR.pop();
                        double b = OPND.pop();
                        double a = OPND.pop();
                        OPND.push(Opera.opera(a,thate,b));
                        break;
                }
            }
        }
        return OPND.peek();
    }
}
