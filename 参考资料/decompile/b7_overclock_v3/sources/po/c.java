package po;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p000do.a f46923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p000do.b f46924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f46925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Date f46926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public X509AttributeCertificateHolder f46927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Collection f46928f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Collection f46929g = new HashSet();

    public void a(b0 b0Var) {
        this.f46929g.add(b0Var);
    }

    public void b(b0 b0Var) {
        this.f46928f.add(b0Var);
    }

    public b c() {
        return new b(this.f46923a, this.f46924b, this.f46925c, this.f46926d, this.f46927e, Collections.unmodifiableCollection(new HashSet(this.f46928f)), Collections.unmodifiableCollection(new HashSet(this.f46929g)));
    }

    public final Set d(Collection collection) throws IOException {
        if (collection == null || collection.isEmpty()) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            hashSet.add(b0.z(it2.next()));
        }
        return hashSet;
    }

    public void e(X509AttributeCertificateHolder x509AttributeCertificateHolder) {
        this.f46927e = x509AttributeCertificateHolder;
    }

    public void f(Date date) {
        if (date != null) {
            this.f46926d = new Date(date.getTime());
        } else {
            this.f46926d = null;
        }
    }

    public void g(p000do.a aVar) {
        this.f46923a = aVar;
    }

    public void h(p000do.b bVar) {
        this.f46924b = bVar;
    }

    public void i(BigInteger bigInteger) {
        this.f46925c = bigInteger;
    }

    public void j(Collection collection) throws IOException {
        this.f46929g = d(collection);
    }

    public void k(Collection collection) throws IOException {
        this.f46928f = d(collection);
    }
}
