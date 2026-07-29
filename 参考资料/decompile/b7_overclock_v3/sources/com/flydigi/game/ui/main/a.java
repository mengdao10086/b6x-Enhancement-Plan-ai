package com.flydigi.game.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.request.h;
import com.flydigi.data.bean.BannerBean;
import com.flydigi.game.R;
import g.n0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class a extends k2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<BannerBean> f15895a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0162a f15896b;

    /* JADX INFO: renamed from: com.flydigi.game.ui.main.a$a, reason: collision with other inner class name */
    public interface InterfaceC0162a {
        void a(BannerBean bannerBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BannerBean bannerBean, View view) {
        InterfaceC0162a interfaceC0162a = this.f15896b;
        if (interfaceC0162a != null) {
            interfaceC0162a.a(bannerBean);
        }
    }

    public void c(InterfaceC0162a interfaceC0162a) {
        this.f15896b = interfaceC0162a;
    }

    @Override // k2.a
    public void destroyItem(@n0 ViewGroup viewGroup, int i10, @n0 Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // k2.a
    public int getCount() {
        return this.f15895a.size();
    }

    @Override // k2.a
    @n0
    public Object instantiateItem(@n0 ViewGroup viewGroup, int i10) {
        final BannerBean bannerBean = this.f15895a.get(i10);
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_item_home_banner, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_banner);
        com.bumptech.glide.b.F(viewInflate).Y(new h().E0(R.drawable.pic_banner_place_holder)).t(bannerBean.getImage()).s1(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: w8.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f54589a.b(bannerBean, view);
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
        this.f15895a = list;
        notifyDataSetChanged();
    }
}
