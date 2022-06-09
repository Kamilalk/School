package com.krukowska.validator;
import com.krukowska.domain.enums.Gender;
import java.time.LocalDate;
public class PeselValidator {
    private PeselValidator() {
    }

    public static LocalDate getBirthDate(final String pesel) {
        byte[] PESEL = new byte[11];

        for (int i = 0; i < 11; i++){
            PESEL[i] = Byte.parseByte(pesel.substring(i, i+1));
        }

        int day = getBirthDay(PESEL);
        int month = getBirthMonth(PESEL);
        int year = getBirthYear(PESEL);

        return LocalDate.of(year,month,day);

    }

    private static int getBirthYear(final byte[] PESEL) {
        int year;
        int month;
        year = 10 * PESEL[0];
        year += PESEL[1];
        month = 10 * PESEL[2];
        month += PESEL[3];
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

    private static int getBirthMonth(final byte[] PESEL) {
        int month;
        month = 10 * PESEL[2];
        month += PESEL[3];
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

    private static int getBirthDay(final byte[] PESEL) {
        int day;
        day = 10 * PESEL[4];
        day += PESEL[5];
        return day;
    }

    public static Gender getSex(String pesel) {
        byte[] valPesel = pesel.getBytes();
        if (valPesel[9] % 2 == 1) {
            return Gender.MALE;
        }
        else {
            return Gender.FEMALE;
        }

    }

    public static int getAge(String pesel){
        byte[] PESEL = new byte[11];

        for (int i = 0; i < 11; i++){
            PESEL[i] = Byte.parseByte(pesel.substring(i, i+1));
        }
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        int birthDay = getBirthDay(PESEL);
        int birthMonth = getBirthMonth(PESEL);
        int birthYear = getBirthYear(PESEL);

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


}