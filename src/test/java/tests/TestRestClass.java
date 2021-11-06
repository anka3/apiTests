package tests;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.json.JSONObject;

import java.util.Date;

import static java.lang.String.valueOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
public class TestRestClass {

    //get
//    @Test
//    public void postmanFirstGetTest() {
//        RestAssured.
//                when().get("https://postman-echo.com/get?foo1=bar1&foo2=bar2").
//                then().assertThat().statusCode(200).
//                and().body("args.foo2", is("bar2"));
//    }

        @Test
    public void postRequestExampleTest() {

        RestAssured.baseURI ="http://localhost:8080";
        RequestSpecification request = RestAssured.given();
        JSONObject jsonObject = new JSONObject();
            jsonObject.put("amount", -7);

        request.header("Content-Type", "application/json");
            request.body(jsonObject.toMap());

       //plus
            Response responsePlus = request.post("/plus");
            int statusCodePlus = responsePlus.getStatusCode();
            Assert.assertEquals(statusCodePlus, 200);
            System.out.println("Код ответа: " + statusCodePlus);

            RestAssured.
                when().get("/balance").
                then().assertThat().body("balance", equalTo(-7));

        //minus
            Response responseMinus = request.post("/minus");
            int statusCodeMinus = responseMinus.getStatusCode();
            Assert.assertEquals(statusCodeMinus, 200);
            System.out.println("Код ответа: " + statusCodeMinus);

            RestAssured.
                    when().get("/balance").
                    then().assertThat().body("balance", equalTo(0));

        }

    @Test
    public void minusTest() {

        RestAssured.baseURI ="http://localhost:8080";
        RequestSpecification request = RestAssured.given();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount", -777);
        request.header("Content-Type", "application/json");
        request.body(jsonObject.toMap());

        request.header("Content-Type", "application/json");
        request.body(jsonObject.toMap());

        //minus
        Response responseMinus = request.post("/minus");
        int statusCodeMinus = responseMinus.getStatusCode();
        Assert.assertEquals(statusCodeMinus, 200);
        System.out.println("Код ответа: " + statusCodeMinus);

        RestAssured.
                when().get("/balance").
                then().assertThat().body("balance", equalTo(777));

        //minus
        jsonObject.put("amount", 777);
        request.header("Content-Type", "application/json");
        request.body(jsonObject.toMap());
        Assert.assertEquals(statusCodeMinus, 200);
        System.out.println("Код ответа: " + statusCodeMinus);

        RestAssured.
                when().get("/balance").
                then().assertThat().body("balance", equalTo(0));

    }

    @Test
    public void doubleRequest() {

        RestAssured.baseURI ="http://localhost:8080";
        RequestSpecification request = RestAssured.given();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount", -777.9764633);
        request.header("Content-Type", "application/json");
        request.body(jsonObject.toMap());

        request.header("Content-Type", "application/json");
        request.body(jsonObject.toMap());

        //minus
        Response responseMinus = request.post("/minus");
        int statusCodeMinus = responseMinus.getStatusCode();
        Assert.assertEquals(statusCodeMinus, 200);
        System.out.println("Код ответа: " + statusCodeMinus);

        RestAssured.
                when().get("/balance").
                then().assertThat().body("balance", equalTo(777));

        //minus
        jsonObject.put("amount", 777);
        request.header("Content-Type", "application/json");
        request.body(jsonObject.toMap());
        Assert.assertEquals(statusCodeMinus, 200);
        System.out.println("Код ответа: " + statusCodeMinus);

        RestAssured.
                when().get("/balance").
                then().assertThat().body("balance", equalTo(0));

    }


}
