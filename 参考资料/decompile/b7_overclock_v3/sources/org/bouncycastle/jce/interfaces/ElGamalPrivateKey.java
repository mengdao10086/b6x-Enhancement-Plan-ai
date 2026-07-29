package org.bouncycastle.jce.interfaces;

import er.d;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
public interface ElGamalPrivateKey extends d, DHPrivateKey {
    BigInteger getX();
}
