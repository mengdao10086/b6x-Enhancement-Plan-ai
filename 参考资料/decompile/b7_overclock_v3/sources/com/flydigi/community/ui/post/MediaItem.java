package com.flydigi.community.ui.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.ContentAddBean;
import java.util.List;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaItem extends AbstractModelItem<ContentAddBean, a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final y5.a0 f13991g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<?> adapter) {
            super(view, adapter);
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(adapter, "adapter");
            y5.a0 a0VarA = y5.a0.a(view);
            kotlin.jvm.internal.f0.o(a0VarA, "bind(view)");
            this.f13991g = a0VarA;
            a0VarA.f56256b.setOnClickListener(this);
        }

        @yt.k
        public final y5.a0 r() {
            return this.f13991g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaItem(@yt.k ContentAddBean data) {
        super(data);
        kotlin.jvm.internal.f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k a holder, int i10, @yt.k List<Object> payloads) {
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        kotlin.jvm.internal.f0.p(holder, "holder");
        kotlin.jvm.internal.f0.p(payloads, "payloads");
        String str = n0.x(z().path) ? z().path : n0.x(z().url) ? z().url : n0.x(z().videoCover) ? z().videoCover : null;
        if (!n0.x(str)) {
            SuperButton superButton = holder.r().f56256b;
            kotlin.jvm.internal.f0.o(superButton, "holder.viewBinding.btnRemove");
            o5.c.b(superButton, Boolean.FALSE, false, 2, null);
        } else {
            SuperButton superButton2 = holder.r().f56256b;
            kotlin.jvm.internal.f0.o(superButton2, "holder.viewBinding.btnRemove");
            o5.c.b(superButton2, Boolean.TRUE, false, 2, null);
            com.bumptech.glide.h<Drawable> hVarT = com.bumptech.glide.b.F(holder.r().f56257c).t(str);
            int i11 = R.drawable.ic_place_holder;
            hVarT.E0(i11).x(i11).s1(holder.r().f56257c);
        }
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        kotlin.jvm.internal.f0.p(view, "view");
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_add_image;
    }
}
