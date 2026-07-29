package com.blankj.utilcode.util;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.SystemClock;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.blankj.utilcode.util.z0;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11938a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f11939b = -0.06f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11940c = -2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11941d = -3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f11942e = 0.8f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11943f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f11944g = 0.9f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f11945h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f11946i = 0.9f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f11947j = 1000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f11948k = 2000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f11949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f11950m;

    public static class a extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f11951e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z10, long j10, View.OnClickListener onClickListener) {
            super(z10, j10);
            this.f11951e = onClickListener;
        }

        @Override // com.blankj.utilcode.util.o.e
        public void c(View view) {
            this.f11951e.onClick(view);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f11952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f11954c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f11955d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f11956e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ View f11957f;

        public b(View view, int i10, int i11, int i12, int i13, View view2) {
            this.f11952a = view;
            this.f11953b = i10;
            this.f11954c = i11;
            this.f11955d = i12;
            this.f11956e = i13;
            this.f11957f = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f11952a.getHitRect(rect);
            rect.top -= this.f11953b;
            rect.bottom += this.f11954c;
            rect.left -= this.f11955d;
            rect.right += this.f11956e;
            this.f11957f.setTouchDelegate(new TouchDelegate(rect, this.f11952a));
        }
    }

    public interface c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f11958a = new a();

        public static class a implements c {
            @Override // com.blankj.utilcode.util.o.c
            public void a(CharSequence charSequence, long j10) {
                l1.c1(charSequence);
            }

            @Override // com.blankj.utilcode.util.o.c
            public void dismiss() {
                l1.b1();
            }
        }

        void a(CharSequence charSequence, long j10);

        void dismiss();
    }

    public static class d extends z0.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BitmapDrawable f11959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Paint f11960c;

        public d(Drawable drawable) {
            super(drawable);
            this.f11959b = null;
            this.f11960c = null;
            if (drawable instanceof ColorDrawable) {
                Paint paint = new Paint(5);
                this.f11960c = paint;
                paint.setColor(((ColorDrawable) drawable).getColor());
            }
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f11959b == null) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                if (this.f11960c != null) {
                    canvas2.drawRect(getBounds(), this.f11960c);
                } else {
                    super.draw(canvas2);
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), bitmapCreateBitmap);
                this.f11959b = bitmapDrawable;
                bitmapDrawable.setBounds(getBounds());
            }
            this.f11959b.draw(canvas);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
            super.setAlpha(i10);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            super.setColorFilter(colorFilter);
        }
    }

    public static abstract class e implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f11961c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Runnable f11962d = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11964b;

        public static class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                boolean unused = e.f11961c = true;
            }
        }

        public e() {
            this(true, 1000L);
        }

        public static boolean b(@g.n0 View view, long j10) {
            Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return l1.D0(view, j10);
        }

        public abstract void c(View view);

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.f11964b) {
                if (b(view, this.f11963a)) {
                    c(view);
                }
            } else if (f11961c) {
                f11961c = false;
                view.postDelayed(f11962d, this.f11963a);
                c(view);
            }
        }

        public e(boolean z10) {
            this(z10, 1000L);
        }

        public e(long j10) {
            this(true, j10);
        }

        public e(boolean z10, long j10) {
            this.f11964b = z10;
            this.f11963a = j10;
        }
    }

    public static abstract class f implements View.OnClickListener {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final long f11965e = 666;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f11967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f11968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11969d;

        public f(int i10) {
            this(i10, 666L);
        }

        public abstract void a(View view, int i10);

        public abstract void b(View view);

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f11966a <= 1) {
                b(view);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f11968c < this.f11967b) {
                int i10 = this.f11969d + 1;
                this.f11969d = i10;
                int i11 = this.f11966a;
                if (i10 == i11) {
                    b(view);
                } else if (i10 < i11) {
                    a(view, i10);
                } else {
                    this.f11969d = 1;
                    a(view, 1);
                }
            } else {
                this.f11969d = 1;
                a(view, 1);
            }
            this.f11968c = jCurrentTimeMillis;
        }

        public f(int i10, long j10) {
            this.f11966a = i10;
            this.f11967b = j10;
        }
    }

    public static class g implements View.OnTouchListener {

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final g f11970a = new g(null);
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public static g a() {
            return a.f11970a;
        }

        public final void b(View view, boolean z10) {
            Object tag = view.getTag(z10 ? -2 : -3);
            if (tag instanceof Float) {
                view.setAlpha(((Float) tag).floatValue());
            }
        }

        public final void c(View view, boolean z10) {
            Object tag = view.getTag(-1);
            if (tag instanceof Float) {
                float fFloatValue = z10 ? 1.0f + ((Float) tag).floatValue() : 1.0f;
                view.animate().scaleX(fFloatValue).scaleY(fFloatValue).setDuration(200L).start();
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                c(view, true);
                b(view, true);
            } else if (action == 1 || action == 3) {
                c(view, false);
                b(view, false);
            }
            return false;
        }

        public g() {
        }
    }

    public o() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void A(@g.n0 View view, int i10, int i11, int i12, int i13) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View view2 = (View) view.getParent();
        if (view2 == null) {
            return;
        }
        view2.post(new b(view, i10, i13, i11, i12, view2));
    }

    public static ColorMatrixColorFilter B(float f10) {
        return new ColorMatrixColorFilter(new ColorMatrix(new float[]{f10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f}));
    }

    public static void a(View[] viewArr, boolean z10, @g.f0(from = 0) long j10, View.OnClickListener onClickListener) {
        if (viewArr == null || viewArr.length == 0 || onClickListener == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                view.setOnClickListener(new a(z10, j10, onClickListener));
            }
        }
    }

    public static void b(View view, @g.f0(from = 0) long j10, View.OnClickListener onClickListener) {
        d(new View[]{view}, j10, onClickListener);
    }

    public static void c(View view, View.OnClickListener onClickListener) {
        e(new View[]{view}, onClickListener);
    }

    public static void d(View[] viewArr, @g.f0(from = 0) long j10, View.OnClickListener onClickListener) {
        a(viewArr, true, j10, onClickListener);
    }

    public static void e(View[] viewArr, View.OnClickListener onClickListener) {
        d(viewArr, 1000L, onClickListener);
    }

    public static void f(View view) {
        g(view, 0.9f);
    }

    public static void g(View view, float f10) {
        j(view, 4, f10);
    }

    public static void h(View view) {
        i(view, 0.9f);
    }

    public static void i(View view, float f10) {
        j(view, 5, f10);
    }

    public static void j(View view, int i10, float f10) {
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        int i11 = -i10;
        Object tag = view.getTag(i11);
        if (tag instanceof Drawable) {
            androidx.core.view.u0.I1(view, (Drawable) tag);
            return;
        }
        Drawable drawableY = y(background, i10, f10);
        androidx.core.view.u0.I1(view, drawableY);
        view.setTag(i11, drawableY);
    }

    public static void k(View view, float f10) {
        if (view == null) {
            return;
        }
        view.setTag(-2, Float.valueOf(f10));
        view.setTag(-3, Float.valueOf(view.getAlpha()));
        view.setClickable(true);
        view.setOnTouchListener(g.a());
    }

    public static void l(View... viewArr) {
        m(viewArr, null);
    }

    public static void m(View[] viewArr, float[] fArr) {
        if (viewArr == null || viewArr.length == 0) {
            return;
        }
        for (int i10 = 0; i10 < viewArr.length; i10++) {
            if (fArr == null || i10 >= fArr.length) {
                k(viewArr[i10], 0.8f);
            } else {
                k(viewArr[i10], fArr[i10]);
            }
        }
    }

    public static void n(View view, float f10) {
        if (view == null) {
            return;
        }
        view.setTag(-1, Float.valueOf(f10));
        view.setClickable(true);
        view.setOnTouchListener(g.a());
    }

    public static void o(View... viewArr) {
        p(viewArr, null);
    }

    public static void p(View[] viewArr, float[] fArr) {
        if (viewArr == null || viewArr.length == 0) {
            return;
        }
        for (int i10 = 0; i10 < viewArr.length; i10++) {
            if (fArr == null || i10 >= fArr.length) {
                n(viewArr[i10], -0.06f);
            } else {
                n(viewArr[i10], fArr[i10]);
            }
        }
    }

    public static void q(View view, @g.f0(from = 0) long j10, View.OnClickListener onClickListener) {
        s(new View[]{view}, j10, onClickListener);
    }

    public static void r(View view, View.OnClickListener onClickListener) {
        t(new View[]{view}, onClickListener);
    }

    public static void s(View[] viewArr, @g.f0(from = 0) long j10, View.OnClickListener onClickListener) {
        a(viewArr, false, j10, onClickListener);
    }

    public static void t(View[] viewArr, View.OnClickListener onClickListener) {
        s(viewArr, 1000L, onClickListener);
    }

    public static void u(CharSequence charSequence) {
        v(charSequence, 2000L, c.f11958a);
    }

    public static void v(@g.n0 CharSequence charSequence, long j10, @g.n0 c cVar) {
        Objects.requireNonNull(charSequence, "Argument 'tip' of type CharSequence (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cVar, "Argument 'listener' of type Back2HomeFriendlyListener (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (Math.abs(jElapsedRealtime - f11949l) >= j10) {
            f11950m = 1;
            cVar.a(charSequence, j10);
            f11949l = jElapsedRealtime;
            return;
        }
        int i10 = f11950m + 1;
        f11950m = i10;
        if (i10 == 2) {
            l1.Y0();
            cVar.dismiss();
            f11949l = 0L;
        }
    }

    public static Drawable w(Drawable drawable, float f10) {
        d dVar = new d(drawable);
        dVar.setAlpha((int) (f10 * 255.0f));
        return dVar;
    }

    public static Drawable x(Drawable drawable, float f10) {
        d dVar = new d(drawable);
        dVar.setColorFilter(B(f10));
        return dVar;
    }

    public static Drawable y(Drawable drawable, int i10, float f10) {
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        if (drawable.getConstantState() == null) {
            return drawable;
        }
        Drawable drawableMutate = drawable.getConstantState().newDrawable().mutate();
        if (i10 == 4) {
            drawableMutate = w(drawableMutate, f10);
        } else if (i10 == 5) {
            drawableMutate = x(drawableMutate, f10);
        }
        Drawable drawableW = w(drawable.getConstantState().newDrawable().mutate(), 0.5f);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawableMutate);
        stateListDrawable.addState(new int[]{-16842910}, drawableW);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }

    public static void z(@g.n0 View view, int i10) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        A(view, i10, i10, i10, i10);
    }
}
