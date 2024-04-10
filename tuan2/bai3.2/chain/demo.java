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
    //đọc dữ liệu từ người dùng qua cửa sổ console
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init(){
        server = new Server();
        //tao ra hai tai khoan cua admin va user
        Server.register("admin@example.com","admin_pass");
        Server.register("user@example.com","user_pass");
        // Khởi tạo middleware Throttling với giới hạn 2 yêu cầu mỗi phút
        Middleware middleware = new ThrottlingMiddleware(2);
        // Thiết lập chuỗi middleware bao gồm UserExistsMiddleware và RoleCheckMiddleware
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
