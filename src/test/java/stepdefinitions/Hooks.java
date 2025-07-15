
package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment.setup;

public class Hooks extends BaseTest {

    @Before
    public void initializeBrowser() {
        setUp(); // from BaseTest
    }

    @After
    public void closeBrowser() {
        tearDown(); // from BaseTest
    }

}

