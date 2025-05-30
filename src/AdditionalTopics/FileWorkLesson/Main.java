package AdditionalTopics.FileWorkLesson;

import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) {
        //String text = null;
        //int num = 0;
        //считыватель
        BufferedReader bufferedReader = null;
        //записыватель(😂?)
        BufferedWriter bufferedWriter = null;

        //кароче операции работы с вводом и выводом обязательно
        //всегда нужно кидать в try-catch
        //потому что ввод и вывод это не простой код
        //а то что вводит человек, по этому программа может сработать не корректно
        try{
            //BufferReader - класс для работы с файлами
            //InputStreamReader - работает именно с консольными данными/вводом
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //text = bufferedReader.readLine();

            //FileWriter - записывает информацию в файл (очевидно)
            bufferedWriter = new BufferedWriter(new FileWriter("note.txt"));


            //в этой строке нам нужно обозначить тип данных,
            //потому что если этого не будет, то буфер будет принимать введенное значение в качестве ASCII кода
            //и будет выполнять  операции с ним
            //num = Integer.parseInt(bufferedReader.readLine());
            String message;
            //вот прям в цикле мы присваиваем значение message
            //после перезапуска цикла файл перезаписывается
            while (!(message = bufferedReader.readLine()).equals("quit")){
                bufferedWriter.append(message + "\n");
            }
            //закрывать врайтер нужно дабы не было утечки памяти
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        getMessageFromFile();

//        System.out.println(num);
//        System.out.println(text);
    }
    //метод для считывания содержимого файла
    private static void getMessageFromFile(){

        BufferedReader read = null;

        try{
            String text;
            read = new BufferedReader(new FileReader("note.txt"));

            while ((text = read.readLine()) != null) {
                System.out.println(text);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
