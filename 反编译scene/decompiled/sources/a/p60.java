package a;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p60<V> implements Callable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q60 f7089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2398a;

    public p60(q60 q60Var, String str) {
        this.f7089a = q60Var;
        this.f2398a = str;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean call() {
        return Boolean.valueOf(e50.f677a.i0(this.f2398a, this.f7089a.b()));
    }
}
