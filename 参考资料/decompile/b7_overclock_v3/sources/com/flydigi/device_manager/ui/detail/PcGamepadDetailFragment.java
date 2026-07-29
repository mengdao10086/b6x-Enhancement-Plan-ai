package com.flydigi.device_manager.ui.detail;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import c7.j1;
import com.alibaba.android.arouter.facade.Postcard;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.DeviceDetailBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.c;
import com.flydigi.device_manager.ui.detail.item.QAItem;
import com.flydigi.device_manager.view.FirmwareUpgradeActionItem;
import com.yqritc.recyclerviewflexibledivider.a;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nPcGamepadDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PcGamepadDetailFragment.kt\ncom/flydigi/device_manager/ui/detail/PcGamepadDetailFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,155:1\n1855#2,2:156\n*S KotlinDebug\n*F\n+ 1 PcGamepadDetailFragment.kt\ncom/flydigi/device_manager/ui/detail/PcGamepadDetailFragment\n*L\n147#1:156,2\n*E\n"})
public final class PcGamepadDetailFragment extends FZFragment implements c.b, b.z {

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public static final a f14594s8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public j1 f14595o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public final c.a f14596p8 = new DetailPresenter(this);

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public String f14597q8 = "all";

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.k
    public final eu.davidea.flexibleadapter.b<QAItem> f14598r8 = new eu.davidea.flexibleadapter.b<>(null, this, true);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final PcGamepadDetailFragment a(@yt.k String deviceCode) {
            kotlin.jvm.internal.f0.p(deviceCode, "deviceCode");
            PcGamepadDetailFragment pcGamepadDetailFragment = new PcGamepadDetailFragment();
            pcGamepadDetailFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode)));
            return pcGamepadDetailFragment;
        }
    }

    public static final void a6(PcGamepadDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        h3.a.j().d(a.d.f31952h).withString("key_device_code", this$0.f14597q8).navigation(this$0.w1());
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString("key_device_code") : null;
        if (string == null) {
            string = "all";
        }
        this.f14597q8 = string;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_pc_gamepad_detail;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) {
        QAItem qAItem;
        DeviceDetailBean.QaListBean qaListBeanD;
        kotlin.jvm.internal.f0.p(view, "view");
        if (i10 == -1 || (qAItem = (QAItem) this.f14598r8.g2(i10)) == null || (qaListBeanD = qAItem.D()) == null) {
            return false;
        }
        int dataType = qaListBeanD.getDataType();
        if (dataType != 1) {
            if (dataType != 2) {
                return false;
            }
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_TITLE, qaListBeanD.getName()).withString(DataConstant.WEB_URL, qaListBeanD.getData()).navigation();
            return true;
        }
        Postcard postcardD = h3.a.j().d(a.b.f31919d);
        String data = qaListBeanD.getData();
        kotlin.jvm.internal.f0.o(data, "it.data");
        postcardD.withInt("id", Integer.parseInt(data)).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13284b).navigation();
        return true;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        j1 j1VarD = j1.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(j1VarD, "inflate(inflater, container, false)");
        this.f14595o8 = j1VarD;
        if (j1VarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            j1VarD = null;
        }
        NestedScrollView nestedScrollViewB = j1VarD.getRoot();
        kotlin.jvm.internal.f0.o(nestedScrollViewB, "viewBinding.root");
        return nestedScrollViewB;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        com.bumptech.glide.h<Drawable> hVarP = com.bumptech.glide.b.G(this).p(Integer.valueOf(a5.b.l(this.f14597q8)));
        j1 j1Var = this.f14595o8;
        j1 j1Var2 = null;
        if (j1Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            j1Var = null;
        }
        hVarP.s1(j1Var.f10143d);
        j1 j1Var3 = this.f14595o8;
        if (j1Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            j1Var3 = null;
        }
        j1Var3.f10145f.setText(a5.b.c(this.f14597q8));
        j1 j1Var4 = this.f14595o8;
        if (j1Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            j1Var4 = null;
        }
        TextView textView = j1Var4.f10146g;
        String str = this.f14597q8;
        Boolean bool = Boolean.FALSE;
        textView.setText(a5.b.n(str, bool, 0));
        j1 j1Var5 = this.f14595o8;
        if (j1Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            j1Var5 = null;
        }
        j1Var5.f10144e.n(new a.C0280a(X1()).A(V2().getDimensionPixelSize(R.dimen.qb_px_16), 0).m(R.drawable.base_view_divider).y());
        j1 j1Var6 = this.f14595o8;
        if (j1Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            j1Var2 = j1Var6;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = j1Var2.f10141b;
        firmwareUpgradeActionItem.T("", bool, bool);
        com.blankj.utilcode.util.o.r(firmwareUpgradeActionItem, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PcGamepadDetailFragment.a6(this.f14615a, view2);
            }
        });
        this.f14596p8.x(this.f14597q8);
    }

    @Override // com.flydigi.device_manager.ui.detail.c.b
    public void v(@yt.k DeviceDetailBean detailBean) {
        kotlin.jvm.internal.f0.p(detailBean, "detailBean");
        List<DeviceDetailBean.QaListBean> qaList = detailBean.getQaList();
        j1 j1Var = null;
        if (qaList == null || qaList.isEmpty()) {
            j1 j1Var2 = this.f14595o8;
            if (j1Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                j1Var2 = null;
            }
            LinearLayout linearLayout = j1Var2.f10142c;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.areaQa");
            o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
            return;
        }
        j1 j1Var3 = this.f14595o8;
        if (j1Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            j1Var3 = null;
        }
        if (j1Var3.f10144e.getAdapter() == null) {
            j1 j1Var4 = this.f14595o8;
            if (j1Var4 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                j1Var4 = null;
            }
            j1Var4.f10144e.setAdapter(this.f14598r8);
        }
        j1 j1Var5 = this.f14595o8;
        if (j1Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            j1Var5 = null;
        }
        LinearLayout linearLayout2 = j1Var5.f10142c;
        kotlin.jvm.internal.f0.o(linearLayout2, "viewBinding.areaQa");
        o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
        j1 j1Var6 = this.f14595o8;
        if (j1Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            j1Var = j1Var6;
        }
        j1Var.f10147h.setText(detailBean.getQaTitle());
        this.f14598r8.m1();
        List<DeviceDetailBean.QaListBean> qaList2 = detailBean.getQaList();
        kotlin.jvm.internal.f0.o(qaList2, "detailBean.qaList");
        for (DeviceDetailBean.QaListBean it2 : qaList2) {
            eu.davidea.flexibleadapter.b<QAItem> bVar = this.f14598r8;
            kotlin.jvm.internal.f0.o(it2, "it");
            bVar.K0(new QAItem(it2));
        }
    }
}
