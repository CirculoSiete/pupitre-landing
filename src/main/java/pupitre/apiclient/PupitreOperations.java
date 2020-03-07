package pupitre.apiclient;

import io.reactivex.Flowable;

import java.util.List;

public interface PupitreOperations {
  Flowable<List<AwesomeCourse>> awesome();

  List<PopularCourse> popular();

  List<FeaturedCourse> featured();

  List<Event> events();

  List<Instructor> instructors();

  List<Review> testimonials();
}
