package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final class XMSSNode implements Serializable {
    private static final long serialVersionUID = 1;
    private final int height;
    private final byte[] value;

    public XMSSNode(int i10, byte[] bArr) {
        this.height = i10;
        this.value = bArr;
    }

    public int a() {
        return this.height;
    }

    public byte[] b() {
        return k0.d(this.value);
    }
}
