package g2;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(18)
public class t implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f28979a;

    public t(@n0 ViewGroup viewGroup) {
        this.f28979a = viewGroup.getOverlay();
    }

    @Override // g2.y
    public void a(@n0 Drawable drawable) {
        this.f28979a.add(drawable);
    }

    @Override // g2.y
    public void b(@n0 Drawable drawable) {
        this.f28979a.remove(drawable);
    }

    @Override // g2.u
    public void c(@n0 View view) {
        this.f28979a.add(view);
    }

    @Override // g2.u
    public void d(@n0 View view) {
        this.f28979a.remove(view);
    }
}
