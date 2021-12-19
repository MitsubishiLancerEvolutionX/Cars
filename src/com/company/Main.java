package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Car> arrayList = new ArrayList<>();

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int a = 0;
        String str = "";
        Car car1 = new Car("Lada Priora", 2014, 107, 385000, Color.GREY);
        Car car2 = new Car("Mitsubishi Lancer X", 2013, 117, 630000, Color.BLACK);
        Car car3 = new Car("Chevrolet Lanos", 2008, 86, 320000, Color.BLUE);
        arrayList.add(car1);
        arrayList.add(car2);
        arrayList.add(car3);


        while (!"0".equals(str)) {
            System.out.println("1. Введите 1, для просмотра списка всех машин.");
            System.out.println("2. Введите 2, для добавления новой машины.");
            System.out.println("3. Введите 3, для поиска самой старой машины.");
            System.out.println("4. Введите 4, для фильтрации по мощности и цене.");
            System.out.println("5. Введите 5, для фильтрации машин по цвету.");
            System.out.println("6. Введите 0, для выхода.");
            str = sc.next();

            try {
                a = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод!");
                System.out.println();
            }

            if (!(a == 1 || a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 0)) {
                System.out.println("Некорректный ввод!");
                System.out.println();
            }

            switch (a) {
                case 1:
                    print();
                    break;
                case 2:
                    addition();
                    break;
                case 3:
                    searchOldCar();
                    break;
                case 4:
                    searchByPowerAndPrice();
                    break;
                case 5:
                    searchByColor();
                    break;
            }
        }
    }

    public static void print() {
        System.out.println("Список всех машин: ");
        for (Car car : arrayList) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void addition() {
        System.out.println("Введите название машины: ");
        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();
        System.out.println("Введите год выпуска: ");
        Scanner sc2 = new Scanner(System.in);
        int productionYear = sc2.nextInt();
        System.out.println("Введите мощность двигателя: ");
        Scanner sc3 = new Scanner(System.in);
        int powerEngine = sc3.nextInt();
        System.out.println("Введите цену машины: ");
        Scanner sc4 = new Scanner(System.in);
        int price = sc4.nextInt();
        System.out.println("Введите цвет машины: ");
        Scanner sc5 = new Scanner(System.in);
        String color = sc5.nextLine();
        switch (color) {
            case "серый":
                arrayList.add(new Car(name, productionYear, powerEngine, price, Color.GREY));
                break;
            case "белый":
                arrayList.add(new Car(name, productionYear, powerEngine, price, Color.WHITE));
                break;
            case "красный":
                arrayList.add(new Car(name, productionYear, powerEngine, price, Color.RED));
                break;
            case "синий":
                arrayList.add(new Car(name, productionYear, powerEngine, price, Color.BLUE));
                break;
            case "черный":
                arrayList.add(new Car(name, productionYear, powerEngine, price, Color.BLACK));
                break;
            default:
                arrayList.add(new Car(name, productionYear, powerEngine, price, Color.WHITE));
                System.out.println("Такого цвета нет среди возможных. Цвет машины выбран по умолчанию.");
                break;
        }
        System.out.println("Машина добавлена!");
        System.out.println();
    }

    public static void searchOldCar() {
        int minYear = 10000;
        for (Car car : arrayList) {
            if (car.getProductionYear() < minYear) {
                minYear = car.getProductionYear();
            }
        }

        System.out.println("Самая старая машина(ы): ");
        for (Car car : arrayList) {
            if (car.getProductionYear() == minYear) {
                System.out.println(car);
            }
        }
        System.out.println();
    }

    public static void searchByPowerAndPrice() {
        System.out.println("Введите максимальную цену: ");
        Scanner sc1 = new Scanner(System.in);
        int price = sc1.nextInt();
        System.out.println("Введите минимальную мощность: ");
        Scanner sc2 = new Scanner(System.in);
        int power = sc2.nextInt();
        ArrayList<Car> arrayList1 = new ArrayList<>();
        for (Car car : arrayList) {
            if (price > car.getPrice()) {
                arrayList1.add(car);
            }
        }

        arrayList1.removeIf(car -> power > car.getPowerEngine()); // Сначала сделал через цикл, но вы летала ошибка ConcurrentModificationException, идея сама помогла исправить.

        System.out.println("Список подходящих по требованиям машин: ");
        for (Car car : arrayList1) {
            System.out.println(car);
        }
        System.out.println();
        arrayList1.clear();
    }

    public static void searchByColor() {
        System.out.println("Введите нужный цвет: ");
        Scanner sc1 = new Scanner(System.in);
        String color = sc1.nextLine();
        ArrayList<Car> arrayList2 = new ArrayList<>();
        for (Car car : arrayList) {
            if (color.equals(car.getColor().getTranslate())) {
                arrayList2.add(car);
            }
        }

        if (arrayList2.isEmpty()) {
            System.out.println("Машин с таким цветом нет!");
        } else {
            System.out.println("Машины с данным цветом в наличии: ");
            for (Car car : arrayList2) {
                System.out.println(car);
            }
        }
        System.out.println();
    }
}
