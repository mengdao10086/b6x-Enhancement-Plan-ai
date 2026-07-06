package a;

import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fi1 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gi1 f6110a;

    public fi1(gi1 gi1Var) {
        this.f6110a = gi1Var;
    }

    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        String strE;
        f92.d(list, "selected");
        f92.d(zArr, "status");
        n30 n30Var = (n30) i52.C(list);
        if (n30Var == null || (strE = n30Var.e()) == null) {
            return;
        }
        u90.b(this.f6110a, strE, null, 2, null);
    }
}
