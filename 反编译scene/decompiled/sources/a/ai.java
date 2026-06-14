package a;

import android.view.WindowInsets;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ai extends zh {
    public uc d;

    public ai(sh shVar, ai aiVar) {
        super(shVar, aiVar);
        this.d = null;
    }

    public ai(sh shVar, WindowInsets windowInsets) {
        super(shVar, windowInsets);
        this.d = null;
    }

    @Override // a.ci
    public uc g() {
        if (this.d == null) {
            this.d = uc.d(((xh) this).f3589a.getMandatorySystemGestureInsets());
        }
        return this.d;
    }

    @Override // a.xh, a.ci
    public sh j(int i, int i2, int i3, int i4) {
        return sh.s(((xh) this).f3589a.inset(i, i2, i3, i4));
    }

    @Override // a.yh, a.ci
    public void p(uc ucVar) {
    }
}
