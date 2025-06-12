package Patterns.State;

// Интерфейс состояния
interface PhoneState {
    void pressPowerButton();
    void receiveCall();
}

// Конкретные состояния
class SilentState implements PhoneState {
    @Override
    public void pressPowerButton() {
        System.out.println("Телефон выключается из беззвучного режима...");
    }

    @Override
    public void receiveCall() {
        System.out.println("Входящий звонок: телефон не издаёт звуков.");
    }
}

class LoudState implements PhoneState {
    @Override
    public void pressPowerButton() {
        System.out.println("Телефон выключается из громкого режима...");
    }

    @Override
    public void receiveCall() {
        System.out.println("Входящий звонок: играет мелодия.");
    }
}

class VibrateState implements PhoneState {
    @Override
    public void pressPowerButton() {
        System.out.println("Телефон выключается из режима вибрации...");
    }

    @Override
    public void receiveCall() {
        System.out.println("Входящий звонок: телефон вибрирует.");
    }
}

// Контекст — Мобильный телефон
class MobilePhone {
    private PhoneState currentState;

    public void setState(PhoneState state) {
        this.currentState = state;
        System.out.println("Состояние изменено: " + state.getClass().getSimpleName());
    }

    public void pressPowerButton() {
        currentState.pressPowerButton();
    }
    public void receiveCall() {
        currentState.receiveCall();
    }
}
 
// Тест
public class Main {
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();

        phone.setState(new LoudState());
        phone.receiveCall();
        phone.pressPowerButton();

        phone.setState(new SilentState());
        phone.receiveCall();

        phone.setState(new VibrateState());
        phone.receiveCall();
        phone.pressPowerButton();
    }
}
