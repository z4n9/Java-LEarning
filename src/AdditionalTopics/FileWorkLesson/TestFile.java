package AdditionalTopics.FileWorkLesson;

import Patterns.Prototype.User;

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
            System.out.println("[3] quit");
            int ch = Integer.parseInt(buffreader.readLine());

            if(ch == 1){
                System.out.println("Insert Id ");
                int id = Integer.parseInt(buffreader.readLine());
                System.out.println("Insert Login ");
                String login = buffreader.readLine();
                System.out.println("Insert Password ");
                String password = buffreader.readLine();

                userFiles.add(new UserFile(id, login, password));

                saveUserFileList(userFiles);
            }else if(ch == 2){
                List<UserFile> userFileList = getUserFileList();
                for (UserFile userFile : userFileList) {
                    System.out.println(userFile);
                }
            }else
                break;
        }

    }
    private static List<UserFile> getUserFileList(){
        List<UserFile> userFileList = null;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("memory.txt"));
            String text;
            userFileList = new ArrayList<>();

            while((text = br.readLine()) != null){
                String[] textUsers = text.split(" ");
                userFileList.add(new UserFile(Integer.parseInt(textUsers[0]), textUsers[1], textUsers[2]));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return userFileList;
    }

    private static void saveUserFileList(List<UserFile> userFileList){
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter("memory.txt"));

            for (UserFile userFile : userFileList) {
                bw.append(userFile + "\n");
            }
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
