package b7;

import com.blankj.utilcode.util.n0;
import com.flydigi.data.bean.ArticleForGame;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.data.bean.NoticeBean;
import com.flydigi.data.bean.ProductSale;
import java.util.List;
import java.util.Objects;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public class m implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f9109a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f9110b = new j();

    public static /* synthetic */ NoticeBean g(NoticeBean noticeBean, NoticeBean noticeBean2) throws Exception {
        if (n0.b(Integer.valueOf(noticeBean.getUpdateTime()), Integer.valueOf(noticeBean2.getUpdateTime()))) {
            return noticeBean;
        }
        for (NoticeBean.TopBean topBean : noticeBean2.getTop()) {
            for (NoticeBean.TopBean topBean2 : noticeBean.getTop()) {
                if (n0.b(Integer.valueOf(topBean.getId()), Integer.valueOf(topBean2.getId()))) {
                    topBean.setLastShowTime(topBean2.getLastShowTime());
                }
            }
        }
        for (NoticeBean.DialogBean dialogBean : noticeBean2.getDialog()) {
            for (NoticeBean.DialogBean dialogBean2 : noticeBean.getDialog()) {
                if (n0.b(Integer.valueOf(dialogBean.getId()), Integer.valueOf(dialogBean2.getId()))) {
                    dialogBean.setLastShowTime(dialogBean2.getLastShowTime());
                }
            }
        }
        return noticeBean2;
    }

    @Override // b7.a
    public z<List<FirmwareInfoBean>> a(@yt.k String str) {
        return this.f9110b.a(str);
    }

    @Override // b7.a
    public z<FirmwareInfoBean> b(@yt.k String str) {
        return this.f9110b.b(str);
    }

    @Override // b7.a
    public xi.a d(String str) {
        return this.f9109a.d(str);
    }

    @Override // b7.a
    public z<NoticeBean> e(String str) {
        return z.S7(this.f9109a.e(str), this.f9110b.e(str), new dj.c() { // from class: b7.k
            @Override // dj.c
            public final Object apply(Object obj, Object obj2) {
                return m.g((NoticeBean) obj, (NoticeBean) obj2);
            }
        });
    }

    @Override // b7.a
    public z<List<ArticleForGame>> f(String str, int i10) {
        return this.f9110b.f(str, i10);
    }

    @Override // b7.a
    public xi.a u(String str, int i10) {
        return this.f9109a.u(str, i10);
    }

    @Override // b7.a
    public z<ProductSale> v() {
        z<ProductSale> zVarV = this.f9109a.v();
        z<ProductSale> zVarV2 = this.f9110b.v();
        final i iVar = this.f9109a;
        Objects.requireNonNull(iVar);
        return zVarV.L5(zVarV2.Y1(new dj.g() { // from class: b7.l
            @Override // dj.g
            public final void accept(Object obj) throws Throwable {
                iVar.r((ProductSale) obj);
            }
        })).L5(this.f9109a.v());
    }

    @Override // b7.a
    public void w(String str, NoticeBean noticeBean) {
        this.f9109a.w(str, noticeBean);
    }
}
