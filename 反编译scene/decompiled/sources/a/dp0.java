package a;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dp0<V> implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mp0 f5924a;

    public dp0(mp0 mp0Var) {
        this.f5924a = mp0Var;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String call() {
        return this.f5924a.s(no0.f6937a.a() + "/scene-announcement", "");
    }
}
