package Patterns.ChainOfRespons;

abstract class Handler {
    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(String request);
}

class AuthHandler extends Handler {
    public void handle(String request) {
        if (request.equals("auth")) {
            System.out.println("Обработано: аутентификация");
        } else if (next != null) {
            next.handle(request);
        }
    }
}

class LogHandler extends Handler {
    public void handle(String request) {
        if (request.equals("log")) {
            System.out.println("Обработано: логирование");
        } else if (next != null) {
            next.handle(request);
        }
    }
}

class ErrorHandler extends Handler {
    public void handle(String request) {
        if (request.equals("error")) {
            System.out.println("Обработано: ошибка");
        } else if (next != null) {
            next.handle(request);
        } else {
            System.out.println("Ни один обработчик не справился с запросом: " + request);
        }
    }
}

// Пример использования
public class ChainOfRespons {
    public static void main(String[] args) {
        Handler chain = new AuthHandler();
        chain.setNext(new LogHandler()).setNext(new ErrorHandler());

        chain.handle("auth");   
        chain.handle("log");
        chain.handle("error");
        chain.handle("other");
    }
}
