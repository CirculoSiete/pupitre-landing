package pupitre.ui.service;

import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;
import pupitre.apiclient.*;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Slf4j
@Singleton
public class CourseService {
  private final CoursesClient client;

  public CourseService(CoursesClient client) {
    this.client = client;
  }

  public Flowable<List<AwesomeCourse>> awesome() {
    log.info("Retrieving Awesome Courses from Pupitre");
    return client.awesome();
  }

  public List<Map<String, String>> awesome(List<AwesomeCourse> awesome) {
    log.info("Mapping Awesome courses from Pupitre model to UI");
    var counter = new AtomicInteger(6);
    return awesome.stream()
      .map(awesomeCourse -> {
        //TODO: split the text
        String text1 = awesomeCourse.getText();
        String text2 = "";
        String index = "rs-170" + counter.getAndIncrement();
        //TODO: fix the length (use a <br>)
        var caption = awesomeCourse.getCaption();
        return Map.of(
          "image", awesomeCourse.getImage(),
          "caption", caption,
          "text1", text1,
          "text2", text2,
          "index", index
        );
      }).collect(toList());
  }

  public Flowable<List<PopularCourse>> popular() {
    log.info("Retrieving popular Courses from Pupitre");
    return client.popular();
  }

  public List<PopularCourse> popular(List<PopularCourse> popular) {
    log.info("Mapping Popular courses from Pupitre model to UI");
    return popular.stream()
      .peek(popularCourse -> {
        //TODO: set this values
        popularCourse.setDetailsUrl("#");
        popularCourse.setRegisterUrl("#");
      })
      .collect(toList());
  }

  public List<FeaturedCourse> featuredCourse() {
    var featured = client.featured();

    if (featured.size() > 0) {
      var rand = new Random();
      var featuredCourse = featured.get(rand.nextInt(featured.size()));
      return List.of(featuredCourse);
    }

    return emptyList();
  }

  public List<Event> events() {
    return client.events().stream()
      .peek(event -> {
        //TODO: set this value
        event.setUrl("#");
      })
      .collect(toList());
  }

  public List<Instructor> instructors() {
    return client.instructors().stream()
      .peek(instructor -> {
        //TODO: set this value
        instructor.setProfileUrl("#");
      }).collect(toList());
  }

  public List<Review> testimonials() {
    return client.testimonials();
  }
}
