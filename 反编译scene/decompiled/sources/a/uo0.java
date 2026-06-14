package a;

import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uo0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vo0 f7617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ HashMap f3200a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uo0(vo0 vo0Var, String str, HashMap map) {
        super(1);
        this.f7617a = vo0Var;
        this.f3199a = str;
        this.f3200a = map;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("id", this.f3199a);
        l30Var.G("map", new qo0(this));
        l30Var.G("fields", ro0.f7319a);
        l30Var.G("array", new so0(this));
        l30Var.G("spf", new to0(this));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
