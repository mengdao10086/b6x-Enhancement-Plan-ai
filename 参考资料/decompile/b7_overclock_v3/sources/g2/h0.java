package g2;

import android.view.View;
import android.view.WindowId;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(18)
public class h0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f28961a;

    public h0(@n0 View view) {
        this.f28961a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof h0) && ((h0) obj).f28961a.equals(this.f28961a);
    }

    public int hashCode() {
        return this.f28961a.hashCode();
    }
}
