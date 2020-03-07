package pupitre.apiclient;

import io.micronaut.discovery.exceptions.DiscoveryException;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.List;

import static java.util.Collections.emptyList;

@Slf4j
@Singleton
@Fallback(includes = {DiscoveryException.class})
public class CoursesClientFallback implements PupitreOperations {
  @Override
  public Flowable<List<AwesomeCourse>> awesome() {
    return Flowable.just(emptyList());
  }

  @Override
  public List<PopularCourse> popular() {
    log.warn("popular courses");
    return emptyList();
  }

  @Override
  public List<FeaturedCourse> featured() {
    log.warn("Featured courses");
    return emptyList();
  }

  @Override
  public List<Event> events() {
    log.warn("Events");
    return emptyList();
  }

  @Override
  public List<Instructor> instructors() {
    log.info("Instructors");
    return emptyList();
  }

  @Override
  public List<Review> testimonials() {
    log.info("Reviews");
    return emptyList();
  }
}
