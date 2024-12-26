package exceptions;

public class ItemDoesntExistException extends  RuntimeException{
    public  ItemDoesntExistException(String msg){
        super(msg);
    }
}
