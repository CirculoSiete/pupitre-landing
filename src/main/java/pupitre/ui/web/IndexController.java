package pupitre.ui.web;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller("/")
public class IndexController {
  @Get
  public ModelAndView index(HttpRequest<?> request) {
    var dataToRender = Map.of(
      "sliderItems", sliderItems(),
      "courses", popularCourses()
    );

    return new ModelAndView("index", dataToRender);
  }

  private List<Map<String, String>> sliderItems() {
    return List.of(
      slider(
        "rs-1706",
        "/images/nivo-1.jpg",
        "Desarrollo de Microservicios",
        "Cloud Native",
        "Aprende los principios de Cloud Native y como aplicarlos <br> " +
          "para desarrollar microservicios en Java con Spring Boot.") /*,
      slider(
        "rs-1707",
        "/images/nivo-2.jpg",
        "Take the first step to",
        "learn with us",
        "Lorem ipsum dolor sit amet, consectetur elit, sed do <br> " +
          "eiusmod tempor incididunt ut laboreet dolore magna aliqua."
      ),
      slider(
        "rs-1708",
        "/images/nivo-3.jpg",
        "Are you ready to",
        "apply?",
        "Lorem ipsum dolor sit amet, consectetur elit, sed do <br> " +
          "eiusmod tempor incididunt ut laboreet dolore magna aliqua."
      )*/
    );
  }

  private Map<String, String> slider(String index, String image, String text1, String text2, String caption) {
    return Map.of(
      "index", index,
      "image", image,
      "text1", text1,
      "text2", text2,
      "caption", caption
    );
  }

  private List<Map<String, String>> popularCourses() {
    return List.of(
      popularCourse(
        "/images/courses/courses1-1.jpg",
        "Mastering DevOps",
        "En este curso aprenderás sobre todas las disciplinas y herramientas de la práctica de DevOps.",
        "$8,000 + IVA",
        "Virtual",
        "#",
        "#"
      ),
      popularCourse(
        "/images/courses/courses1-2.jpg",
        "Introducción a Micronaut",
        "Conoce las bases fundamentales para desarrollar aplicaciones ligeras en Java",
        "¡Gratis!",
        "En línea-OnDemand",
        "#",
        "#"
      ),
      popularCourse(
        "/images/courses/courses1-3.jpg",
        "Jenkins efectivo",
        "Aprende a usar Jenkins en una forma efectiva, para implementar Integración Continua con valor.",
        "$ 11,000 + IVA",
        "Presencial",
        "#",
        "#"
      )
    );
  }

  private Map<String, String> popularCourse(String banner, String shortName, String shortDescription, String price,
                                            String type, String detailsUrl, String registerUrl) {
    return Map.of(
      "banner", banner,
      "shortName", shortName,
      "shortDescription", shortDescription,
      "price", price,
      "type", type,
      "detailsUrl", detailsUrl,
      "registerUrl", registerUrl
    );
  }
}
