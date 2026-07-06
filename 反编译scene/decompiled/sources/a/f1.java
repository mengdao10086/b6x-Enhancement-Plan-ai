package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f1 extends nh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f6061a;

    public f1(w1 w1Var) {
        this.f6061a = w1Var;
    }

    @Override // a.mh
    public void a(View view) {
        this.f6061a.f3343a.setAlpha(1.0f);
        this.f6061a.f3330a.f(null);
        this.f6061a.f3330a = null;
    }

    @Override // a.nh, a.mh
    public void c(View view) {
        this.f6061a.f3343a.setVisibility(0);
        this.f6061a.f3343a.sendAccessibilityEvent(32);
        if (this.f6061a.f3343a.getParent() instanceof View) {
            eh.h0((View) this.f6061a.f3343a.getParent());
        }
    }
}
