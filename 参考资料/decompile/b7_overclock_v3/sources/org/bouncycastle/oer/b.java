package org.bouncycastle.oer;

import gm.h;
import java.io.ByteArrayOutputStream;
import org.bouncycastle.oer.OERDefinition;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static byte[] a(h hVar, OERDefinition.b bVar) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new e(byteArrayOutputStream).f(hVar, bVar);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e10) {
            throw new IllegalStateException(e10.getMessage(), e10);
        }
    }
}
