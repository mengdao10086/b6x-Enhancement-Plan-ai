package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class p extends LinearLayoutManager {
    public static final float F7 = 100.0f;

    public class a extends androidx.recyclerview.widget.q {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.q
        public float w(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public p(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void f2(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.q(i10);
        g2(aVar);
    }
}
