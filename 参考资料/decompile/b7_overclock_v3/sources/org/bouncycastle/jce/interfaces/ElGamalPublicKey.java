package org.bouncycastle.jce.interfaces;

import er.d;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;

/* JADX INFO: loaded from: classes5.dex */
public interface ElGamalPublicKey extends d, DHPublicKey {
    BigInteger getY();
}
