package com.flydigi.device_manager.ui.detail.waspwing.b6.more;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.e;
import c7.g0;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.FZFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.b6.more.MoreSettingFragment;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class MoreSettingFragment extends FZFragment {

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @k
    public static final a f14693q8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public g0 f14694o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public b f14695p8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final MoreSettingFragment a() {
            MoreSettingFragment moreSettingFragment = new MoreSettingFragment();
            moreSettingFragment.c5(e.a());
            return moreSettingFragment;
        }
    }

    public interface b {
        void w0();
    }

    @m
    @k
    public static final MoreSettingFragment a6() {
        return f14693q8.a();
    }

    public static final void b6(MoreSettingFragment this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f14695p8;
        if (bVar == null) {
            f0.S("listener");
            bVar = null;
        }
        bVar.w0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f14695p8 = (b) context;
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_detail_waspwing_more_settings;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        g0 g0VarA = g0.a(view);
        f0.o(g0VarA, "bind(view)");
        this.f14694o8 = g0VarA;
        if (g0VarA == null) {
            f0.S("viewBinding");
            g0VarA = null;
        }
        o.r(g0VarA.f10040b, new View.OnClickListener() { // from class: g7.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MoreSettingFragment.b6(this.f29066a, view2);
            }
        });
    }
}
