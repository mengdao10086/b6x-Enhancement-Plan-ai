package org.bouncycastle.operator.jcajce;

import cs.q;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class m {
    public static Key a(q qVar) {
        if (qVar.b() instanceof Key) {
            return (Key) qVar.b();
        }
        if (qVar.b() instanceof byte[]) {
            return new SecretKeySpec((byte[]) qVar.b(), "ENC");
        }
        throw new IllegalArgumentException("unknown generic key type");
    }
}
