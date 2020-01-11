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
      "courses", popularCourses(),
      "featuredCourse", featuredCourse(),
      "events", events(),
      "instructors", instructors(),
      "tour", tour()
    );

    return new ModelAndView("index", dataToRender);
  }

  private Map tour() {
    return tour("/images/video.png",
      "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis corrupti quos dolores et " +
        "quas molestias excepturi sint occaecati cupiditate",
      "non provident, similique sunt in culpa qui officia deserunt mollitia animi fuga.",
      "https://www.youtube.com/watch?v=VaZ_B4HeewU");
  }

  private Map tour(String image, String desc1, String desc2, String videoUrl) {
    return Map.of(
      "image", image,
      "desc1", desc1,
      "desc2", desc2,
      "videoUrl", videoUrl

    );
  }

  private List instructors() {
    return List.of(
      instructor(
        "/images/team/team-01.jpg",
        "#",
        "Domingo Suárez",
        "Instructor"
      )
    );
  }

  private Map instructor(String logo, String profileUrl, String name, String title) {
    return Map.of(
      "logo", logo,
      "profileUrl", profileUrl,
      "name", name,
      "title", title
    );
  }

  private List<Map<String, String>> events() {
    String venue = "iQ4";
    return List.of(
      event(
        "22 <span>Ene</span>",
        "Cloud Native MX Meetup",
        "Miercoles, 8pm-9pm",
        "YouTube",
        "/images/event/event-2.jpg",
        "#"
      ),
      event(
        "18 <span>Feb</span>",
        "Curso Terraform",
        "Viernes, 3pm a 5pm<br>" + venue,
        venue,
        "/images/event/event-1.jpg",
        "#"
      ),
      event(
        "31 <span>Mar</span>",
        "Some event",
        "Martes, 7pm a 10pm<br>Centraal",
        "Centraal",
        "/images/event/event-3.jpg",
        "#"
      )
    );
  }

  private Map<String, String> event(String date, String name, String time, String venue, String image, String url) {
    return Map.of(
      "date", date,
      "name", name,
      "time", time,
      "venue", venue,
      "image", image,
      "url", url
    );
  }

  private Map<String, String> featuredCourse() {
    return Map.of(
      "name", "Docker Containers y Orquestación con Kubernetes"
    );
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
