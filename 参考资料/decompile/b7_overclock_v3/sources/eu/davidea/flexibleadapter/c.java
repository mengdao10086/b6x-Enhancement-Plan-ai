package eu.davidea.flexibleadapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;
import bi.b;
import g.n0;
import g.p0;
import gi.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends RecyclerView.g implements b.e, b.h, b.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f27322k = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fi.c f27323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f27324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<d> f27325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f27326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ci.b f27327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f27328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b.f f27329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f27330h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f27331i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f27332j = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f27331i = false;
            cVar.f27332j = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"UniqueConstants"})
    public @interface b {

        /* JADX INFO: renamed from: s1, reason: collision with root package name */
        public static final int f27334s1 = 0;

        /* JADX INFO: renamed from: t1, reason: collision with root package name */
        public static final int f27335t1 = 1;

        /* JADX INFO: renamed from: u1, reason: collision with root package name */
        public static final int f27336u1 = 2;
    }

    public c() {
        if (fi.b.f28518e == null) {
            fi.b.p("FlexibleAdapter");
        }
        fi.c cVar = new fi.c(fi.b.f28518e);
        this.f27323a = cVar;
        cVar.d("Running version %s", eu.davidea.flexibleadapter.a.f27244f);
        this.f27324b = Collections.synchronizedSet(new TreeSet());
        this.f27325c = new HashSet();
        this.f27326d = 0;
        this.f27329g = new b.f();
    }

    public static void N(String str) {
        fi.b.p(str);
    }

    public static void p(int i10) {
        fi.b.o(i10);
    }

    public abstract boolean A(int i10);

    public boolean B(int i10) {
        return this.f27324b.contains(Integer.valueOf(i10));
    }

    public final void C(int i10, int i11) {
        if (i11 > 0) {
            Iterator<d> it2 = this.f27325c.iterator();
            while (it2.hasNext()) {
                it2.next().q();
            }
            if (this.f27325c.isEmpty()) {
                notifyItemRangeChanged(i10, i11, Payload.SELECTION);
            }
        }
    }

    public void D(Bundle bundle) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f27322k);
        if (integerArrayList != null) {
            this.f27324b.addAll(integerArrayList);
            if (u() > 0) {
                this.f27323a.a("Restore selection %s", this.f27324b);
            }
        }
    }

    public void E(Bundle bundle) {
        bundle.putIntegerArrayList(f27322k, new ArrayList<>(this.f27324b));
        if (u() > 0) {
            this.f27323a.a("Saving selection %s", this.f27324b);
        }
    }

    public final boolean F(int i10) {
        return this.f27324b.remove(Integer.valueOf(i10));
    }

    public final void G() {
        if (this.f27331i || this.f27332j) {
            this.f27328f.postDelayed(new a(), 200L);
        }
    }

    public void H(Integer... numArr) {
        this.f27331i = true;
        List listAsList = Arrays.asList(numArr);
        this.f27323a.e("selectAll ViewTypes to include %s", listAsList);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < getItemCount(); i12++) {
            if (A(i12) && (listAsList.isEmpty() || listAsList.contains(Integer.valueOf(getItemViewType(i12))))) {
                this.f27324b.add(Integer.valueOf(i12));
                i11++;
            } else if (i10 + i11 == i12) {
                C(i10, i11);
                i10 = i12;
                i11 = 0;
            }
        }
        this.f27323a.a("selectAll notifyItemRangeChanged from positionStart=%s itemCount=%s", Integer.valueOf(i10), Integer.valueOf(getItemCount()));
        C(i10, getItemCount());
    }

    public void I(ci.b bVar) {
        this.f27327e = bVar;
    }

    public void J(int i10) {
        this.f27323a.d("Mode %s enabled", fi.a.f(i10));
        if (this.f27326d == 1 && i10 == 0) {
            n();
        }
        this.f27326d = i10;
        this.f27332j = i10 != 2;
    }

    public void K(int i10, int i11) {
        if (B(i10) && !B(i11)) {
            F(i10);
            m(i11);
        } else {
            if (B(i10) || !B(i11)) {
                return;
            }
            F(i11);
            m(i10);
        }
    }

    public void L() {
        this.f27329g.f();
    }

    public void M(int i10) {
        if (i10 < 0) {
            return;
        }
        if (this.f27326d == 1) {
            n();
        }
        boolean zContains = this.f27324b.contains(Integer.valueOf(i10));
        if (zContains) {
            F(i10);
        } else {
            m(i10);
        }
        fi.c cVar = this.f27323a;
        Object[] objArr = new Object[3];
        objArr[0] = zContains ? "removed" : "added";
        objArr[1] = Integer.valueOf(i10);
        objArr[2] = this.f27324b;
        cVar.e("toggleSelection %s on position %s, current %s", objArr);
    }

    public RecyclerView getRecyclerView() {
        return this.f27328f;
    }

    @Override // bi.b.d
    public void h(@p0 bi.b bVar) {
        this.f27329g.e(bVar);
    }

    @Override // bi.b.h
    public void i(boolean z10) {
        this.f27330h = z10;
    }

    @Override // bi.b.e
    public String k(int i10) {
        return String.valueOf(i10 + 1);
    }

    public final boolean l(int i10) {
        return this.f27324b.add(Integer.valueOf(i10));
    }

    public final boolean m(int i10) {
        return A(i10) && this.f27324b.add(Integer.valueOf(i10));
    }

    public void n() {
        synchronized (this.f27324b) {
            int i10 = 0;
            this.f27323a.a("clearSelection %s", this.f27324b);
            Iterator<Integer> it2 = this.f27324b.iterator();
            int i11 = 0;
            while (it2.hasNext()) {
                int iIntValue = it2.next().intValue();
                it2.remove();
                if (i10 + i11 == iIntValue) {
                    i11++;
                } else {
                    C(i10, i11);
                    i10 = iIntValue;
                    i11 = 1;
                }
            }
            C(i10, i11);
        }
    }

    public void o() {
        this.f27325c.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onAttachedToRecyclerView(@n0 RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        b.f fVar = this.f27329g;
        if (fVar != null) {
            fVar.c(recyclerView);
        }
        this.f27328f = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(@n0 RecyclerView.e0 e0Var, int i10, @n0 List list) {
        if (!(e0Var instanceof d)) {
            e0Var.itemView.setActivated(B(i10));
            return;
        }
        d dVar = (d) e0Var;
        dVar.h().setActivated(B(i10));
        if (dVar.h().isActivated() && dVar.k() > 0.0f) {
            u0.N1(dVar.h(), dVar.k());
        } else if (dVar.k() > 0.0f) {
            u0.N1(dVar.h(), 0.0f);
        }
        if (!dVar.isRecyclable()) {
            this.f27323a.e("onViewBound    recyclable=%s %s %s", Boolean.valueOf(e0Var.isRecyclable()), fi.a.e(e0Var), e0Var);
        } else {
            this.f27325c.add(dVar);
            this.f27323a.e("onViewBound    viewSize=%s %s %s", Integer.valueOf(this.f27325c.size()), fi.a.e(e0Var), e0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onDetachedFromRecyclerView(@n0 RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        b.f fVar = this.f27329g;
        if (fVar != null) {
            fVar.d(recyclerView);
        }
        this.f27328f = null;
        this.f27327e = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onViewRecycled(@n0 RecyclerView.e0 e0Var) {
        if (e0Var instanceof d) {
            this.f27323a.e("onViewRecycled viewSize=%s %s %s recycled=%s", Integer.valueOf(this.f27325c.size()), fi.a.e(e0Var), e0Var, Boolean.valueOf(this.f27325c.remove(e0Var)));
        }
    }

    public Set<d> q() {
        return Collections.unmodifiableSet(this.f27325c);
    }

    @p0
    public bi.b r() {
        return this.f27329g.a();
    }

    public ci.b s() {
        if (this.f27327e == null) {
            Object layoutManager = this.f27328f.getLayoutManager();
            if (layoutManager instanceof ci.b) {
                this.f27327e = (ci.b) layoutManager;
            } else if (layoutManager != null) {
                this.f27327e = new ci.a(this.f27328f);
            }
        }
        return this.f27327e;
    }

    public int t() {
        return this.f27326d;
    }

    public int u() {
        return this.f27324b.size();
    }

    public List<Integer> v() {
        return new ArrayList(this.f27324b);
    }

    public Set<Integer> w() {
        return this.f27324b;
    }

    public boolean x() {
        return this.f27329g.b();
    }

    public boolean y() {
        G();
        return this.f27332j;
    }

    public boolean z() {
        G();
        return this.f27331i;
    }
}
