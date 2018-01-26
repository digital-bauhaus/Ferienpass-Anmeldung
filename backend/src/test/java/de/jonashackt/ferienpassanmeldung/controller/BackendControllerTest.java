package de.jonashackt.ferienpassanmeldung.controller;

import de.jonashackt.ferienpassanmeldung.FerienpassAnmeldungApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = FerienpassAnmeldungApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
		properties = "server.port = 8099"
)
public class BackendControllerTest {

	private static final String BASE_URL = "http://localhost:8099/api";

	@Test
	public void query() {}

	@Test
    public void simple() {}

    @Test
	public void add_user() {}

	@Test
	public void authenticate() {}

}
