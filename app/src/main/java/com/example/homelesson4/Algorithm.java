package com.example.homelesson4;

import android.renderscript.ScriptGroup;

public class Algorithm {

    //создание пустого конструктора
    public Algorithm() {

    }

    //метод определения счастливого билета по питерской системе
    public boolean isHappyTicketSpb(String ticketNumber) {
        if (ticketNumber.length() != 6) {
            return false;
        }
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < 6; i++) {
            int n = Integer.parseInt(ticketNumber.charAt(i) + "");
            if(n % 2 == 0) {
                s1 += n;
            } else {
                s2 += n;
            }
        }
        return s1 == s2;
    }

    //метод определения счастливого билета(чуть менее быстрый)
    public int nextHappyTicketV1(String input) {
        int inputInt = Integer.parseInt(input);//Конвертирование данных из String в int

        if (!isHappyTicketSpb(Integer.toString(inputInt))) {
            //то выполняется цикл
            //шаговой проверки следующих билетов до наступления счастливых билетов
            while (!isHappyTicketSpb(Integer.toString(inputInt))) {
                inputInt = inputInt + 1;
            }
            return inputInt;//возвращается найденный счастливый билет
        } else {
            //иначе(в случе изначально счастливого билета)
            return inputInt;//возвращается счастливый билет
        }
    }

    //метод определения счастливого билета(быстрее)
    public int nextHappyTicketV2(String input) {
        int inputInt = Integer.parseInt(input);//конвертирование данных из String в int
        int count = 0;//задание счётчика

        for (int i = inputInt; i < 1000000; i++) {// цикл проверки и поиски счастливого билета
            int s1 = 0;
            int s2 = 0;
            String strInput = Integer.toString(i);
            for (int j = 0; j < 6; j++) {
                int n = Integer.parseInt(strInput.charAt(j) + "");
                if (n % 2 == 0) {
                    s1 += n;
                } else {
                    s2 += n;
                }
            }

            if (s1 == s2) {//проверка счастливого билета
                break;//выброс из цикла
            } else { //иначе
                count++;//увеличение счётчика на единицу
            }
        }
        return inputInt + count; //вывод счастливого билета
    }
}
