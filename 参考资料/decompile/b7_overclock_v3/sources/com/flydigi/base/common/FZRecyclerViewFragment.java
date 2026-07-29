package com.flydigi.base.common;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ToastUtils;
import com.flydigi.base.R;
import com.flydigi.base.net.ApiException;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import eu.davidea.flexibleadapter.b;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FZRecyclerViewFragment extends FZLazyFragment implements b.z, b.a0, b.s, b.e0 {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public SmartRefreshLayout f13329p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public RecyclerView f13330q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public eu.davidea.flexibleadapter.b f13331r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public t5.b f13332s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public t5.a f13333t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public long f13334u8;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e6(View view) {
        this.f13329p8.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f6(mg.j jVar) {
        y0(0, 0);
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void J(int i10) {
        this.f13331r8.Q0(this.f13333t8);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        eu.davidea.flexibleadapter.b bVar = new eu.davidea.flexibleadapter.b(null, this);
        this.f13331r8 = bVar;
        bVar.c4(c6());
        this.f13332s8 = new t5.b();
        this.f13333t8 = i6();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.fragment_recycler_view;
    }

    @Override // eu.davidea.flexibleadapter.b.a0
    public void S(int i10) {
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        this.f13329p8.z();
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        this.f13329p8.N();
    }

    public void b(boolean z10, @n0 Throwable th2) {
        String strC3;
        if (th2 instanceof ApiException) {
            ApiException apiException = (ApiException) th2;
            strC3 = apiException.a() == -101 ? c3(R.string.net_state_error) : com.blankj.utilcode.util.n0.x(apiException.getMessage()) ? apiException.getMessage() : c3(R.string.api_error_notice);
        } else {
            strC3 = c3(R.string.api_error_notice);
        }
        if (z10 && this.f13331r8.T2()) {
            this.f13329p8.m(false);
            W5(strC3, -1);
        } else {
            this.f13331r8.r3(null);
            ToastUtils.V(strC3);
        }
    }

    public abstract int c6();

    public boolean d6() {
        boolean z10 = System.currentTimeMillis() - this.f13334u8 <= 500;
        this.f13334u8 = System.currentTimeMillis();
        return z10;
    }

    @p0
    public RecyclerView.n g6() {
        return null;
    }

    public RecyclerView.o h6() {
        return new LinearLayoutManager(X1());
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        this.f13329p8.m(false);
    }

    public t5.a i6() {
        return new t5.a(c3(R.string.base_no_more_data));
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k @n0 View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.f13329p8 = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.f13330q8 = recyclerView;
        recyclerView.setLayoutManager(h6());
        RecyclerView.n nVarG6 = g6();
        if (nVarG6 != null) {
            this.f13330q8.n(nVarG6);
        }
        this.f13330q8.setAdapter(this.f13331r8);
        P5(this.f13330q8);
        this.f13322i8.setVisibility(8);
        this.f13324k8.setVisibility(8);
        this.f13330q8.setNestedScrollingEnabled(true);
        this.f13325l8.addView(this.f13322i8);
        this.f13325l8.addView(this.f13324k8);
        this.f13324k8.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.base.common.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13367a.e6(view2);
            }
        });
        this.f13329p8.L(new sg.d() { // from class: com.flydigi.base.common.r
            @Override // sg.d
            public final void o(mg.j jVar) {
                this.f13368a.f6(jVar);
            }
        });
    }

    @Override // eu.davidea.flexibleadapter.b.e0
    public void m0(int i10) {
        if (this.f13331r8 == null) {
            return;
        }
        SmartRefreshLayout smartRefreshLayout = this.f13329p8;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.N();
        }
        if (i10 == 0 && this.f13331r8.l2() == 0) {
            U5();
            return;
        }
        T5();
        if (this.f13331r8.l2() % c6() == 0) {
            this.f13331r8.e4(this, this.f13332s8);
        } else {
            this.f13331r8.d4(null);
        }
    }
}
