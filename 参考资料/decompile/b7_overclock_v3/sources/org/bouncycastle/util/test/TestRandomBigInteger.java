package org.bouncycastle.util.test;

import java.math.BigInteger;
import org.bouncycastle.util.test.FixedSecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class TestRandomBigInteger extends FixedSecureRandom {
    public TestRandomBigInteger(int i10, byte[] bArr) {
        super(new FixedSecureRandom.c[]{new FixedSecureRandom.a(i10, bArr)});
    }

    public TestRandomBigInteger(String str) {
        this(str, 10);
    }

    public TestRandomBigInteger(String str, int i10) {
        super(new FixedSecureRandom.c[]{new FixedSecureRandom.a(org.bouncycastle.util.b.c(new BigInteger(str, i10)))});
    }

    public TestRandomBigInteger(byte[] bArr) {
        super(new FixedSecureRandom.c[]{new FixedSecureRandom.a(bArr)});
    }
}
