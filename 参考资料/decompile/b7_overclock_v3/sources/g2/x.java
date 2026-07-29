package g2;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(18)
public class x implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f28990a;

    public x(@n0 View view) {
        this.f28990a = view.getOverlay();
    }

    @Override // g2.y
    public void a(@n0 Drawable drawable) {
        this.f28990a.add(drawable);
    }

    @Override // g2.y
    public void b(@n0 Drawable drawable) {
        this.f28990a.remove(drawable);
    }
}
