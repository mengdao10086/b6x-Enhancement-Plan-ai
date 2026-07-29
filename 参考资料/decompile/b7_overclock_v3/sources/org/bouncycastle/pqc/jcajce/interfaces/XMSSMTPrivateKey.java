package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;
import us.d;

/* JADX INFO: loaded from: classes6.dex */
public interface XMSSMTPrivateKey extends d, PrivateKey {
    long S();

    long V();

    XMSSMTPrivateKey g(int i10);
}
