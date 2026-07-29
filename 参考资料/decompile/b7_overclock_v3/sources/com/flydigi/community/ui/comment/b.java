package com.flydigi.community.ui.comment;

import android.view.View;
import android.widget.TextView;
import com.flydigi.community.R;
import java.util.List;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ei.c<C0136b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final a f13839c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final String f13840d = "id";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final String f13841e = "zan";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13842f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f13843g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public String f13845b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.flydigi.community.ui.comment.b$b, reason: collision with other inner class name */
    public final class C0136b extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final TextView f13846g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.k
        public final TextView f13847h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ b f13848i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0136b(@yt.k b bVar, @yt.k View view, eu.davidea.flexibleadapter.b<?> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            this.f13848i = bVar;
            View viewFindViewById = view.findViewById(R.id.tv_comments);
            f0.o(viewFindViewById, "view.findViewById(R.id.tv_comments)");
            this.f13846g = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.tv_sort);
            f0.o(viewFindViewById2, "view.findViewById(R.id.tv_sort)");
            TextView textView = (TextView) viewFindViewById2;
            this.f13847h = textView;
            textView.setOnClickListener(this);
        }

        @yt.k
        public final TextView r() {
            return this.f13847h;
        }

        @yt.k
        public final TextView s() {
            return this.f13846g;
        }
    }

    public b(int i10) {
        this.f13844a = i10;
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public C0136b i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<?>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new C0136b(this, view, adapter);
    }

    public final int B() {
        return this.f13844a;
    }

    @yt.l
    public final String C() {
        return this.f13845b;
    }

    public final void D(int i10) {
        this.f13844a = i10;
    }

    public final void E(@yt.l String str) {
        this.f13845b = str;
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_comment_header;
    }

    @Override // ei.c
    public boolean equals(@yt.l Object obj) {
        return this == obj;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<?>> adapter, @yt.k C0136b holder, int i10, @yt.k List<? extends Object> payloads) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        f0.p(payloads, "payloads");
        if (payloads.contains(1)) {
            this.f13844a--;
        } else if (payloads.contains(2)) {
            this.f13844a++;
        }
        holder.s().setText(holder.r().getResources().getString(R.string.community_comment_count, Integer.valueOf(this.f13844a)));
        String str = this.f13845b;
        if (f0.g(str, "zan")) {
            holder.r().setText(holder.r().getResources().getString(R.string.community_order_by_hot));
        } else if (f0.g(str, "id")) {
            holder.r().setText(holder.r().getResources().getString(R.string.community_order_by_time));
        } else {
            holder.r().setText(holder.r().getResources().getString(R.string.community_order_by_time));
        }
    }
}
