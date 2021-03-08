package home.solmaz.tinyProject.utility;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileWriteAbleImpl implements WriteAble<String> {

    @Override
    public void writeToSource(String source, List<String> infoList) throws IOException {
        Path path = Paths.get(source);
        Charset charset = StandardCharsets.UTF_8;
        Files.write(path,infoList,charset);
    }
}
