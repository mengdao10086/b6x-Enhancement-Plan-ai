package a;

import android.content.pm.PackageInfo;
import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class go0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ho0 f6227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ PackageInfo f1048a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public go0(ho0 ho0Var, PackageInfo packageInfo) {
        super(1);
        this.f6227a = ho0Var;
        this.f1048a = packageInfo;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("branch", "scene9/threads");
        l30Var.E("versionName", this.f1048a.versionName);
        l30Var.E("osVersion", Integer.valueOf(Build.VERSION.SDK_INT));
        l30Var.E("platform", this.f6227a.G());
        l30Var.E("machine", jm0.f6525a.a());
        l30Var.E("scheme", this.f6227a.H());
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
