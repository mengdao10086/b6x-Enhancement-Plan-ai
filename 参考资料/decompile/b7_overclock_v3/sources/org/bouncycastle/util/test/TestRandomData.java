package org.bouncycastle.util.test;

import jt.h;
import org.bouncycastle.util.test.FixedSecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class TestRandomData extends FixedSecureRandom {
    public TestRandomData(String str) {
        super(new FixedSecureRandom.c[]{new FixedSecureRandom.b(h.b(str))});
    }

    public TestRandomData(byte[] bArr) {
        super(new FixedSecureRandom.c[]{new FixedSecureRandom.b(bArr)});
    }
}
