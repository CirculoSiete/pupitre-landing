package pupitre.apiclient;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client("pupitre")
public interface CoursesClient {
  @Get("/v1/courses/awesome")
  List<AwesomeCourse> awesome();

  @Get("/v1/courses/popular")
  List<PopularCourse> popular();

  @Get("/v1/courses/featured")
  FeaturedCourse featured();

  @Get("/v1/courses/events")
  List<Event> events();

  @Get("/v1/courses/instructors")
  List<Instructor> instructors();

  @Get("/v1/courses/testimonials")
  List<Testimonial> testimonials();
}
