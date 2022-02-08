package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.PaymentCreditCard;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentCreditTest {

    @BeforeAll
    static void setUpAll() {

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp(){

        open("http://localhost:8080/");
    }

    @AfterAll
    static void tearDownAll() {
        SqlHelper.cleanTables();
    }

    @Test
    void shouldPaymentCreditCardStatusApproved(){
        val dashboardPage = new DashboardPage();
        val paymentCreditCard = new PaymentCreditCard();
        dashboardPage.getCreditCard();
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonth();
        val year = DataHelper.getYear();
        val cvccvv = DataHelper.getCorrectCVCCVV();
        val owner = DataHelper.getValidOwner();
        paymentCreditCard.fillingFieldsFormat(cardNumber, month, year,cvccvv, owner);
        paymentCreditCard.checkSuccessNotification();
        val paymentStatus = SqlHelper.getStatusCreditRequestEntity();
        assertEquals("APPROVED", paymentStatus);
    }
    @Test
    void shouldPaymentCreditWithStatusDeclined(){
        val dashboardPage = new DashboardPage();
        val paymentCreditCard = new PaymentCreditCard();
        dashboardPage.getCreditCard();
        val cardNumber = DataHelper.getDeclinedCardNumber();
        val month = DataHelper.getMonth();
        val year = DataHelper.getYear();
        val cvccvv = DataHelper.getCorrectCVCCVV();
        val owner = DataHelper.getValidOwner();
        paymentCreditCard.fillingFieldsFormat(cardNumber, month, year,cvccvv, owner);
        paymentCreditCard.checkErrorNotification();
        val paymentStatus = SqlHelper.getStatusCreditRequestEntity();
        assertEquals("DECLINES", paymentStatus);
    }

    @Test
    void shouldDontSuccessByCreditWithAnotherCard(){
        val dashboardPage = new DashboardPage();
        val paymentCreditCard = new PaymentCreditCard();
        dashboardPage.getCreditCard();
        val cardNumber = DataHelper.getDeclinedCardNumber();
        val month = DataHelper.getMonth();
        val year = DataHelper.getYear();
        val cvccvv = DataHelper.getCorrectCVCCVV();
        val owner = DataHelper.getValidOwner();
        paymentCreditCard.fillingFieldsFormat(cardNumber, month, year,cvccvv, owner);
        paymentCreditCard.checkErrorNotification();
    }

    @Test
    void shouldDontSuccessByCreditCardNumberWithNulls(){
        val dashboardPage = new DashboardPage();
        val paymentCreditCard = new PaymentCreditCard();
        dashboardPage.getCreditCard();
        val cardNumber = DataHelper.getCardWithoutNumber();
        val month = DataHelper.getMonth();
        val year = DataHelper.getYear();
        val cvccvv = DataHelper.getCorrectCVCCVV();
        val owner = DataHelper.getValidOwner();
        paymentCreditCard.fillingFieldsFormat(cardNumber, month, year,cvccvv, owner);
        paymentCreditCard.checkErrorNotification();
    }

    @Test
    void shouldDontSuccessByCreditWithEmptyFieldCardNumber(){
        val dashboardPage = new DashboardPage();
        val paymentCreditCard = new PaymentCreditCard();
        dashboardPage.getCreditCard();
        val cardNumber = DataHelper.getCardWithoutNumber();
        val month = DataHelper.getMonth();
        val year = DataHelper.getYear();
        val cvccvv = DataHelper.getCorrectCVCCVV();
        val owner = DataHelper.getValidOwner();
        paymentCreditCard.fillingFieldsFormat(cardNumber, month, year,cvccvv, owner);
        paymentCreditCard.checkWrongFormatMessage();
    }

}
