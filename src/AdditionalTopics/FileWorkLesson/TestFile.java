package AdditionalTopics.FileWorkLesson;


import java.io.*;
import java.util.List;
import java.util.ArrayList;


public class TestFile {
    public static void main(String[] args) throws IOException {


        BufferedReader buffreader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<UserFile> userFiles = new ArrayList<>();


        while(true){
            System.out.println("[1] ADD USER");
            System.out.println("[2] LIST USER");
            System.out.println("[3] DELETE USER");
            System.out.println("[4] quit");
            int ch = Integer.parseInt(buffreader.readLine());

            if(ch == 1){
                System.out.println("Insert Id ");
                int id = Integer.parseInt(buffreader.readLine());
                System.out.println("Insert Login ");
                String login = buffreader.readLine();
                System.out.println("Insert Password ");
                String password = buffreader.readLine();

                userFiles.add(new UserFile(id, login, password));
                //тут мы сохраняем файл после внесения изменений
                saveUserFileList(userFiles);

            }else if(ch == 2){
                List<UserFile> userFileList = getUserFileList();
                for (UserFile userFile : userFileList) {
                    System.out.println(userFile);
                }
            }else if(ch == 3) {
                System.out.println("Type Id of user you want to delete");
                int userId = Integer.parseInt(buffreader.readLine());
                List<UserFile> userFileList = getUserFileList();
                UserFile userDel = null;
                for (UserFile userFile : userFileList) {
                    if (userFile.getId() == userId) {
                        userDel = userFile;
                    }
                }
                if (userDel != null) {
                    userFileList.remove(userDel);
                    //сохранение изменений в файле
                    saveUserFileList(userFileList);
                    System.out.println("User deleted.");
                } else {
                    System.out.println("User not found.");
                }
            }
            else
                break;
        }

    }
    private static List<UserFile> getUserFileList(){
        //создаем массив с юзерами
        List<UserFile> userFileList = null;
        //создаем переменную с ридером
        BufferedReader br = null;
        try{
            //указываем какой файл нужно считывать
            br = new BufferedReader(new FileReader("memory.txt"));
            String text;

            //указываем элементами какого массива будут юзеры
            userFileList = new ArrayList<>();

            //"пока строка не пустая" - простыми словами
            while((text = br.readLine()) != null){
                //мы делим данные юзера на разные слова чтобы использовать эти данные при вводе их в конструктор класса Юзеров
                //таким образом создавая объект этого класса
                String[] textUsers = text.split(" ");
                userFileList.add(new UserFile(Integer.parseInt(textUsers[0]), textUsers[1], textUsers[2]));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return userFileList;
    }

    private static void saveUserFileList(List<UserFile> userFileList){
        //создаем переменную записывателя
        BufferedWriter bw = null;

        try{
            //передаем файл в который нужно записывать с помощью FileWriter
            bw = new BufferedWriter(new FileWriter("memory.txt"));
            //добавляем в массив даные по юзеру через цикл
            for (UserFile userFile : userFileList) {
                bw.append(userFile + "\n");
            }
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
