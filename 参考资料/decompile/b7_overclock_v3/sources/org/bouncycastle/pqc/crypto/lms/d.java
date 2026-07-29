package org.bouncycastle.pqc.crypto.lms;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class d extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t[] f45736c;

    public d(t[] tVarArr, SecureRandom secureRandom) {
        super(secureRandom, a0.c(tVarArr[0]));
        if (tVarArr.length == 0 || tVarArr.length > 8) {
            throw new IllegalArgumentException("lmsParameters length should be between 1 and 8 inclusive");
        }
        this.f45736c = tVarArr;
    }

    public int c() {
        return this.f45736c.length;
    }

    public t[] d() {
        return this.f45736c;
    }
}
