package racetrack

import static org.junit.Assert.*
import org.junit.*

class RaceTests{

    @Before
    void setUp() {
        // Setup logic here
        //super.setUp()
    }

    @After
    void tearDown() {
        // Tear down logic here
        //super.tearDown()
    }

    @Test
    void testRaceDatesBeforeToday() {
        def lastWeek = new Date() - 7
        def race = new Race(startDate:lastWeek)
        assertFalse "La validacion debería fallar",race.validate()
        // It should have errors after validation fails
        assertTrue "Debería haber errores",race.hasErrors()

        println "\nErrors:"
        println race.errors ?: "no errors found"
        def badField = race.errors.getFieldError('startDate')
        println "\nBadField:"
        println badField ?: "startDate wasn't a bad field"
        assertNotNull "Expecting to find an error on the startDate field", badField
        def code = badField?.codes.find {
          it == 'race.startDate.validator.invalid'
        }
        println "\nCode:"
        println code ?:"the custom validator for startDate wasn't found"
        assertNotNull "startDate field should be the culprit",code
    } 
}