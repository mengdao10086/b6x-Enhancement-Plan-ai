package a;

import android.os.SystemClock;
import android.view.MenuItem;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class c4 implements u7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e4 f5757a;

    public c4(e4 e4Var) {
        this.f5757a = e4Var;
    }

    @Override // a.u7
    public void h(i4 i4Var, MenuItem menuItem) {
        this.f5757a.f655a.removeCallbacksAndMessages(null);
        int size = this.f5757a.f663b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (i4Var == this.f5757a.f663b.get(i).f476a) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        this.f5757a.f655a.postAtTime(new b4(this, i2 < this.f5757a.f663b.size() ? this.f5757a.f663b.get(i2) : null, menuItem, i4Var), i4Var, SystemClock.uptimeMillis() + 200);
    }

    @Override // a.u7
    public void m(i4 i4Var, MenuItem menuItem) {
        this.f5757a.f655a.removeCallbacksAndMessages(i4Var);
    }
}
