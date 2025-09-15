package ru;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name; //Приват Имя
    private final List<Integer> grades; //Приват Оценки (массив целых чисел)

    // Имя без оценок
    public Student(String name) {
        this.name = validateName(name);
        this.grades = new ArrayList<>();
    }

    // Имя и оценка по умолчанию
    public Student(String name, int[] initialGrades) {
        this.name = validateName(name);
        this.grades = new ArrayList<>();
        if (initialGrades != null) {
            for (int grade : initialGrades) {
                addGrade(grade); //положительное
            }
        }
    }

    // Валидация имени
    /*При создании обязательно указать имя, и опционально набор оценок*/
    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Имя не может быть пустым");
        return name.trim();
    }

    // Валидация оценки
    /*При создании обязательно указать имя, и опционально набор оценок
    Все оценки должны быть в диапазоне от 2 до 5*/
    private void validateGrade(int grade) {
        if (grade < 2 || grade > 5) throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5");
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Метод для добавления оценки
    public void addGrade(int grade) {
        validateGrade(grade);
        grades.add(grade);
    }

    // Метод для получения всех оценок (вернем копию для защиты от изменений)
    /*Оценки можно добавлять в любой момент, но нельзя удалять*/
    public List<Integer> getGrades() {
        return new ArrayList<>(grades); //Вернем копию
    }

    // Метод для получения оценок в виде массива
    public int[] getGradesAsArray() {
        int[] result = new int[grades.size()];
        for (int i = 0; i < grades.size(); i++) {
            result[i] = grades.get(i);
        }
        return result;
    }

    // Метод для проверки, есть ли у студента оценки
    public boolean hasGrades() {
        return !grades.isEmpty();
    }

    // Метод для получения количества оценок
    public int getGradesCount() {
        return grades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}