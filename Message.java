package Model;

/**
 * Created by zhangzheyu on 2017/7/17.
 */
public class Message {
    private String task_id;
    private String message_details;
    private String message_receiver;
    private String  message_sender;
    private String message_date;
    private String task_title;
    private String isread;

    public void setTask_id(String task_id){
        this.task_id =task_id;
    }
    public void setMessage_details(String message_details){
        this.message_details =message_details;
    }
    public void setMessage_receiver(String message_receiver){
        this.message_receiver = message_receiver;
    }
    public void setMessage_sender(String message_sender){
        this.message_sender =message_sender;
    }
    public void setMessage_date(String message_date){
        this.message_date = message_date;
    }
    public void setTask_title(String task_title){this.task_title = task_title;}
    public void setIsread(String isread){this.isread =isread;}
    public String getTask_id(){
        return task_id;
    }
    public String getMessage_details(){
        return message_details;
    }
    public String getMessage_receiver(){
        return  message_receiver;
    }
    public String getMessage_sender(){
        return message_sender;
    }
    public String getMessage_date(){
        return message_date;
    }
    public String getTask_title(){return task_title;}
    public String getIsread(){return isread;}
}
