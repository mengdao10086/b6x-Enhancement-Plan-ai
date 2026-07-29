package z3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import ya.g;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f57727a = Charset.forName(g.f56707m);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f57728b = Charset.forName("UTF-8");

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static void b(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                b(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    public static String c(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int i10 = reader.read(cArr);
                if (i10 == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, i10);
            }
        } finally {
            reader.close();
        }
    }
}
