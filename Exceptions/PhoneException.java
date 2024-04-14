package Exceptions;

public class PhoneException extends Exception{

    private Character ch;
    private String phone;

    public PhoneException(String phone, Character ch) {
        super();
        this.ch = ch;
        this.phone = phone;
    }

    @Override
    public String getMessage() {
        
        return String.format("Проверьте правильность ввода телефонного номера %s,  \"%c\" не является цифрой", phone, ch);
    }
}
