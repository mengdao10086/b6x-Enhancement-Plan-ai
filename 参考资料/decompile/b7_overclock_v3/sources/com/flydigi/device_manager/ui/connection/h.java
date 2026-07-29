package com.flydigi.device_manager.ui.connection;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.b1;
import com.flydigi.device_manager.R;
import java.util.List;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends ei.c<b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f14540e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14541f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14542g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f14543h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f14544i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f14545j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f14546k = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final String f14549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final String f14550d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public static final class b extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final ImageView f14551g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.k
        public final TextView f14552h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @yt.k
        public final TextView f14553i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.iv_pic);
            f0.o(viewFindViewById, "view.findViewById(R.id.iv_pic)");
            this.f14551g = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.tv_title);
            f0.o(viewFindViewById2, "view.findViewById(R.id.tv_title)");
            this.f14552h = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.tv_action);
            f0.o(viewFindViewById3, "view.findViewById(R.id.tv_action)");
            this.f14553i = (TextView) viewFindViewById3;
        }

        @yt.k
        public final ImageView r() {
            return this.f14551g;
        }

        @yt.k
        public final TextView s() {
            return this.f14553i;
        }

        @yt.k
        public final TextView t() {
            return this.f14552h;
        }
    }

    public /* synthetic */ h(int i10, int i11, String str, String str2, int i12, kotlin.jvm.internal.u uVar) {
        this((i12 & 1) != 0 ? 0 : i10, i11, str, (i12 & 8) != 0 ? null : str2);
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public b i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new b(view, adapter);
    }

    public final int B() {
        return this.f14548b;
    }

    public final int C() {
        return this.f14547a;
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_failure_situation;
    }

    @Override // ei.c
    public boolean equals(@yt.l Object obj) {
        return this == obj;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@yt.l eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> bVar, @yt.k b holder, int i10, @yt.l List<Object> list) {
        f0.p(holder, "holder");
        boolean z10 = true;
        if (this.f14548b != 0) {
            com.bumptech.glide.b.F(holder.r()).p(Integer.valueOf(this.f14548b)).a(com.bumptech.glide.request.h.a1(new c4.c(new com.bumptech.glide.load.resource.bitmap.l(), new RoundedCornersTransformation(b1.b(4.0f), 0, RoundedCornersTransformation.CornerType.ALL)))).s1(holder.r());
        }
        holder.t().setText(this.f14549c);
        String str = this.f14550d;
        if (str != null && str.length() != 0) {
            z10 = false;
        }
        if (z10) {
            o5.c.b(holder.s(), Boolean.FALSE, false, 2, null);
        } else {
            o5.c.b(holder.s(), Boolean.TRUE, false, 2, null);
            holder.s().setText(Html.fromHtml(this.f14550d));
        }
    }

    public h(int i10, @g.v int i11, @yt.k String titleStr, @yt.l String str) {
        f0.p(titleStr, "titleStr");
        this.f14547a = i10;
        this.f14548b = i11;
        this.f14549c = titleStr;
        this.f14550d = str;
    }
}
