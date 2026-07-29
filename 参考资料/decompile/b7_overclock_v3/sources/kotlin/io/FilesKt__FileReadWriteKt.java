package kotlin.io;

import ik.p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import qk.v;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nFileReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,232:1\n231#1:234\n1#2:233\n1#2:235\n*S KotlinDebug\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n*L\n230#1:234\n230#1:235\n*E\n"})
public class FilesKt__FileReadWriteKt extends j {
    @bk.f
    public static final InputStreamReader A(File file, Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static /* synthetic */ InputStreamReader B(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static final <T> T C(@yt.k File file, @yt.k Charset charset, @yt.k ik.l<? super kotlin.sequences.m<String>, ? extends T> block) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        f0.p(block, "block");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            T tI = block.i(TextStreamsKt.h(bufferedReader));
            c0.d(1);
            b.a(bufferedReader, null);
            c0.c(1);
            return tI;
        } finally {
        }
    }

    public static /* synthetic */ Object D(File file, Charset charset, ik.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            Object objI = lVar.i(TextStreamsKt.h(bufferedReader));
            c0.d(1);
            b.a(bufferedReader, null);
            c0.c(1);
            return objI;
        } finally {
        }
    }

    public static final void E(@yt.k File file, @yt.k byte[] array) {
        f0.p(file, "<this>");
        f0.p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            z1 z1Var = z1.f38230a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void F(@yt.k File file, @yt.k String text, @yt.k Charset charset) {
        f0.p(file, "<this>");
        f0.p(text, "text");
        f0.p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        E(file, bytes);
    }

    public static /* synthetic */ void G(File file, String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        F(file, str, charset);
    }

    @bk.f
    public static final OutputStreamWriter H(File file, Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static /* synthetic */ OutputStreamWriter I(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static final void g(@yt.k File file, @yt.k byte[] array) {
        f0.p(file, "<this>");
        f0.p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(array);
            z1 z1Var = z1.f38230a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void h(@yt.k File file, @yt.k String text, @yt.k Charset charset) {
        f0.p(file, "<this>");
        f0.p(text, "text");
        f0.p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        g(file, bytes);
    }

    public static /* synthetic */ void i(File file, String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        h(file, str, charset);
    }

    @bk.f
    public static final BufferedReader j(File file, Charset charset, int i10) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i10);
    }

    public static /* synthetic */ BufferedReader k(File file, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i10);
    }

    @bk.f
    public static final BufferedWriter l(File file, Charset charset, int i10) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i10);
    }

    public static /* synthetic */ BufferedWriter m(File file, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void n(@yt.k File file, int i10, @yt.k p<? super byte[], ? super Integer, z1> action) {
        f0.p(file, "<this>");
        f0.p(action, "action");
        ?? r22 = new byte[v.u(i10, 512)];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i11 = fileInputStream.read(r22);
                if (i11 <= 0) {
                    z1 z1Var = z1.f38230a;
                    b.a(fileInputStream, null);
                    return;
                }
                action.r0(r22, Integer.valueOf(i11));
            } finally {
            }
        }
    }

    public static final void o(@yt.k File file, @yt.k p<? super byte[], ? super Integer, z1> action) {
        f0.p(file, "<this>");
        f0.p(action, "action");
        n(file, 4096, action);
    }

    public static final void p(@yt.k File file, @yt.k Charset charset, @yt.k ik.l<? super String, z1> action) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        f0.p(action, "action");
        TextStreamsKt.g(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), action);
    }

    public static /* synthetic */ void q(File file, Charset charset, ik.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        p(file, charset, lVar);
    }

    @bk.f
    public static final FileInputStream r(File file) {
        f0.p(file, "<this>");
        return new FileInputStream(file);
    }

    @bk.f
    public static final FileOutputStream s(File file) {
        f0.p(file, "<this>");
        return new FileOutputStream(file);
    }

    @bk.f
    public static final PrintWriter t(File file, Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    public static /* synthetic */ PrintWriter u(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    @yt.k
    public static final byte[] v(@yt.k File file) {
        f0.p(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i10 = (int) length;
            byte[] bArrW0 = new byte[i10];
            int i11 = i10;
            int i12 = 0;
            while (i11 > 0) {
                int i13 = fileInputStream.read(bArrW0, i12, i11);
                if (i13 < 0) {
                    break;
                }
                i11 -= i13;
                i12 += i13;
            }
            if (i11 > 0) {
                bArrW0 = Arrays.copyOf(bArrW0, i12);
                f0.o(bArrW0, "copyOf(this, newSize)");
            } else {
                int i14 = fileInputStream.read();
                if (i14 != -1) {
                    f fVar = new f(8193);
                    fVar.write(i14);
                    a.l(fileInputStream, fVar, 0, 2, null);
                    int size = fVar.size() + i10;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrA = fVar.a();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrW0, size);
                    f0.o(bArrCopyOf, "copyOf(this, newSize)");
                    bArrW0 = kotlin.collections.m.W0(bArrA, bArrCopyOf, i10, 0, fVar.size());
                }
            }
            b.a(fileInputStream, null);
            return bArrW0;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                b.a(fileInputStream, th2);
                throw th3;
            }
        }
    }

    @yt.k
    public static final List<String> w(@yt.k File file, @yt.k Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        final ArrayList arrayList = new ArrayList();
        p(file, charset, new ik.l<String, z1>() { // from class: kotlin.io.FilesKt__FileReadWriteKt$readLines$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(@yt.k String it2) {
                f0.p(it2, "it");
                arrayList.add(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        });
        return arrayList;
    }

    public static /* synthetic */ List x(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        return w(file, charset);
    }

    @yt.k
    public static final String y(@yt.k File file, @yt.k Charset charset) {
        f0.p(file, "<this>");
        f0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strK = TextStreamsKt.k(inputStreamReader);
            b.a(inputStreamReader, null);
            return strK;
        } finally {
        }
    }

    public static /* synthetic */ String z(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        return y(file, charset);
    }
}
