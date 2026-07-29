package b7;

import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.f1;
import com.blankj.utilcode.util.j1;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ArticleForGame;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.NoticeBean;
import com.flydigi.data.bean.ProductSale;
import com.google.gson.Gson;
import dj.o;
import java.io.File;
import java.util.List;
import m5.f0;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public class i implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f9104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f9105b;

    public i() {
        File file = new File(j1.a().getCacheDir(), "api");
        this.f9104a = file;
        b0.k(file);
        this.f9105b = new Gson();
    }

    public static /* synthetic */ InstalledGameBean l(int i10, InstalledGameBean installedGameBean) throws Exception {
        installedGameBean.setGameMode(i10);
        return installedGameBean;
    }

    public static /* synthetic */ xi.g m(InstalledGameBean installedGameBean) throws Exception {
        return DBManager.getInstance().updateInstalledGameRx(installedGameBean);
    }

    public static /* synthetic */ NoticeBean n(String str) throws Exception {
        return (NoticeBean) com.blankj.utilcode.util.h.D("notice_" + str, NoticeBean.CREATOR, new NoticeBean());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ProductSale o(String str) throws Exception {
        return (ProductSale) this.f9105b.fromJson(str, ProductSale.class);
    }

    public static /* synthetic */ InstalledGameBean p(InstalledGameBean installedGameBean) throws Exception {
        installedGameBean.setUpdateTime(System.currentTimeMillis());
        return installedGameBean;
    }

    public static /* synthetic */ xi.g q(InstalledGameBean installedGameBean) throws Exception {
        return DBManager.getInstance().updateInstalledGameRx(installedGameBean);
    }

    @Override // b7.a
    public z<List<FirmwareInfoBean>> a(@yt.k String str) {
        return null;
    }

    @Override // b7.a
    public z<FirmwareInfoBean> b(@yt.k String str) {
        return null;
    }

    @Override // b7.a
    public xi.a d(String str) {
        return DBManager.getInstance().getInstalledGameObservable(str).A3(new o() { // from class: b7.f
            @Override // dj.o
            public final Object apply(Object obj) {
                return i.p((InstalledGameBean) obj);
            }
        }).O5(new o() { // from class: b7.e
            @Override // dj.o
            public final Object apply(Object obj) {
                return i.q((InstalledGameBean) obj);
            }
        });
    }

    @Override // b7.a
    public z<NoticeBean> e(String str) {
        return z.m3(str).A3(new o() { // from class: b7.h
            @Override // dj.o
            public final Object apply(Object obj) {
                return i.n((String) obj);
            }
        }).J5(lj.b.d());
    }

    @Override // b7.a
    public z<List<ArticleForGame>> f(String str, int i10) {
        return z.e2();
    }

    public void r(ProductSale productSale) throws Throwable {
        if (productSale == null) {
            return;
        }
        a0.U(new File(this.f9104a, "getProduct"), this.f9105b.toJson(productSale), false);
    }

    @Override // b7.a
    public xi.a u(String str, final int i10) {
        return DBManager.getInstance().getInstalledGameObservable(str).A3(new o() { // from class: b7.b
            @Override // dj.o
            public final Object apply(Object obj) {
                return i.l(i10, (InstalledGameBean) obj);
            }
        }).O5(new o() { // from class: b7.d
            @Override // dj.o
            public final Object apply(Object obj) {
                return i.m((InstalledGameBean) obj);
            }
        });
    }

    @Override // b7.a
    public z<ProductSale> v() {
        File file = new File(this.f9104a, "getProduct");
        return (file.exists() && f1.J0(b0.H(file))) ? z.m3(file).A3(g.f9102a).A3(new o() { // from class: b7.c
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f9098a.o((String) obj);
            }
        }) : z.e2();
    }

    @Override // b7.a
    public void w(String str, NoticeBean noticeBean) {
        com.blankj.utilcode.util.h.V("notice_" + str, noticeBean);
        o5.m.k(DataConstant.SP_APP).B(DataConstant.SP_NOTICE, f0.i().h().toJson(noticeBean));
    }
}
