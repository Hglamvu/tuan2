package middleware;

import Server.Server;

public class UserExistsMiddleware extends Middleware{
    //lớp này kế thừa từ middleware
    public Server server;
    public UserExistsMiddleware(Server server){
        this.server = server;
    }
    //kiểm tra xem một người dùng đã tồn tại hay không
    public boolean check(String email, String password){
        if (!server.hasEmail(email)){
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email,password)){
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
        // Chuyển tiếp kiểm tra đến middleware tiếp theo trong chuỗi và trả về kết quả

    }
}