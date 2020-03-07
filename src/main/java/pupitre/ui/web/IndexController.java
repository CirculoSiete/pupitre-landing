package pupitre.ui.web;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import pupitre.ui.service.CourseService;

import java.util.Map;

import static io.reactivex.Flowable.zip;

@Slf4j
@Controller("/")
public class IndexController {

  private final CourseService courseService;

  public IndexController(CourseService courseService) {
    this.courseService = courseService;
  }

  @Get
  public ModelAndView index(HttpRequest<?> request) {
    log.info("Loading index page");

    var mapFlowable = zip(
      courseService.awesome(),
      courseService.popular(),
      (awesomeCourses, popularCourses) ->
        Map.of(
          "sliderItems", courseService.awesome(awesomeCourses),
          "courses", courseService.popular(popularCourses),

          "featuredCourse", courseService.featuredCourse(),
          "events", courseService.events(),
          "instructors", courseService.instructors(),
          "tour", tour(),
          "testimonials", courseService.testimonials()
        )).observeOn(Schedulers.io());
    var dataToRender = mapFlowable.blockingFirst();

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
}
