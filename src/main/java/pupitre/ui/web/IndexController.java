package pupitre.ui.web;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller("/")
public class IndexController {
  @Get
  public ModelAndView index(HttpRequest<?> request) {
    var items = List.of(
      Map.of(
        "index", "rs-1706",
        "image", "/images/nivo-1.jpg",
        "text1", "Desarrollo de Microservicios",
        "text2", "Cloud Native",
        "caption", "Aprende los principios de Cloud Native y como aplicarlos <br> para desarrollar microservicios en Java con Spring Boot."
      )/*,
      Map.of(
        "index", "rs-1707",
        "image", "/images/nivo-2.jpg",
        "text1", "Take the first step to",
        "text2", "learn with us",
        "caption", "Lorem ipsum dolor sit amet, consectetur elit, sed do <br> eiusmod tempor incididunt ut laboreet dolore magna aliqua."
      ),
      Map.of(
        "index", "rs-1708",
        "image", "/images/nivo-3.jpg",
        "text1", "Are you ready to",
        "text2", "apply?",
        "caption", "Lorem ipsum dolor sit amet, consectetur elit, sed do <br> eiusmod tempor incididunt ut laboreet dolore magna aliqua."
      )*/
    );
    var dataToRender = Map.of(
      "sliderItems", items
    );

    return new ModelAndView("index", dataToRender);
  }
}
