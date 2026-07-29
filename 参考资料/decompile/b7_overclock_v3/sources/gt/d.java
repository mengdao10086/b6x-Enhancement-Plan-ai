package gt;

import gm.s;
import gm.y;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TSPValidationException;
import un.k;
import zn.z;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Set f30036c = Collections.unmodifiableSet(new HashSet());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f30037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f30038b;

    public d(InputStream inputStream) throws IOException {
        this(p(inputStream));
    }

    public d(k kVar) {
        this.f30037a = kVar;
        this.f30038b = kVar.z();
    }

    public d(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public static k p(InputStream inputStream) throws IOException {
        try {
            return k.A(new s(inputStream).n());
        } catch (ClassCastException e10) {
            throw new IOException("malformed request: " + e10);
        } catch (IllegalArgumentException e11) {
            throw new IOException("malformed request: " + e11);
        }
    }

    public final Set a(Set set) {
        if (set == null) {
            return set;
        }
        HashSet hashSet = new HashSet(set.size());
        for (Object obj : set) {
            if (obj instanceof String) {
                hashSet.add(new y((String) obj));
            } else {
                hashSet.add(obj);
            }
        }
        return hashSet;
    }

    public boolean b() {
        if (this.f30037a.y() != null) {
            return this.f30037a.y().L();
        }
        return false;
    }

    public Set c() {
        return this.f30038b == null ? f30036c : Collections.unmodifiableSet(new HashSet(Arrays.asList(this.f30038b.y())));
    }

    public byte[] d() throws IOException {
        return this.f30037a.getEncoded();
    }

    public zn.y e(y yVar) {
        z zVar = this.f30038b;
        if (zVar != null) {
            return zVar.z(yVar);
        }
        return null;
    }

    public List f() {
        return c.c(this.f30038b);
    }

    public z g() {
        return this.f30038b;
    }

    public zn.b h() {
        return this.f30037a.B().x();
    }

    public y i() {
        return this.f30037a.B().x().x();
    }

    public byte[] j() {
        return this.f30037a.B().y();
    }

    public Set k() {
        return this.f30038b == null ? f30036c : Collections.unmodifiableSet(new HashSet(Arrays.asList(this.f30038b.H())));
    }

    public BigInteger l() {
        if (this.f30037a.C() != null) {
            return this.f30037a.C().K();
        }
        return null;
    }

    public y m() {
        if (this.f30037a.D() != null) {
            return this.f30037a.D();
        }
        return null;
    }

    public int n() {
        return this.f30037a.E().Q();
    }

    public boolean o() {
        return this.f30038b != null;
    }

    public void q(Set set, Set set2, Set set3) throws TSPException {
        Set setA = a(set);
        Set setA2 = a(set2);
        Set setA3 = a(set3);
        if (!setA.contains(i())) {
            throw new TSPValidationException("request contains unknown algorithm", 128);
        }
        if (setA2 != null && m() != null && !setA2.contains(m())) {
            throw new TSPValidationException("request contains unknown policy", 256);
        }
        if (g() != null && setA3 != null) {
            Enumeration enumerationI = g().I();
            while (enumerationI.hasMoreElements()) {
                if (!setA3.contains((y) enumerationI.nextElement())) {
                    throw new TSPValidationException("request contains unknown extension", 8388608);
                }
            }
        }
        if (c.b(i().L()) != j().length) {
            throw new TSPValidationException("imprint digest the wrong length", 4);
        }
    }
}
