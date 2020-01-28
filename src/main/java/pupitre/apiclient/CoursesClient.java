package pupitre.apiclient;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client("pupitre")
public interface CoursesClient {
  @Get("/v1/courses/awesome")
  List<AwesomeCourse> awesome();
}
