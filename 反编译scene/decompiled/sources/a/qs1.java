package a;

import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qs1 extends g92 implements v72<fn0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f7235a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qs1(zs1 zs1Var) {
        super(0);
        this.f7235a = zs1Var;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final fn0 i() {
        Context contextP = this.f7235a.p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        return new fn0(contextP);
    }
}
