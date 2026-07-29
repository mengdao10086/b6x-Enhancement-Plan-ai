package s4;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import g.n0;
import g.p0;
import t4.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j<Z> extends r<ImageView, Z> implements f.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public Animatable f49487j;

    public j(ImageView imageView) {
        super(imageView);
    }

    @Override // s4.b, p4.m
    public void b() {
        Animatable animatable = this.f49487j;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // s4.b, p4.m
    public void c() {
        Animatable animatable = this.f49487j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // t4.f.a
    public void d(Drawable drawable) {
        ((ImageView) this.f49503b).setImageDrawable(drawable);
    }

    @Override // t4.f.a
    @p0
    public Drawable e() {
        return ((ImageView) this.f49503b).getDrawable();
    }

    @Override // s4.p
    public void g(@n0 Z z10, @p0 t4.f<? super Z> fVar) {
        if (fVar == null || !fVar.a(z10, this)) {
            y(z10);
        } else {
            w(z10);
        }
    }

    @Override // s4.b, s4.p
    public void n(@p0 Drawable drawable) {
        super.n(drawable);
        y(null);
        d(drawable);
    }

    @Override // s4.r, s4.b, s4.p
    public void q(@p0 Drawable drawable) {
        super.q(drawable);
        y(null);
        d(drawable);
    }

    @Override // s4.r, s4.b, s4.p
    public void s(@p0 Drawable drawable) {
        super.s(drawable);
        Animatable animatable = this.f49487j;
        if (animatable != null) {
            animatable.stop();
        }
        y(null);
        d(drawable);
    }

    public final void w(@p0 Z z10) {
        if (!(z10 instanceof Animatable)) {
            this.f49487j = null;
            return;
        }
        Animatable animatable = (Animatable) z10;
        this.f49487j = animatable;
        animatable.start();
    }

    public abstract void x(@p0 Z z10);

    public final void y(@p0 Z z10) {
        x(z10);
        w(z10);
    }

    @Deprecated
    public j(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }
}
