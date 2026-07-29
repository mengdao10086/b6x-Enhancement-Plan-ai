package org.bouncycastle.jcajce.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes7.dex */
public interface XDHPublicKey extends XDHKey, PublicKey {
    BigInteger g0();

    byte[] z0();
}
