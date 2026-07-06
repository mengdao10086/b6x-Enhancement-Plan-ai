package a;

import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ro1 implements c90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g82 f7320a;

    public ro1(g82 g82Var) {
        this.f7320a = g82Var;
    }

    @Override // a.c90
    public void a(List<n30> list, boolean[] zArr) {
        String strE;
        f92.d(list, "selected");
        f92.d(zArr, "status");
        n30 n30Var = (n30) i52.C(list);
        if (n30Var == null || (strE = n30Var.e()) == null) {
            return;
        }
        if (strE.length() == 0) {
            this.f7320a.f(0);
        } else {
            this.f7320a.f(Integer.valueOf(Integer.parseInt(strE)));
        }
    }
}
