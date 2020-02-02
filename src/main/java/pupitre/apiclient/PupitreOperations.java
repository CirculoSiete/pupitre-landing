package pupitre.apiclient;

import java.util.List;

public interface PupitreOperations {
  List<AwesomeCourse> awesome();

  List<PopularCourse> popular();

  List<FeaturedCourse> featured();

  List<Event> events();

  List<Instructor> instructors();

  List<Testimonial> testimonials();
}
