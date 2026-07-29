package kotlinx.coroutines.debug.internal;

import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class i implements zj.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final zj.c f38459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final StackTraceElement f38460b;

    public i(@l zj.c cVar, @k StackTraceElement stackTraceElement) {
        this.f38459a = cVar;
        this.f38460b = stackTraceElement;
    }

    @Override // zj.c
    @k
    public StackTraceElement D() {
        return this.f38460b;
    }

    @Override // zj.c
    @l
    public zj.c r() {
        return this.f38459a;
    }
}
