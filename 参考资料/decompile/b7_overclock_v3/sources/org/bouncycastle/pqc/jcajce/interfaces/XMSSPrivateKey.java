package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;
import us.c;

/* JADX INFO: loaded from: classes6.dex */
public interface XMSSPrivateKey extends c, PrivateKey {
    long S();

    long V();

    XMSSPrivateKey g(int i10);
}
