package com.flydigi.qiji.ui.mall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c4.c;
import com.blankj.utilcode.util.b1;
import com.bumptech.glide.b;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.request.h;
import com.fdg.flashplay.farsef.R;
import com.flydigi.data.bean.BannerBean;
import g.n0;
import java.util.ArrayList;
import java.util.List;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/* JADX INFO: loaded from: classes3.dex */
public class a extends k2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<BannerBean> f16156a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0167a f16157b;

    /* JADX INFO: renamed from: com.flydigi.qiji.ui.mall.a$a, reason: collision with other inner class name */
    public interface InterfaceC0167a {
        void a(BannerBean bannerBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BannerBean bannerBean, View view) {
        InterfaceC0167a interfaceC0167a = this.f16157b;
        if (interfaceC0167a != null) {
            interfaceC0167a.a(bannerBean);
        }
    }

    public void c(InterfaceC0167a interfaceC0167a) {
        this.f16157b = interfaceC0167a;
    }

    @Override // k2.a
    public void destroyItem(@n0 ViewGroup viewGroup, int i10, @n0 Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // k2.a
    public int getCount() {
        return this.f16156a.size();
    }

    @Override // k2.a
    @n0
    public Object instantiateItem(@n0 ViewGroup viewGroup, int i10) {
        final BannerBean bannerBean = this.f16156a.get(i10);
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_layout_community_home_banner, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_banner);
        b.F(viewInflate).t(bannerBean.getImage()).E0(R.drawable.main_recommend_bg_banner_place_holder).x(R.drawable.main_recommend_bg_banner_place_holder).a(h.a1(new c(new l(), new RoundedCornersTransformation(b1.b(13.0f), 0, RoundedCornersTransformation.CornerType.ALL)))).s1(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: g9.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f29079a.b(bannerBean, view);
            }
        });
        viewGroup.addView(viewInflate);
        return viewInflate;
    }

    @Override // k2.a
    public boolean isViewFromObject(@n0 View view, @n0 Object obj) {
        return view == obj;
    }

    public void setData(List<BannerBean> list) {
        this.f16156a = list;
        notifyDataSetChanged();
    }
}
