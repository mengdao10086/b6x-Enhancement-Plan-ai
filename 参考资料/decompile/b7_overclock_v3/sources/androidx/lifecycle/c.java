package androidx.lifecycle;

import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
@g.v0(26)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final c f6174a = new c();

    public final long a(@yt.k Duration timeout) {
        kotlin.jvm.internal.f0.p(timeout, "timeout");
        return timeout.toMillis();
    }
}
