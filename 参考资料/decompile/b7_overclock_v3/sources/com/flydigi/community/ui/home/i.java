package com.flydigi.community.ui.home;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.community.R;
import java.util.List;
import kotlin.jvm.internal.f0;
import o5.p;
import top.androidman.SuperButton;
import y5.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends ei.c<a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final j f13903g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            j jVarA = j.a(view);
            f0.o(jVarA, "bind(view)");
            this.f13903g = jVarA;
            jVarA.f56359b.setOnClickListener(this);
            jVarA.f56360c.setOnClickListener(this);
            jVarA.f56361d.setOnClickListener(this);
            SuperButton superButton = jVarA.f56360c;
            f0.o(superButton, "viewBinding.btnPost");
            o5.c.b(superButton, Boolean.valueOf(p.d()), false, 2, null);
        }

        @k
        public final j r() {
            return this.f13903g;
        }
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_fragment_home_item_search_bar;
    }

    @Override // ei.c
    public boolean equals(@l Object obj) {
        return this == obj;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @k a holder, int i10, @l List<Object> list) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
    }
}
