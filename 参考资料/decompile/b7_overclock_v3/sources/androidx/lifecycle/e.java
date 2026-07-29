package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h2;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Closeable, kotlinx.coroutines.o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final CoroutineContext f6187a;

    public e(@yt.k CoroutineContext context) {
        kotlin.jvm.internal.f0.p(context, "context");
        this.f6187a = context;
    }

    @Override // kotlinx.coroutines.o0
    @yt.k
    public CoroutineContext W() {
        return this.f6187a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h2.i(W(), null, 1, null);
    }
}
