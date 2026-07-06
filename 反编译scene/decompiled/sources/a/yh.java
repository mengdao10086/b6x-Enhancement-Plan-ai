package a;

import android.view.WindowInsets;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class yh extends xh {
    public uc c;

    public yh(sh shVar, yh yhVar) {
        super(shVar, yhVar);
        this.c = null;
        this.c = yhVar.c;
    }

    public yh(sh shVar, WindowInsets windowInsets) {
        super(shVar, windowInsets);
        this.c = null;
    }

    @Override // a.ci
    public sh b() {
        return sh.s(((xh) this).f3589a.consumeStableInsets());
    }

    @Override // a.ci
    public sh c() {
        return sh.s(((xh) this).f3589a.consumeSystemWindowInsets());
    }

    @Override // a.ci
    public final uc h() {
        if (this.c == null) {
            this.c = uc.b(((xh) this).f3589a.getStableInsetLeft(), ((xh) this).f3589a.getStableInsetTop(), ((xh) this).f3589a.getStableInsetRight(), ((xh) this).f3589a.getStableInsetBottom());
        }
        return this.c;
    }

    @Override // a.ci
    public boolean k() {
        return ((xh) this).f3589a.isConsumed();
    }

    @Override // a.ci
    public void p(uc ucVar) {
        this.c = ucVar;
    }
}
