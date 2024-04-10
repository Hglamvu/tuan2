package Server;

import java.util.HashMap;
import java.util.Map;

import middleware.Middleware;
//khai 1 lop server
public class Server {
    private static Map<String,String> users = new HashMap();
    private static Middleware middleware
    ;

    public void setMiddleware(Middleware middleware){ 
        this.middleware = middleware;}
    public static boolean logIn(String email, String password){
        if(middleware.check(email,password)){
            //neu kiem tra dung email, pwd thi in ra thanh cong
            System.out.println("Authorization have been successfully!");
            return true;
        }
        return false;
    }
    public static void register(String email, String password){
        users.put(email,password);
        //tao ra 1 phuong thuc dang ky
    }
    public boolean hasEmail(String email){
        return users.containsKey(email);
    }
    public boolean isValidPassword(String email, String password){
        return users.get(email).equals(password);
    }
    
}
