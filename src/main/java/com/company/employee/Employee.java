package com.company.employee;

import com.company.department.Department;

public class Employee {
    private final String name;
    Department department; //package-private доступ для Department

    public Employee(String name) {
        this.name = validateName(name);
    }

    public Employee(String name, Department department) {
        this.name = validateName(name);
        setDepartment(department);
    }

    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя сотрудника не может быть пусто");
        }
        return name.trim();
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department newDepartment) {
        if (newDepartment == null) {
            throw new IllegalArgumentException("Отдел не может быть пуст");
        }

        //удаляем сотрудника из старого отдела
        if (this.department != null) {
            //если сотрудник был руководителем старого отдела
            if (isManager()) {
                this.department.removeManagerDirectly();
            }
        }

        //назначаем новый отдел
        this.department = newDepartment;
    }

    public boolean isManager() {
        return department != null && department.hasManager() && department.getManager() == this;
    }

    public void promoteToManager() {
        if (department == null) {
            throw new IllegalStateException("Сотрудник не работает в отделе");
        }
        department.setManagerDirectly(this);
    }

    public void demoteFromManager() {
        if (isManager()) {
            department.removeManagerDirectly();
        }
    }

    @Override
    public String toString() {
        if (department == null) {
            return name + " (не работает в отделе)";
        }

        if (isManager()) {
            return name + " начальник отдела " + department.getName();
        } else {
            String managerName = department.hasManager() ? department.getManager().getName() : "отсутствует";
            return name + " работает в отделе " + department.getName() +
                    ", начальник которого " + managerName;
        }
    }
}