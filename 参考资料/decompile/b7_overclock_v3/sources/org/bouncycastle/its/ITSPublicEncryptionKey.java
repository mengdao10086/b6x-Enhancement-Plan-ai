package org.bouncycastle.its;

import xr.a2;
import xr.d1;

/* JADX INFO: loaded from: classes5.dex */
public class ITSPublicEncryptionKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f44854a;

    public enum symmAlgorithm {
        aes128Ccm(a2.f55812e.M());

        private final int tagValue;

        symmAlgorithm(int i10) {
            this.tagValue = i10;
        }
    }

    public ITSPublicEncryptionKey(d1 d1Var) {
        this.f44854a = d1Var;
    }

    public d1 a() {
        return this.f44854a;
    }
}
