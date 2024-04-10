public class BusinessAnalyst implements Customer {
    private Developer dev;

    public BusinessAnalyst(Developer dev) {
        this.dev = dev;
    }


    @Override
    public void sendRequest(String request){
    //duoc goi khi client gui request
        System.out.println("Reading request...");
        System.out.println(request);
        String info = this.translate(request);
        System.out.println("Sending info....");
        dev.receive(info);
    }
     private String translate(String request){
        //ba dich request cho dev
         return "Create Zoom";
     }
}
