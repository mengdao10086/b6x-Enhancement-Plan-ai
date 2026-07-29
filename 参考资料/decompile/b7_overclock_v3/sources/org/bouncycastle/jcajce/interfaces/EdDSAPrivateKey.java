package org.bouncycastle.jcajce.interfaces;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public interface EdDSAPrivateKey extends EdDSAKey, PrivateKey {
    EdDSAPublicKey Y();
}
