package com.gzt.lambda;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
public class StreamAPITest {

    /**
     * 筛选与切片
     * 1. filter(Predicate p)  接收Lambda ，从流中排除某些元素
     * 2. distinct()    筛选，通过流所生成元素的hashCode() 和equals() 去除重复元素
     * 3. limit(long maxSize)
     * 4. skip(long n)  跳过元素，返回一个扔掉了前n 个元素的流。若流中元素不足n 个，则返回个空流。与limit(n) 互补
     */
    @Test
    public void testStreamAPI1() {
        Employee emp = new Employee("zs", 18);
        Employee emp1 = new Employee("zs1", 22);
        Employee emp2 = new Employee("ls", 18);
        Employee emp3 = new Employee("ls1", 17);
        Employee emp4 = new Employee("ww", 20);
        List<Employee> employees = new ArrayList<>();
        employees.add(emp);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        // 找出年龄为18的员工信息
        Stream<Employee> employeeStream = employees.stream().filter(e -> e.age == 18);
        employeeStream.forEach(e -> System.out.println(e.toString()));
        System.out.println("*****************************");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(1);
        Stream<Integer> distinct = list.stream().distinct();
        distinct.forEach(System.out::println);
        System.out.println("******************************");
        list.stream().limit(2).forEach(System.out::println);
        System.out.println("******************************");
        list.stream().skip(4).forEach(System.out::println);
    }

    class Employee {
        String name;
        int age;
        Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String toString(){
            return this.name + " " + this.age;
        }
        public String getName() {return this.name;}
        public void setName(String name) {this.name = name;}
        public int getAge() {return this.age;}
        public void setAge(int age) {this.age = age;}
    }

    /**
     * 映 射
     * map(Function f)  接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     */
    @Test
    public void testStreamAPI2() {
        Employee emp = new Employee("zs", 18);
        Employee emp1 = new Employee("zs1", 22);
        Employee emp2 = new Employee("ls", 18);
        Employee emp3 = new Employee("ls1", 17);
        Employee emp4 = new Employee("ww", 20);
        List<Employee> employees = new ArrayList<>();
        employees.add(emp);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("*******************************");
        employees.stream().map(Employee::getAge).forEach(System.out::println);
    }

    /**
     * 排序
     * sorted()                 产生一个新流，其中按自然顺序排序
     * sorted(Comparator com)   产生一个新流，其中按比较器顺序排序
     */
    @Test
    public void testStreamAPI3() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(1);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("****************************");
        Employee emp = new Employee("zs", 18);
        Employee emp1 = new Employee("zs1", 22);
        Employee emp2 = new Employee("ls", 18);
        Employee emp3 = new Employee("ls1", 17);
        Employee emp4 = new Employee("ww", 20);
        List<Employee> employees = new ArrayList<>();
        employees.add(emp);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.stream().sorted((o1, o2) -> {
            int result = Integer.compare(o1.getAge(), o2.getAge());
            if (result == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return result;
        }).forEach(System.out::println);

    }

    /**
     * 匹配与查找
     * allMatch(Predicate p)        检查是否匹配所有元素
     * anyMatch(Predicate p)        检查是否至少匹配一个元素
     * noneMatch(Predicate p)       检查是否没有匹配所有元素
     * findFirst()                  返回第一个元素
     * findAny()                    返回当前流中的任意元素
     * count()                      返回流中元素总数
     * max(Comparator c)            返回流中最大值
     * min(Comparator c)            返回流中最小值
     * forEach(Consumer c)         内部迭代
     */
    @Test
    public void testStreamAPI4() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list.stream().allMatch(i -> i == 2));
        System.out.println(list.stream().anyMatch(i -> i == 1));
        System.out.println(list.stream().noneMatch(i -> i == 4));
        System.out.println();
        list.stream().filter(i -> i == 2).findFirst().ifPresent(System.out::println);
        System.out.println();
        list.stream().filter(i -> i == 2).findAny().ifPresent(System.out::println);
        System.out.println();
        System.out.println(list.stream().filter(e -> e == 2).count());
        System.out.println();
        list.stream().max(Integer::compare).ifPresent(System.out::println);
        System.out.println();
        list.stream().min(Integer::compare).ifPresent(System.out::println);
        System.out.println();
        //list.stream().forEach(System.out::println);
        list.forEach(System.out::println);
    }

    /**
     * 归约
     * reduce(T iden, BinaryOperator b)         可以将流中元素反复结合起来，得到一个值。返回T
     * reduce(BinaryOperator b)                 可以将流中元素反复结合起来，得到一个值。返回Optional<T>
     */
    @Test
    public void testStreamAPI5() {
        // 求和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream().reduce(0, Integer::sum));
    }

    /**
     * 收集
     * collect(Collector c)     将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void testStreamAPI6() {
        Employee emp = new Employee("zs", 18);
        Employee emp1 = new Employee("zs1", 22);
        Employee emp2 = new Employee("ls", 18);
        Employee emp3 = new Employee("ls1", 17);
        Employee emp4 = new Employee("ww", 20);
        List<Employee> employees = new ArrayList<>();
        employees.add(emp);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        Set<String> nameSet = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        nameSet.forEach(System.out::println);
        System.out.println("*********************************************");
        Set<Integer> ageSet = employees.stream().map(Employee::getAge).collect(Collectors.toSet());
        ageSet.forEach(System.out::println);
    }
}
