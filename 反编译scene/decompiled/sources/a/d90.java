package a;

import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d90 implements c90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g82 f5873a;

    public d90(g82 g82Var) {
        this.f5873a = g82Var;
    }

    @Override // a.c90
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        this.f5873a.f(Integer.valueOf(u42.u(zArr, true)));
    }
}
