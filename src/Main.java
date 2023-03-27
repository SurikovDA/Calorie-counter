import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();                           // Метод печати меню
        int userInput = scanner.nextInt();     // ввод команды пользователем

        //Объявление новых объектов
        StepTracker tracker = new StepTracker ();
        int ambitionSteps = 10000;

        // Цикл программы
        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                System.out.println("За какой месяц вы хотите ввести количество шагов? 0-январь, 11- декабрь");
                int month = scanner.nextInt();
                System.out.println("За какой день вы хотите ввести количество шагов?");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt();

                //Метод ввода шагов:
                tracker.addStepsForDay(day, steps, month);


            } else if (userInput ==2 ) {
                System.out.println("За какой месяц вы хотите узнать статистику?");
                System.out.println("Введите месяц от 0 до 11");
                int month = scanner.nextInt();

                //Методы для вывода статистики
                tracker.printAllStepsMonth(month);
                tracker.sumInMonth(month);
                tracker.maxStepMonth(month);
                tracker.averageStepMonth(month);
                tracker.distanceStepKm(month);
                tracker.caloriesBurned(month);
                tracker.bestSeries(ambitionSteps,month);


            }  else if (userInput ==3 ) {
                System.out.println("Ваше целевое количество шагов в день: " + ambitionSteps);
                System.out.println("Какое количество шагов вы хотите задать?");
                ambitionSteps = tracker.newAmbitionSteps();
                System.out.println("Целевое значение шагов в день сохранено.");
                System.out.println("Ваша новая цель: " + ambitionSteps);
        }  else {
                System.out.println("Извините, такой команды пока не существует!");
                System.out.println("Пожалуйста выберите другую команду");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя

        }
        System.out.println("Программа завершена");
    }


    // Метод вывода меню
    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения.");
    }
}
