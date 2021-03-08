package home.solmaz.tinyProject.utility;

import java.util.List;
import java.util.Optional;

public interface ReadAble {
    Optional<List<String>> readFromSource(String sourcePath);
}
