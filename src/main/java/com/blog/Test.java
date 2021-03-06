package com.blog;


import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

    public List<Apple> filterRedApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if ("red".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterRedApples1(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getWeight() > 10) {
                result.add(apple);
            }
        }
        return result;
    }


    static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("green", 16));
        apples.add(new Apple("red", 10));
        apples.add(new Apple("red", 20));

        //List<Apple> apples1 = filterApples(apples, apple -> "red".equals(apple.getColor()));
        //List<Apple> apples2 = filterApples(apples, apple -> apple.getWeight() > 15);
        //List<Apple> apples3 = filterApples(apples, apple -> "red".equals(apple.getColor()) && apple.getWeight() > 15);


        //List<Apple> redApples = apples.stream().filter(apple -> "red".equals(apple.getColor())).collect(Collectors.toList());
        //List<String> appleNames = apples.stream().map(apple -> apple.getName()).collect(Collectors.toList());
        //List<String> appleNames = apples.stream().map(Apple::getName).collect(Collectors.toList());
        //List<Apple> orderedApples = apples.stream().sorted(Comparator.comparing(Apple::getWeight).reversed()).collect(Collectors.toList());
        Map<String, List<Apple>> groupedApples = apples.stream().collect(Collectors.groupingBy(Apple::getColor));
        //orderedApples.forEach(System.out::println);

        //Insurance insurance = new Insurance();
        ////insurance.setName("ABC");
        //Optional<Insurance> optional = Optional.of(insurance);
        //String carInsuranceName = getCarInsuranceName(optional);
        //System.out.println(carInsuranceName);
        //Person person = new Person();
        //Optional<Person> optional = Optional.of(person);
        //String carInsuranceName = getCarInsuranceName(optional);
        //System.out.println(carInsuranceName);

        //System.out.println(new Date());

        //List<Integer> list = Arrays.asList(5, 3, 1, 9);
        //list.forEach(integer -> integer += 5);
        //list.forEach(System.out::println);
        //apples.forEach(System.out::println);
        //groupedApples.forEach((k, v) -> System.out.println(k + "," + v));
        //apples.forEach(apple -> {
        //    apple.setColor("red");
        //    System.out.println(apple);
        //});

        //apples.sort(Comparator.comparing(apple -> apple.getWeight()));
        //apples.forEach(System.out::println);

        apples.replaceAll(apple -> {
            apple.setColor("red");
            return apple;
        });

        // 替换集合中的每个元素
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(5);
        //numbers.replaceAll(number -> number * 2);
        //System.out.println(numbers);// 输出 4,6,10
        //boolean b = numbers.removeIf(number -> number ==2);
        //System.out.println(b);
        //Integer remove = numbers.remove(9);
        //System.out.println(remove);
        //System.out.println(numbers);

        //List<String> list = new ArrayList<>();
        //boolean ddd = list.remove("ddd");
        //System.out.println(ddd);
        //Map<String, Integer> carInventory = new HashMap<>();
        //Integer count = 0;
        //if (carInventory.containsKey("Aston Martin")) {
        //   int count = carInventory.get("Aston Martin");
        //    System.out.println(count);
        //}
        //
        //
        //Integer count = carInventory.getOrDefault("Aston Martin", 0);

        List<String> cars = new ArrayList<>();
        cars.add("Aston Martin");
        cars.removeIf(car -> car.equals("Aston Martin"));
        //System.out.println(add);


    }

    //public String getData(String url) {
    //    return cache.computeIfAbsent(url, this::getData);
    //}
    //
    //public String getData(String url) {
    //    String data = cache.get(url);
    //    if (data == null) {
    //        data = getData(url);
    //        cache.put(url, data);
    //    }
    //    return data;
    //}

    public String getCarInsuranceName(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return null;
    }

    //public Car getCarInsuranceName(Optional<Person> person) {
    //    return person.map(Person::getCar).orElseGet(null);
    //}

//public static String getCarInsuranceName(Optional<Insurance> insurance) {
//    Optional<String> name = insurance.map(Insurance::getName);
//    return name.orElse("Unknown");
//}

    public static String getCarInsuranceName(Optional<Person> person) {
        //Optional<Car> car1 = person.map(Person::getCar);
        //Optional<Insurance> optional = car1.map(Car::getInsurance);
        //Optional<Car> car = person.flatMap(person1 -> Optional.of(person1.getCar()));
        //return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
        return person.map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
