package st;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f50513a = 8192;

    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i10 = 0;
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 == -1) {
                return i10;
            }
            outputStream.write(bArr, 0, i11);
            i10 += i11;
        }
    }

    public static byte[] b(InputStream inputStream, String str) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[8192];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, i10);
            }
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String c(InputStream inputStream) throws IOException {
        return pt.c.i(b(inputStream, "MD5"));
    }

    public static String d(InputStream inputStream) throws IOException {
        return pt.c.i(b(inputStream, et.e.f27137f));
    }

    public static String e(InputStream inputStream) throws IOException {
        return pt.c.i(b(inputStream, "SHA-256"));
    }

    public static byte[] f(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] g(InputStream inputStream) throws IOException {
        try {
            return f(inputStream);
        } finally {
            j(inputStream);
        }
    }

    public static String h(Reader reader) throws IOException {
        char[] cArr = new char[4096];
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i10 = reader.read(cArr);
            if (i10 == -1) {
                return sb2.toString();
            }
            sb2.append(cArr, 0, i10);
        }
    }

    public static String i(Reader reader) throws IOException {
        try {
            return h(reader);
        } finally {
            j(reader);
        }
    }

    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void k(InputStream inputStream, Checksum checksum) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return;
            } else {
                checksum.update(bArr, 0, i10);
            }
        }
    }

    public static void l(Writer writer, CharSequence charSequence) throws IOException {
        try {
            writer.append(charSequence);
        } finally {
            j(writer);
        }
    }
}
