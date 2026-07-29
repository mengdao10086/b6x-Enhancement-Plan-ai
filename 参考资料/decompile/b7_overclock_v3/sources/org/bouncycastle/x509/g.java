package org.bouncycastle.x509;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public abstract class g implements Cloneable {
    public abstract void a(l lVar, CertPath certPath, CertPath certPath2, Collection collection) throws CertPathValidatorException;

    public abstract Set b();

    public abstract Object clone();
}
