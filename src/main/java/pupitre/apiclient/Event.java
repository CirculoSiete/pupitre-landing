package pupitre.apiclient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Event {
  private String date;
  private String image;
  private String name;
  private String time;
  private String url;
  private String venue;
}
