package utils;

public class SpeciesFactory {

    public static String getExpectedBody() {
        return """
                {
                                "name": "Sullustan",
                                "classification": "mammal",
                                "designation": "sentient",
                                "average_height": "180",
                                "skin_colors": "pale",
                                "hair_colors": "none",
                                "eye_colors": "black",
                                "average_lifespan": "unknown",
                                "homeworld": "https://swapi.dev/api/planets/33/",
                                "language": "Sullutese",
                                "people": [
                                    "https://swapi.dev/api/people/31/"
                                ],
                                "films": [
                                    "https://swapi.dev/api/films/3/"
                                ],
                                "created": "2014-12-18T11:26:20.103000Z",
                                "edited": "2014-12-20T21:36:42.157000Z",
                                "url": "https://swapi.dev/api/species/10/"
                }
                """;
    }
}