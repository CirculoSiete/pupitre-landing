package pupitre.apiclient;

import io.micronaut.discovery.exceptions.DiscoveryException;
import io.micronaut.retry.annotation.Fallback;

import javax.inject.Singleton;
import java.util.List;

import static java.util.Collections.emptyList;

@Singleton
@Fallback(includes = {DiscoveryException.class})
public class CoursesClientFallback implements PupitreOperations {
  @Override
  public List<AwesomeCourse> awesome() {
    return emptyList();
  }

  @Override
  public List<PopularCourse> popular() {
    return emptyList();
  }

  @Override
  public List<FeaturedCourse> featured() {
    return emptyList();
  }

  @Override
  public List<Event> events() {
    return emptyList();
  }

  @Override
  public List<Instructor> instructors() {
    return emptyList();
  }

  @Override
  public List<Testimonial> testimonials() {
    return emptyList();
  }
}
