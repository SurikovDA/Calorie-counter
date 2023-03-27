public class MonthData {

    private int[] stepsPerDay;

    public MonthData() {
        stepsPerDay = new int[30];
    }


    //Сохранение шагов по дням:
    public void addSteps(int steps, int day) {
        if(steps >=0 ) {
            stepsPerDay[day-1] += steps;
            System.out.println("Шаги сохранены.");
        } else {
            System.out.println("Количество шагов не может быть отрицательным");
        }
    }
    //Вывод количества шагов по дням в течение месяца:
    public void goStepsInDay() {

        for (int i = 0 ; i < stepsPerDay.length-1; i++) {
          System.out.print((i + 1) + " день: " + stepsPerDay[i] + ", ");
        }
        System.out.println("30 день: " + stepsPerDay[29]);
    }

    //Сумма шагов за месяц:
    public int sumStepMonth () {
        int sumStepMonth = 0;
        for(int i = 0; i < stepsPerDay.length; i++) {
            sumStepMonth = sumStepMonth + stepsPerDay[i];
        } return sumStepMonth;
    }

    //Максимальное количество шагов в месяце
    public int maxStep () {
        int maxExpense = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            if (stepsPerDay[i] > maxExpense) {
                maxExpense = stepsPerDay[i];
            }
        } return maxExpense;
    }

    //Среднее количество шагов за месяц
    public int averageStepMonth (){
        int average = sumStepMonth() / stepsPerDay.length;
        return average;
    }
    //Лучшая серия
    public void bestSeria(int ambitionSteps){

        int dayRow = 0;     //счетчик серии
        int bestSeries = 0; //лучшие серии

            for (int i = 0; i < stepsPerDay.length; i++) {
                if (stepsPerDay[i] >= ambitionSteps) {
                    dayRow++;   // плюс 1 к счетчику серии
                    if (dayRow > bestSeries) {
                        bestSeries = dayRow;
                    }
                }
                 else if (stepsPerDay[i] < ambitionSteps) {
                 dayRow = 0;    //обнуление счетчика серии
                 }

            }
            System.out.println("Лучшая серия - " + bestSeries + " дней.");
        }
    }



