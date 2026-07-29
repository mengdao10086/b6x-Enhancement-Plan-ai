package com.flydigi.data;

import androidx.lifecycle.LiveData;
import androidx.room.r2;
import com.blankj.utilcode.util.d;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.flydigi.data.bean.CommunitySearchHistoryBean;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.SupportedGameBean;
import com.flydigi.database.AppDatabase;
import dj.o;
import dj.r;
import e6.z;
import java.util.Iterator;
import java.util.List;
import o5.p;
import xi.b0;
import xi.c0;

/* JADX INFO: loaded from: classes7.dex */
public class DBManager {
    private AppDatabase mDatabase;

    public static class DBManagerHolder {
        private static final DBManager sInstance = new DBManager();

        private DBManagerHolder() {
        }
    }

    private boolean checkHasLocalConfigs(String packageName) {
        Iterator<String> it2 = z.I().iterator();
        while (it2.hasNext()) {
            if (it2.next().contains(packageName)) {
                return true;
            }
        }
        return false;
    }

    private AppDatabase getDatabase() {
        if (this.mDatabase == null) {
            this.mDatabase = (AppDatabase) r2.a(j1.a(), AppDatabase.class, j1.a().getPackageName()).m().e().c(AppDatabase.f14366r, AppDatabase.f14367s).f();
        }
        return this.mDatabase;
    }

    public static DBManager getInstance() {
        return DBManagerHolder.sInstance;
    }

