package id.co.nds.project.demo.utils;

public class validationUtil {
  public static boolean isEmpty(String content) {
    if (content == null || content.isEmpty() || content.isBlank()) {
      return true;
    } else
      return false;
  }

  public static boolean isEmpty(Integer content) {
    if (content == null) {
      return true;
    } else
      return false;
  }
}
