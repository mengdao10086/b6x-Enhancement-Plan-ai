package kotlin.io;

import java.io.Closeable;
import java.io.IOException;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.s0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "CloseableKt")
public final class b {
    @v0(version = "1.1")
    @s0
    public static final void a(@yt.l Closeable closeable, @yt.l Throwable th2) {
        if (closeable != null) {
            if (th2 == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th3) {
                o.a(th2, th3);
            }
        }
    }

    @bk.f
    public static final <T extends Closeable, R> R b(T t10, ik.l<? super T, ? extends R> block) throws IOException {
        f0.p(block, "block");
        try {
            R rI = block.i(t10);
            c0.d(1);
            if (bk.m.a(1, 1, 0)) {
                a(t10, null);
            } else if (t10 != null) {
                t10.close();
            }
            c0.c(1);
            return rI;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                c0.d(1);
                if (bk.m.a(1, 1, 0)) {
                    a(t10, th2);
                } else if (t10 != null) {
                    try {
                        t10.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th3;
            }
        }
    }
}
