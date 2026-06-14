package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vs0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ws0 f7720a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vs0(ws0 ws0Var) {
        super(1);
        this.f7720a = ws0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("default", "1");
        l30Var.E("path", "variance_adjust");
        l30Var.E("type", "select");
        ArrayList arrayListC = y42.c(new l30(new ss0(this)), new l30(new ts0(this)), new l30(new us0(this)));
        if (this.f7720a.f7818a.f600b) {
            arrayListC.add(new l30(new rs0(this)));
        }
        m42 m42Var = m42.f6769a;
        l30Var.D("options", arrayListC);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
