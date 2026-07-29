package com.flydigi.device_manager.ui.detail.waspwing.b6.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.e;
import c7.h0;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.b6.more.AppearanceSettingFragment;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import o5.c;
import o5.m;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class AppearanceSettingFragment extends FZFragment {

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @k
    public static final a f14689q8 = new a(null);

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @k
    public static final String f14690r8 = "key_ip_type";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public h0 f14691o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public int f14692p8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final AppearanceSettingFragment a(int i10) {
            AppearanceSettingFragment appearanceSettingFragment = new AppearanceSettingFragment();
            appearanceSettingFragment.c5(e.b(new Pair(AppearanceSettingFragment.f14690r8, Integer.valueOf(i10))));
            return appearanceSettingFragment;
        }
    }

    public static final void c6(AppearanceSettingFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f6(0);
    }

    public static final void d6(AppearanceSettingFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f6(1);
    }

    public static final void e6(AppearanceSettingFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f6(2);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_detail_waspwing_setting_appearance;
    }

    public final void f6(int i10) {
        h0 h0Var = this.f14691o8;
        if (h0Var == null) {
            f0.S("viewBinding");
            h0Var = null;
        }
        ImageView imageView = h0Var.f10080g;
        f0.o(imageView, "viewBinding.ivSelectedStandard");
        c.b(imageView, Boolean.valueOf(i10 == 0), false, 2, null);
        h0 h0Var2 = this.f14691o8;
        if (h0Var2 == null) {
            f0.S("viewBinding");
            h0Var2 = null;
        }
        ImageView imageView2 = h0Var2.f10079f;
        f0.o(imageView2, "viewBinding.ivSelectedOp");
        c.b(imageView2, Boolean.valueOf(i10 == 1), false, 2, null);
        h0 h0Var3 = this.f14691o8;
        if (h0Var3 == null) {
            f0.S("viewBinding");
            h0Var3 = null;
        }
        ImageView imageView3 = h0Var3.f10078e;
        f0.o(imageView3, "viewBinding.ivSelectedMhy");
        c.b(imageView3, Boolean.valueOf(i10 == 2), false, 2, null);
        if (this.f14692p8 != i10) {
            this.f14692p8 = i10;
            m.k(DataConstant.SP_APP).x(DataConstant.SP_APP_KEY_WASPWING_IP_TYPE, this.f14692p8);
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        h0 h0VarA = h0.a(view);
        f0.o(h0VarA, "bind(view)");
        this.f14691o8 = h0VarA;
        Bundle bundleT1 = T1();
        this.f14692p8 = bundleT1 != null ? bundleT1.getInt(f14690r8) : 0;
        h0 h0Var = this.f14691o8;
        h0 h0Var2 = null;
        if (h0Var == null) {
            f0.S("viewBinding");
            h0Var = null;
        }
        TextView textView = h0Var.f10083j;
        int i10 = R.string.device_ip_type_desc;
        int i11 = R.string.device_name_radiator;
        textView.setText(d3(i10, c3(i11), c3(R.string.device_ip_type_standard)));
        h0 h0Var3 = this.f14691o8;
        if (h0Var3 == null) {
            f0.S("viewBinding");
            h0Var3 = null;
        }
        h0Var3.f10082i.setText(d3(i10, c3(i11), c3(R.string.device_ip_type_op)));
        h0 h0Var4 = this.f14691o8;
        if (h0Var4 == null) {
            f0.S("viewBinding");
            h0Var4 = null;
        }
        h0Var4.f10081h.setText(d3(i10, c3(i11), c3(R.string.device_ip_type_mhy)));
        h0 h0Var5 = this.f14691o8;
        if (h0Var5 == null) {
            f0.S("viewBinding");
            h0Var5 = null;
        }
        o.r(h0Var5.f10076c, new View.OnClickListener() { // from class: g7.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AppearanceSettingFragment.c6(this.f29063a, view2);
            }
        });
        h0 h0Var6 = this.f14691o8;
        if (h0Var6 == null) {
            f0.S("viewBinding");
            h0Var6 = null;
        }
        o.r(h0Var6.f10077d, new View.OnClickListener() { // from class: g7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AppearanceSettingFragment.d6(this.f29064a, view2);
            }
        });
        h0 h0Var7 = this.f14691o8;
        if (h0Var7 == null) {
            f0.S("viewBinding");
        } else {
            h0Var2 = h0Var7;
        }
        o.r(h0Var2.f10075b, new View.OnClickListener() { // from class: g7.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AppearanceSettingFragment.e6(this.f29065a, view2);
            }
        });
        f6(this.f14692p8);
    }
}
