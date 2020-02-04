package pupitre.apiclient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Review {
  private String id;
  private String company;
  private String content;
  private String image;
  private String name;
  private String shortReview;
  private String courseName;
  private Integer rating;
}
