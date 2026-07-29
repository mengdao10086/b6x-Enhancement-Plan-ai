package vd;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;
import com.google.common.collect.LinkedHashMultimap;
import g.f0;
import g.n0;
import g.x;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f53098a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f53099b = 0.54f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f53100c = 0.38f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f53101d = 0.32f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f53102e = 0.12f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f53103f = 40;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f53104g = 100;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f53105h = 90;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f53106i = 10;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f53107j = 80;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f53108k = 20;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f53109l = 30;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f53110m = 90;

    @g.l
    public static int a(@g.l int i10, @f0(from = 0, to = or.a.f44396a) int i11) {
        return m0.g.B(i10, (Color.alpha(i10) * i11) / 255);
    }

    @g.l
    public static int b(@n0 Context context, @g.f int i10, @g.l int i11) {
        TypedValue typedValueA = ie.b.a(context, i10);
        return typedValueA != null ? q(context, typedValueA) : i11;
    }

    @g.l
    public static int c(Context context, @g.f int i10, String str) {
        return q(context, ie.b.i(context, i10, str));
    }

    @g.l
    public static int d(@n0 View view, @g.f int i10) {
        return q(view.getContext(), ie.b.j(view, i10));
    }

    @g.l
    public static int e(@n0 View view, @g.f int i10, @g.l int i11) {
        return b(view.getContext(), i10, i11);
    }

    @g.l
    public static int f(@g.l int i10, @f0(from = 0, to = 100) int i11) {
        l lVarC = l.c(i10);
        lVarC.l(i11);
        return lVarC.m();
    }

    @n0
    public static e g(@g.l int i10, boolean z10) {
        return z10 ? new e(f(i10, 40), f(i10, 100), f(i10, 90), f(i10, 10)) : new e(f(i10, 80), f(i10, 20), f(i10, 30), f(i10, 90));
    }

    @n0
    public static e h(@n0 Context context, @g.l int i10) {
        return g(i10, ie.b.b(context, R.attr.isLightTheme, true));
    }

    @n0
    public static ColorStateList i(@n0 Context context, @g.f int i10, @n0 ColorStateList colorStateList) {
        TypedValue typedValueA = ie.b.a(context, i10);
        ColorStateList colorStateListR = typedValueA != null ? r(context, typedValueA) : null;
        return colorStateListR == null ? colorStateList : colorStateListR;
    }

    @g.l
    public static int j(@g.l int i10, @g.l int i11) {
        return a.c(i10, i11);
    }

    @g.l
    public static int k(@n0 Context context, @g.l int i10) {
        return j(i10, c(context, R.attr.colorPrimary, m.class.getCanonicalName()));
    }

    public static boolean l(@g.l int i10) {
        return i10 != 0 && m0.g.m(i10) > 0.5d;
    }

    @g.l
    public static int m(@g.l int i10, @g.l int i11) {
        return m0.g.t(i11, i10);
    }

    @g.l
    public static int n(@g.l int i10, @g.l int i11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        return m(i10, m0.g.B(i11, Math.round(Color.alpha(i11) * f10)));
    }

    @g.l
    public static int o(@n0 View view, @g.f int i10, @g.f int i11) {
        return p(view, i10, i11, 1.0f);
    }

    @g.l
    public static int p(@n0 View view, @g.f int i10, @g.f int i11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        return n(d(view, i10), d(view, i11), f10);
    }

    public static int q(@n0 Context context, @n0 TypedValue typedValue) {
        int i10 = typedValue.resourceId;
        return i10 != 0 ? h0.d.f(context, i10) : typedValue.data;
    }

    public static ColorStateList r(@n0 Context context, @n0 TypedValue typedValue) {
        int i10 = typedValue.resourceId;
        return i10 != 0 ? h0.d.g(context, i10) : ColorStateList.valueOf(typedValue.data);
    }
}
