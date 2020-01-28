package pupitre.ui.web;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import lombok.extern.slf4j.Slf4j;
import pupitre.apiclient.CoursesClient;
import pupitre.ui.service.CourseService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller("/")
public class IndexController {

  private final CourseService courseService;

  public IndexController(CourseService courseService) {
    this.courseService = courseService;
  }
  @Get
  public ModelAndView index(HttpRequest<?> request) {
    var dataToRender = Map.of(
      "sliderItems", courseService.awesome(),
      "courses", popularCourses(),
      "featuredCourse", featuredCourse(),
      "events", events(),
      "instructors", instructors(),
      "tour", tour(),
      "testimonials", testimonials()
    );

    return new ModelAndView("index", dataToRender);
  }

  private List testimonials() {
    return List.of(
      testimonial(
        "/images/team/team-01.jpg",
        "Devid Martin",
        "Guardian",
        "I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was " +
          "born and I will give you a complete account of the system, and expound the actual teachings of the " +
          "great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, " +
          "or avoids pleasure itself"
      )
    );
  }

  private Map testimonial(String image, String name, String company, String content) {
    return Map.of(
      "image", image,
      "name", name,
      "company", company,
      "content", content
    );
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
