package fk;

import bk.f;
import hk.h;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.s0;
import kotlin.v0;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "AutoCloseableKt")
public final class a {
    @v0(version = "1.2")
    @s0
    public static final void a(@l AutoCloseable autoCloseable, @l Throwable th2) throws Exception {
        if (autoCloseable != null) {
            if (th2 == null) {
                autoCloseable.close();
                return;
            }
            try {
                autoCloseable.close();
            } catch (Throwable th3) {
                o.a(th2, th3);
            }
        }
    }

    @f
    @v0(version = "1.2")
    public static final <T extends AutoCloseable, R> R b(T t10, ik.l<? super T, ? extends R> block) throws Exception {
        f0.p(block, "block");
        try {
            R rI = block.i(t10);
            c0.d(1);
            a(t10, null);
            c0.c(1);
            return rI;
        } finally {
        }
    }
}
