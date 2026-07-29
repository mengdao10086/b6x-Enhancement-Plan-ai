package b7;

import com.flydigi.data.bean.ArticleForGame;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.data.bean.NoticeBean;
import com.flydigi.data.bean.ProductSale;
import java.util.List;
import m5.c0;
import m5.f0;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public class j implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h5.d f9106a = (h5.d) f0.i().k().g(h5.d.class);

    @Override // b7.a
    public z<List<FirmwareInfoBean>> a(@yt.k String str) {
        return this.f9106a.a(str).s0(c0.p()).s0(c0.t());
    }

    @Override // b7.a
    public z<FirmwareInfoBean> b(@yt.k String str) {
        return this.f9106a.B(str).s0(c0.p()).s0(c0.t());
    }

    @Override // b7.a
    public xi.a d(String str) {
        return null;
    }

    @Override // b7.a
    public z<NoticeBean> e(String str) {
        return this.f9106a.e(str).s0(c0.p()).s0(c0.t());
    }

    @Override // b7.a
    public z<List<ArticleForGame>> f(String str, int i10) {
        return this.f9106a.f(str, i10).s0(c0.p()).s0(c0.t());
    }

    @Override // b7.a
    public xi.a u(String str, int i10) {
        return null;
    }

    @Override // b7.a
    public z<ProductSale> v() {
        return this.f9106a.E().s0(c0.p()).s0(c0.t());
    }

    @Override // b7.a
    public void w(String str, NoticeBean noticeBean) {
    }
}
