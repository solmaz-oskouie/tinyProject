package home.solmaz.tinyProject.utility;

import java.io.IOException;
import java.util.List;

public interface WriteAble<T> {
    void writeToSource(String path, List<T> infoList) throws IOException;
}
