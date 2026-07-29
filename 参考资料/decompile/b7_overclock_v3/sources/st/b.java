package st;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static void a(File file, CharSequence charSequence) throws IOException {
        p(file, "UTF-8", charSequence, true);
    }

    public static void b(File file, File file2) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            try {
                c.a(bufferedInputStream, bufferedOutputStream);
            } finally {
                c.j(bufferedOutputStream);
            }
        } finally {
            c.j(bufferedInputStream);
        }
    }

    public static void c(String str, String str2) throws IOException {
        b(new File(str), new File(str2));
    }

    public static void d(File file) throws IOException {
        File fileF = f(file, true);
        if (fileF == null) {
            return;
        }
        throw new IOException("Could not delete file: " + fileF.getPath());
    }

    public static boolean e(File file) {
        f(file, false);
        return !file.exists();
    }

    public static File f(File file, boolean z10) {
        File[] fileArrListFiles;
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                File fileF = f(file2, z10);
                if (z10 && fileF != null) {
                    return fileF;
                }
            }
            if (!file2.delete() && z10 && file2.exists()) {
                return file2;
            }
        }
        if (!file.delete() && z10 && file.exists()) {
            return file;
        }
        return null;
    }

    public static String g(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            return c.c(bufferedInputStream);
        } finally {
            c.j(bufferedInputStream);
        }
    }

    public static String h(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            return c.d(bufferedInputStream);
        } finally {
            c.j(bufferedInputStream);
        }
    }

    public static String i(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            return c.e(bufferedInputStream);
        } finally {
            c.j(bufferedInputStream);
        }
    }

    public static byte[] j(File file) throws IOException {
        return c.g(new FileInputStream(file));
    }

    public static String k(File file, String str) throws IOException {
        return c.i(new InputStreamReader(new FileInputStream(file), str));
    }

    public static <T> T l(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            return (T) objectInputStream.readObject();
        } finally {
            c.j(objectInputStream);
        }
    }

    public static String m(File file) throws IOException {
        return k(file, "UTF-8");
    }

    public static void n(File file, Checksum checksum) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            c.k(bufferedInputStream, checksum);
        } finally {
            c.j(bufferedInputStream);
        }
    }

    public static void o(File file, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
        } finally {
            c.j(fileOutputStream);
        }
    }

    public static void p(File file, String str, CharSequence charSequence, boolean z10) throws IOException {
        c.l(new OutputStreamWriter(new FileOutputStream(file, z10), str), charSequence);
    }

    public static void q(File file, Object obj) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            fileOutputStream.getFD().sync();
        } finally {
            c.j(objectOutputStream);
        }
    }

    public static void r(File file, CharSequence charSequence) throws IOException {
        p(file, "UTF-8", charSequence, false);
    }
}
