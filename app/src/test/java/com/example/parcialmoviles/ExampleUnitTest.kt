import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.parcialmoviles.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {

        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testActivityLaunch() {

        scenario.onActivity { activity ->
            assertNotNull(activity)
        }
    }

    @Test
    fun testButtonClick() {

        onView(withId(R.id.myButton)).perform(click())


    }

    @After
    fun tearDown() {

        scenario.close()
    }
}
