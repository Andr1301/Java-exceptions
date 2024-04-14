package Exceptions;

public class BirthdayException extends Exception{

    private String date;


    public BirthdayException(String date) {
        super();
        this.date = date;
    }

    @Override
    public String getMessage() {

        return String.format("Проверьте правильность ввода даты рождения %s", date);
        
    }


}
