package com.flydigi.community.ui.message.comment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.MyMessageBean;
import ei.h;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class CommentRecordItem extends AbstractModelItem<MyMessageBean.Message, a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public ImageView f13917g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @k
        public TextView f13918h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @k
        public TextView f13919i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @k
        public TextView f13920j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k eu.davidea.flexibleadapter.b<? extends h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.civ_avatar);
            f0.o(viewFindViewById, "view.findViewById(R.id.civ_avatar)");
            this.f13917g = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.tv_author);
            f0.o(viewFindViewById2, "view.findViewById(R.id.tv_author)");
            this.f13918h = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.tv_time);
            f0.o(viewFindViewById3, "view.findViewById(R.id.tv_time)");
            this.f13919i = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.tv_content);
            f0.o(viewFindViewById4, "view.findViewById(R.id.tv_content)");
            this.f13920j = (TextView) viewFindViewById4;
        }

        @k
        public final ImageView r() {
            return this.f13917g;
        }

        @k
        public final TextView s() {
            return this.f13918h;
        }

        @k
        public final TextView t() {
            return this.f13920j;
        }

        @k
        public final TextView u() {
            return this.f13919i;
        }

        public final void v(@k ImageView imageView) {
            f0.p(imageView, "<set-?>");
            this.f13917g = imageView;
        }

        public final void w(@k TextView textView) {
            f0.p(textView, "<set-?>");
            this.f13918h = textView;
        }

        public final void x(@k TextView textView) {
            f0.p(textView, "<set-?>");
            this.f13920j = textView;
        }

        public final void y(@k TextView textView) {
            f0.p(textView, "<set-?>");
            this.f13919i = textView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentRecordItem(@k MyMessageBean.Message data) {
        super(data);
        f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@l eu.davidea.flexibleadapter.b<h<RecyclerView.e0>> bVar, @k a holder, int i10, @l List<Object> list) {
        f0.p(holder, "holder");
        l5.a.b().h(holder.r(), holder.r(), z().getAvatar());
        holder.s().setText(z().getText());
        if (TextUtils.isEmpty(z().getType()) || !f0.g(z().getType(), "1")) {
            holder.t().setText(z().getMessage());
        } else {
            holder.t().setText(holder.s().getResources().getString(R.string.community_message_with_floor, Integer.valueOf(z().getFloor()), z().getMessage()));
        }
        holder.u().setText(z().getTimeText());
        holder.u().setTextColor(h0.d.f(holder.u().getContext(), z().getIsRead() == 0 ? R.color.colorTextPrimary : R.color.color_b6b6b6));
        holder.t().setTextColor(h0.d.f(holder.t().getContext(), z().getIsRead() == 0 ? R.color.colorTextPrimary : R.color.color_b6b6b6));
        holder.s().setTextColor(h0.d.f(holder.s().getContext(), z().getIsRead() == 0 ? R.color.colorTextPrimary : R.color.color_b6b6b6));
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k eu.davidea.flexibleadapter.b<h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_my_message;
    }
}
