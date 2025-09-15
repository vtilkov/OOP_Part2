package ru;

public class Employee {
    private final String name;
    private Department department;

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

    //установим отдел
    public void setDepartment(Department newDepartment) {
        if (newDepartment == null) throw new IllegalArgumentException("Отдел не может быть null");

        //если сотрудник ужек работает в каком то отделе
        if (this.department != null) {
            //если сотрудник был уже руком какого то отдела
            if (this.department.hasManager() && this.department.getManager() == this) {
                this.department.removeManager();
            }
        }
        this.department = newDepartment;
    }

    //сотрудник руководитель (да/нет)
    public boolean isManager() {
        return department != null && department.hasManager() && department.getManager() == this;
    }

    //назначим сотрудника на руководящую должность
    public void promoteToManager() {
        if (department == null) throw new IllegalStateException("Сотрудник не работает в отделе");
        department.setManager(this);
    }

    //снять с должности рука
    public void demoteFromManager() {
        if (isManager()) department.removeManager();
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