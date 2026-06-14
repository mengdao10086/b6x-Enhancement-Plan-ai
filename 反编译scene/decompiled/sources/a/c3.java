package a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class c3 extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d3 f326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Resources f328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorFilter f329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArray<Drawable.ConstantState> f332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable[] f334a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f335b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f336c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f337d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f338e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f339f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f340g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f341h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f342i;
    public int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f343j;
    public int k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public boolean f344k;
    public int l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public boolean f345l;
    public boolean m;
    public boolean n;
    public boolean o;

    public c3(c3 c3Var, d3 d3Var, Resources resources) {
        this.f5755a = 160;
        this.f333a = false;
        this.f336c = false;
        this.f343j = true;
        this.k = 0;
        this.l = 0;
        this.f326a = d3Var;
        this.f328a = resources != null ? resources : c3Var != null ? c3Var.f328a : null;
        int iF = d3.f(resources, c3Var != null ? c3Var.f5755a : 0);
        this.f5755a = iF;
        if (c3Var == null) {
            this.f334a = new Drawable[10];
            this.d = 0;
            return;
        }
        this.b = c3Var.b;
        this.c = c3Var.c;
        this.f341h = true;
        this.f342i = true;
        this.f333a = c3Var.f333a;
        this.f336c = c3Var.f336c;
        this.f343j = c3Var.f343j;
        this.f344k = c3Var.f344k;
        this.j = c3Var.j;
        this.k = c3Var.k;
        this.l = c3Var.l;
        this.f345l = c3Var.f345l;
        this.f329a = c3Var.f329a;
        this.m = c3Var.m;
        this.f327a = c3Var.f327a;
        this.f330a = c3Var.f330a;
        this.n = c3Var.n;
        this.o = c3Var.o;
        if (c3Var.f5755a == iF) {
            if (c3Var.f335b) {
                this.f331a = new Rect(c3Var.f331a);
                this.f335b = true;
            }
            if (c3Var.f337d) {
                this.e = c3Var.e;
                this.f = c3Var.f;
                this.g = c3Var.g;
                this.h = c3Var.h;
                this.f337d = true;
            }
        }
        if (c3Var.f338e) {
            this.i = c3Var.i;
            this.f338e = true;
        }
        if (c3Var.f339f) {
            this.f340g = c3Var.f340g;
            this.f339f = true;
        }
        Drawable[] drawableArr = c3Var.f334a;
        this.f334a = new Drawable[drawableArr.length];
        this.d = c3Var.d;
        SparseArray<Drawable.ConstantState> sparseArray = c3Var.f332a;
        this.f332a = sparseArray != null ? sparseArray.clone() : new SparseArray<>(this.d);
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2] != null) {
                Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                if (constantState != null) {
                    this.f332a.put(i2, constantState);
                } else {
                    this.f334a[i2] = drawableArr[i2];
                }
            }
        }
    }

    public final int a(Drawable drawable) {
        int i = this.d;
        if (i >= this.f334a.length) {
            o(i, i + 10);
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.f326a);
        this.f334a[i] = drawable;
        this.d++;
        this.c = drawable.getChangingConfigurations() | this.c;
        p();
        this.f331a = null;
        this.f335b = false;
        this.f337d = false;
        this.f341h = false;
        return i;
    }

    public final void b(Resources.Theme theme) {
        if (theme != null) {
            e();
            int i = this.d;
            Drawable[] drawableArr = this.f334a;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                    drawableArr[i2].applyTheme(theme);
                    this.c |= drawableArr[i2].getChangingConfigurations();
                }
            }
            y(theme.getResources());
        }
    }

    public synchronized boolean c() {
        if (this.f341h) {
            return this.f342i;
        }
        e();
        this.f341h = true;
        int i = this.d;
        Drawable[] drawableArr = this.f334a;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2].getConstantState() == null) {
                this.f342i = false;
                return false;
            }
        }
        this.f342i = true;
        return true;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        int i = this.d;
        Drawable[] drawableArr = this.f334a;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable == null) {
                Drawable.ConstantState constantState = this.f332a.get(i2);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            } else if (drawable.canApplyTheme()) {
                return true;
            }
        }
        return false;
    }

    public void d() {
        this.f337d = true;
        e();
        int i = this.d;
        Drawable[] drawableArr = this.f334a;
        this.f = -1;
        this.e = -1;
        this.h = 0;
        this.g = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.e) {
                this.e = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f) {
                this.f = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.g) {
                this.g = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.h) {
                this.h = minimumHeight;
            }
        }
    }

    public final void e() {
        SparseArray<Drawable.ConstantState> sparseArray = this.f332a;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                this.f334a[this.f332a.keyAt(i)] = s(this.f332a.valueAt(i).newDrawable(this.f328a));
            }
            this.f332a = null;
        }
    }

    public final int f() {
        return this.f334a.length;
    }

    public final Drawable g(int i) {
        int iIndexOfKey;
        Drawable drawable = this.f334a[i];
        if (drawable != null) {
            return drawable;
        }
        SparseArray<Drawable.ConstantState> sparseArray = this.f332a;
        if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
            return null;
        }
        Drawable drawableS = s(this.f332a.valueAt(iIndexOfKey).newDrawable(this.f328a));
        this.f334a[i] = drawableS;
        this.f332a.removeAt(iIndexOfKey);
        if (this.f332a.size() == 0) {
            this.f332a = null;
        }
        return drawableS;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.b | this.c;
    }

    public final int h() {
        return this.d;
    }

    public final int i() {
        if (!this.f337d) {
            d();
        }
        return this.f;
    }

    public final int j() {
        if (!this.f337d) {
            d();
        }
        return this.h;
    }

    public final int k() {
        if (!this.f337d) {
            d();
        }
        return this.g;
    }

    public final Rect l() {
        Rect rect = null;
        if (this.f333a) {
            return null;
        }
        if (this.f331a != null || this.f335b) {
            return this.f331a;
        }
        e();
        Rect rect2 = new Rect();
        int i = this.d;
        Drawable[] drawableArr = this.f334a;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2].getPadding(rect2)) {
                if (rect == null) {
                    rect = new Rect(0, 0, 0, 0);
                }
                int i3 = rect2.left;
                if (i3 > rect.left) {
                    rect.left = i3;
                }
                int i4 = rect2.top;
                if (i4 > rect.top) {
                    rect.top = i4;
                }
                int i5 = rect2.right;
                if (i5 > rect.right) {
                    rect.right = i5;
                }
                int i6 = rect2.bottom;
                if (i6 > rect.bottom) {
                    rect.bottom = i6;
                }
            }
        }
        this.f335b = true;
        this.f331a = rect;
        return rect;
    }

    public final int m() {
        if (!this.f337d) {
            d();
        }
        return this.e;
    }

    public final int n() {
        if (this.f338e) {
            return this.i;
        }
        e();
        int i = this.d;
        Drawable[] drawableArr = this.f334a;
        int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
        for (int i2 = 1; i2 < i; i2++) {
            opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
        }
        this.i = opacity;
        this.f338e = true;
        return opacity;
    }

    public void o(int i, int i2) {
        Drawable[] drawableArr = new Drawable[i2];
        System.arraycopy(this.f334a, 0, drawableArr, 0, i);
        this.f334a = drawableArr;
    }

    public void p() {
        this.f338e = false;
        this.f339f = false;
    }

    public final boolean q() {
        return this.f336c;
    }

    public abstract void r();

    public final Drawable s(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.setLayoutDirection(this.j);
        }
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setCallback(this.f326a);
        return drawableMutate;
    }

    public final void t(boolean z) {
        this.f336c = z;
    }

    public final void u(int i) {
        this.k = i;
    }

    public final void v(int i) {
        this.l = i;
    }

    public final boolean w(int i, int i2) {
        int i3 = this.d;
        Drawable[] drawableArr = this.f334a;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            if (drawableArr[i4] != null) {
                boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                if (i4 == i2) {
                    z = layoutDirection;
                }
            }
        }
        this.j = i;
        return z;
    }

    public final void x(boolean z) {
        this.f333a = z;
    }

    public final void y(Resources resources) {
        if (resources != null) {
            this.f328a = resources;
            int iF = d3.f(resources, this.f5755a);
            int i = this.f5755a;
            this.f5755a = iF;
            if (i != iF) {
                this.f337d = false;
                this.f335b = false;
            }
        }
    }
}
