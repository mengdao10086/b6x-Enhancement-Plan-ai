package jq;

import java.security.cert.CRL;
import java.util.Collection;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.util.q;
import org.bouncycastle.util.s;

/* JADX INFO: loaded from: classes7.dex */
public interface d<T extends CRL> extends s<T> {
    @Override // org.bouncycastle.util.s
    Collection<T> a(q<T> qVar) throws StoreException;
}
