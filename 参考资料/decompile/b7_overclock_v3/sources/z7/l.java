package z7;

import android.content.Context;
import android.view.WindowManager;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
public class l extends y7.b {
    public l(Context context, y7.n nVar) {
        super(context, nVar);
        this.f56483f.postDelayed(new k(this), 1000L);
    }

    public final void C() {
        if (!o5.d.o(this.f56478a)) {
            com.flydigi.base.common.n.a("悬浮窗权限未开启");
            this.f56483f.postDelayed(new k(this), 1000L);
        } else {
            com.flydigi.base.common.n.a("悬浮窗权限已开启");
            h();
            h3.a.j().d(a.d.f31959o).navigation();
        }
    }

    @Override // y7.b
    public int i() {
        return 0;
    }

    @Override // y7.b
    public void n() {
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        return null;
    }
}
