// Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:

// Фамилия Имя Отчество дата _ рождения номер _ телефона пол

// Форматы данных:

// фамилия, имя, отчество - строки
// дата _ рождения - строка формата dd.mm.yyyy
// номер _ телефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.

// Приложение должно проверить введенные данные по количеству. 
// Если количество не совпадает, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

// Приложение должно распарсить полученную строку и выделить из них требуемые значения. 
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
// Можно использовать встроенные типы java и создать свои. 
// Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
// <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>

// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.
// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

//Pupkin Anton Vasyanovich 13.01.1993 88888888888 m

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Exceptions.*;

public class app {
    public static void main(String[] args) {
        
        System.out.println("Введите данные в формате Фамилия Имя Отчество дата_рождения номер_телефона пол");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] data = s.split(" ");//Парсим строку в массив строк
        boolean correctData = true; //Контрольная переменная, запись данных в файл запускается только если true

        //Проверка количества введенных данных, с выводом сообщения пользователю в случае неверного количества
        while (data.length != 6){
            System.out.println("Введено неверное количество данных, повторите ввод");
            s = scanner.nextLine();
            data = s.split(" ");
        }

        scanner.close();

        Checker ch = new Checker(data);

        try {
            ch.surnameCheck();
        } catch (FIOException e) {
            correctData = false;
            e.printStackTrace();
        }

        try {
            ch.nameCheck();
        } catch (FIOException e) {
            correctData = false;
            e.printStackTrace();
        }

        try {
            ch.fatherNameCheck();
        } catch (FIOException e) {
            correctData = false;
            e.printStackTrace();
        }

        try {
            ch.phoneCheck();
        } catch (PhoneException e) {
            correctData = false;
            e.printStackTrace();
        }

        try {
            ch.birthDateCheck();
        } catch (BirthdayException e) {
            correctData = false;
            e.printStackTrace();
        }

        try {
            ch.sexCheck();
        } catch (SexException e) {
            correctData = false;
            e.printStackTrace();
        }

        if (correctData == true){
            String path = String.format("DataFiles/%s.txt", data[0]);
            //String path = String.format("qwejkvbjfklbjnj/%s.txt", data[0]); //Строка с заведомо неверным путем для проверки
            File file = new File(path);

            try {
                if(!file.exists()){
                    file.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter fw = new FileWriter(file, true)) { //Используем конструкцию try-with-resourses для автоматического закрытия файла
                fw.append(s);
                fw.append('\n');
                System.out.println("Данные успешно внесены в файл!");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    }

    
}