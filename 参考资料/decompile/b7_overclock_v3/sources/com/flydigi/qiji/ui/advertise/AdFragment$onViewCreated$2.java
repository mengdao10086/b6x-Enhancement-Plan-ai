package com.flydigi.qiji.ui.advertise;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.o;
import com.flydigi.data.bean.AdvertiseBean;
import com.flydigi.qiji.ui.advertise.AdFragment;
import ik.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.z1;

/* JADX INFO: loaded from: classes3.dex */
public final class AdFragment$onViewCreated$2 extends Lambda implements l<AdvertiseBean, z1> {
    public final /* synthetic */ AdFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFragment$onViewCreated$2(AdFragment adFragment) {
        super(1);
        this.this$0 = adFragment;
    }

    public static final void k(AdFragment this$0, AdvertiseBean advertiseBean, View view) {
        f0.p(this$0, "this$0");
        this$0.f16081p8 = true;
        int type = advertiseBean.getType();
        String data = advertiseBean.getData();
        f0.o(data, "it.data");
        this$0.p6(type, data);
    }

    public static final void n(AdFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f16082q8 = true;
        AdFragment.a aVar = this$0.f16080o8;
        if (aVar == null) {
            f0.S("mCallback");
            aVar = null;
        }
        aVar.k2();
    }

    public final void f(final AdvertiseBean advertiseBean) {
        b9.b bVar = this.this$0.f16083r8;
        b9.b bVar2 = null;
        if (bVar == null) {
            f0.S("viewBinding");
            bVar = null;
        }
        ImageView imageView = bVar.f9146b;
        final AdFragment adFragment = this.this$0;
        o.r(imageView, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.advertise.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdFragment$onViewCreated$2.k(adFragment, advertiseBean, view);
            }
        });
        b9.b bVar3 = this.this$0.f16083r8;
        if (bVar3 == null) {
            f0.S("viewBinding");
            bVar3 = null;
        }
        TextView textView = bVar3.f9148d;
        final AdFragment adFragment2 = this.this$0;
        o.r(textView, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.advertise.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdFragment$onViewCreated$2.n(adFragment2, view);
            }
        });
        b9.b bVar4 = this.this$0.f16083r8;
        if (bVar4 == null) {
            f0.S("viewBinding");
            bVar4 = null;
        }
        bVar4.f9147c.setVisibility(advertiseBean.getHasLogo() == 1 ? 0 : 8);
        com.bumptech.glide.h hVarC = com.bumptech.glide.b.G(this.this$0).t(advertiseBean.getUrl()).c();
        b9.b bVar5 = this.this$0.f16083r8;
        if (bVar5 == null) {
            f0.S("viewBinding");
        } else {
            bVar2 = bVar5;
        }
        hVarC.s1(bVar2.f9146b);
        this.this$0.j6();
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ z1 i(AdvertiseBean advertiseBean) {
        f(advertiseBean);
        return z1.f38230a;
    }
}
