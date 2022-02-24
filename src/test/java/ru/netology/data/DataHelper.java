package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    private DataHelper() {

    }

    @Value
    public static class CardNumber {
        private String cardNumber;
    }

    public static CardNumber getApprovedCardNumber() {

        return new CardNumber("4444 4444 4444 4441");
    }

    public static CardNumber getDeclinedCardNumber() {

        return new CardNumber("4444 4444 4444 4442");
    }

    public static CardNumber getCardNumberWithAnotherCard() {
        return new CardNumber("4444 4444 4444 4440");
    }

    public static CardNumber getCardNumberWithNulls(){
        return new CardNumber("0000 0000 0000 0000");
    }

    public static CardNumber getCardWithoutNumber() {

        return new CardNumber("");
    }

    public static String getMonth() {

        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getInvalidMonth() {

        return "23";
    }

    public static String getEmptyMonth() {

        return "";
    }


    public static String getYear() {

        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getLastYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getEmptyYear() {
        return "";
    }

    public static String getAfterCardExpiryDate(){
        return LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy"));
    }
    public static String getCardExpiryDate(){
        return LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getCorrectCVCCVV() {
        return "256";
    }

    public static String getCVCCVVWithOneNumber() {
        return "7";
    }

    public static String getEmptyCVCCVV() {
        return "";
    }

    public static String getValidOwner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getOwnerWithRusLetters() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getOwnerWithNumbers() {

        return "456456";
    }
    public static String getOwnerWithSpecialSymbols() {
        return "**%###";
    }

    public static String getEmptyOwner() {

        return "";
    }
}

