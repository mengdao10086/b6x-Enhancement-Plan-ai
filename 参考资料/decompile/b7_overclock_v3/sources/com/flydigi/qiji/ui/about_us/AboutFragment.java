package com.flydigi.qiji.ui.about_us;

import a9.b;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.e;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.common.o;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.data.DataConstant;
import com.flydigi.qiji.ui.about_us.AboutFragment;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import o5.p;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class AboutFragment extends FZFragment {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @k
    public static final a f16046o8 = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final AboutFragment a() {
            AboutFragment aboutFragment = new AboutFragment();
            aboutFragment.c5(e.a());
            return aboutFragment;
        }
    }

    @m
    @k
    public static final AboutFragment f6() {
        return f16046o8.a();
    }

    public static final void g6(AboutFragment this$0, View view) {
        f0.p(this$0, "this$0");
        if (p.a(this$0.H1(), this$0.c3(R.string.app_name))) {
            o.G(this$0.c3(R.string.app_action_copy_wechat_success), 0, 17);
        }
    }

    public static final void h6(AboutFragment this$0, View view) {
        f0.p(this$0, "this$0");
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? "https://next.flydigi.com/read.php?id=1008&hideTop=1" : "https://bbs.flydigi.com/reads/1034&hideTop=1").withString(DataConstant.WEB_TITLE, this$0.c3(R.string.account_title_privacy_policy)).navigation();
    }

    public static final void i6(View view) {
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.URL_WEIBO).navigation();
    }

    public static final void j6(String site, AboutFragment this$0, View view) {
        f0.p(site, "$site");
        f0.p(this$0, "this$0");
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, site).withString(DataConstant.WEB_TITLE, this$0.c3(R.string.app_feizhi_offical_site)).navigation();
    }

    public static final void k6(AboutFragment this$0, View view) {
        f0.p(this$0, "this$0");
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? b.f326h : b.f327i).withString(DataConstant.WEB_TITLE, this$0.c3(R.string.app_title_disclaimer)).navigation();
    }

    public static final void l6(AboutFragment this$0, View view) {
        f0.p(this$0, "this$0");
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? "https://next.flydigi.com/read.php?id=818&hideTop=1" : "https://bbs.flydigi.com/reads/1035&hideTop=1").withString(DataConstant.WEB_TITLE, this$0.c3(R.string.account_title_user_agreement)).navigation();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_fragment_about_us;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        ActionItemNormal actionItemNormal = (ActionItemNormal) view.findViewById(R.id.ov_wechat);
        if (actionItemNormal != null) {
            actionItemNormal.Q(c3(R.string.app_name));
            com.blankj.utilcode.util.o.r(actionItemNormal, new View.OnClickListener() { // from class: e9.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AboutFragment.g6(this.f26740a, view2);
                }
            });
        }
        ActionItemNormal actionItemNormal2 = (ActionItemNormal) view.findViewById(R.id.ov_weibo);
        if (actionItemNormal2 != null) {
            com.blankj.utilcode.util.o.r(actionItemNormal2, new View.OnClickListener() { // from class: e9.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AboutFragment.i6(view2);
                }
            });
        }
        ActionItemNormal actionItemNormal3 = (ActionItemNormal) view.findViewById(R.id.ov_official_site);
        if (actionItemNormal3 != null) {
            final String str = p.d() ? b.f320b : b.f321c;
            actionItemNormal3.Q(str);
            com.blankj.utilcode.util.o.r(actionItemNormal3, new View.OnClickListener() { // from class: e9.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AboutFragment.j6(str, this, view2);
                }
            });
        }
        ActionItemNormal actionItemNormal4 = (ActionItemNormal) view.findViewById(R.id.ov_disclaimer);
        if (actionItemNormal4 != null) {
            com.blankj.utilcode.util.o.r(actionItemNormal4, new View.OnClickListener() { // from class: e9.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AboutFragment.k6(this.f26741a, view2);
                }
            });
        }
        ActionItemNormal actionItemNormal5 = (ActionItemNormal) view.findViewById(R.id.ov_user_agreement);
        if (actionItemNormal5 != null) {
            com.blankj.utilcode.util.o.r(actionItemNormal5, new View.OnClickListener() { // from class: e9.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AboutFragment.l6(this.f26739a, view2);
                }
            });
        }
        ActionItemNormal actionItemNormal6 = (ActionItemNormal) view.findViewById(R.id.ov_user_privacy);
        if (actionItemNormal6 != null) {
            com.blankj.utilcode.util.o.r(actionItemNormal6, new View.OnClickListener() { // from class: e9.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AboutFragment.h6(this.f26738a, view2);
                }
            });
        }
    }
}
