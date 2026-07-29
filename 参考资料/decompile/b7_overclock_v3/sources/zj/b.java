package zj;

import kotlin.coroutines.CoroutineContext;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements kotlin.coroutines.c<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final b f58597a = new b();

    @Override // kotlin.coroutines.c
    @k
    public CoroutineContext b() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @k
    public String toString() {
        return "This continuation is already complete";
    }

    @Override // kotlin.coroutines.c
    public void x(@k Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }
}
