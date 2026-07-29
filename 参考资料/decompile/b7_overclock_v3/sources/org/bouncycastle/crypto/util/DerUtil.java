package org.bouncycastle.crypto.util;

import gm.c0;
import gm.f2;
import gm.z;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class DerUtil {
    public static z a(byte[] bArr) {
        return bArr == null ? new f2(new byte[0]) : new f2(org.bouncycastle.util.a.p(bArr));
    }

    public static byte[] b(c0 c0Var) {
        try {
            return c0Var.getEncoded();
        } catch (IOException e10) {
            throw new IllegalStateException("Cannot get encoding: " + e10.getMessage()) { // from class: org.bouncycastle.crypto.util.DerUtil.1
                @Override // java.lang.Throwable
                public Throwable getCause() {
                    return e10;
                }
            };
        }
    }
}
