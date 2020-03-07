package pupitre.apiclient;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.reactivex.Flowable;

import java.util.List;

@CircuitBreaker
@Client("pupitre")
public interface CoursesClient extends PupitreOperations {
  @Get("/v1/courses/highlighted")
  Flowable<List<AwesomeCourse>> awesome();

  @Get("/v1/courses/popular")
  Flowable<List<PopularCourse>> popular();

  @Get("/v1/courses/featured")
  Flowable<List<FeaturedCourse>> featured();

  @Get("/v1/courses/events")
  List<Event> events();

  @Get("/v1/courses/instructors")
  List<Instructor> instructors();

  @Get("/v1/reviews")
  List<Review> testimonials();
}
