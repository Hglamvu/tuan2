package Server;

import java.util.HashMap;
import java.util.Map;

import middleware.Middleware;

public class Server {
    private static Map<String,String> users = new HashMap();
    private static Middleware middleware
    ;

    public void setMiddleware(Middleware middleware){ 
        this.middleware = middleware;}
    public static boolean logIn(String email, String password){
        if(middleware.check(email,password)){
            System.out.println("Authorization have been successfully!");
            return true;
        }
        return false;
    }
    public static void register(String email, String password){
        users.put(email,password);
    }
    public boolean hasEmail(String email){
        return users.containsKey(email);
    }
    public boolean isValidPassword(String email, String password){
        return users.get(email).equals(password);
    }
    
}