    public static SupportedGameBean getSupportedGame(String packageName) {
        String lowerCase = packageName.toLowerCase();
        boolean z10 = false;
        for (SupportedGameBean supportedGameBean : getInstance().getAllSupportedGames()) {
            if (!lowerCase.contains(supportedGameBean.getPackageName()) && !supportedGameBean.getPackageName().contains(lowerCase)) {
                for (String str : supportedGameBean.getPattern()) {
                    if ((n0.x(str) && lowerCase.contains(str.toLowerCase())) || str.toLowerCase().contains(lowerCase)) {
                        z10 = true;
                        break;
                        break;
                    }
                }
            } else {
                z10 = true;
                break;
            }
            if (z10) {
                return supportedGameBean;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteInstalledGame$5(String str, b0 b0Var) throws Exception {
        b0Var.onNext(getDatabase().M().b(str));
        b0Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteInstalledGame$6(InstalledGameBean installedGameBean) throws Exception {
        return installedGameBean.getId() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteInstalledGame$7(InstalledGameBean installedGameBean) throws Exception {
        getDatabase().M().g(installedGameBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteInstalledGame$8(Throwable th2) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllInstalledGamesObservable$0(b0 b0Var) throws Exception {
        b0Var.onNext(getDatabase().M().getAll());
        b0Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getInstalledGameObservable$10(String str, InstalledGameBean installedGameBean) throws Exception {
        installedGameBean.setLocalPackageName(str);
        installedGameBean.setStandardPackageName(str);
        installedGameBean.setGameMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getStandardPackageNameOrDefault$9(String str, b0 b0Var) throws Exception {
        SupportedGameBean supportedGame;
        InstalledGameBean installedGameBeanB = null;
        if (n0.b(str, DataConstant.TEST_KEYMAPPING)) {
            b0Var.onNext(str);
            supportedGame = null;
        } else {
            installedGameBeanB = getDatabase().M().b(str);
            supportedGame = getSupportedGame(str);
        }
        if (installedGameBeanB != null) {
            b0Var.onNext(installedGameBeanB.getStandardPackageName());
        } else if (supportedGame != null) {
            b0Var.onNext(supportedGame.getPackageName());
        } else {
            b0Var.onNext(str);
        }
        b0Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isSupportGameObservable$11(String str, b0 b0Var) throws Exception {
        b0Var.onNext(Boolean.valueOf(d1.l(str).equals(DataConstant.TEST_KEYMAPPING) || getInstalledGame(str) != null));
        b0Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeAllInstalledGame$1() throws Exception {
        getDatabase().M().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$removeUninstalledGame$2(InstalledGameBean installedGameBean) throws Exception {
        return !p.c(installedGameBean.getLocalPackageName()) || (installedGameBean.getId() == 0 && installedGameBean.isUseMappingMode() && !checkHasLocalConfigs(installedGameBean.getStandardPackageName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeUninstalledGame$3(InstalledGameBean installedGameBean) throws Exception {
        getDatabase().M().g(installedGameBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$removeUninstalledGame$4(Throwable th2) throws Exception {
    }

    public void addInstalledGame(d.a appInfo, SupportedGameBean supportedGame) {
        InstalledGameBean installedGameBean = new InstalledGameBean();
        installedGameBean.setId(supportedGame != null ? supportedGame.getId() : 0L);
        installedGameBean.setTitle(appInfo.b());
        installedGameBean.setLocalPackageName(appInfo.c());
        installedGameBean.setStandardPackageName(supportedGame != null ? supportedGame.getPackageName() : appInfo.c());
        installedGameBean.setThumb(supportedGame != null ? supportedGame.getThumb() : null);
        addInstalledGame(installedGameBean);
    }

    public xi.a deleteCommunitySearchHistory() {
        return getDatabase().N().b();
    }

    public void deleteInstalledGame(final String packageName) {
        xi.z.r1(new c0() { // from class: com.flydigi.data.c
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                this.f14350a.lambda$deleteInstalledGame$5(packageName, b0Var);
            }
        }).h2(new r() { // from class: com.flydigi.data.l
            @Override // dj.r
            public final boolean a(Object obj) {
                return DBManager.lambda$deleteInstalledGame$6((InstalledGameBean) obj);
            }
        }).J5(lj.b.a()).b4(lj.b.a()).F5(new dj.g() { // from class: com.flydigi.data.e
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f14354a.lambda$deleteInstalledGame$7((InstalledGameBean) obj);
            }
        }, new dj.g() { // from class: com.flydigi.data.h
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                DBManager.lambda$deleteInstalledGame$8((Throwable) obj);
            }
        });
    }

    public xi.z<List<InstalledGameBean>> getAllInstalledGamesObservable() {
        return xi.z.r1(new c0() { // from class: com.flydigi.data.m
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                this.f14364a.lambda$getAllInstalledGamesObservable$0(b0Var);
            }
        });
    }

    public List<SupportedGameBean> getAllSupportedGames() {
        return getDatabase().O().getAll();
    }

    public xi.j<List<CommunitySearchHistoryBean>> getCommunitySearchHistory() {
        return getDatabase().N().getAll();
    }

    public InstalledGameBean getInstalledGame(String packageName) {
        return getDatabase().M().b(packageName);
    }

    public xi.z<InstalledGameBean> getInstalledGameObservable(final String localPackageName) {
        return n0.b(localPackageName, DataConstant.TEST_KEYMAPPING) ? xi.z.m3(new InstalledGameBean()).Y1(new dj.g() { // from class: com.flydigi.data.g
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                DBManager.lambda$getInstalledGameObservable$10(localPackageName, (InstalledGameBean) obj);
            }
        }) : getDatabase().M().e(localPackageName).v1();
    }

    public InstalledGameBean getLocalInstalledGame(String packageName) {
        return getDatabase().M().d(packageName);
    }

    public xi.z<String> getStandardPackageNameOrDefault(final String packageName) {
        return xi.z.r1(new c0() { // from class: com.flydigi.data.b
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                this.f14320a.lambda$getStandardPackageNameOrDefault$9(packageName, b0Var);
            }
        });
    }

    public void init() {
        this.mDatabase = getDatabase();
    }

    public boolean isSupportGame(String packageName) {
        return d1.l(packageName).equals(DataConstant.TEST_KEYMAPPING) || getInstalledGame(packageName) != null;
    }

    public xi.z<Boolean> isSupportGameObservable(final String packageName) {
        return xi.z.r1(new c0() { // from class: com.flydigi.data.d
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                this.f14352a.lambda$isSupportGameObservable$11(packageName, b0Var);
            }
        });
    }

    public LiveData<List<InstalledGameBean>> observableInstalledGames() {
        return getDatabase().M().i();
    }

    public void removeAllInstalledGame() {
        xi.a.R(new dj.a() { // from class: com.flydigi.data.a
            @Override // dj.a
            public final void run() throws Exception {
                this.f14319a.lambda$removeAllInstalledGame$1();
            }
        }).J0(lj.b.a()).n0(lj.b.a()).F0();
    }

    public void removeUninstalledGame() {
        getAllInstalledGamesObservable().l2(new o() { // from class: com.flydigi.data.j
            @Override // dj.o
            public final Object apply(Object obj) {
                return xi.z.P2((List) obj);
            }
        }).h2(new r() { // from class: com.flydigi.data.k
            @Override // dj.r
            public final boolean a(Object obj) {
                return this.f14362a.lambda$removeUninstalledGame$2((InstalledGameBean) obj);
            }
        }).J5(lj.b.a()).b4(lj.b.a()).F5(new dj.g() { // from class: com.flydigi.data.f
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f14357a.lambda$removeUninstalledGame$3((InstalledGameBean) obj);
            }
        }, new dj.g() { // from class: com.flydigi.data.i
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                DBManager.lambda$removeUninstalledGame$4((Throwable) obj);
            }
        });
    }

    public xi.a updateCommunitySearchHistory(final String keyword) {
        return getDatabase().N().a(new CommunitySearchHistoryBean(keyword, System.currentTimeMillis()));
    }

    public xi.a updateInstalledGameRx(InstalledGameBean gameBean) {
        return getDatabase().M().h(gameBean);
    }

    public void updateSupportedGameList(List<SupportedGameBean> list) {
        getDatabase().O().a();
        getDatabase().O().f(list);
    }

    private DBManager() {
    }

    public void addInstalledGame(InstalledGameBean gameBean) {
        getDatabase().M().f(gameBean);
    }
}
