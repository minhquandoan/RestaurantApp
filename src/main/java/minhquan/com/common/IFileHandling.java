package minhquan.com.common;

public interface IFileHandling {
    void writeFile(String path, String content);
    String readFile(String path);

    void writeObject(String path, Object object);
    Object readObject(String path);
}
