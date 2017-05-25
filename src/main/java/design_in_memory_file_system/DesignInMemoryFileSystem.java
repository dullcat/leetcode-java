package design_in_memory_file_system;

import java.lang.reflect.Array;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DesignInMemoryFileSystem {

    /***
     * https://leetcode.com/contest/leetcode-weekly-contest-33/problems/design-in-memory-file-system/
     * Design an in-memory file system to simulate the following functions:

     ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

     mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

     addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

     readContentFromFile: Given a file path, return its content in string format.

     Example:
     Input:
     ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
     [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
     Output:
     [null,[],null,null,["a"],"hello"]

     Note:
     You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
     You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
     You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.
     */
    // Insert your Solution class here
    public class FileSystem {
        class Node {
            String name;
            int type; // 0: folder, 1: file
            String content;
            HashMap<String, Node> list;
        }

        Node root;

        public FileSystem() {
            root = new Node();
            root.name = "/";
            root.type = 0;
            root.list = new HashMap<String, Node>();
        }

        public List<String> ls(String path) {
            Node cur = getNode(path);

            List<String> res = new ArrayList<String>();
            if (cur.type == 0) {
                res.addAll(cur.list.keySet());
            }
            else {
                res.add(cur.name);
            }
            Collections.sort(res);
            return  res;
        }

        private Node getNode(String path) {
            if (path.equals("/")) return root;
            String[] folders = path.split("/");
            Node cur = root;
            for (int i = 1; i<folders.length; i++) {
                String folder = folders[i];
                cur = cur.list.get(folder);
            }
            return cur;
        }

        public void mkdir(String path) {
            String[] folders = path.split("/");
            Node cur = root;
            for (int i = 1; i<folders.length; i++) {
                String folder = folders[i];
                if (!cur.list.containsKey(folder)) {
                    Node newFolder = new Node();
                    newFolder.name = folder;
                    newFolder.type = 0;
                    newFolder.list = new HashMap<String, Node>();
                    cur.list.put(folder, newFolder);
                    cur = newFolder;
                }
                else {
                    cur = cur.list.get(folder);
                }
            }
        }

        public void addContentToFile(String filePath, String content) {
            String[] folders = filePath.split("/");
            Node cur = root;
            for (int i = 1; i<folders.length; i++) {
                String folder = folders[i];
                if (!cur.list.containsKey(folder)) {
                    Node newFile = new Node();
                    newFile.name = folder;
                    newFile.type = 1;
                    newFile.list = null;
                    cur.list.put(folder, newFile);
                    cur = newFile;
                }
                else {
                    cur = cur.list.get(folder);
                }
            }
            cur.content += content;
        }

        public String readContentFromFile(String filePath) {
            Node cur = getNode(filePath);
            return cur.content;
        }
    }

    /**
     * Your FileSystem object will be instantiated and called as such:
     * FileSystem obj = new FileSystem();
     * List<String> param_1 = obj.ls(path);
     * obj.mkdir(path);
     * obj.addContentToFile(filePath,content);
     * String param_4 = obj.readContentFromFile(filePath);
     */

    public static class UnitTest {
        @Test
        public void testDesignInMemoryFileSystem() {
            //Solution s = new DesignInMemoryFileSystem().new Solution();
            FileSystem obj = new DesignInMemoryFileSystem().new FileSystem();
            List<String> param_1 = obj.ls("/");
            obj.mkdir("/a/b/c");
            obj.addContentToFile("/a/b/c/d","hello");
            String param_4 = obj.readContentFromFile("/a/b/c/d");

        }
    }
}

