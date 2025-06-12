package AdditionalTopics.GenericsLesson;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain {
    public static void main(String[] args) {
        //Generics - параметризация - обобщение
        //Женерики вышли с Java 5
//        List player = new ArrayList();
//        player.add("Messi");
//        player.add("Ronaldo");
//        player.add("Neymar");
//        player.add(new Player());
        //Без четкой параметризации, элементы этого массива будут объектами класса Object
        //а не класса String
        //в связи с этим возникает ошибка, конфликт типов данных(мы запрашиваем типа String, а массив - Object)
        //String player2 = player.get(1);

        //вот это правильный вариант потому что мы переводим тип данных в String
//        String player2 = (String)player.get(1);
//        String player3 = (String)player.get(3);
//        System.out.println(player3);

        //а вот подход который был с Java 8
        List<String> allPlayers = new ArrayList<>();
        allPlayers.add("Mbappe");
        allPlayers.add("Zlatan");
        allPlayers.add("Laminima");
        System.out.println(allPlayers);
        //теперь в эту колекцию я могу добавлять только значения String
    }
}

class Player {

}