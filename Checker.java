import Exceptions.*;

public class Checker {

    private String[] data = new String[6];

    /**Создаем объект, проверяющий данные, в него передаем массив данных из распарсеной строки
     * @param data Массив строк из данных, введенных пользователем
     */
    public Checker(String[] data) {
        this.data = data;
    }

    /**Проверяем, чтобы фамилия не содержала лишних символов
     * @throws FIOException Если обнаруживается не-буквенный символ
     */
    void surnameCheck() throws FIOException{
        String surname = data[0];
        for (Character ch : surname.toCharArray()){
            if(!Character.isLetter(ch)){
                throw new FIOException(surname);
            }
        }
    }
    /**Проверяем, чтобы имя не содержало лишних символов
     * @throws FIOException Если обнаруживается не-буквенный символ
     */
    void nameCheck() throws FIOException{
        String name = data[1];
        for (Character ch : name.toCharArray()){
            if(!Character.isLetter(ch)){
                throw new FIOException(name);
            }
        }
    }
    /**Проверяем, чтобы отчество не содержало лишних символов
     * @throws FIOException Если обнаруживается не-буквенный символ
     */
    void fatherNameCheck() throws FIOException{
        String fathername = data[2];
        for (Character ch : fathername.toCharArray()){
            if(!Character.isLetter(ch)){
                throw new FIOException(fathername);
            }
        }
    }

    /**Проверяем, чтобы номер телефона состоял из цифр
     * @throws PhoneException Если обнаруживаем не-цифру
     */
    void phoneCheck() throws PhoneException{
        String phone = data[4];
        for (Character ch : phone.toCharArray()){
            if(!Character.isDigit(ch)){
                throw new PhoneException(phone, ch);
            }
        }
    }
    
    /**Проверяем корректность даты рождения
     * @throws BirthdayException Если дата введена неверно или не соответствует шаблону
     */
    void birthDateCheck() throws BirthdayException{
        String birthday = data[3];
        if (birthday.charAt(2) == '.' && birthday.charAt(5) == '.'){ //Проверяем, чтобы ввод соответсвовал шаблону
            String[] dateBirthday = birthday.split("\\.");

            int day = Integer.parseInt(dateBirthday[0]);
            int month = Integer.parseInt(dateBirthday[1]);
            int year = Integer.parseInt(dateBirthday[2]);

            if (day < 1 || day > 31){
                throw new BirthdayException(birthday);
            }

            if (month < 1 || month > 12){
                throw new BirthdayException(birthday);
            }

            if (year < 1900 || year > 2024){
                throw new BirthdayException(birthday);
            }


        }
        else{
            throw new BirthdayException(birthday);
        }

    }

    /**
     * @throws SexException Проверяем правильность ввода пола
     */
    void sexCheck() throws SexException{
        String sex = data[5];
        if (sex.equals("m") || sex.equals("f")){
            System.out.println("Начинаем печать в файл");
        }
        else{
            throw new SexException(sex);
        } 
    }
}
