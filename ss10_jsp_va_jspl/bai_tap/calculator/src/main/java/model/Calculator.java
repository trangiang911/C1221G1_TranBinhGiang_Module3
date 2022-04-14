package model;

public class Calculator {
    public static double calculator(double firstOp,double secondOp,char op){
        switch (op){
            case '+':
                return firstOp+secondOp;
            case '-':
                return firstOp-secondOp;
            case '*':
                return firstOp-secondOp;
            case '/':
                if (secondOp!=0){
                    return firstOp/secondOp;
                }
                else {
                    throw new RuntimeException("Mẩu ko thể bằng 0");
                }
            default:
                throw new RuntimeException("Chịu");
        }
    }
}
