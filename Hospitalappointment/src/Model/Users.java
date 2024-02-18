package Model;

public class Users {
    private int uId;
    private String mail;
    private String passWord;
    private String type;
    public void setUserId(int id){
        uId = id;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    public void setType(String type){
        this.type = type;
    }
    public int getUerId(){
        return uId;
    }
    public String getMail(){
        return mail;
    }
    public String getPassWord(){
        return passWord;
    }
    public String getUserType(){
        return type;
    }
}
