package a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class o72 extends m72 {
    public static final void a(File file, Charset charset, g82<? super String, m42> g82Var) {
        f92.d(file, "$this$forEachLine");
        f92.d(charset, "charset");
        f92.d(g82Var, "action");
        t72.c(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), g82Var);
    }

    public static final byte[] b(File file) {
        f92.d(file, "$this$readBytes");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i = (int) length;
            byte[] bArrCopyOf = new byte[i];
            int i2 = i;
            int i3 = 0;
            while (i2 > 0) {
                int i4 = fileInputStream.read(bArrCopyOf, i3, i2);
                if (i4 < 0) {
                    break;
                }
                i2 -= i4;
                i3 += i4;
            }
            if (i2 > 0) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i3);
                f92.c(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            } else {
                int i5 = fileInputStream.read();
                if (i5 != -1) {
                    l72 l72Var = new l72(8193);
                    l72Var.write(i5);
                    j72.b(fileInputStream, l72Var, 0, 2, null);
                    int size = l72Var.size() + i;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrA = l72Var.a();
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, size);
                    f92.c(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                    s42.c(bArrA, bArrCopyOf, i, 0, l72Var.size());
                }
            }
            k72.a(fileInputStream, null);
            return bArrCopyOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                k72.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final List<String> c(File file, Charset charset) {
        f92.d(file, "$this$readLines");
        f92.d(charset, "charset");
        ArrayList arrayList = new ArrayList();
        a(file, charset, new n72(arrayList));
        return arrayList;
    }

    public static final String d(File file, Charset charset) {
        f92.d(file, "$this$readText");
        f92.d(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strE = t72.e(inputStreamReader);
            k72.a(inputStreamReader, null);
            return strE;
        } finally {
        }
    }

    public static final void e(File file, byte[] bArr) {
        f92.d(file, "$this$writeBytes");
        f92.d(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            m42 m42Var = m42.f6769a;
            k72.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void f(File file, String str, Charset charset) {
        f92.d(file, "$this$writeText");
        f92.d(str, "text");
        f92.d(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        e(file, bytes);
    }

    public static /* synthetic */ void g(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = bb2.f5692a;
        }
        f(file, str, charset);
    }
}
