package com.flydigi.device_manager.ui.device_list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.s0;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.DeviceListBean;
import com.flydigi.device_manager.R;
import java.util.List;
import o5.m;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceItem extends AbstractModelItem<DeviceListBean.CategoryBean.SectionBean.DeviceBean, a> {

    public static class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f14821g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ImageView f14822h;

        public a(View view, eu.davidea.flexibleadapter.b bVar) {
            super(view, bVar);
            this.f14822h = (ImageView) view.findViewById(R.id.iv_device);
            this.f14821g = (TextView) view.findViewById(R.id.tv_device_name);
        }
    }

    public DeviceItem(DeviceListBean.CategoryBean.SectionBean.DeviceBean deviceBean) {
        super(deviceBean);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(eu.davidea.flexibleadapter.b<ei.h> bVar, a aVar, int i10, List<Object> list) {
        aVar.f14821g.setText(z().getDeviceName());
        if (n0.m(z().getListPic())) {
            aVar.f14822h.setImageResource(a5.b.l(z().getDeviceType()));
            return;
        }
        if (z().getListPic().startsWith("http")) {
            com.bumptech.glide.b.F(aVar.f14822h).t(z().getListPic()).s1(aVar.f14822h);
            return;
        }
        int iG = s0.g(z().getListPic() + "_" + m.l(DataConstant.SP_FLOAT, 2).r(DataConstant.SP_FLOAT_KEY_CHANNEL_NAME, ""));
        if (iG == 0) {
            iG = s0.g(z().getListPic());
        }
        if (iG != 0) {
            aVar.f14822h.setImageResource(iG);
        }
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(View view, eu.davidea.flexibleadapter.b<ei.h> bVar) {
        return new a(view, bVar);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_product;
    }
}
