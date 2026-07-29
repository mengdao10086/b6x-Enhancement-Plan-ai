package com.flydigi.game.ui.main;

import com.blankj.utilcode.util.n0;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.BannerBean;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.api.GameApiService;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.RecoGameBean;
import com.flydigi.game.data.bean.RecoGameEntity;
import com.flydigi.game.ui.main.b;
import com.google.gson.reflect.TypeToken;
import dj.g;
import dj.o;
import dj.r;
import java.util.Iterator;
import java.util.List;
import m5.c0;
import m5.f0;
import o5.l;
import o5.m;
import o5.p;
import xi.b0;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f15897c = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.InterfaceC0163b f15898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15899b = 1;

    public class a extends TypeToken<BaseResponse<List<BannerBean>>> {
        public a() {
        }
    }

    public class b extends TypeToken<BaseResponse<RecoGameBean>> {
        public b() {
        }
    }

    public c(b.InterfaceC0163b interfaceC0163b) {
        this.f15898a = interfaceC0163b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(List list) throws Exception {
        this.f15898a.L0(list);
    }

    public static /* synthetic */ void s0(Throwable th2) throws Exception {
    }

    public static /* synthetic */ void t0(BaseResponse baseResponse) throws Exception {
        m.k(DataConstant.SP_MAIN).B(DataConstant.SP_GAME_BANNER, f0.i().h().toJson(baseResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(b0 b0Var) throws Exception {
        BaseResponse baseResponse = (BaseResponse) f0.i().h().fromJson(m.k(DataConstant.SP_MAIN).q(DataConstant.SP_GAME_BANNER), new a().getType());
        if (baseResponse != null) {
            b0Var.onNext(baseResponse);
        } else {
            b0Var.onComplete();
        }
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(b0 b0Var) throws Exception {
        BaseResponse baseResponse = (BaseResponse) f0.i().h().fromJson(m.k(DataConstant.SP_MAIN).q(DataConstant.SP_MAIN_RECO_GAME_LIST), new b().getType());
        if (baseResponse != null) {
            b0Var.onNext(baseResponse);
        } else {
            b0Var.onComplete();
            this.f15898a.W();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResponse w0(BaseResponse baseResponse) throws Exception {
        List<RecoGameEntity> list;
        RecoGameBean recoGameBean = (RecoGameBean) baseResponse.data;
        if (recoGameBean != null && (list = recoGameBean.datalist) != null && list.size() > 0) {
            Iterator<RecoGameEntity> it2 = recoGameBean.datalist.iterator();
            while (it2.hasNext()) {
                for (GameBean gameBean : it2.next().games) {
                    gameBean.installed = p.c(gameBean.packageName);
                    GameBean installedGameBean = DBManager.getInstalledGameBean(gameBean.packageName);
                    if (installedGameBean != null) {
                        gameBean.installed = installedGameBean.installed;
                        gameBean.localPath = installedGameBean.localPath;
                        gameBean.progress = installedGameBean.progress;
                        gameBean.wifiRequired = installedGameBean.wifiRequired;
                        gameBean.updateAble = installedGameBean.updateAble;
                    }
                }
            }
        }
        return baseResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void x0(boolean z10, BaseResponse baseResponse) throws Exception {
        T t10 = baseResponse.data;
        if (((RecoGameBean) t10).cur_page <= ((RecoGameBean) t10).total_page) {
            this.f15899b++;
        }
        if (z10) {
            m.k(DataConstant.SP_MAIN).B(DataConstant.SP_MAIN_RECO_GAME_LIST, f0.i().h().toJson(baseResponse));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResponse y0(BaseResponse baseResponse) throws Exception {
        List<RecoGameEntity> list;
        RecoGameBean recoGameBean = (RecoGameBean) baseResponse.data;
        if (recoGameBean != null && (list = recoGameBean.datalist) != null && list.size() > 0) {
            Iterator<RecoGameEntity> it2 = recoGameBean.datalist.iterator();
            while (it2.hasNext()) {
                for (GameBean gameBean : it2.next().games) {
                    gameBean.installed = p.c(gameBean.packageName);
                    GameBean installedGameBean = DBManager.getInstalledGameBean(gameBean.packageName);
                    if (installedGameBean != null) {
                        gameBean.installed = installedGameBean.installed;
                        gameBean.localPath = installedGameBean.localPath;
                        gameBean.progress = installedGameBean.progress;
                        gameBean.wifiRequired = installedGameBean.wifiRequired;
                        gameBean.updateAble = installedGameBean.updateAble;
                    }
                }
            }
        }
        return baseResponse;
    }

    @Override // com.flydigi.game.ui.main.b.a
    public void G() {
        ((GameApiService) f0.i().k().g(GameApiService.class)).getDownloadableSubscribedGame().s0(c0.p()).h2(new r() { // from class: w8.q
            @Override // dj.r
            public final boolean a(Object obj) {
                return n0.z((List) obj);
            }
        }).s0(l.d()).F5(new g() { // from class: w8.k
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f54600a.r0((List) obj);
            }
        }, new g() { // from class: w8.n
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                com.flydigi.game.ui.main.c.s0((Throwable) obj);
            }
        });
    }

    @Override // com.flydigi.game.ui.main.b.a
    public void O(boolean z10) {
        p0(z10);
    }

    public void m0() {
        this.f15898a.s1(((GameApiService) f0.i().k().g(GameApiService.class)).getGameBanner().Y1(new g() { // from class: w8.m
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                com.flydigi.game.ui.main.c.t0((BaseResponse) obj);
            }
        }).s0(c0.t()).s0(l.d()), true);
    }

    public final void n0() {
        this.f15898a.s1(z.r1(new xi.c0() { // from class: w8.s
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                this.f54609a.u0(b0Var);
            }
        }).s0(c0.t()).s0(l.d()), false);
    }

    public final void o0() {
        this.f15899b = 1;
        this.f15898a.Y(z.r1(new xi.c0() { // from class: w8.r
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                this.f54608a.v0(b0Var);
            }
        }).A3(new o() { // from class: w8.o
            @Override // dj.o
            public final Object apply(Object obj) {
                return com.flydigi.game.ui.main.c.w0((BaseResponse) obj);
            }
        }).s0(c0.t()).s0(l.d()));
    }

    public final void p0(final boolean z10) {
        if (z10) {
            this.f15899b = 1;
        }
        this.f15898a.M1(((GameApiService) f0.i().k().g(GameApiService.class)).getRecoGameList(this.f15899b, 3).s0(c0.r()).Y1(new g() { // from class: w8.l
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f54601a.x0(z10, (BaseResponse) obj);
            }
        }).A3(new o() { // from class: w8.p
            @Override // dj.o
            public final Object apply(Object obj) {
                return com.flydigi.game.ui.main.c.y0((BaseResponse) obj);
            }
        }).s0(c0.t()).s0(l.d()), z10);
    }

    @Override // com.flydigi.game.ui.main.b.a
    public void r() {
        o0();
        m0();
    }
}
