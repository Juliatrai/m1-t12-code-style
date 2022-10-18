import java.util.Scanner;

public class DepositCalculator {
    //лучше добавить пустую строку
    //yearRate у нас не меняется, можно вынести его сюда как контанту
    
    double calculateComplexPercent(double depositAmount, double yearRate,int depositPeriod) { //после запятой пробел
        //лучше добавить пустую строку для читаемости
        double pay = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return round(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double round(double value,int places) {//пробел после запятой
        double Scale = Math.pow(10, places); // возведение в степень 10^2 // ися переменной с маленькой буквы
        return Math.round(value * Scale) / Scale; //округляет до целого и делит на 100
    }

    void calculateDeposit() {
        int depositPeriod;
        int depositType;
        Scanner scanner = new Scanner(System.in);
        double depositResult = 0;
        //может здесь переменным дать имена покороче? код будет чуть компактенее.
        //например amount, period, type..
        
        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        //лучше добавить пустую строку
        if (depositType == 1) {
            depositResult = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            depositResult = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        //можно пустую строку
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + depositResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
