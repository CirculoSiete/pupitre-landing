package pupitre.ui.service;

import pupitre.apiclient.*;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

@Singleton
public class CourseService {
  private final CoursesClient client;

  public CourseService(CoursesClient client) {
    this.client = client;
  }

  public List<Map<String, String>> awesome() {
    List<AwesomeCourse> awesome = client.awesome();
    AtomicInteger counter = new AtomicInteger(6);
    return awesome.stream()
      .map(awesomeCourse -> {
        //TODO: split the text
        String text1 = awesomeCourse.getText();
        String text2 = "";
        String index = "rs-170" + counter.getAndIncrement();
        //TODO: fix the length (use a <br>)
        String caption = awesomeCourse.getCaption();
        return Map.of(
          "image", awesomeCourse.getImage(),
          "caption", caption,
          "text1", text1,
          "text2", text2,
          "index", index
        );
      }).collect(toList());
  }

  public List<PopularCourse> popular() {
    return client.popular().stream()
      .peek(popularCourse -> {
        //TODO: set this values
        popularCourse.setDetailsUrl("#");
        popularCourse.setRegisterUrl("#");
      })
      .collect(toList());
  }

  public FeaturedCourse featuredCourse() {
    return client.featured();
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

  public List<Testimonial> testimonials() {
    return client.testimonials();
  }
}
