package home.solmaz.tinyProject.utility;

import java.util.List;

public interface FormatAble<T> {
    List<String> format(List<T> content,String [] header,String [] footer);
}
