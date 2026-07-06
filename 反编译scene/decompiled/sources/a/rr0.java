package a;

import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rr0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sr0 f7325a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rr0(sr0 sr0Var) {
        super(1);
        this.f7325a = sr0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f7325a.f7425a.c(u61.schedule_env_skey));
        l30Var.E("desc", this.f7325a.f7425a.c(u61.schedule_env_skey_desc));
        l30Var.E("visible", (f92.a(Build.MANUFACTURER, "OnePlus") && f92.a(e50.f677a.Z("settings get global side_button"), "1")) ? "always" : "never");
        l30Var.G("field", new qr0(this));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
