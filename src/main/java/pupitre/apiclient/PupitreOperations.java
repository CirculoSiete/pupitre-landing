package pupitre.apiclient;

import io.reactivex.Flowable;

import java.util.List;

public interface PupitreOperations {
  Flowable<List<AwesomeCourse>> awesome();

  Flowable<List<PopularCourse>> popular();

  Flowable<List<FeaturedCourse>> featured();

  Flowable<List<Event>> events();

  List<Instructor> instructors();

  List<Review> testimonials();
}
