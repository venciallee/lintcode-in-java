package com.bytetree.lintcode.design.ood;

import java.util.HashMap;
import java.util.Map;

/**
 * 566. GFS Client
 * <p>
 * Implement a simple client for GFS (Google File System, a distributed file system), it provides the following methods:
 * <p>
 * read(filename). Read the file with given filename from GFS.
 * write(filename, content). Write a file with given filename & content to GFS.
 * There are two private methods that already implemented in the base class:
 * <p>
 * readChunk(filename, chunkIndex). Read a chunk from GFS.
 * writeChunk(filename, chunkIndex, chunkData). Write a chunk to GFS.
 * To simplify this question, we can assume that the chunk size is chunkSize bytes. (In a real world system, it is 64M). The GFS Client's job is splitting a file into multiple chunks (if need) and save to the remote GFS server. chunkSize will be given in the constructor. You need to call these two private methods to implement read & write methods.
 * <p>
 * Example
 * GFSClient(5)
 * read("a.txt")
 * >> null
 * write("a.txt", "World")
 * >> You don't need to return anything, but you need to call writeChunk("a.txt", 0, "World") to write a 5 bytes chunk to GFS.
 * read("a.txt")
 * >> "World"
 * write("b.txt", "111112222233")
 * >> You need to save "11111" at chink 0, "22222" at chunk 1, "33" at chunk 2.
 * write("b.txt", "aaaaabbbbb")
 * read("b.txt")
 * >> "aaaaabbbbb"
 * <p>
 * <a href="https://www.lintcode.com/problem/gfs-client/description">566. GFS Client</a>
 * <p>
 * Created by vencial on 2019-10-10.
 */
public class GFSClient extends BaseGFSClient {

    private Map<String, Integer> map;
    private int chunkSize;

    /*
     * @param chunkSize: An integer
     */
    public GFSClient(int chunkSize) {
        // do intialization if necessary
        this.map = new HashMap<>();
        this.chunkSize = chunkSize;
    }

    /*
     * @param filename: a file name
     * @return: conetent of the file given from GFS
     */
    public String read(String filename) {
        // write your code here
        if (!map.containsKey(filename)) {
            return null;
        }
        int chunk = map.get(filename);
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < chunk; i++) {
            String content = readChunk(filename, i);
            if (content != null) {
                sbuf.append(content);
            }
        }
        return sbuf.toString();
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        // write your code here
        int length = content.length();
        int chunk = (length - 1) / chunkSize + 1;
        map.put(filename, chunk);
        for (int i = 0; i < chunk; i++) {
            int start = i * chunkSize;
            int end = i == chunk - 1 ? length : (i + 1) * chunkSize;
            String subContent = content.substring(start, end);
            writeChunk(filename, i, subContent);
        }

    }
}

class BaseGFSClient {
    private Map<String, String> chunk_list;

    public BaseGFSClient() {
    }

    public String readChunk(String filename, int chunkIndex) {
        // Read a chunk from GFS
        return "";
    }

    public void writeChunk(String filename, int chunkIndex,
                           String content) {
        // Write a chunk to GFS
    }
}
