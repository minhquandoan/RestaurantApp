package minhquan.com.db;

import minhquan.com.entity.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MenuDB {
    private static List<Menu> storage;

    private static MenuDB instance;

    private MenuDB() {
        storage = new ArrayList<>();
    }

    public static MenuDB getInstance() {
        if (instance == null) {
            instance = new MenuDB();
        }
        return instance;
    }

    public List<Menu> getStorage() {
        return storage;
    }

    public int getSize() {
        return storage.size();
    }
}
