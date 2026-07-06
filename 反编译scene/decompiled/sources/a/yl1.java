package a;

import a.p80;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yl1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nm1 f7993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f3745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3746a;

    public yl1(nm1 nm1Var, p80.b bVar, String str) {
        this.f7993a = nm1Var;
        this.f3745a = bVar;
        this.f3746a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7993a.k(this.f3745a, this.f3746a, true);
    }
}
