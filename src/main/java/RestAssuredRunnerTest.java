import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;


public class RestAssuredRunnerTest {

    public static final String url = "http://ergast.com/api/f1/2010/constructors.json";

    private static ArrayList<String> expectedConstructorsList = new ArrayList<String>();

    private static String expectedConstructorsListSize;

    private static Constructor expectedConstructorFerrary;


    private static Response response;


    @BeforeClass
    public static void init() {
        expectedConstructorsList.addAll(Arrays.asList(
                "ferrari", "force_india", "hrt", "lotus_racing", "mclaren", "mercedes",
                "red_bull", "renault", "sauber", "toro_rosso", "virgin", "williams"));

        expectedConstructorFerrary = new Constructor("ferrari"
                , "http://en.wikipedia.org/wiki/Scuderia_Ferrari"
                , "Ferrari"
                , "Italian");

        expectedConstructorsListSize = getExpectedConstructorsListSizeToString(expectedConstructorsList);
        response = given().when().get(url);
        response.then().statusCode(200);


    }

    @Test
    public void testConstructorsNumber() {
        response.then().assertThat()
                .body("MRData.total", equalTo(expectedConstructorsListSize));
    }

    @Test
    public void testConstructorsNames() {

        List<String> list = response.then().extract().jsonPath()
                .getList("MRData.ConstructorTable.Constructors.constructorId", String.class);

        assertTrue(list.containsAll(expectedConstructorsList));
    }

    @Test
    public void testConstructorsSchema() {
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }

    @Test
    public void testConstructorsMatcher() {
        List<Constructor> list = response
                .then().extract().jsonPath().getList("MRData.ConstructorTable.Constructors", Constructor.class);

        assertTrue(list.contains(expectedConstructorFerrary));
    }

    public static String getExpectedConstructorsListSizeToString(ArrayList<String> expectedConstructorsList) {
        int size = expectedConstructorsList.size();
        return Integer.toString(size);
    }
}
