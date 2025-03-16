package Sec13.LocalClassChallenge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import Sec13.LocalClassChallenge.Employee;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Vuz", "Vu", "11/05/2005");
        Employee e2 = new Employee("Vus", "Vu", "11/05/2006");
        Employee e3 = new Employee("Vua", "Vu", "11/05/2007");
        Employee e4 = new Employee("Vue", "Vu", "11/05/2008");
        Employee e5 = new Employee("Vui", "Vu", "11/05/2009");

        List<Employee> list = new ArrayList<>(Arrays.asList(e1,e2,e3,e4,e5));
        printOrderedList(list, "name");
        System.out.println();
        printOrderedList(list, "year");
    }

    public static void printOrderedList(List<Employee> eList, String sortField){
                    int currentYear = LocalDate.now().getYear();
        
                    class MyEmployee{
                        Employee containedEmployee;
                        int yearsWorked;
                        String fullName;
        
                        public MyEmployee(Employee containedEmployee){
                            this.containedEmployee = containedEmployee;
                            yearsWorked = currentYear - Integer.parseInt(containedEmployee.hireDate().split("/")[2]);
                            fullName = String.join(" ",containedEmployee.first(),containedEmployee.last());
                        }
                        @Override
                        public String toString(){
                            return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
                        }
                    }

                    List<MyEmployee> list = new ArrayList<>();
                    for(Employee employee : eList){
                        list.add(new MyEmployee(employee));
                    }

                    var comparator = new Comparator<MyEmployee>(){
                        @Override
                        public int compare(MyEmployee o1, MyEmployee o2) {
                            if(sortField.equals("name")){
                                return o1.fullName.compareTo(o2.fullName);
                            }
                            return o1.yearsWorked - o2.yearsWorked;
                        }
                    };
                    
                    list.sort(comparator);

                    for(MyEmployee myEmployee : list){
                        System.out.println(myEmployee);
                    }
    }
}

