package minhquan.com.common.impl;

import minhquan.com.common.IFileHandling;

import java.io.*;


public class FileHandling implements IFileHandling {
    private BufferedInputStream inBuffer;

    private BufferedOutputStream outBuffer;

    private ObjectOutputStream objOut;
    private ObjectInputStream objIn;


    @Override
    public void writeFile(String path, String content) {
        try {
            outBuffer = new BufferedOutputStream(new FileOutputStream(path));
            outBuffer.write(content.getBytes());
            outBuffer.flush();
            outBuffer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void writeObject(String path, Object object) {
        try {
            this.objOut = new ObjectOutputStream(new FileOutputStream(path));
            this.objOut.writeObject(object);
            this.objOut.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public String readFile(String path) {
        StringBuilder builder = new StringBuilder("");
        try {
            inBuffer = new BufferedInputStream(new FileInputStream(path));
            int bytesRead;
            byte[] buffer = new byte[1024];

            while ((bytesRead = inBuffer.read(buffer)) != -1) {
                builder.append((char) bytesRead);
            }
            inBuffer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return builder.toString();
    }

    @Override
    public Object readObject(String path) {
        try {
            this.objIn = new ObjectInputStream(new FileInputStream(path));
            return this.objIn.readObject();
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
