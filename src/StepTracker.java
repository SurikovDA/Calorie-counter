import java.util.Scanner;

public class StepTracker {
    private MonthData[] monthData;
    Converter converter = new Converter();

    public StepTracker() {
        monthData = new MonthData[12];
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();

        }
    }

    // Ввод количества шагов:
    public void addStepsForDay(int day, int steps, int month) {
        if (day > 0 && day < 31 && month >= 0 && month < 12) {
            monthData[month].addSteps(steps, day);
        } else {
            System.out.println("Ошибка! Такого количества дней и месяцев нет в программе, задайте другие значения!");
        }
    }

    // Сумма шагов за месяц:
    public void sumInMonth(int month) {
        System.out.println("Сумма шагов за месяц " + month + " составила: " + monthData[month].sumStepMonth());
    }


    // Печать количества шагов по дням за месяц
    public void printAllStepsMonth(int month) {
        if (month >= 0 && month < 31) {
            monthData[month].goStepsInDay();
        } else {
            System.out.println("Такого месяца не существует! Введите другой");
        }
    }

    // Максимальное количество шагов в день за месяц
    public void maxStepMonth(int month) {
        System.out.println("Максимальное пройденное количество шагов в месяце " + month + " составило: " + monthData[month].maxStep());
    }

    // Среднее количетво шагов за месяц
    public void averageStepMonth(int month) {
        System.out.println("Среднее пройденное количество шагов за месяц " + month + " составило: " + monthData[month].averageStepMonth() + " шагов.");
    }

    //Перевод суммы шагов за месяц в километры
    public void distanceStepKm(int month) {
        int sumStep = monthData[month].sumStepMonth();
        System.out.println("Дистанция пройденная за месяц " + month + " = " + converter.distanceKm(sumStep) + " километров.");
    }

    // Рассчет килокалорий
    public void caloriesBurned(int month) {
        int sumStep = monthData[month].sumStepMonth();
        System.out.println("Количество сожженых килокалорий за месяц " + month + " = " + converter.cCal(sumStep) + " килокалорий.");
    }

    //Лучшая серия
    public void bestSeries(int ambitionSteps, int month) {
    monthData[month].bestSeria(ambitionSteps);
    }

    //Заявление новых целей

    /* Не стал переносить считывание данных из этого класса в класс Main, тк начинает ехать код из за нарушения
     цикла while. И по итогу весь метод переезжает в Main. Еще подумаю, как можно реализовать по другому... */
    public int newAmbitionSteps() {
        Scanner scanner = new Scanner(System.in);
        int newAmbition = scanner.nextInt();
        while (newAmbition < 0) {
            System.out.println("Значение шагов не может быть меньше нуля. Введите другое значение!");
            newAmbition = scanner.nextInt();
        } return newAmbition;
    }
}




