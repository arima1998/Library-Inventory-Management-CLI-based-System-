package exceptions;

public class DuplicateItemException extends  RuntimeException{
    public DuplicateItemException(String msg){
        super(msg);
    }
}
