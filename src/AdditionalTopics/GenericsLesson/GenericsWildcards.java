package AdditionalTopics.GenericsLesson;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcards {
    public static void main(String[] args) {
        List<Sportsmen> sportsmenList = new ArrayList<>();
        sportsmenList.add(new Sportsmen("Arthur"));
        List<Player2> player2List = new ArrayList<>();
        player2List.add(new Player2("Masha"));
        testSportsmen(sportsmenList);
        //тут нам выдает ошибку, потому что метод testSportsmen ожидает принять на вход
        //тип данных Sportsmen(смотри ниже1⬇)
        testSportsmen(player2List);
        //теперь ошибку не выдает тут, потому что массив готов принять объект класса Player2
        //но теперь появляется ошибка ниже3⬇
    }
    //                       по этой причине, тут мы указываем не какой то определенный тип данных
    //                       а ставим знак вопроса "?"
    //                      это будет означать что теперь тип данных в этом массиве,
    //                          это объекты класса Object(родитель всех классов)2⬆
    //                             теперь мы экстендим класс спортсмен чтобы класс Object знал
    //                             какие операции мы проводим с объектами массива5
    public static void testSportsmen(List</*Sportsmen*/ ? extends Sportsmen> sportsmen){
        //тут появляется ошибка потому что в переборе мы используем не объекты класс Object
        //а объекты класса Sportsmen4⬆
        for(Sportsmen sportsmen1 : sportsmen){
            System.out.println(sportsmen1);
        }
    }
}

class Sportsmen{
    private String name;

    public Sportsmen(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sportsmen{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Player2 extends Sportsmen{
    public Player2(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Player2{}";
    }
}
