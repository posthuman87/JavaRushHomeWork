package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
 Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human GrPa1 = new Human("Вася", "мужской", 53);
        System.out.println(GrPa1);

        Human GrPa2 = new Human("Толик", "мужской", 55);
        System.out.println(GrPa2);

        Human GrMa1 = new Human("Катя", "женский", 53);
        System.out.println(GrMa1);

        Human GrMa2 = new Human("Тома", "женский", 54);
        System.out.println(GrMa2);

        Human father = new Human("Олег", "мужской", 28, GrPa1, GrMa1);
        System.out.println(father);

        Human mother = new Human("Наташа", "женский", 27, GrPa2, GrMa2);
        System.out.println(mother);

        Human son1 = new Human("Саша", "мужской", 6, father, mother);
        System.out.println(son1);

        Human son2 = new Human("Ярик", "мужской", 3, father, mother);
        System.out.println(son2);

        Human doughter = new Human("Ева", "женский", 0, father, mother);
        System.out.println(doughter);//напишите тут ваш код
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human (String name, String sex, int age){
            this.name = name;
            if (sex.equals("мужской")) this.sex = true; else this.sex = false;
            this.age = age;
        }

        public Human (String name, String sex, int age, Human father, Human mother){
            this.name = name;
            this.age = age;
            this.father = father;
            this.mother = mother;
            if (sex.equals("мужской")) this.sex = true; else this.sex = false;
        }


        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
