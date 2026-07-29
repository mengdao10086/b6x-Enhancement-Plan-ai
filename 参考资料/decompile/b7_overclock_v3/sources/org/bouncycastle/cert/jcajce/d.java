package org.bouncycastle.cert.jcajce;

import java.io.IOException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.cert.X509CRLHolder;

/* JADX INFO: loaded from: classes5.dex */
public class d extends org.bouncycastle.util.e {
    public d(Collection collection) throws CRLException {
        super(b(collection));
    }

    public static Collection b(Collection collection) throws CRLException {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj instanceof X509CRL) {
                try {
                    arrayList.add(new X509CRLHolder(((X509CRL) obj).getEncoded()));
                } catch (IOException e10) {
                    throw new CRLException("cannot read encoding: " + e10.getMessage());
                }
            } else {
                arrayList.add((X509CRLHolder) obj);
            }
        }
        return arrayList;
    }
}
