package Model;


import java.util.LinkedList;

public class CurrentUser {

    private  Account userInfo;
    private  Task Currenttask;
    private  LinkedList<Task> task_list;
    private  LinkedList<Task> my_pub_uncomplete_task_list;
    private  LinkedList<Task> my_pub_complete_task_list;
    private  LinkedList<Task> my_rec_uncomplete_task_list;
    private  LinkedList<Message> my_system_message_list;
    private  LinkedList<Message> my_friend_message_list;
    private  LinkedList<Task> my_rec_complete_task_list;
    private LinkedList<String> my_friend_list;
    private LinkedList<FriendRequest> my_friend_require_list;


    public Account getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Account userInfo) {
        this.userInfo = userInfo;
    }

    public Task getCurrenttask() {
        return Currenttask;
    }

    public void setCurrenttask(Task currenttask) {
        Currenttask = currenttask;
    }

    public LinkedList<Task> getTask_list() {
        return task_list;
    }

    public void setTask_list(LinkedList<Task> task_list) {
        this.task_list = task_list;
    }

    public LinkedList<Task> getMy_pub_uncomplete_task_list() {
        return my_pub_uncomplete_task_list;
    }

    public void setMy_pub_uncomplete_task_list(LinkedList<Task> my_pub_uncomplete_task_list) {
        this.my_pub_uncomplete_task_list = my_pub_uncomplete_task_list;
    }

    public LinkedList<Task> getMy_pub_complete_task_list() {
        return my_pub_complete_task_list;
    }

    public void setMy_pub_complete_task_list(LinkedList<Task> my_pub_complete_task_list) {
        this.my_pub_complete_task_list = my_pub_complete_task_list;
    }

    public LinkedList<Task> getMy_rec_uncomplete_task_list() {
        return my_rec_uncomplete_task_list;
    }

    public void setMy_rec_uncomplete_task_list(LinkedList<Task> my_rec_uncomplete_task_list) {
        this.my_rec_uncomplete_task_list = my_rec_uncomplete_task_list;
    }

    public LinkedList<Task> getMy_rec_complete_task_list() {
        return my_rec_complete_task_list;
    }

    public void setMy_rec_complete_task_list(LinkedList<Task> my_rec_complete_task_list) {
        this.my_rec_complete_task_list = my_rec_complete_task_list;
    }


    public void setMy_system_message_list(LinkedList<Message> my_system_message_list){
        this.my_system_message_list = my_system_message_list;
    }
    public LinkedList<Message> getMy_system_message_list(){
        return my_system_message_list;
    }
    public void setMy_friend_message_list(LinkedList<Message> my_friend_message_list){
        this.my_friend_message_list = my_friend_message_list;
    }
    public LinkedList<Message> getMy_friend_message_list(){
        return  my_friend_message_list;
    }

    public void setMy_friend_list(LinkedList<String> my_friend_list){
        this.my_friend_list = my_friend_list;
    }

    public LinkedList<String> getMy_friend_list(){
        return my_friend_list;
    }
    public void setMy_friend_require_list(LinkedList<FriendRequest> my_friend_require_list){
        this.my_friend_require_list = my_friend_require_list;
    }
    public LinkedList<FriendRequest> getMy_friend_require_list(){
        return my_friend_require_list;
    }

    public LinkedList<Task> getMy_task_list(String taskqueue){
        if(taskqueue.equals("pub_complete")){
            return my_pub_complete_task_list;
        }
        else if (taskqueue.equals("pub_uncomplete")){
            return my_pub_uncomplete_task_list;
        }
        else if (taskqueue.equals("rec_complete")){
            return my_rec_complete_task_list;
        }
        else if (taskqueue.equals("rec_uncomplete")){
            return my_rec_uncomplete_task_list;
        }
        else return null;
    }



}
