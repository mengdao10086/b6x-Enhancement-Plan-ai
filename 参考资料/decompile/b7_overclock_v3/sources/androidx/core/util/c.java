package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.AtomicFile;
import g.v0;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nAtomicFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n1#1,84:1\n34#1,13:85\n*S KotlinDebug\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n53#1:85,13\n*E\n"})
@SuppressLint({"ClassVerificationFailure"})
public final class c {
    @yt.k
    @v0(17)
    public static final byte[] a(@yt.k AtomicFile atomicFile) throws IOException {
        kotlin.jvm.internal.f0.p(atomicFile, "<this>");
        byte[] fully = atomicFile.readFully();
        kotlin.jvm.internal.f0.o(fully, "readFully()");
        return fully;
    }

    @yt.k
    @v0(17)
    public static final String b(@yt.k AtomicFile atomicFile, @yt.k Charset charset) throws IOException {
        kotlin.jvm.internal.f0.p(atomicFile, "<this>");
        kotlin.jvm.internal.f0.p(charset, "charset");
        byte[] fully = atomicFile.readFully();
        kotlin.jvm.internal.f0.o(fully, "readFully()");
        return new String(fully, charset);
    }

    public static /* synthetic */ String c(AtomicFile atomicFile, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        return b(atomicFile, charset);
    }

    @v0(17)
    public static final void d(@yt.k AtomicFile atomicFile, @yt.k ik.l<? super FileOutputStream, z1> block) throws IOException {
        kotlin.jvm.internal.f0.p(atomicFile, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            kotlin.jvm.internal.f0.o(stream, "stream");
            block.i(stream);
            kotlin.jvm.internal.c0.d(1);
            atomicFile.finishWrite(stream);
            kotlin.jvm.internal.c0.c(1);
        } catch (Throwable th2) {
            kotlin.jvm.internal.c0.d(1);
            atomicFile.failWrite(stream);
            kotlin.jvm.internal.c0.c(1);
            throw th2;
        }
    }

    @v0(17)
    public static final void e(@yt.k AtomicFile atomicFile, @yt.k byte[] array) throws IOException {
        kotlin.jvm.internal.f0.p(atomicFile, "<this>");
        kotlin.jvm.internal.f0.p(array, "array");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            kotlin.jvm.internal.f0.o(stream, "stream");
            stream.write(array);
            atomicFile.finishWrite(stream);
        } catch (Throwable th2) {
            atomicFile.failWrite(stream);
            throw th2;
        }
    }

    @v0(17)
    public static final void f(@yt.k AtomicFile atomicFile, @yt.k String text, @yt.k Charset charset) throws IOException {
        kotlin.jvm.internal.f0.p(atomicFile, "<this>");
        kotlin.jvm.internal.f0.p(text, "text");
        kotlin.jvm.internal.f0.p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        kotlin.jvm.internal.f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        e(atomicFile, bytes);
    }

    public static /* synthetic */ void g(AtomicFile atomicFile, String str, Charset charset, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.d.f38161b;
        }
        f(atomicFile, str, charset);
    }
}
