package com.company;

import com.company.department.Department;
import com.company.employee.Employee;

public class CompanyMain {
    public static void main(String[] args) {

        //создадим отделы
        Department itDepartment = new Department("IT"); //отдел Айти
        Department mnDepartment = new Department("Miner"); //отдел Шахтер

        //создадим сотрудников
        Employee anton = new Employee("Антон Антонов");
        Employee petya = new Employee("Петя Петров");
        Employee pit = new Employee("Пит Питейнов");

        //назначим сотрудников на отделы
        anton.setDepartment(itDepartment);
        petya.setDepartment(itDepartment);
        pit.setDepartment(mnDepartment);

        //назначим руководителей
        anton.promoteToManager(); //Антон - рук Айти
        pit.promoteToManager(); //Пит - рук Шахтер

        //выведем все это искусство
        System.out.println(anton);
        System.out.println(petya);
        System.out.println(pit);
        System.out.println();

        //переведем Петю к Шахтерам
        System.out.println(" -- Петя в отеделе у Шахтеров -- ");
        petya.setDepartment(mnDepartment);
        System.out.println(petya);
        System.out.println();

        //Антон больше не рук
        System.out.println(" -- Антон больше не рук -- ");
        anton.demoteFromManager();
        System.out.println(anton);
        System.out.println();

        //назначить реководителем сотрудника не из отдела
        System.out.println(" -- Назначить реководителем сотрудника не из отдела -- ");
        try {
            petya.promoteToManager(); //Петя теперь в отделе Шатеры, можно назначить
            System.out.println("Петя назначен рук - Шатеры: " + petya.isManager());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}