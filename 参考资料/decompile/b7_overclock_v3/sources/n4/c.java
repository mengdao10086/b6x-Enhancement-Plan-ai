package n4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import g.i1;
import g.n0;
import h2.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import n4.g;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public class c extends Drawable implements g.b, Animatable, h2.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f41830l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f41831m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f41832n = 119;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f41833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f41834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f41835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f41837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f41838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f41839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f41840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f41841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Rect f41842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<b.a> f41843k;

    public static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @i1
        public final g f41844a;

        public a(g gVar) {
            this.f41844a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    @Deprecated
    public c(Context context, a4.a aVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, c4.h<Bitmap> hVar, int i10, int i11, Bitmap bitmap) {
        this(context, aVar, hVar, i10, i11, bitmap);
    }

    @Override // n4.g.b
    public void a() {
        if (e() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (j() == i() - 1) {
            this.f41838f++;
        }
        int i10 = this.f41839g;
        if (i10 == -1 || this.f41838f < i10) {
            return;
        }
        o();
        stop();
    }

    @Override // h2.b
    public boolean b(@n0 b.a aVar) {
        List<b.a> list = this.f41843k;
        if (list == null || aVar == null) {
            return false;
        }
        return list.remove(aVar);
    }

    @Override // h2.b
    public void c(@n0 b.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f41843k == null) {
            this.f41843k = new ArrayList();
        }
        this.f41843k.add(aVar);
    }

    @Override // h2.b
    public void d() {
        List<b.a> list = this.f41843k;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        if (this.f41836d) {
            return;
        }
        if (this.f41840h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), g());
            this.f41840h = false;
        }
        canvas.drawBitmap(this.f41833a.f41844a.c(), (Rect) null, g(), l());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable.Callback e() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public ByteBuffer f() {
        return this.f41833a.f41844a.b();
    }

    public final Rect g() {
        if (this.f41842j == null) {
            this.f41842j = new Rect();
        }
        return this.f41842j;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f41833a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f41833a.f41844a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f41833a.f41844a.m();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public Bitmap h() {
        return this.f41833a.f41844a.e();
    }

    public int i() {
        return this.f41833a.f41844a.f();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f41834b;
    }

    public int j() {
        return this.f41833a.f41844a.d();
    }

    public c4.h<Bitmap> k() {
        return this.f41833a.f41844a.h();
    }

    public final Paint l() {
        if (this.f41841i == null) {
            this.f41841i = new Paint(2);
        }
        return this.f41841i;
    }

    public int m() {
        return this.f41833a.f41844a.l();
    }

    public boolean n() {
        return this.f41836d;
    }

    public final void o() {
        List<b.a> list = this.f41843k;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f41843k.get(i10).b(this);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f41840h = true;
    }

    public void p() {
        this.f41836d = true;
        this.f41833a.f41844a.a();
    }

    public final void q() {
        this.f41838f = 0;
    }

    public void r(c4.h<Bitmap> hVar, Bitmap bitmap) {
        this.f41833a.f41844a.q(hVar, bitmap);
    }

    public void s(boolean z10) {
        this.f41834b = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        l().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        l().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        m.a(!this.f41836d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f41837e = z10;
        if (!z10) {
            w();
        } else if (this.f41835c) {
            v();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f41835c = true;
        q();
        if (this.f41837e) {
            v();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f41835c = false;
        w();
    }

    public void t(int i10) {
        if (i10 <= 0 && i10 != -1 && i10 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i10 != 0) {
            this.f41839g = i10;
        } else {
            int iJ = this.f41833a.f41844a.j();
            this.f41839g = iJ != 0 ? iJ : -1;
        }
    }

    public void u() {
        m.a(!this.f41834b, "You cannot restart a currently running animation.");
        this.f41833a.f41844a.r();
        start();
    }

    public final void v() {
        m.a(!this.f41836d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f41833a.f41844a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f41834b) {
                return;
            }
            this.f41834b = true;
            this.f41833a.f41844a.v(this);
            invalidateSelf();
        }
    }

    public final void w() {
        this.f41834b = false;
        this.f41833a.f41844a.w(this);
    }

    public c(Context context, a4.a aVar, c4.h<Bitmap> hVar, int i10, int i11, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.b.e(context), aVar, i10, i11, hVar, bitmap)));
    }

    public c(a aVar) {
        this.f41837e = true;
        this.f41839g = -1;
        this.f41833a = (a) m.d(aVar);
    }

    @i1
    public c(g gVar, Paint paint) {
        this(new a(gVar));
        this.f41841i = paint;
    }
}
