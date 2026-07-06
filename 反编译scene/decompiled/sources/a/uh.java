package a;

import android.view.WindowInsets;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class uh extends wh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowInsets.Builder f7596a;

    public uh() {
        this.f7596a = new WindowInsets.Builder();
    }

    public uh(sh shVar) {
        WindowInsets windowInsetsR = shVar.r();
        this.f7596a = windowInsetsR != null ? new WindowInsets.Builder(windowInsetsR) : new WindowInsets.Builder();
    }

    @Override // a.wh
    public sh b() {
        a();
        sh shVarS = sh.s(this.f7596a.build());
        shVarS.n(((wh) this).f3438a);
        return shVarS;
    }

    @Override // a.wh
    public void c(uc ucVar) {
        this.f7596a.setMandatorySystemGestureInsets(ucVar.e());
    }

    @Override // a.wh
    public void d(uc ucVar) {
        this.f7596a.setStableInsets(ucVar.e());
    }

    @Override // a.wh
    public void e(uc ucVar) {
        this.f7596a.setSystemGestureInsets(ucVar.e());
    }

    @Override // a.wh
    public void f(uc ucVar) {
        this.f7596a.setSystemWindowInsets(ucVar.e());
    }

    @Override // a.wh
    public void g(uc ucVar) {
        this.f7596a.setTappableElementInsets(ucVar.e());
    }
}
