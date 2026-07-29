package org.bouncycastle.operator.jcajce;

import cs.q;
import java.security.Key;

/* JADX INFO: loaded from: classes6.dex */
public class g extends q {
    public g(zn.b bVar, Key key) {
        super(bVar, c(key));
    }

    public static Object c(Key key) {
        byte[] encoded = key.getEncoded();
        return encoded != null ? encoded : key;
    }
}
