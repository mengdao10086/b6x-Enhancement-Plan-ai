package com.flydigi.device_manager.ui.mapping_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.g;
import c7.p1;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.FZFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.mapping_test.StingerTestFragment;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class StingerTestFragment extends FZFragment {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @k
    public static final a f15377p8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public p1 f15378o8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final StingerTestFragment a() {
            StingerTestFragment stingerTestFragment = new StingerTestFragment();
            stingerTestFragment.c5(new Bundle());
            return stingerTestFragment;
        }
    }

    @m
    @k
    public static final StingerTestFragment e6() {
        return f15377p8.a();
    }

    public static final void f6(View view) {
    }

    public static final void g6(View view) {
    }

    public static final void h6(StingerTestFragment this$0, View view) {
        f0.p(this$0, "this$0");
        p1 p1Var = this$0.f15378o8;
        p1 p1Var2 = null;
        if (p1Var == null) {
            f0.S("viewBinding");
            p1Var = null;
        }
        p1Var.f10331b.h();
        p1 p1Var3 = this$0.f15378o8;
        if (p1Var3 == null) {
            f0.S("viewBinding");
        } else {
            p1Var2 = p1Var3;
        }
        p1Var2.f10332c.h();
    }

    public static final void i6(StingerTestFragment this$0, View view) {
        f0.p(this$0, "this$0");
        r7.a aVar = r7.a.f47747a;
        g gVarW1 = this$0.w1();
        if (gVarW1 == null) {
            gVarW1 = this$0.f13317d8;
        }
        f0.o(gVarW1, "activity ?: mActivity");
        aVar.a(gVarW1);
    }

    public static final void j6(StingerTestFragment this$0, View view) {
        f0.p(this$0, "this$0");
        g gVarW1 = this$0.w1();
        if (gVarW1 != null) {
            gVarW1.finish();
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_stinger_test;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        p1 p1VarD = p1.d(inflater, viewGroup, false);
        f0.o(p1VarD, "inflate(inflater, container, false)");
        this.f15378o8 = p1VarD;
        if (p1VarD == null) {
            f0.S("viewBinding");
            p1VarD = null;
        }
        ConstraintLayout constraintLayoutB = p1VarD.getRoot();
        f0.o(constraintLayoutB, "viewBinding.root");
        return constraintLayoutB;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        p1 p1Var = this.f15378o8;
        p1 p1Var2 = null;
        if (p1Var == null) {
            f0.S("viewBinding");
            p1Var = null;
        }
        p1Var.f10331b.setOnClickListener(new View.OnClickListener() { // from class: o7.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StingerTestFragment.f6(view2);
            }
        });
        p1 p1Var3 = this.f15378o8;
        if (p1Var3 == null) {
            f0.S("viewBinding");
            p1Var3 = null;
        }
        p1Var3.f10332c.setOnClickListener(new View.OnClickListener() { // from class: o7.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StingerTestFragment.g6(view2);
            }
        });
        p1 p1Var4 = this.f15378o8;
        if (p1Var4 == null) {
            f0.S("viewBinding");
            p1Var4 = null;
        }
        p1Var4.f10336g.setOnClickListener(new View.OnClickListener() { // from class: o7.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StingerTestFragment.h6(this.f42803a, view2);
            }
        });
        p1 p1Var5 = this.f15378o8;
        if (p1Var5 == null) {
            f0.S("viewBinding");
            p1Var5 = null;
        }
        o.r(p1Var5.f10335f, new View.OnClickListener() { // from class: o7.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StingerTestFragment.i6(this.f42805a, view2);
            }
        });
        p1 p1Var6 = this.f15378o8;
        if (p1Var6 == null) {
            f0.S("viewBinding");
        } else {
            p1Var2 = p1Var6;
        }
        o.r(p1Var2.f10334e, new View.OnClickListener() { // from class: o7.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StingerTestFragment.j6(this.f42804a, view2);
            }
        });
    }
}
