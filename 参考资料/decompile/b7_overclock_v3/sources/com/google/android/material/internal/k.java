package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class k extends androidx.appcompat.view.menu.e {
    public k(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    @n0
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        androidx.appcompat.view.menu.h hVar = (androidx.appcompat.view.menu.h) a(i10, i11, i12, charSequence);
        m mVar = new m(x(), this, hVar);
        hVar.A(mVar);
        return mVar;
    }
}
