package Exceptions;

public class SexException extends Exception{

    private String sex;

    public SexException(String sex) {
        this.sex = sex;
    }

    @Override
    public String getMessage() {
        return String.format("Проверьте правильность ввода пола, он должен быть представлен буквой m для мужчин," + 
        "или f для женщин, а было введено %s", sex);
    }

    
}
