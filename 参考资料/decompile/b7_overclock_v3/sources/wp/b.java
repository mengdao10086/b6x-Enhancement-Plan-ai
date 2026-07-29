package wp;

import gm.y;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f54778a;

    static {
        Hashtable hashtable = new Hashtable();
        f54778a = hashtable;
        hashtable.put(sm.g.f49911l, "SHA1withRSA");
        hashtable.put(sm.g.f49912m, "SHA256withRSA");
        hashtable.put(sm.g.f49913n, "SHA1withRSAandMGF1");
        hashtable.put(sm.g.f49914o, "SHA256withRSAandMGF1");
        hashtable.put(sm.g.f49915p, "SHA512withRSA");
        hashtable.put(sm.g.f49916q, "SHA512withRSAandMGF1");
        hashtable.put(sm.g.f49918s, "SHA1withECDSA");
        hashtable.put(sm.g.f49919t, "SHA224withECDSA");
        hashtable.put(sm.g.f49920u, "SHA256withECDSA");
        hashtable.put(sm.g.f49921v, "SHA384withECDSA");
        hashtable.put(sm.g.f49922w, "SHA512withECDSA");
    }

    public abstract Signature a(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    public Signature b(y yVar) throws NoSuchAlgorithmException, NoSuchProviderException {
        return a((String) f54778a.get(yVar));
    }
}
