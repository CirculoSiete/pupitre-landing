package pupitre.apiclient;

import io.reactivex.Flowable;

import java.util.List;

public interface PupitreOperations {
  Flowable<List<AwesomeCourse>> awesome();

  Flowable<List<PopularCourse>> popular();

  Flowable<List<FeaturedCourse>> featured();

  Flowable<List<Event>> events();

  Flowable<List<Instructor>> instructors();

  Flowable<List<Review>> testimonials();
}
