package middleware;

public class ThrottlingMiddleware extends Middleware{
    // lớp throttlingmiddleware kế thừa từ middleware
    private int requestPerMinute;
    private int request;
    private long currentTime;
    public ThrottlingMiddleware(int requestPerMinute){
        this.requestPerMinute = requestPerMinute;
        // this.currentTime = currentTime;
    }
    
    public boolean check(String email, String password){
        // Kiểm tra nếu thời gian hiện tại đã vượt quá thời gian của lần cuối cùng đã reset
        if(System.currentTimeMillis()> currentTime + 60_000){
            //nếu vượt quá thời gian 
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        //tăng số lượng yêu cầu lên 1
        request++;
        if (request > requestPerMinute){
            //kiểm tra nếu số lượng yêu cầu vượt quá ngưỡng
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(email, password);
        // Chuyển tiếp kiểm tra đến middleware tiếp theo trong chuỗi và trả về kết quả
    }
}
//nhiệm vụ chính của lớp này là giới hạn số lượng yêu cầu trong một phút, nếu yêu cầu vượt quá ngưỡng thì sẽ chặn không cho làm bước tiếp theo 
