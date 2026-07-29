package com.flydigi.base.widget.recyclerview.layoutmanager;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.x;

/* JADX INFO: loaded from: classes2.dex */
public class PagerLayoutManager extends LinearLayoutManager {
    public static final String K7 = "PagerLayoutManager";
    public x F7;
    public b G7;
    public RecyclerView H7;
    public int I7;
    public final RecyclerView.q J7;

    public class a implements RecyclerView.q {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void a(View view) {
            if (PagerLayoutManager.this.I7 >= 0) {
                if (PagerLayoutManager.this.G7 != null) {
                    PagerLayoutManager.this.G7.b(true, PagerLayoutManager.this.u0(view));
                }
            } else if (PagerLayoutManager.this.G7 != null) {
                PagerLayoutManager.this.G7.b(false, PagerLayoutManager.this.u0(view));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(View view) {
            if (PagerLayoutManager.this.G7 == null || PagerLayoutManager.this.Y() != 1) {
                return;
            }
            PagerLayoutManager.this.G7.c();
        }
    }

    public interface b {
        void a(int i10, boolean z10);

        void b(boolean z10, int i10);

        void c();
    }

    public PagerLayoutManager(Context context, int i10) {
        this(context, i10, false);
    }

    public void A3(b bVar) {
        this.G7 = bVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        this.I7 = i10;
        return super.Q1(i10, wVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int S1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        this.I7 = i10;
        return super.S1(i10, wVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView) {
        super.Z0(recyclerView);
        this.F7.b(recyclerView);
        this.H7 = recyclerView;
        recyclerView.p(this.J7);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void q1(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        super.q1(wVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i10) {
        View viewH = this.F7.h(this);
        int iU0 = viewH == null ? 0 : u0(viewH);
        if (i10 == 1 || i10 == 2 || this.G7 == null || Y() != 1) {
            return;
        }
        this.G7.a(iU0, iU0 == o0() - 1);
    }

    public final void z3() {
        this.F7 = new x();
    }

    public PagerLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
        this.J7 = new a();
        z3();
    }
}
