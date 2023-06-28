import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // задача 1
        System.out.print("Задача 1\nВведите год нашей эры: ");
        int year = scanner.nextInt();
        checkYear(year);

        // задача 2
        System.out.println("Задача 2");
        String operationSystemName = "Android";     // iOS или Android
        int deviceYear = 2023;                      // год выпуска устройства
        int clientOS = getClientOS(operationSystemName);
        checkClientOS(clientOS, deviceYear);

        // задача 3
        System.out.print("\nЗадача 3\nВведите расстояние: ");
        int deliveryDistance = scanner.nextInt();
        checkDistance(deliveryDistance);


    }

    // метод, определяющий, является ли год високосным
    public static void checkYear(int year){

        // проверка на эру - года до н.э. не учитываем в задаче
        if (year <= 0){
            System.out.println("Ошибка! Введенное значение года не соответствует требованию!\n");
            return;
        }

        // проверка на високосность (а вообще есть такое слово? =D)
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)){
            System.out.println(year + " год не является високосным\n");
        } else {
            System.out.println(year + " год является високосным\n");
        }
    }

    // метод, возвращающий значение в зависимости от ОС
    public static int getClientOS(String operationSystemName){

        if (operationSystemName.equals("iOS")){
            return 0;
        } else if (operationSystemName.equals("Android")){
            return 1;
        } else{
            return 2;
        }
    }

    // метод, определяющий, какую версию приложения необходимо скачать
    public static void checkClientOS(int clientOS, int deviceYear) {

        int currentYear = LocalDate.now().getYear(); // определение текущего года
        if (deviceYear < currentYear) {
            switch (clientOS) {
                case 1:
                    System.out.println("Установите облегченную версию приложения для Android по ссылке");
                    return;
                case 0:
                    System.out.println("Установите облегченную версию приложения для iOS по ссылке");
                case 2:
                    System.out.println("Ошибка! ОС не распознана!");
            }
        } else {
            switch (clientOS) {
                case 1:
                    System.out.println("Установите версию приложения для Android по ссылке");
                    return;
                case 0:
                    System.out.println("Установите версию приложения для iOS по ссылке");
                case 2:
                    System.out.println("Ошибка! ОС не распознана!");
            }
        }
    }

    // метод, определяющий срок доставки в зависимости от расстояния
    public static void checkDistance(int deliveryDistance){

        int daysToDelivery; // переменная для записи дней для доставки

        if(deliveryDistance > 0 && deliveryDistance <= 20){
            daysToDelivery = 1;
        } else if(deliveryDistance > 20 && deliveryDistance <= 60){
            daysToDelivery = 2;
        } else if(deliveryDistance > 60 && deliveryDistance <= 100){
            daysToDelivery = 3;
        } else if(deliveryDistance > 100){
            daysToDelivery = 0;
        } else{
            // если ввели отрицательное значение расстояния
            System.out.println("Ошибка! Введите корректное расстояние!");
            return;
        }

        switch (daysToDelivery){
            case 1:
            case 2:
            case 3:
                System.out.println("Потребуется дней: " + daysToDelivery);
                return;
            case 0:
                System.out.println("Доставки нет");
        }
    }
}