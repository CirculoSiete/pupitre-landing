package pupitre.apiclient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PopularCourse {
  private String banner;
  private String detailsUrl;
  private String price;
  private String registerUrl;
  private String shortDescription;
  private String shortName;
  private String type;
}
