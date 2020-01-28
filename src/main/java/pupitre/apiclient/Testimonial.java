package pupitre.apiclient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Testimonial {
  private String company;
  private String content;
  private String image;
  private String name;
}
