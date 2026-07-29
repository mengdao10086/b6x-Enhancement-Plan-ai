package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class f extends ByteArrayOutputStream {
    public f(int i10) {
        super(i10);
    }

    @yt.k
    public final byte[] a() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        f0.o(buf, "buf");
        return buf;
    }
}
