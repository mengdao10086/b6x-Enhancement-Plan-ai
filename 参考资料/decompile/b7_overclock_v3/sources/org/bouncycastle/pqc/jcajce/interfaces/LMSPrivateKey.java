package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes6.dex */
public interface LMSPrivateKey extends LMSKey, PrivateKey {
    long S();

    long V();

    LMSPrivateKey g(int i10);
}
