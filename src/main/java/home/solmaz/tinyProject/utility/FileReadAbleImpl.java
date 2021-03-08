package home.solmaz.tinyProject.utility;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReadAbleImpl implements ReadAble {

    public Optional<List<String>> readFromSource(String sourcePath) {
        Path path = Paths.get(sourcePath);
        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            return Optional.of(stream.collect(Collectors.toList()));
        } catch (IOException e) {

            e.printStackTrace();
            return Optional.empty();
        }
    }
}
