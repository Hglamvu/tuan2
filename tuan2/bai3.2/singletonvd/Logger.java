public class Logger{
    private static Logger instance;

    private Logger(){
        //Khởi tạo logger 
    }
    public static Logger getInstance() {
        if (instance == null){
            instance = new Logger();
            //Chưa có instance nào, tạo mới
        }
        return instance;
    }
    public static void Log(String message){
        System.out.println(message);
        //Ghi logger vào message 
    }
} 