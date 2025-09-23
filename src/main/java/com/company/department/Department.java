package com.company.department;

import com.company.employee.Employee;

public class Department {
    private final String name;
    Employee manager; //package-private доступ для Employee

    public Department(String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Отдел не может быть пустым");
        }
        return name.trim();
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }

    // Package-private метод для Employee
    public void setManagerDirectly(Employee manager) {
        this.manager = manager;
    }

    // Package-private метод для Employee
    public void removeManagerDirectly() {
        this.manager = null;
    }

    public boolean hasManager() {
        return manager != null;
    }

    @Override
    public String toString() {
        return name + (hasManager() ? " (руководитель: " + manager.getName() + ")" : " (руководитель отсутствует)");
    }
}