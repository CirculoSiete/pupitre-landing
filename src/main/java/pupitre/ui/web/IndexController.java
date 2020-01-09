package pupitre.ui.web;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Controller("/")
public class IndexController {
  @Get
  public ModelAndView index(HttpRequest<?> request) {
    var dataToRender = Map.of(
      "user", ""
    );

    return new ModelAndView("index", dataToRender);
  }
}
