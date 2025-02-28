package ru.mihozhereb.io;

import com.google.gson.Gson;
import ru.mihozhereb.collection.model.MusicBand;

import java.io.File;

/**
 * JsonParser for storage file with MusicBands objects in json format
 */
public class JsonWorker implements IOWorker<MusicBand[]> {
    private final String path;

    public JsonWorker(String path) {
        this.path = path;
    }

    /**
     * @param elements Collection of MusicBand's elements
     * @see MusicBand
     */
    @Override
    public void write(MusicBand[] elements) {
        Gson gson = new Gson();
        JsonBase base = new JsonBase(elements);

        FileWorker fileWorker = new FileWorker(path, false);
        fileWorker.write(gson.toJson(base));
    }

    /**
     * @return Collection of MusicBands
     */
    @Override
    public MusicBand[] read() {
        Gson gson = new Gson();

        FileWorker fileWorker = new FileWorker(path, true);

        return gson.fromJson(fileWorker.readAll(), JsonBase.class).elements();
    }

    /**
     * @return Good or bad json file
     */
    @Override
    public Boolean ready() {
        File file = new File(path);
        return !file.isDirectory() && file.exists() && file.canRead() && file.canWrite();
    }

    /**
     * Do nothing
     */
    @Override
    public void close() {

    }
}
