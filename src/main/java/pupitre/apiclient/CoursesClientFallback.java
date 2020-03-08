package pupitre.apiclient;

import io.micronaut.discovery.exceptions.DiscoveryException;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.List;

import static io.reactivex.Flowable.just;
import static java.util.Collections.emptyList;

@Slf4j
@Singleton
@Fallback(includes = {DiscoveryException.class})
public class CoursesClientFallback implements PupitreOperations {
  @Override
  public Flowable<List<AwesomeCourse>> awesome() {
    log.warn("awesome courses");
    return just(emptyList());
  }

  @Override
  public Flowable<List<PopularCourse>> popular() {
    log.warn("popular courses");
    return just(emptyList());
  }

  @Override
  public Flowable<List<FeaturedCourse>> featured() {
    log.warn("Featured courses");
    return just(emptyList());
  }

  @Override
  public Flowable<List<Event>> events() {
    log.warn("Events");
    return just(emptyList());
  }

  @Override
  public Flowable<List<Instructor>> instructors() {
    log.warn("Instructors");
    return just(emptyList());
  }

  @Override
  public Flowable<List<Review>> testimonials() {
    log.warn("Reviews");
    return just(emptyList());
  }
}
