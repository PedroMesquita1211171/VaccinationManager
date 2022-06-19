package app.domain.shared;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class CommonMethods {

    private CommonMethods() {
        throw new IllegalStateException("Utility class");
    }

    public static void serializeStore(List<?> list, String path) {
        try (FileOutputStream out = new FileOutputStream(path); ObjectOutputStream outputStream = new ObjectOutputStream(out)) {
            outputStream.writeObject(list);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

}
