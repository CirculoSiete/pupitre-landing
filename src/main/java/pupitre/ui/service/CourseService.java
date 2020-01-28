package pupitre.ui.service;

import pupitre.apiclient.AwesomeCourse;
import pupitre.apiclient.CoursesClient;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        String text1 = awesomeCourse.getText();
        String text2 = "";
        String index = "rs-170" + counter.getAndIncrement();
        return Map.of(
          "image", awesomeCourse.getImage(),
          "caption", awesomeCourse.getCaption(),
          "text1", text1,
          "text2", text2,
          "index", index
        );
      }).collect(Collectors.toList());
  }
}
