package m1;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.m;
import androidx.core.view.u0;
import androidx.drawerlayout.widget.DrawerLayout;
import g.c1;
import g.n0;
import g.p0;
import g.v;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class a implements DrawerLayout.e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f40612m = "ActionBarDrawerToggle";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f40613n = {R.attr.homeAsUpIndicator};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f40614o = 0.33333334f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f40615p = 16908332;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f40616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0450a f40617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DrawerLayout f40618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f40619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f40620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f40621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f40622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f40623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f40624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f40625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f40626k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f40627l;

    /* JADX INFO: renamed from: m1.a$a, reason: collision with other inner class name */
    @Deprecated
    public interface InterfaceC0450a {
        void a(Drawable drawable, @c1 int i10);

        @p0
        Drawable b();

        void c(@c1 int i10);
    }

    @Deprecated
    public interface b {
        @p0
        InterfaceC0450a g();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f40628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f40629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f40630c;

        public c(Activity activity) {
            try {
                this.f40628a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.f40629b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View viewFindViewById = activity.findViewById(16908332);
                if (viewFindViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof ImageView) {
                    this.f40630c = (ImageView) childAt;
                }
            }
        }
    }

    public class d extends InsetDrawable implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f40631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f40632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f40633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f40634d;

        public d(Drawable drawable) {
            super(drawable, 0);
            this.f40631a = true;
            this.f40632b = new Rect();
        }

        public float a() {
            return this.f40633c;
        }

        public void b(float f10) {
            this.f40634d = f10;
            invalidateSelf();
        }

        public void c(float f10) {
            this.f40633c = f10;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(@n0 Canvas canvas) {
            copyBounds(this.f40632b);
            canvas.save();
            boolean z10 = u0.Z(a.this.f40616a.getWindow().getDecorView()) == 1;
            int i10 = z10 ? -1 : 1;
            float fWidth = this.f40632b.width();
            canvas.translate((-this.f40634d) * fWidth * this.f40633c * i10, 0.0f);
            if (z10 && !this.f40631a) {
                canvas.translate(fWidth, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    public a(Activity activity, DrawerLayout drawerLayout, @v int i10, @c1 int i11, @c1 int i12) {
        this(activity, drawerLayout, !e(activity), i10, i11, i12);
    }

    public static boolean e(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void a(View view) {
        this.f40623h.c(1.0f);
        if (this.f40619d) {
            j(this.f40626k);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void b(View view) {
        this.f40623h.c(0.0f);
        if (this.f40619d) {
            j(this.f40625j);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void c(int i10) {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void d(View view, float f10) {
        float fA = this.f40623h.a();
        this.f40623h.c(f10 > 0.5f ? Math.max(fA, Math.max(0.0f, f10 - 0.5f) * 2.0f) : Math.min(fA, f10 * 2.0f));
    }

    public final Drawable f() {
        InterfaceC0450a interfaceC0450a = this.f40617b;
        if (interfaceC0450a != null) {
            return interfaceC0450a.b();
        }
        ActionBar actionBar = this.f40616a.getActionBar();
        TypedArray typedArrayObtainStyledAttributes = (actionBar != null ? actionBar.getThemedContext() : this.f40616a).obtainStyledAttributes(null, f40613n, R.attr.actionBarStyle, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    public boolean g() {
        return this.f40619d;
    }

    public void h(Configuration configuration) {
        if (!this.f40620e) {
            this.f40621f = f();
        }
        this.f40622g = h0.d.i(this.f40616a, this.f40624i);
        o();
    }

    public boolean i(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f40619d) {
            return false;
        }
        if (this.f40618c.F(m.f5025b)) {
            this.f40618c.d(m.f5025b);
            return true;
        }
        this.f40618c.K(m.f5025b);
        return true;
    }

    public final void j(int i10) {
        InterfaceC0450a interfaceC0450a = this.f40617b;
        if (interfaceC0450a != null) {
            interfaceC0450a.c(i10);
            return;
        }
        ActionBar actionBar = this.f40616a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i10);
        }
    }

    public final void k(Drawable drawable, int i10) {
        InterfaceC0450a interfaceC0450a = this.f40617b;
        if (interfaceC0450a != null) {
            interfaceC0450a.a(drawable, i10);
            return;
        }
        ActionBar actionBar = this.f40616a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i10);
        }
    }

    public void l(boolean z10) {
        if (z10 != this.f40619d) {
            if (z10) {
                k(this.f40623h, this.f40618c.C(m.f5025b) ? this.f40626k : this.f40625j);
            } else {
                k(this.f40621f, 0);
            }
            this.f40619d = z10;
        }
    }

    public void m(int i10) {
        n(i10 != 0 ? h0.d.i(this.f40616a, i10) : null);
    }

    public void n(Drawable drawable) {
        if (drawable == null) {
            this.f40621f = f();
            this.f40620e = false;
        } else {
            this.f40621f = drawable;
            this.f40620e = true;
        }
        if (this.f40619d) {
            return;
        }
        k(this.f40621f, 0);
    }

    public void o() {
        if (this.f40618c.C(m.f5025b)) {
            this.f40623h.c(1.0f);
        } else {
            this.f40623h.c(0.0f);
        }
        if (this.f40619d) {
            k(this.f40623h, this.f40618c.C(m.f5025b) ? this.f40626k : this.f40625j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Activity activity, DrawerLayout drawerLayout, boolean z10, @v int i10, @c1 int i11, @c1 int i12) {
        this.f40619d = true;
        this.f40616a = activity;
        if (activity instanceof b) {
            this.f40617b = ((b) activity).g();
        } else {
            this.f40617b = null;
        }
        this.f40618c = drawerLayout;
        this.f40624i = i10;
        this.f40625j = i11;
        this.f40626k = i12;
        this.f40621f = f();
        this.f40622g = h0.d.i(activity, i10);
        d dVar = new d(this.f40622g);
        this.f40623h = dVar;
        dVar.b(z10 ? 0.33333334f : 0.0f);
    }
}
