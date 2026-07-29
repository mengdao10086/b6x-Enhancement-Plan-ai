package com.flydigi.device_manager.ui.sync;

import com.flydigi.data.bean.CloudConfigBean;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList;
import java.io.File;
import java.io.IOException;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

/* JADX INFO: loaded from: classes7.dex */
public final class SyncConfigViewModel$downloadConfig$1$1 extends Lambda implements ik.l<CFGEntityList, xi.e0<? extends CFGEntityList>> {
    public final /* synthetic */ boolean $forceReplace;
    public final /* synthetic */ int[] $selectedPositions;
    public final /* synthetic */ SyncConfigViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncConfigViewModel$downloadConfig$1$1(SyncConfigViewModel syncConfigViewModel, int[] iArr, boolean z10) {
        super(1);
        this.this$0 = syncConfigViewModel;
        this.$selectedPositions = iArr;
        this.$forceReplace = z10;
    }

    public static final CFGEntityList f(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (CFGEntityList) tmp0.i(obj);
    }

    @Override // ik.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final xi.e0<? extends CFGEntityList> i(@yt.k final CFGEntityList cfgEntityList) {
        kotlin.jvm.internal.f0.p(cfgEntityList, "cfgEntityList");
        SyncConfigViewModel syncConfigViewModel = this.this$0;
        xi.z zVarC0 = syncConfigViewModel.C0(syncConfigViewModel.O0(this.$selectedPositions, this.$forceReplace));
        final boolean z10 = this.$forceReplace;
        final ik.l<Pair<? extends CloudConfigBean, ? extends File>, CFGEntityList> lVar = new ik.l<Pair<? extends CloudConfigBean, ? extends File>, CFGEntityList>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadConfig$1$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CFGEntityList i(@yt.k Pair<? extends CloudConfigBean, ? extends File> configFile) throws JSONException, IOException {
                kotlin.jvm.internal.f0.p(configFile, "configFile");
                e6.z.w(cfgEntityList, configFile.f(), configFile.h(), z10);
                return cfgEntityList;
            }
        };
        return zVarC0.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.f1
            @Override // dj.o
            public final Object apply(Object obj) {
                return SyncConfigViewModel$downloadConfig$1$1.f(lVar, obj);
            }
        });
    }
}
