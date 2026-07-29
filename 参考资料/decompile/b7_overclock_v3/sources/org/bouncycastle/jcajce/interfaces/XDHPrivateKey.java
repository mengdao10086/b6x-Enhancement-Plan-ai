package org.bouncycastle.jcajce.interfaces;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public interface XDHPrivateKey extends XDHKey, PrivateKey {
    XDHPublicKey Y();
}
