import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate,int depositPeriod) {
        double pay = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return round(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double round(double value,int places) {
        double Scale = Math.pow(10, places); // возведение в степень 10^2
        return Math.round(value * Scale) / Scale; //округляет до целого и делит на 100
    }

    void calculateDeposit() {
        int depositPeriod;
        int depositType;
        Scanner scanner = new Scanner(System.in);
        double depositResult = 0;

        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        if (depositType == 1) {
            depositResult = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            depositResult = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + depositResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
