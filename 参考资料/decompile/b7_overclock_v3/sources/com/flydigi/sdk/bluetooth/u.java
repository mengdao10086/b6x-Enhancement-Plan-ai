package com.flydigi.sdk.bluetooth;

/* JADX INFO: loaded from: classes3.dex */
public interface u {

    public static final class a {
        public static /* synthetic */ boolean a(u uVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isValidDevice");
            }
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return uVar.a(str, i10);
        }
    }

    boolean a(@yt.l String str, int i10);
}
