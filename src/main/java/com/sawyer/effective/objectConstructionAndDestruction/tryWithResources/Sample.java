package com.sawyer.effective.objectConstructionAndDestruction.tryWithResources;

import java.io.*;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 5:44 PM 2019/2/26
 */

public class Sample {

    private final static int BUFFER_SIZE = 256;

    /**
     * try-finally, old way to close resources
     *
     * @param path
     * @return
     * @throws IOException
     */
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    /**
     * try-with-resources, new way to close resources, with resources that implement autoClosable interface
     *
     * @param path
     * @return
     * @throws IOException
     */
    static String firstLineOfFileNew(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    /**
     * try-finally, old way to close resources
     *
     * @param src
     * @param dst
     * @throws IOException
     */
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    /**
     * try-with-resources, new way to close resources
     * @param src
     * @param dst
     * @throws IOException
     */
    static void copyNew(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
