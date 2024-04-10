package middleware;


public abstract class Middleware {

    private Middleware next;
    //  thiết lập middleware tiếp theo trong chuỗi và trả về middleware đó
    public Middleware setNextChain(Middleware next){
        this.next = next;
        return next;
    }
public abstract boolean check(String email, String password);
protected boolean checkNext(String email, String password){
    if(next == null){
        return true;
    }
    return next.check(email,password);
}
}
