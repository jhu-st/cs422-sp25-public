import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;

public class Task2Test {

    static String BASE_URL = "https://sis.jhu.edu/api/classes";
    static String KEY;

    @BeforeAll
    public static void setUP() {
        KEY = "YOU_SIS_API_KEY";
    }



    @Test
    public void CSDepartmentExists() {
        String query = BASE_URL + "/codes/departments/Whiting School of Engineering?key=" + KEY;
        when().
                get(query).
                then().assertThat().body("DepartmentName", hasItems("EN Computer Science"));

    }

    @Test
    public void DSCourseExists() {
        String query = BASE_URL + "/Whiting School of Engineering/Spring 2023?key=" + KEY;
        when().
                get(query).
                then().assertThat().body("Title", hasItems("Data Structures"));

    }

    @Test
    public void postReqFails() {
        String query = BASE_URL + "/Whiting School of Engineering/Spring 2023?key=" + KEY;
        when().
                post(query).
                then().assertThat().statusCode(405);

    }


}
