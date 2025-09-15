package ru;

public class Department {


    private final String name;
    private Employee manager;

    //имя
    public Department(String name) {
        this.name = validateName(name);
    }

    //валидация
    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Название отдела не может быть пустым");
        return name.trim();
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }

    //проверка на рука
    public void setManager(Employee manager) {
        if (manager == null) throw new IllegalArgumentException("Руководитель не может быть null");
        //сутрудник из нашего отдела
        if (manager.getDepartment() != this) throw new IllegalArgumentException("Руководитель должен работать в этом отделе");
        this.manager = manager;
    }

    //удалим рука
    public void removeManager() {
        this.manager = null;
    }

    public boolean hasManager() {
        return manager != null;
    }
}