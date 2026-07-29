package com.flydigi.device_manager.ui.home.device;

import com.flydigi.base.common.FZFragment;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class EmptyDeviceFragment extends FZFragment {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @yt.k
    public static final a f15156o8 = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final EmptyDeviceFragment a() {
            return new EmptyDeviceFragment();
        }
    }

    @hk.m
    @yt.k
    public static final EmptyDeviceFragment Z5() {
        return f15156o8.a();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_home_empty;
    }
}
