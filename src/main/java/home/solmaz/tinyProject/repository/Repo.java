package home.solmaz.tinyProject.repository;

import java.util.List;

public interface Repo<T> {
    List<T> readData();
}
