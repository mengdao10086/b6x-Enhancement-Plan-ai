package com.flydigi.device_manager.ui.sync;

import com.flydigi.data.bean.CloudConfigBean;
import java.io.File;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class SyncConfigViewModel$downloadConfigFile$2 extends Lambda implements ik.l<CloudConfigBean, xi.e0<? extends Pair<? extends CloudConfigBean, ? extends File>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SyncConfigViewModel$downloadConfigFile$2 f15434a = new SyncConfigViewModel$downloadConfigFile$2();

    public SyncConfigViewModel$downloadConfigFile$2() {
        super(1);
    }

    public static final Pair f(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (Pair) tmp0.i(obj);
    }

    @Override // ik.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final xi.e0<? extends Pair<CloudConfigBean, File>> i(@yt.k final CloudConfigBean config) {
        kotlin.jvm.internal.f0.p(config, "config");
        xi.z<File> zVarF = e6.z.F(config.url);
        final ik.l<File, Pair<? extends CloudConfigBean, ? extends File>> lVar = new ik.l<File, Pair<? extends CloudConfigBean, ? extends File>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadConfigFile$2.1
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Pair<CloudConfigBean, File> i(@yt.k File it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return new Pair<>(config, it2);
            }
        };
        return zVarF.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.g1
            @Override // dj.o
            public final Object apply(Object obj) {
                return SyncConfigViewModel$downloadConfigFile$2.f(lVar, obj);
            }
        });
    }
}
