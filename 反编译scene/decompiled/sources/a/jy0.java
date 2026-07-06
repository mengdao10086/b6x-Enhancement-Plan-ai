package a;

import com.omarea.Scene;
import com.omarea.model.FpsWatchSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jy0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ly0 f6554a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jy0(ly0 ly0Var) {
        super(1);
        this.f6554a = ly0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("id", "" + this.f6554a.f6747a);
        l30Var.E("androidId", this.f6554a.f1856a.j(Scene.f4798a.c()));
        FpsWatchSession fpsWatchSession = this.f6554a.f1857a;
        f92.b(fpsWatchSession);
        l30Var.E("time", fpsWatchSession.beginTime);
        l30Var.E("appName", this.f6554a.f1857a.appName);
        l30Var.E("pkg", this.f6554a.f1857a.packageName);
        l30Var.E("version", this.f6554a.f1857a.packageVersion);
        l30Var.E("viewSize", this.f6554a.f1857a.viewSize);
        l30Var.E("model", this.f6554a.f1855a.f());
        l30Var.E("marketModel", this.f6554a.f1855a.d());
        l30Var.E("mode", this.f6554a.f1855a.e());
        l30Var.E("workingMode", this.f6554a.f1855a.j());
        l30Var.E("sdkInt", Integer.valueOf(this.f6554a.f1855a.h()));
        l30Var.E("platform", this.f6554a.f1855a.g());
        l30Var.E("machine", this.f6554a.f1855a.b());
        l30Var.E("manufacturer", this.f6554a.f1855a.c());
        l30Var.E("version", this.f6554a.f1855a.i());
        l30Var.E("remark", this.f6554a.f1857a.sessionDesc);
        l30Var.E("summary", new l30(new iy0(this)));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
