package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.b0;
import com.google.android.material.tabs.TabLayout;
import com.google.common.collect.LinkedHashMultimap;
import g.n0;
import g.p0;
import g.r;
import g.x;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @r(unit = 0)
    public static final int f20846a = 24;

    public static RectF a(TabLayout tabLayout, @p0 View view) {
        return view == null ? new RectF() : (tabLayout.C() || !(view instanceof TabLayout.n)) ? new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : b((TabLayout.n) view, 24);
    }

    public static RectF b(@n0 TabLayout.n nVar, @r(unit = 0) int i10) {
        int contentWidth = nVar.getContentWidth();
        int contentHeight = nVar.getContentHeight();
        int iE = (int) b0.e(nVar.getContext(), i10);
        if (contentWidth < iE) {
            contentWidth = iE;
        }
        int left = (nVar.getLeft() + nVar.getRight()) / 2;
        int top2 = (nVar.getTop() + nVar.getBottom()) / 2;
        int i11 = contentWidth / 2;
        return new RectF(left - i11, top2 - (contentHeight / 2), i11 + left, top2 + (left / 2));
    }

    public void c(TabLayout tabLayout, View view, @n0 Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
    }

    public void d(TabLayout tabLayout, View view, View view2, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @n0 Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        RectF rectFA2 = a(tabLayout, view2);
        drawable.setBounds(kd.a.c((int) rectFA.left, (int) rectFA2.left, f10), drawable.getBounds().top, kd.a.c((int) rectFA.right, (int) rectFA2.right, f10), drawable.getBounds().bottom);
    }
}
