package Exceptions;

public class FIOException extends Exception{

    String name;

    public FIOException(String name) {
        super();
        this.name = name;
    }

    @Override
    public String getMessage() {
        
        return String.format("Проверьте правильность ввода данных в слове \"%s\"", name);
    }

}
