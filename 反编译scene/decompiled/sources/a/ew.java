package a;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ew {
    public static final boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nz f802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LayerDrawable f806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MaterialButton f807a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f809b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ColorStateList f811c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f813d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f814e;
    public int f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f808a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f810b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f812c = false;

    static {
        e = Build.VERSION.SDK_INT >= 21;
    }

    public ew(MaterialButton materialButton, nz nzVar) {
        this.f807a = materialButton;
        this.f802a = nzVar;
    }

    public final void A(nz nzVar) {
        if (d() != null) {
            d().setShapeAppearanceModel(nzVar);
        }
        if (l() != null) {
            l().setShapeAppearanceModel(nzVar);
        }
        if (c() != null) {
            c().setShapeAppearanceModel(nzVar);
        }
    }

    public void B(int i, int i2) {
        Drawable drawable = this.f805a;
        if (drawable != null) {
            drawable.setBounds(this.f6046a, this.c, i2 - this.b, i - this.d);
        }
    }

    public final void C() {
        iz izVarD = d();
        iz izVarL = l();
        if (izVarD != null) {
            izVarD.b0(this.f, this.f809b);
            if (izVarL != null) {
                izVarL.a0(this.f, this.f808a ? iw.c(this.f807a, zu.colorSurface) : 0);
            }
        }
    }

    public final InsetDrawable D(Drawable drawable) {
        return new InsetDrawable(drawable, this.f6046a, this.c, this.b, this.d);
    }

    public final Drawable a() {
        iz izVar = new iz(this.f802a);
        izVar.K(this.f807a.getContext());
        kd.o(izVar, this.f803a);
        PorterDuff.Mode mode = this.f804a;
        if (mode != null) {
            kd.p(izVar, mode);
        }
        izVar.b0(this.f, this.f809b);
        iz izVar2 = new iz(this.f802a);
        izVar2.setTint(0);
        izVar2.a0(this.f, this.f808a ? iw.c(this.f807a, zu.colorSurface) : 0);
        if (e) {
            iz izVar3 = new iz(this.f802a);
            this.f805a = izVar3;
            kd.n(izVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(wy.d(this.f811c), D(new LayerDrawable(new Drawable[]{izVar2, izVar})), this.f805a);
            this.f806a = rippleDrawable;
            return rippleDrawable;
        }
        vy vyVar = new vy(this.f802a);
        this.f805a = vyVar;
        kd.o(vyVar, wy.d(this.f811c));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{izVar2, izVar, this.f805a});
        this.f806a = layerDrawable;
        return D(layerDrawable);
    }

    public int b() {
        return this.f814e;
    }

    public a00 c() {
        LayerDrawable layerDrawable = this.f806a;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (a00) (this.f806a.getNumberOfLayers() > 2 ? this.f806a.getDrawable(2) : this.f806a.getDrawable(1));
    }

    public iz d() {
        return e(false);
    }

    public final iz e(boolean z) {
        LayerDrawable layerDrawable = this.f806a;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (iz) (e ? (LayerDrawable) ((InsetDrawable) this.f806a.getDrawable(0)).getDrawable() : this.f806a).getDrawable(!z ? 1 : 0);
    }

    public ColorStateList f() {
        return this.f811c;
    }

    public nz g() {
        return this.f802a;
    }

    public ColorStateList h() {
        return this.f809b;
    }

    public int i() {
        return this.f;
    }

    public ColorStateList j() {
        return this.f803a;
    }

    public PorterDuff.Mode k() {
        return this.f804a;
    }

    public final iz l() {
        return e(true);
    }

    public boolean m() {
        return this.f810b;
    }

    public boolean n() {
        return this.f813d;
    }

    public void o(TypedArray typedArray) {
        this.f6046a = typedArray.getDimensionPixelOffset(jv.MaterialButton_android_insetLeft, 0);
        this.b = typedArray.getDimensionPixelOffset(jv.MaterialButton_android_insetRight, 0);
        this.c = typedArray.getDimensionPixelOffset(jv.MaterialButton_android_insetTop, 0);
        this.d = typedArray.getDimensionPixelOffset(jv.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(jv.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(jv.MaterialButton_cornerRadius, -1);
            this.f814e = dimensionPixelSize;
            u(this.f802a.u(dimensionPixelSize));
            this.f812c = true;
        }
        this.f = typedArray.getDimensionPixelSize(jv.MaterialButton_strokeWidth, 0);
        this.f804a = gy.e(typedArray.getInt(jv.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f803a = ny.a(this.f807a.getContext(), typedArray, jv.MaterialButton_backgroundTint);
        this.f809b = ny.a(this.f807a.getContext(), typedArray, jv.MaterialButton_strokeColor);
        this.f811c = ny.a(this.f807a.getContext(), typedArray, jv.MaterialButton_rippleColor);
        this.f813d = typedArray.getBoolean(jv.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(jv.MaterialButton_elevation, 0);
        int iD = eh.D(this.f807a);
        int paddingTop = this.f807a.getPaddingTop();
        int iC = eh.C(this.f807a);
        int paddingBottom = this.f807a.getPaddingBottom();
        if (typedArray.hasValue(jv.MaterialButton_android_background)) {
            q();
        } else {
            this.f807a.setInternalBackground(a());
            iz izVarD = d();
            if (izVarD != null) {
                izVarD.T(dimensionPixelSize2);
            }
        }
        eh.w0(this.f807a, iD + this.f6046a, paddingTop + this.c, iC + this.b, paddingBottom + this.d);
    }

    public void p(int i) {
        if (d() != null) {
            d().setTint(i);
        }
    }

    public void q() {
        this.f810b = true;
        this.f807a.setSupportBackgroundTintList(this.f803a);
        this.f807a.setSupportBackgroundTintMode(this.f804a);
    }

    public void r(boolean z) {
        this.f813d = z;
    }

    public void s(int i) {
        if (this.f812c && this.f814e == i) {
            return;
        }
        this.f814e = i;
        this.f812c = true;
        u(this.f802a.u(i));
    }

    public void t(ColorStateList colorStateList) {
        if (this.f811c != colorStateList) {
            this.f811c = colorStateList;
            if (e && (this.f807a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f807a.getBackground()).setColor(wy.d(colorStateList));
            } else {
                if (e || !(this.f807a.getBackground() instanceof vy)) {
                    return;
                }
                ((vy) this.f807a.getBackground()).setTintList(wy.d(colorStateList));
            }
        }
    }

    public void u(nz nzVar) {
        this.f802a = nzVar;
        A(nzVar);
    }

    public void v(boolean z) {
        this.f808a = z;
        C();
    }

    public void w(ColorStateList colorStateList) {
        if (this.f809b != colorStateList) {
            this.f809b = colorStateList;
            C();
        }
    }

    public void x(int i) {
        if (this.f != i) {
            this.f = i;
            C();
        }
    }

    public void y(ColorStateList colorStateList) {
        if (this.f803a != colorStateList) {
            this.f803a = colorStateList;
            if (d() != null) {
                kd.o(d(), this.f803a);
            }
        }
    }

    public void z(PorterDuff.Mode mode) {
        if (this.f804a != mode) {
            this.f804a = mode;
            if (d() == null || this.f804a == null) {
                return;
            }
            kd.p(d(), this.f804a);
        }
    }
}
