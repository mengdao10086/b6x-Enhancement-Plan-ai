package wd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.e;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.c1;
import g.d1;
import g.f;
import g.n0;
import g.p0;
import g.r;
import g.t0;
import g.v;
import l.d;
import le.j;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
public class b extends e.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @f
    public static final int f54641e = R.attr.alertDialogStyle;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @d1
    public static final int f54642f = R.style.MaterialAlertDialog_MaterialComponents;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @f
    public static final int f54643g = R.attr.materialAlertDialogTheme;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public Drawable f54644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    @r
    public final Rect f54645d;

    public b(@n0 Context context) {
        this(context, 0);
    }

    public static Context J(@n0 Context context) {
        int iL = L(context);
        Context contextC = pe.a.c(context, null, f54641e, f54642f);
        return iL == 0 ? contextC : new d(contextC, iL);
    }

    public static int L(@n0 Context context) {
        TypedValue typedValueA = ie.b.a(context, f54643g);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    public static int M(@n0 Context context, int i10) {
        return i10 == 0 ? L(context) : i10;
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public b setView(@p0 View view) {
        return (b) super.setView(view);
    }

    @p0
    public Drawable K() {
        return this.f54644c;
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public b a(@p0 ListAdapter listAdapter, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.a(listAdapter, onClickListener);
    }

    @n0
    public b O(@p0 Drawable drawable) {
        this.f54644c = drawable;
        return this;
    }

    @n0
    public b P(@t0 int i10) {
        this.f54645d.bottom = i10;
        return this;
    }

    @n0
    public b Q(@t0 int i10) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.f54645d.left = i10;
        } else {
            this.f54645d.right = i10;
        }
        return this;
    }

    @n0
    public b R(@t0 int i10) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.f54645d.right = i10;
        } else {
            this.f54645d.left = i10;
        }
        return this;
    }

    @n0
    public b S(@t0 int i10) {
        this.f54645d.top = i10;
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public b b(boolean z10) {
        return (b) super.b(z10);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public b c(@p0 Cursor cursor, @p0 DialogInterface.OnClickListener onClickListener, @n0 String str) {
        return (b) super.c(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public b d(@p0 View view) {
        return (b) super.d(view);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public b e(@v int i10) {
        return (b) super.e(i10);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public b f(@p0 Drawable drawable) {
        return (b) super.f(drawable);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public b g(@f int i10) {
        return (b) super.g(i10);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public b i(@g.e int i10, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.i(i10, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public b j(@p0 CharSequence[] charSequenceArr, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.j(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b k(@c1 int i10) {
        return (b) super.k(i10);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b l(@p0 CharSequence charSequence) {
        return (b) super.l(charSequence);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    public e create() {
        e eVarCreate = super.create();
        Window window = eVarCreate.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.f54644c;
        if (drawable instanceof j) {
            ((j) drawable).n0(u0.R(decorView));
        }
        window.setBackgroundDrawable(c.b(this.f54644c, this.f54645d));
        decorView.setOnTouchListener(new a(eVarCreate, this.f54645d));
        return eVarCreate;
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public b m(@g.e int i10, @p0 boolean[] zArr, @p0 DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.m(i10, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b n(@p0 Cursor cursor, @n0 String str, @n0 String str2, @p0 DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.n(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public b o(@p0 CharSequence[] charSequenceArr, @p0 boolean[] zArr, @p0 DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.o(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public b setNegativeButton(@c1 int i10, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNegativeButton(i10, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public b p(@p0 CharSequence charSequence, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.p(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public b q(@p0 Drawable drawable) {
        return (b) super.q(drawable);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b r(@c1 int i10, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.r(i10, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b s(@p0 CharSequence charSequence, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.s(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b t(@p0 Drawable drawable) {
        return (b) super.t(drawable);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public b u(@p0 DialogInterface.OnCancelListener onCancelListener) {
        return (b) super.u(onCancelListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b v(@p0 DialogInterface.OnDismissListener onDismissListener) {
        return (b) super.v(onDismissListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b w(@p0 AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (b) super.w(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public b x(@p0 DialogInterface.OnKeyListener onKeyListener) {
        return (b) super.x(onKeyListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b setPositiveButton(@c1 int i10, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.setPositiveButton(i10, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public b y(@p0 CharSequence charSequence, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.y(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b z(@p0 Drawable drawable) {
        return (b) super.z(drawable);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public b B(@g.e int i10, int i11, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.B(i10, i11, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public b C(@p0 Cursor cursor, int i10, @n0 String str, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.C(cursor, i10, str, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public b D(@p0 ListAdapter listAdapter, int i10, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.D(listAdapter, i10, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public b E(@p0 CharSequence[] charSequenceArr, int i10, @p0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.E(charSequenceArr, i10, onClickListener);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public b F(@c1 int i10) {
        return (b) super.F(i10);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public b setTitle(@p0 CharSequence charSequence) {
        return (b) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.e.a
    @n0
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public b G(int i10) {
        return (b) super.G(i10);
    }

    public b(@n0 Context context, int i10) {
        super(J(context), M(context, i10));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int i11 = f54641e;
        int i12 = f54642f;
        this.f54645d = c.a(context2, i11, i12);
        int iC = m.c(context2, R.attr.colorSurface, getClass().getCanonicalName());
        j jVar = new j(context2, null, i11, i12);
        jVar.Z(context2);
        jVar.o0(ColorStateList.valueOf(iC));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                jVar.k0(dimension);
            }
        }
        this.f54644c = jVar;
    }
}
