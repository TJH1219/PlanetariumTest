Feature:Adding new planets and moons
  Scenario Outline: Planet Happy Path
    Given the user is on the homepage
    Then the user selects the planet option
    And the user enters a valid planet name "<validPlanetName>"
    And the user enters a valid planet image "<img>"
    And the user clicks the add planet button
    Then the planet table is updated planet "<validPlanetName>"

    Examples:
    |validPlanetName|img|
    |Zanath          |C:\Users\thadd\Documents\GitHub\PlanetariumTest\PlanettariumTests\src\main\resources\Celestial-Images\planet-5.jpg|

  Scenario Outline: Moon Happy Path
    Given the user is on the homepage
    Then the user selects the moon option
    And the user enters a valid moon name "<validMoonName>"
    And the user enters the owner planet id "<ownerPlanet>"
    And the moon has a valid owner planet "<ownerPlanet>"
    And the user enters a valid moon image "<img>"
    And the user clicks the add moon button
    Then the planet table is updated moon "<validMoonName>"

    Examples:
      |validMoonName|ownerPlanet|img|
      |Pios         |2           |C:\Users\thadd\Documents\GitHub\PlanetariumTest\PlanettariumTests\src\main\resources\Celestial-Images\moon-4.jpg |
      |Algeras      |1           |C:\Users\thadd\Documents\GitHub\PlanetariumTest\PlanettariumTests\src\main\resources\Celestial-Images\moon-5.jpg|

  Scenario Outline:Sad Planet Path
    Given the user is on the homepage
    Then the user selects the planet option
    And the user enters an invalid name planet "<invalidPlanetName>"
    And the user enters a planet image "<img>"
    And the user clicks the add planet button
    Then the browser gives the alert "<message>"

    Examples:
    |invalidPlanetName|img|message|
    |lentokonesuihkuturbiinimoottoriapumekaanikkoaliupseerioppilas| C:\Users\thadd\Documents\GitHub\PlanetariumTest\PlanettariumTests\src\main\resources\Celestial-Images\planet-4.jpg|Invalid planet name|
    |::Broken planet Name[]                                       | C:\Users\thadd\Documents\GitHub\PlanetariumTest\PlanettariumTests\src\main\resources\Celestial-Images\planet-4.jpg|Invalid planet name |
    |Earth                                                        |C:\Users\thadd\Documents\GitHub\PlanetariumTest\PlanettariumTests\src\main\resources\Celestial-Images\planet-5.jpg |Invalid planet name |

  Scenario Outline:Sad Moon Path
    Given the user is on the homepage
    Then the user selects the moon option
    And the user enters a valid moon name "<invalidMoonName>"
    And the user enters the owner planet id "<id>"
    And the user enters a valid moon image "<img>"
    And the user clicks the add moon button
    Then the browser gives the alert "<message>"

    Examples:
      |invalidMoonName|id|message|img|
      |lentokonesuihkuturbiinimoottoriapumekaanikkoaliupseerioppilas|1|Invalid moon name|C:\Users\thadd\Documents\GitHub\PlanetariumTest\PlanettariumTests\src\main\resources\Celestial-Images\moon-4.jpg|
      |::bad name;;                                                 |1|Invalid moon name|C:\Users\thadd\Documents\GitHub\PlanetariumTest\PlanettariumTests\src\main\resources\Celestial-Images\moon-5.jpg|
      |ValidMoon                                                    |500|Invalid planet id|C:\Users\thadd\Documents\GitHub\PlanetariumTest\PlanettariumTests\src\main\resources\Celestial-Images\moon-4.jpg|