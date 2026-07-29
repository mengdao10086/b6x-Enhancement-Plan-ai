package androidx.core.os;

import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.t0;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    @kotlin.k(message = "Use androidx.tracing.Trace instead", replaceWith = @t0(expression = "trace(sectionName)", imports = {"androidx.tracing.trace"}))
    public static final <T> T a(@yt.k String sectionName, @yt.k ik.a<? extends T> block) {
        f0.p(sectionName, "sectionName");
        f0.p(block, "block");
        y.b(sectionName);
        try {
            return block.o();
        } finally {
            c0.d(1);
            y.d();
            c0.c(1);
        }
    }
}
