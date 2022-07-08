package test;

import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import io.restassured.RestAssured;
import org.testng.Assert;

import java.util.Map;


public class RestTests {

    protected static RequestSpecification request;
    protected static Integer customerId = 13100;
    protected static Integer fromAccount = 14232;
    protected static String userName = "prueba1";
    protected static String password = "123";

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI="https://parabank.parasoft.com/parabank";
           request = RestAssured.given();
           request.auth().basic(userName, password);
    }

    @DisplayName("Login test")
    @Test
    public void register0(){
        request
                .when()
                .get("/services/bank/login/"+userName+"/"+password)
                .then()
                .statusCode(200).log().all();
    }

    @DisplayName("Check register page")
    @Test
    public void register1(){
        request
                .when()
                .get("/register.htm")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void register2(){
        //int customerId = 13877;
        int accountType = 1;
        //int fromAccount = 14898;
        request
                //.auth().basic("prueba1", "123")
                .queryParams(Map.of(
                        "customerId",customerId, "newAccountType", 1, "fromAccountId", fromAccount
                ))
                .when()
                .post("/services_proxy/bank/createAccount")
                .then()
                .statusCode(500)
                //.assertThat().body("customerId", Matchers.equalTo(customerId))
                .log().all();
    }

    @DisplayName("Resumen de las cuentas")
    @Test
    public void register3(){
        int customerId = 13877;
        request.auth().basic("sfd", "123")
                .get("/services/bank/customers/"+customerId+"/accounts")
                .then().statusCode(200).log().all();
    }
    @DisplayName("Actividad de la cuenta / Transaction history")
    @Test
    public void register5(){
        request
                .get("/services/bank/accounts/"+fromAccount+"/transactions")
                .then().statusCode(200).log().all();
    }

    @Test
    @DisplayName("Create new account")
    public void register6(){
        request
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .when()
                .post("/services/bank/createAccount?customerId="+customerId+"&newAccountType=CHECKING&fromAccountId="+fromAccount)
                .then()
                .statusCode(200).log().all();
    }

    @Test
    @DisplayName("TransferFunds between accounts")
    public void register7(){
        request
                //
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .when()
                .post("/services/bank/transfer?fromAccountId="+fromAccount+"&toAccountId="+fromAccount+"&amount=10")
                .then()
                .statusCode(200).log().all();
    }
}
