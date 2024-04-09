import java.util.ArrayList;
import java.util.List;

public class DataMgr {
    List<Catagory> catagories;
    List<Product> products;
    private static DataMgr instance = null;
    private DataMgr(){
        catagories = new ArrayList<>();
        products = new ArrayList<>();
        System.out.println("init");
    }
    public synchronized static DataMgr getInstance(){
        if(instance == null){
            instance = new DataMgr();
        }
        return instance;
    }
}
