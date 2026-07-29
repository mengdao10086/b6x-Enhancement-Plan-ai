package com.flydigi.qiji.ui.mall.detail;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.fdg.flashplay.farsef.R;
import ei.h;
import java.util.List;
import kotlin.jvm.internal.f0;
import s4.p;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ei.c<C0168a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final String f16164a;

    /* JADX INFO: renamed from: com.flydigi.qiji.ui.mall.detail.a$a, reason: collision with other inner class name */
    public static final class C0168a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final ImageView f16165g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0168a(@k View view, @k eu.davidea.flexibleadapter.b<? extends h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.iv_product_desc);
            f0.o(viewFindViewById, "view.findViewById(R.id.iv_product_desc)");
            this.f16165g = (ImageView) viewFindViewById;
        }

        @k
        public final ImageView r() {
            return this.f16165g;
        }
    }

    public static final class b implements com.bumptech.glide.request.g<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0168a f16166a;

        public b(C0168a c0168a) {
            this.f16166a = c0168a;
        }

        @Override // com.bumptech.glide.request.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean e(@l Bitmap bitmap, @l Object obj, @l p<Bitmap> pVar, @l DataSource dataSource, boolean z10) {
            int width = bitmap != null ? bitmap.getWidth() : 0;
            int height = bitmap != null ? bitmap.getHeight() : 0;
            if (width != 0) {
                int width2 = (height * this.f16166a.r().getWidth()) / width;
                ViewGroup.LayoutParams layoutParams = this.f16166a.r().getLayoutParams();
                f0.n(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).height = width2;
            }
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean d(@l GlideException glideException, @l Object obj, @l p<Bitmap> pVar, boolean z10) {
            return false;
        }
    }

    public a(@k String url) {
        f0.p(url, "url");
        this.f16164a = url;
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public C0168a i(@k View view, @k eu.davidea.flexibleadapter.b<h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new C0168a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.main_item_mall_product_detail_describe;
    }

    @Override // ei.c
    public boolean equals(@l Object obj) {
        return this == obj;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@k eu.davidea.flexibleadapter.b<h<RecyclerView.e0>> adapter, @k C0168a holder, int i10, @l List<Object> list) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        com.bumptech.glide.b.F(holder.r()).x().t(this.f16164a).u1(new b(holder)).s1(holder.r());
    }
}
