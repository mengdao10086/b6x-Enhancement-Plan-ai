package com.flydigi.device_manager.ui.sync;

import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ConfigUploadBean;
import com.flydigi.data.bean.EntitySimpleConfig;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class SyncConfigViewModel$uploadConfig$2 extends Lambda implements ik.l<EntitySimpleConfig, xi.e0<? extends ConfigUploadBean>> {
    public final /* synthetic */ SyncConfigViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncConfigViewModel$uploadConfig$2(SyncConfigViewModel syncConfigViewModel) {
        super(1);
        this.this$0 = syncConfigViewModel;
    }

    public static final xi.e0 k(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (xi.e0) tmp0.i(obj);
    }

    public static final ConfigUploadBean n(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (ConfigUploadBean) tmp0.i(obj);
    }

    @Override // ik.l
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final xi.e0<? extends ConfigUploadBean> i(@yt.k final EntitySimpleConfig config) {
        kotlin.jvm.internal.f0.p(config, "config");
        config.getCfgEntity().setInTop(false);
        config.getCfgEntity().setRecommend(false);
        config.getCfgEntity().setDefault(false);
        config.getCfgEntity().setInUse(false);
        xi.z zVarX1 = xi.z.m3(e6.z.f0(config)).x1(100L, TimeUnit.MILLISECONDS);
        final ik.l<File, xi.e0<? extends String>> lVar = new ik.l<File, xi.e0<? extends String>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfig$2.1
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final xi.e0<? extends String> i(@yt.k File it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return u9.k.g(config.getName(), it2, DataConstant.UPYUN_BUCKET);
            }
        };
        xi.z zVarM5 = zVarX1.M5(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.i1
            @Override // dj.o
            public final Object apply(Object obj) {
                return SyncConfigViewModel$uploadConfig$2.k(lVar, obj);
            }
        });
        final SyncConfigViewModel syncConfigViewModel = this.this$0;
        final ik.l<String, ConfigUploadBean> lVar2 = new ik.l<String, ConfigUploadBean>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfig$2.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final com.flydigi.data.bean.ConfigUploadBean i(@yt.k java.lang.String r9) {
                /*
                    r8 = this;
                    java.lang.String r0 = "url"
                    kotlin.jvm.internal.f0.p(r9, r0)
                    com.flydigi.data.bean.ConfigUploadBean r0 = new com.flydigi.data.bean.ConfigUploadBean
                    r0.<init>()
                    com.flydigi.data.bean.EntitySimpleConfig r1 = r1
                    com.flydigi.device_manager.ui.sync.SyncConfigViewModel r2 = r2
                    java.lang.String r3 = r1.getName()
                    r0.title = r3
                    int r3 = r1.getVersion()
                    r0.version = r3
                    r0.url = r9
                    com.flydigi.sdk.gamepad.extension.config.data.CFGEntity r9 = r1.getCfgEntity()
                    java.lang.String r9 = r9.getGamepad()
                    r3 = 1
                    if (r9 != 0) goto L3d
                    int r9 = r1.getVersion()
                    java.lang.String r4 = "apex"
                    if (r9 == r3) goto L3c
                    r5 = 2
                    if (r9 == r5) goto L39
                    r5 = 3
                    if (r9 == r5) goto L36
                    goto L3c
                L36:
                    java.lang.String r9 = "wasp2"
                    goto L3d
                L39:
                    java.lang.String r9 = "q1"
                    goto L3d
                L3c:
                    r9 = r4
                L3d:
                    r0.setGamepad(r9)
                    java.lang.String r9 = r1.getFid()
                    java.lang.String r4 = "config.fid"
                    kotlin.jvm.internal.f0.o(r9, r4)
                    int r9 = r9.length()
                    r5 = 0
                    if (r9 <= 0) goto L52
                    r9 = 1
                    goto L53
                L52:
                    r9 = 0
                L53:
                    if (r9 == 0) goto L63
                    java.lang.String r9 = r1.getFid()
                    kotlin.jvm.internal.f0.o(r9, r4)
                    int r9 = java.lang.Integer.parseInt(r9)
                    r0.fid = r9
                    goto Lab
                L63:
                    androidx.lifecycle.LiveData r9 = r2.F0()
                    java.lang.Object r9 = r9.f()
                    java.util.List r9 = (java.util.List) r9
                    if (r9 == 0) goto Lab
                    java.lang.String r2 = "cloudConfigs"
                    kotlin.jvm.internal.f0.o(r9, r2)
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Iterator r9 = r9.iterator()
                L7d:
                    boolean r4 = r9.hasNext()
                    if (r4 == 0) goto L9a
                    java.lang.Object r4 = r9.next()
                    r6 = r4
                    com.flydigi.data.bean.CloudConfigBean r6 = (com.flydigi.data.bean.CloudConfigBean) r6
                    java.lang.String r6 = r6.title
                    java.lang.String r7 = r1.getName()
                    boolean r6 = android.text.TextUtils.equals(r6, r7)
                    if (r6 == 0) goto L7d
                    r2.add(r4)
                    goto L7d
                L9a:
                    boolean r9 = r2.isEmpty()
                    r9 = r9 ^ r3
                    if (r9 == 0) goto Lab
                    java.lang.Object r9 = r2.get(r5)
                    com.flydigi.data.bean.CloudConfigBean r9 = (com.flydigi.data.bean.CloudConfigBean) r9
                    int r9 = r9.f14326id
                    r0.fid = r9
                Lab:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfig$2.AnonymousClass2.i(java.lang.String):com.flydigi.data.bean.ConfigUploadBean");
            }
        };
        return zVarM5.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.h1
            @Override // dj.o
            public final Object apply(Object obj) {
                return SyncConfigViewModel$uploadConfig$2.n(lVar2, obj);
            }
        });
    }
}
