package com.flydigi.community.ui.my.config;

import android.text.TextUtils;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.CfgInfoBean;
import com.flydigi.data.bean.community.ArticleBean;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import y5.d0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class MySharedConfigItem extends AbstractModelItem<ArticleBean, a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final d0 f13966g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            d0 d0VarA = d0.a(view);
            f0.o(d0VarA, "bind(view)");
            this.f13966g = d0VarA;
            d0VarA.f56292c.setOnClickListener(this);
            d0VarA.f56291b.setOnClickListener(this);
            d0VarA.f56298i.setOnClickListener(this);
        }

        @k
        public final d0 r() {
            return this.f13966g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MySharedConfigItem(@k ArticleBean data) {
        super(data);
        f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @k a holder, int i10, @l List<Object> list) {
        z1 z1Var;
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        holder.r().f56294e.setText(z().getDescription());
        holder.r().f56299j.setText(d6.f.a(z().getUpdateTime()));
        CfgInfoBean cfgInfo = z().getCfgInfo();
        if (cfgInfo != null) {
            holder.r().f56295f.setText(cfgInfo.getGameName());
            TextView textView = holder.r().f56295f;
            f0.o(textView, "holder.viewBinding.tvGame");
            Boolean bool = Boolean.TRUE;
            o5.c.b(textView, bool, false, 2, null);
            if (TextUtils.isEmpty(cfgInfo.getModelName())) {
                TextView textView2 = holder.r().f56297h;
                f0.o(textView2, "holder.viewBinding.tvPhone");
                o5.c.b(textView2, Boolean.FALSE, false, 2, null);
            } else {
                holder.r().f56297h.setText(cfgInfo.getModelName());
                TextView textView3 = holder.r().f56297h;
                f0.o(textView3, "holder.viewBinding.tvPhone");
                o5.c.b(textView3, bool, false, 2, null);
            }
            if (TextUtils.isEmpty(cfgInfo.getGamepad())) {
                TextView textView4 = holder.r().f56296g;
                f0.o(textView4, "holder.viewBinding.tvGamepad");
                o5.c.b(textView4, Boolean.FALSE, false, 2, null);
            } else {
                TextView textView5 = holder.r().f56296g;
                String gamepad = cfgInfo.getGamepad();
                f0.o(gamepad, "it.gamepad");
                textView5.setText(com.flydigi.community.ui.article_list.c.a(gamepad));
                TextView textView6 = holder.r().f56296g;
                f0.o(textView6, "holder.viewBinding.tvGamepad");
                o5.c.b(textView6, bool, false, 2, null);
            }
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            TextView textView7 = holder.r().f56295f;
            f0.o(textView7, "holder.viewBinding.tvGame");
            Boolean bool2 = Boolean.FALSE;
            o5.c.b(textView7, bool2, false, 2, null);
            TextView textView8 = holder.r().f56297h;
            f0.o(textView8, "holder.viewBinding.tvPhone");
            o5.c.b(textView8, bool2, false, 2, null);
            TextView textView9 = holder.r().f56296g;
            f0.o(textView9, "holder.viewBinding.tvGamepad");
            o5.c.b(textView9, bool2, false, 2, null);
        }
        String status = z().getStatus();
        if (status != null) {
            int iHashCode = status.hashCode();
            if (iHashCode == -1217487446) {
                if (status.equals(ArticleBean.STATE_IN_AUDIT)) {
                    holder.r().f56298i.setText(R.string.community_article_state_in_audit);
                    holder.r().f56298i.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.community_ic_help, 0);
                    TextView textView10 = holder.r().f56291b;
                    f0.o(textView10, "holder.viewBinding.btnDelete");
                    Boolean bool3 = Boolean.FALSE;
                    o5.c.b(textView10, bool3, false, 2, null);
                    Space space = holder.r().f56293d;
                    f0.o(space, "holder.viewBinding.divider");
                    o5.c.b(space, bool3, false, 2, null);
                    holder.r().f56292c.setText(R.string.community_check);
                    return;
                }
                return;
            }
            if (iHashCode == -1039745817) {
                if (status.equals(ArticleBean.STATE_PUBLISHED)) {
                    holder.r().f56298i.setText(R.string.community_article_state_published);
                    holder.r().f56298i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    TextView textView11 = holder.r().f56291b;
                    f0.o(textView11, "holder.viewBinding.btnDelete");
                    Boolean bool4 = Boolean.TRUE;
                    o5.c.b(textView11, bool4, false, 2, null);
                    Space space2 = holder.r().f56293d;
                    f0.o(space2, "holder.viewBinding.divider");
                    o5.c.b(space2, bool4, false, 2, null);
                    holder.r().f56292c.setText(R.string.edit);
                    return;
                }
                return;
            }
            if (iHashCode == 3135262 && status.equals("fail")) {
                holder.r().f56298i.setText(R.string.community_article_state_reject);
                holder.r().f56298i.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.community_ic_help, 0);
                TextView textView12 = holder.r().f56291b;
                f0.o(textView12, "holder.viewBinding.btnDelete");
                Boolean bool5 = Boolean.TRUE;
                o5.c.b(textView12, bool5, false, 2, null);
                Space space3 = holder.r().f56293d;
                f0.o(space3, "holder.viewBinding.divider");
                o5.c.b(space3, bool5, false, 2, null);
                holder.r().f56292c.setText(R.string.edit);
            }
        }
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_my_shared_config;
    }
}
