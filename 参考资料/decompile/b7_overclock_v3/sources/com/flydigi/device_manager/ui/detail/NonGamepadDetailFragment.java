package com.flydigi.device_manager.ui.detail;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import c7.i1;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.n0;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.DeviceDetailBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.c;
import com.flydigi.device_manager.ui.detail.item.QAItem;
import com.flydigi.device_manager.view.ProductHelpItem;
import com.yqritc.recyclerviewflexibledivider.a;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nNonGamepadDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NonGamepadDetailFragment.kt\ncom/flydigi/device_manager/ui/detail/NonGamepadDetailFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,192:1\n1855#2,2:193\n*S KotlinDebug\n*F\n+ 1 NonGamepadDetailFragment.kt\ncom/flydigi/device_manager/ui/detail/NonGamepadDetailFragment\n*L\n151#1:193,2\n*E\n"})
public final class NonGamepadDetailFragment extends FZFragment implements c.b, b.z {

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public static final a f14589s8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @yt.k
    public final c.a f14590o8 = new DetailPresenter(this);

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public String f14591p8 = "all";

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public final eu.davidea.flexibleadapter.b<QAItem> f14592q8 = new eu.davidea.flexibleadapter.b<>(null, this, true);

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public i1 f14593r8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final NonGamepadDetailFragment a(@yt.k String deviceCode) {
            kotlin.jvm.internal.f0.p(deviceCode, "deviceCode");
            NonGamepadDetailFragment nonGamepadDetailFragment = new NonGamepadDetailFragment();
            nonGamepadDetailFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode)));
            return nonGamepadDetailFragment;
        }
    }

    public static final void b6(NonGamepadDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        h3.a.j().d(a.d.f31954j).withString("key_device_code", this$0.f14591p8).navigation();
    }

    public static final void d6(DeviceDetailBean.HelpBean help, View view) {
        kotlin.jvm.internal.f0.p(help, "$help");
        if (help.getUrlType() != 1) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_TITLE, help.getTitle()).withString(DataConstant.WEB_URL, help.getData()).navigation();
            return;
        }
        Postcard postcardD = h3.a.j().d(a.b.f31919d);
        String data = help.getData();
        kotlin.jvm.internal.f0.o(data, "help.data");
        postcardD.withInt("id", Integer.parseInt(data)).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13284b).navigation();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString("key_device_code") : null;
        if (string == null) {
            string = "all";
        }
        this.f14591p8 = string;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_non_gamepad_detail;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) {
        QAItem qAItem;
        DeviceDetailBean.QaListBean qaListBeanD;
        kotlin.jvm.internal.f0.p(view, "view");
        if (i10 == -1 || (qAItem = (QAItem) this.f14592q8.g2(i10)) == null || (qaListBeanD = qAItem.D()) == null) {
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
        i1 i1VarD = i1.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(i1VarD, "inflate(inflater, container, false)");
        this.f14593r8 = i1VarD;
        if (i1VarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            i1VarD = null;
        }
        NestedScrollView nestedScrollViewB = i1VarD.getRoot();
        kotlin.jvm.internal.f0.o(nestedScrollViewB, "viewBinding.root");
        return nestedScrollViewB;
    }

    public final void c6(final DeviceDetailBean.HelpBean helpBean) {
        i1 i1Var = this.f14593r8;
        if (i1Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            i1Var = null;
        }
        ProductHelpItem it2 = i1Var.f10103b;
        kotlin.jvm.internal.f0.o(it2, "it");
        o5.c.b(it2, Boolean.TRUE, false, 2, null);
        it2.setTitle(helpBean.getTitle());
        it2.Q(helpBean.getActionText());
        if (n0.b(this.f14591p8, a5.a.f248d)) {
            com.bumptech.glide.h<Drawable> hVarT = com.bumptech.glide.b.G(this).t(helpBean.getPic());
            int i10 = R.drawable.device_pic_shadow_stinger_record_help;
            hVarT.E0(i10).x(i10).s1((ImageView) it2.findViewById(R.id.iv_help));
        } else {
            com.bumptech.glide.b.G(this).t(helpBean.getPic()).s1((ImageView) it2.findViewById(R.id.iv_help));
        }
        com.blankj.utilcode.util.o.r(it2, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NonGamepadDetailFragment.d6(helpBean, view);
            }
        });
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        com.bumptech.glide.h<Drawable> hVarP = com.bumptech.glide.b.G(this).p(Integer.valueOf(a5.b.l(this.f14591p8)));
        i1 i1Var = this.f14593r8;
        i1 i1Var2 = null;
        if (i1Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            i1Var = null;
        }
        hVarP.s1(i1Var.f10106e);
        i1 i1Var3 = this.f14593r8;
        if (i1Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            i1Var3 = null;
        }
        i1Var3.f10108g.setText(a5.b.c(this.f14591p8));
        i1 i1Var4 = this.f14593r8;
        if (i1Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            i1Var4 = null;
        }
        TextView textView = i1Var4.f10109h;
        String str = this.f14591p8;
        Boolean bool = Boolean.FALSE;
        textView.setText(a5.b.n(str, bool, 0));
        i1 i1Var5 = this.f14593r8;
        if (i1Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            i1Var5 = null;
        }
        i1Var5.f10107f.n(new a.C0280a(X1()).A(V2().getDimensionPixelSize(R.dimen.qb_px_16), 0).m(R.drawable.base_view_divider).y());
        if (kotlin.jvm.internal.f0.g(this.f14591p8, a5.a.f247c) || kotlin.jvm.internal.f0.g(this.f14591p8, a5.a.f248d)) {
            i1 i1Var6 = this.f14593r8;
            if (i1Var6 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                i1Var6 = null;
            }
            i1Var6.f10104c.setTitle(d3(R.string.device_key_mapping_test, a5.b.c(this.f14591p8)));
            i1 i1Var7 = this.f14593r8;
            if (i1Var7 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                i1Var7 = null;
            }
            i1Var7.f10104c.setDesc(c3(R.string.device_action_mapping_test_fc_desc));
            i1 i1Var8 = this.f14593r8;
            if (i1Var8 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                i1Var8 = null;
            }
            ActionItemNormal actionItemNormal = i1Var8.f10104c;
            kotlin.jvm.internal.f0.o(actionItemNormal, "viewBinding.actionTest");
            o5.c.b(actionItemNormal, Boolean.TRUE, false, 2, null);
            i1 i1Var9 = this.f14593r8;
            if (i1Var9 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                i1Var2 = i1Var9;
            }
            i1Var2.f10104c.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NonGamepadDetailFragment.b6(this.f14612a, view2);
                }
            });
        } else {
            i1 i1Var10 = this.f14593r8;
            if (i1Var10 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                i1Var10 = null;
            }
            ActionItemNormal actionItemNormal2 = i1Var10.f10104c;
            kotlin.jvm.internal.f0.o(actionItemNormal2, "viewBinding.actionTest");
            o5.c.b(actionItemNormal2, bool, false, 2, null);
        }
        this.f14590o8.x(this.f14591p8);
    }

    @Override // com.flydigi.device_manager.ui.detail.c.b
    public void v(@yt.k DeviceDetailBean detailBean) {
        kotlin.jvm.internal.f0.p(detailBean, "detailBean");
        if (detailBean.getHelp() != null && detailBean.getHelp().getGoodId() != 0) {
            DeviceDetailBean.HelpBean help = detailBean.getHelp();
            kotlin.jvm.internal.f0.o(help, "detailBean.help");
            c6(help);
        }
        List<DeviceDetailBean.QaListBean> qaList = detailBean.getQaList();
        i1 i1Var = null;
        if (qaList == null || qaList.isEmpty()) {
            i1 i1Var2 = this.f14593r8;
            if (i1Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                i1Var2 = null;
            }
            LinearLayout linearLayout = i1Var2.f10105d;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.areaQa");
            o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
            return;
        }
        i1 i1Var3 = this.f14593r8;
        if (i1Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            i1Var3 = null;
        }
        if (i1Var3.f10107f.getAdapter() == null) {
            i1 i1Var4 = this.f14593r8;
            if (i1Var4 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                i1Var4 = null;
            }
            i1Var4.f10107f.setAdapter(this.f14592q8);
        }
        i1 i1Var5 = this.f14593r8;
        if (i1Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            i1Var5 = null;
        }
        LinearLayout linearLayout2 = i1Var5.f10105d;
        kotlin.jvm.internal.f0.o(linearLayout2, "viewBinding.areaQa");
        o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
        i1 i1Var6 = this.f14593r8;
        if (i1Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            i1Var = i1Var6;
        }
        i1Var.f10110i.setText(detailBean.getQaTitle());
        this.f14592q8.m1();
        List<DeviceDetailBean.QaListBean> qaList2 = detailBean.getQaList();
        kotlin.jvm.internal.f0.o(qaList2, "detailBean.qaList");
        for (DeviceDetailBean.QaListBean it2 : qaList2) {
            eu.davidea.flexibleadapter.b<QAItem> bVar = this.f14592q8;
            kotlin.jvm.internal.f0.o(it2, "it");
            bVar.K0(new QAItem(it2));
        }
    }
}
