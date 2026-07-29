package com.google.android.material.internal;

import android.widget.Checkable;
import androidx.annotation.RestrictTo;
import com.google.android.material.internal.j;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface j<T extends j<T>> extends Checkable {

    public interface a<C> {
        void a(C c10, boolean z10);
    }

    @g.d0
    int getId();

    void setInternalOnCheckedChangeListener(@p0 a<T> aVar);
}
