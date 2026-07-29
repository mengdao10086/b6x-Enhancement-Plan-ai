package org.bouncycastle.jcajce.provider.asymmetric.util;

/* JADX INFO: loaded from: classes7.dex */
public class n {
    public static int a(int i10) {
        if (i10 <= 1024) {
            return 80;
        }
        return (((i10 - 1) / 1024) * 16) + 96;
    }
}
