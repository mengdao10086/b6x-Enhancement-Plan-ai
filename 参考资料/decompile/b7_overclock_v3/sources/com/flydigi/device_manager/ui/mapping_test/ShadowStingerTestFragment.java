package com.flydigi.device_manager.ui.mapping_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.g;
import c7.n1;
import com.flydigi.base.common.FZFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.mapping_test.ShadowStingerTestFragment;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class ShadowStingerTestFragment extends FZFragment {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @k
    public static final a f15375p8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public n1 f15376o8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final ShadowStingerTestFragment a() {
            ShadowStingerTestFragment shadowStingerTestFragment = new ShadowStingerTestFragment();
            shadowStingerTestFragment.c5(new Bundle());
            return shadowStingerTestFragment;
        }
    }

    @m
    @k
    public static final ShadowStingerTestFragment e6() {
        return f15375p8.a();
    }

    public static final void f6(View view) {
    }

    public static final void g6(View view) {
    }

    public static final void h6(ShadowStingerTestFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.d6().f10257b.h();
        this$0.d6().f10258c.h();
    }

    public static final void i6(ShadowStingerTestFragment this$0, View view) {
        f0.p(this$0, "this$0");
        g gVarW1 = this$0.w1();
        if (gVarW1 != null) {
            gVarW1.finish();
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_shadow_stinger_test;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        n1 n1VarD = n1.d(inflater, viewGroup, false);
        f0.o(n1VarD, "inflate(inflater, container, false)");
        j6(n1VarD);
        ConstraintLayout constraintLayoutB = d6().getRoot();
        f0.o(constraintLayoutB, "viewBinding.root");
        return constraintLayoutB;
    }

    @k
    public final n1 d6() {
        n1 n1Var = this.f15376o8;
        if (n1Var != null) {
            return n1Var;
        }
        f0.S("viewBinding");
        return null;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        d6().f10257b.setOnClickListener(new View.OnClickListener() { // from class: o7.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShadowStingerTestFragment.f6(view2);
            }
        });
        d6().f10258c.setOnClickListener(new View.OnClickListener() { // from class: o7.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShadowStingerTestFragment.g6(view2);
            }
        });
        d6().f10261f.setOnClickListener(new View.OnClickListener() { // from class: o7.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShadowStingerTestFragment.h6(this.f42799a, view2);
            }
        });
        d6().f10260e.setOnClickListener(new View.OnClickListener() { // from class: o7.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShadowStingerTestFragment.i6(this.f42800a, view2);
            }
        });
    }

    public final void j6(@k n1 n1Var) {
        f0.p(n1Var, "<set-?>");
        this.f15376o8 = n1Var;
    }
}
