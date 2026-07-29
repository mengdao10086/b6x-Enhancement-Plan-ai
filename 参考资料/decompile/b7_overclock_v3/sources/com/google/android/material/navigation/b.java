package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.h;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b extends e {

    @n0
    public final Class<?> Q;
    public final int R;

    public b(@n0 Context context, @n0 Class<?> cls, int i10) {
        super(context);
        this.Q = cls;
        this.R = i10;
    }

    @Override // androidx.appcompat.view.menu.e
    @n0
    public MenuItem a(int i10, int i11, int i12, @n0 CharSequence charSequence) {
        if (size() + 1 <= this.R) {
            m0();
            MenuItem menuItemA = super.a(i10, i11, i12, charSequence);
            if (menuItemA instanceof h) {
                ((h) menuItemA).w(true);
            }
            l0();
            return menuItemA;
        }
        String simpleName = this.Q.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.R + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    @n0
    public SubMenu addSubMenu(int i10, int i11, int i12, @n0 CharSequence charSequence) {
        throw new UnsupportedOperationException(this.Q.getSimpleName() + " does not support submenus");
    }

    public int n0() {
        return this.R;
    }
}
