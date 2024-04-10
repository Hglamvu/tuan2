import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

import Server.Server;
import middleware.Middleware;
import middleware.RoleCheckMiddleware;
import middleware.ThrottlingMiddleware;
import middleware.UserExistsMiddleware;

public class demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init(){
        server = new Server();
        Server.register("admin@example.com","admin_pass");
        Server.register("user@example.com","user_pass");

        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.setNextChain(new UserExistsMiddleware(server)).setNextChain(new RoleCheckMiddleware());
        server.setMiddleware(middleware);

    }
    public static void main(String [] args) throws IOException{
        init();

        boolean success;
        do{
            System.out.println("Enter email: ");
            String email = reader.readLine();
            System.out.println("Enter password");
            String password = reader.readLine();
            success = Server.logIn(email,password);
        } while(!success);
    }
}
