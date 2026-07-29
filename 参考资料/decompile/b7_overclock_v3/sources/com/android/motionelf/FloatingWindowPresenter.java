package com.android.motionelf;

import android.os.Environment;
import com.android.motionelf.z0;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.CheckPhoneSupportBean;
import com.flydigi.data.bean.DeviceListBean;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.KeyPropertyData;
import com.flydigi.data.bean.KeyPropertySubPkg;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nFloatingWindowPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingWindowPresenter.kt\ncom/android/motionelf/FloatingWindowPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,266:1\n1#2:267\n*E\n"})
public final class FloatingWindowPresenter implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final io.reactivex.disposables.a f11242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final m3.a f11243b;

    public static final class a extends TypeToken<ArrayList<KeyPropertySubPkg>> {
    }

    public FloatingWindowPresenter(@yt.k z0.b view) {
        kotlin.jvm.internal.f0.p(view, "view");
        this.f11242a = new io.reactivex.disposables.a();
        this.f11243b = new m3.a();
    }

    public static final String B0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final String C0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final xi.e0 D0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (xi.e0) tmp0.i(obj);
    }

    public static final void E0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void F0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final Iterable G0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (Iterable) tmp0.i(obj);
    }

    public static final void H0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void I0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void K0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void L0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void v0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void w0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void y0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void z0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.android.motionelf.z0.a
    public void A() {
        J0();
        x0();
        R();
        A0();
    }

    public final void A0() {
        xi.z<List<InstalledGameBean>> allInstalledGamesObservable = DBManager.getInstance().getAllInstalledGamesObservable();
        final FloatingWindowPresenter$checkKeyProperty$1 floatingWindowPresenter$checkKeyProperty$1 = new ik.l<List<InstalledGameBean>, Iterable<? extends InstalledGameBean>>() { // from class: com.android.motionelf.FloatingWindowPresenter$checkKeyProperty$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterable<InstalledGameBean> i(@yt.k List<InstalledGameBean> it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return it2;
            }
        };
        xi.z<U> zVarZ2 = allInstalledGamesObservable.z2(new dj.o() { // from class: com.android.motionelf.e1
            @Override // dj.o
            public final Object apply(Object obj) {
                return FloatingWindowPresenter.G0(floatingWindowPresenter$checkKeyProperty$1, obj);
            }
        });
        final FloatingWindowPresenter$checkKeyProperty$2 floatingWindowPresenter$checkKeyProperty$2 = new ik.l<InstalledGameBean, String>() { // from class: com.android.motionelf.FloatingWindowPresenter$checkKeyProperty$2
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k InstalledGameBean obj) {
                kotlin.jvm.internal.f0.p(obj, "obj");
                return obj.getLocalPackageName();
            }
        };
        xi.z zVarV1 = zVarZ2.A3(new dj.o() { // from class: com.android.motionelf.d1
            @Override // dj.o
            public final Object apply(Object obj) {
                return FloatingWindowPresenter.B0(floatingWindowPresenter$checkKeyProperty$2, obj);
            }
        }).Y6().v1();
        final FloatingWindowPresenter$checkKeyProperty$3 floatingWindowPresenter$checkKeyProperty$3 = new ik.l<List<? extends String>, String>() { // from class: com.android.motionelf.FloatingWindowPresenter$checkKeyProperty$3
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k List<String> pkgNameList) {
                kotlin.jvm.internal.f0.p(pkgNameList, "pkgNameList");
                return CollectionsKt___CollectionsKt.h3(pkgNameList, ag.c.f654g, null, null, 0, null, null, 62, null);
            }
        };
        xi.z zVarA3 = zVarV1.A3(new dj.o() { // from class: com.android.motionelf.c1
            @Override // dj.o
            public final Object apply(Object obj) {
                return FloatingWindowPresenter.C0(floatingWindowPresenter$checkKeyProperty$3, obj);
            }
        });
        final ik.l<String, xi.e0<? extends KeyPropertyData>> lVar = new ik.l<String, xi.e0<? extends KeyPropertyData>>() { // from class: com.android.motionelf.FloatingWindowPresenter$checkKeyProperty$4
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final xi.e0<? extends KeyPropertyData> i(@yt.k String pkgNameList) {
                kotlin.jvm.internal.f0.p(pkgNameList, "pkgNameList");
                return this.this$0.f11243b.c(pkgNameList, o5.m.k(DataConstant.SP_APP).p(DataConstant.SP_GAME_KEY_PROPERTY_CONFIG_UPDATE_TIME, 0L));
            }
        };
        xi.z zVarB4 = zVarA3.l2(new dj.o() { // from class: com.android.motionelf.b1
            @Override // dj.o
            public final Object apply(Object obj) {
                return FloatingWindowPresenter.D0(lVar, obj);
            }
        }).J5(lj.b.d()).b4(lj.b.d());
        final ik.l<KeyPropertyData, z1> lVar2 = new ik.l<KeyPropertyData, z1>() { // from class: com.android.motionelf.FloatingWindowPresenter$checkKeyProperty$5
            {
                super(1);
            }

            public final void b(KeyPropertyData keyPropertyData) throws Throwable {
                FloatingWindowPresenter floatingWindowPresenter = this.this$0;
                kotlin.jvm.internal.f0.o(keyPropertyData, "keyPropertyData");
                floatingWindowPresenter.N0(keyPropertyData);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(KeyPropertyData keyPropertyData) throws Throwable {
                b(keyPropertyData);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.android.motionelf.f1
            @Override // dj.g
            public final void accept(Object obj) {
                FloatingWindowPresenter.E0(lVar2, obj);
            }
        };
        final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.android.motionelf.FloatingWindowPresenter$checkKeyProperty$6
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.M0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f11242a.b(zVarB4.F5(gVar, new dj.g() { // from class: com.android.motionelf.j1
            @Override // dj.g
            public final void accept(Object obj) {
                FloatingWindowPresenter.F0(lVar3, obj);
            }
        }));
    }

    public final void J0() {
        xi.z<BaseResponse<Object>> zVarB4 = this.f11243b.d().b4(lj.b.d());
        final FloatingWindowPresenter$getMinVersionForGamepad$1 floatingWindowPresenter$getMinVersionForGamepad$1 = new ik.l<BaseResponse<Object>, z1>() { // from class: com.android.motionelf.FloatingWindowPresenter$getMinVersionForGamepad$1
            public final void b(@yt.k BaseResponse<Object> configBean) {
                kotlin.jvm.internal.f0.p(configBean, "configBean");
                String json = m5.f0.i().h().toJson(configBean.data);
                File file = new File(com.blankj.utilcode.util.j1.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), DataConstant.CONFIG_PATH_FIRMWARE_MIN_SUPPORTED);
                com.blankj.utilcode.util.b0.m(file);
                com.blankj.utilcode.util.a0.T(file, json);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<Object> baseResponse) {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g<? super BaseResponse<Object>> gVar = new dj.g() { // from class: com.android.motionelf.n1
            @Override // dj.g
            public final void accept(Object obj) {
                FloatingWindowPresenter.K0(floatingWindowPresenter$getMinVersionForGamepad$1, obj);
            }
        };
        final FloatingWindowPresenter$getMinVersionForGamepad$2 floatingWindowPresenter$getMinVersionForGamepad$2 = new ik.l<Throwable, z1>() { // from class: com.android.motionelf.FloatingWindowPresenter$getMinVersionForGamepad$2
            public final void b(@yt.k Throwable throwable) {
                kotlin.jvm.internal.f0.p(throwable, "throwable");
                com.flydigi.base.common.n.c(throwable.getMessage(), new Object[0]);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f11242a.b(zVarB4.F5(gVar, new dj.g() { // from class: com.android.motionelf.m1
            @Override // dj.g
            public final void accept(Object obj) {
                FloatingWindowPresenter.L0(floatingWindowPresenter$getMinVersionForGamepad$2, obj);
            }
        }));
    }

    public final void M0() {
        File file = new File(com.blankj.utilcode.util.j1.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "GameKeyProperty");
        if (file.exists()) {
            ArrayList arrayList = (ArrayList) com.blankj.utilcode.util.e0.k().fromJson(com.blankj.utilcode.util.a0.q(file), new a().getType());
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                HashMap<String, KeyPropertySubPkg> mapKeyProperty = x7.f.f54910q;
                kotlin.jvm.internal.f0.o(mapKeyProperty, "mapKeyProperty");
                mapKeyProperty.put(((KeyPropertySubPkg) arrayList.get(i10)).pkgName, (KeyPropertySubPkg) arrayList.get(i10));
            }
        }
    }

    public final void N0(KeyPropertyData keyPropertyData) throws Throwable {
        ArrayList arrayList = new ArrayList();
        for (String str : keyPropertyData.game.keySet()) {
            kotlin.jvm.internal.f0.o(str, "keyPropertyData.game.keys");
            String str2 = str;
            com.flydigi.base.common.n.b("flydigitestdata 配置有更新 " + keyPropertyData.game.size(), new Object[0]);
            HashMap<String, KeyPropertySubPkg> mapKeyProperty = x7.f.f54910q;
            kotlin.jvm.internal.f0.o(mapKeyProperty, "mapKeyProperty");
            mapKeyProperty.put(str2, keyPropertyData.game.get(str2));
            arrayList.add(keyPropertyData.game.get(str2));
            com.flydigi.base.common.n.b("flydigitestdata KeyPropertySubPkg:" + keyPropertyData.game.get(str2), new Object[0]);
        }
        com.flydigi.base.common.n.b("flydigitestdata 最新时间 updateTime：" + keyPropertyData.updateTime, new Object[0]);
        o5.m.k(DataConstant.SP_APP).A(DataConstant.SP_GAME_KEY_PROPERTY_CONFIG_UPDATE_TIME, keyPropertyData.updateTime, true);
        if (arrayList.size() != 0) {
            com.flydigi.base.common.n.b("flydigitestdata checkKeyProperty 有更新，配置json写入文件", new Object[0]);
            String json = com.blankj.utilcode.util.e0.k().toJson(arrayList);
            kotlin.jvm.internal.f0.o(json, "getGson().toJson(keyPropertySubPkgArrayList)");
            O0(json);
            return;
        }
        com.flydigi.base.common.n.b("flydigitestdata checkKeyProperty 配置无更新全部删除", new Object[0]);
        if (keyPropertyData.updateTime != 0) {
            com.flydigi.base.common.n.b("flydigitestdata checkKeyProperty 配置无更新，读取本地", new Object[0]);
            M0();
        } else {
            com.flydigi.base.common.n.b("flydigitestdata checkKeyProperty 全部删除", new Object[0]);
            String json2 = com.blankj.utilcode.util.e0.k().toJson(arrayList);
            kotlin.jvm.internal.f0.o(json2, "getGson().toJson(keyPropertySubPkgArrayList)");
            O0(json2);
        }
    }

    public final void O0(String str) throws Throwable {
        com.blankj.utilcode.util.a0.U(new File(com.blankj.utilcode.util.j1.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "GameKeyProperty"), str, false);
    }

    public final void R() {
        File externalFilesDir = com.blankj.utilcode.util.j1.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        kotlin.jvm.internal.v0 v0Var = kotlin.jvm.internal.v0.f37964a;
        String str = String.format("%s_%s", Arrays.copyOf(new Object[]{o5.p.b(), DataConstant.CACHE_KEY_DEVICE_LIST}, 2));
        kotlin.jvm.internal.f0.o(str, "format(format, *args)");
        final File file = new File(externalFilesDir, str);
        final long version = 0;
        if (file.exists()) {
            String strQ = com.blankj.utilcode.util.a0.q(file);
            if (!com.blankj.utilcode.util.d1.g(strQ)) {
                DeviceListBean deviceListBean = (DeviceListBean) m5.f0.i().h().fromJson(strQ, DeviceListBean.class);
                if (com.blankj.utilcode.util.n0.b(deviceListBean.getAppVersion(), com.blankj.utilcode.util.d.C())) {
                    version = deviceListBean.getVersion();
                }
            }
        }
        xi.z<DeviceListBean> zVarB4 = this.f11243b.b(version).b4(lj.b.d());
        final ik.l<DeviceListBean, z1> lVar = new ik.l<DeviceListBean, z1>() { // from class: com.android.motionelf.FloatingWindowPresenter$getDeviceList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(@yt.k DeviceListBean response) {
                kotlin.jvm.internal.f0.p(response, "response");
                if (version == 0 || response.getVersion() != version) {
                    response.setAppVersion(com.blankj.utilcode.util.d.C());
                    String json = m5.f0.i().h().toJson(response);
                    com.blankj.utilcode.util.b0.m(file);
                    com.blankj.utilcode.util.a0.T(file, json);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(DeviceListBean deviceListBean2) {
                b(deviceListBean2);
                return z1.f38230a;
            }
        };
        dj.g<? super DeviceListBean> gVar = new dj.g() { // from class: com.android.motionelf.h1
            @Override // dj.g
            public final void accept(Object obj) {
                FloatingWindowPresenter.H0(lVar, obj);
            }
        };
        final FloatingWindowPresenter$getDeviceList$2 floatingWindowPresenter$getDeviceList$2 = new ik.l<Throwable, z1>() { // from class: com.android.motionelf.FloatingWindowPresenter$getDeviceList$2
            public final void b(@yt.k Throwable throwable) {
                kotlin.jvm.internal.f0.p(throwable, "throwable");
                com.flydigi.base.common.n.c(throwable.getMessage(), new Object[0]);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f11242a.b(zVarB4.F5(gVar, new dj.g() { // from class: com.android.motionelf.l1
            @Override // dj.g
            public final void accept(Object obj) {
                FloatingWindowPresenter.I0(floatingWindowPresenter$getDeviceList$2, obj);
            }
        }));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u0() {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.motionelf.FloatingWindowPresenter.u0():void");
    }

    public final void x0() {
        xi.z<CheckPhoneSupportBean> zVarB4 = this.f11243b.a().b4(lj.b.d());
        final FloatingWindowPresenter$checkFlashplaySupport$1 floatingWindowPresenter$checkFlashplaySupport$1 = new ik.l<CheckPhoneSupportBean, z1>() { // from class: com.android.motionelf.FloatingWindowPresenter$checkFlashplaySupport$1
            public final void b(CheckPhoneSupportBean checkPhoneSupportBean) {
                o5.m mVarL = o5.m.l(DataConstant.SP_FLOAT, 2);
                mVarL.x(DataConstant.SP_APP_KEY_FLASHPLAY_SUPPORT, checkPhoneSupportBean.getFlashplay());
                mVarL.F(DataConstant.SP_APP_KEY_FORCE_COMPATIBLE_DRIVER, checkPhoneSupportBean.isUseCompatibleDriver());
                if (mVarL.n(DataConstant.SP_APP_KEY_FORCE_ROTATION_90, -1) == -1 && checkPhoneSupportBean.getRotation() == 1) {
                    mVarL.x(DataConstant.SP_APP_KEY_FORCE_ROTATION_90, checkPhoneSupportBean.getRotation());
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(CheckPhoneSupportBean checkPhoneSupportBean) {
                b(checkPhoneSupportBean);
                return z1.f38230a;
            }
        };
        dj.g<? super CheckPhoneSupportBean> gVar = new dj.g() { // from class: com.android.motionelf.g1
            @Override // dj.g
            public final void accept(Object obj) {
                FloatingWindowPresenter.y0(floatingWindowPresenter$checkFlashplaySupport$1, obj);
            }
        };
        final FloatingWindowPresenter$checkFlashplaySupport$2 floatingWindowPresenter$checkFlashplaySupport$2 = new ik.l<Throwable, z1>() { // from class: com.android.motionelf.FloatingWindowPresenter$checkFlashplaySupport$2
            public final void b(@yt.k Throwable throwable) {
                kotlin.jvm.internal.f0.p(throwable, "throwable");
                com.flydigi.base.common.n.c(throwable.getMessage(), new Object[0]);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f11242a.b(zVarB4.F5(gVar, new dj.g() { // from class: com.android.motionelf.a1
            @Override // dj.g
            public final void accept(Object obj) {
                FloatingWindowPresenter.z0(floatingWindowPresenter$checkFlashplaySupport$2, obj);
            }
        }));
    }
}
