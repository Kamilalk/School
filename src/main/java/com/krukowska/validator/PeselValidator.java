package com.krukowska.validator;
import com.krukowska.domain.enums.Gender;
import java.time.LocalDate;
public class PeselValidator {

    public int getBirthYear(String pesel) {
        byte[] valPesel = pesel.getBytes();
        int year;
        int month;
        year = 10 * valPesel[0];
        year += valPesel[1];
        month = 10 * valPesel[2];
        month += valPesel[3];
        if (month > 80 && month < 93) {
            year += 1800;
        }
        else if (month > 0 && month < 13) {
            year += 1900;
        }
        else if (month > 20 && month < 33) {
            year += 2000;
        }
        else if (month > 40 && month < 53) {
            year += 2100;
        }
        else if (month > 60 && month < 73) {
            year += 2200;
        }
        return year;
    }

    public int getBirthMonth(String pesel) {
        byte[] valPesel = pesel.getBytes();
        int month;
        month = 10 * valPesel[2];
        month += valPesel[3];
        if (month > 80 && month < 93) {
            month -= 80;
        }
        else if (month > 20 && month < 33) {
            month -= 20;
        }
        else if (month > 40 && month < 53) {
            month -= 40;
        }
        else if (month > 60 && month < 73) {
            month -= 60;
        }
        return month;
    }

    public int getBirthDay(String pesel) {
        byte[] valPesel = pesel.getBytes();
        int day;
        day = 10 * valPesel[4];
        day += valPesel[5];
        return day;
    }

    public String getBirthDate(String pesel){
        int day = getBirthDay(pesel);
        int month = getBirthMonth(pesel);
        int year = getBirthYear(pesel);
        return "" + day + "/" +  month + "/" + year;
    }

    public int getAge(String pesel){
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        int birthDay = getBirthDay(pesel);
        int birthMonth = getBirthMonth(pesel);
        int birthYear = getBirthYear(pesel);

        int age = currentYear - birthYear;

        if(birthMonth > currentMonth){
            age -= age;
        }
        else if (birthMonth == currentMonth) {
            if(birthDay > currentDay){
                age -= age;
            }
        }
        return age;
    }

    public Gender getSex(String pesel) {
        byte[] valPesel = pesel.getBytes();
        if (valPesel[9] % 2 == 1) {
            return Gender.MALE;
        }
        else {
            return Gender.FEMALE;
        }

    }



}