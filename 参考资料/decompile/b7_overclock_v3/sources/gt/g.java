package gt;

import gm.j2;
import gm.p2;
import gm.t;
import gm.u1;
import gm.y;
import gm.z2;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lm.b0;
import lm.v;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TSPValidationException;
import un.l;
import zn.z;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.i f30046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f30048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f30049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set f30050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set f30051g;

    public class a extends u1 {
        public a(int i10) {
            super(gm.d.I(i10), gm.d.M(i10));
        }
    }

    public g(i iVar, Set set) {
        this(iVar, set, null, null);
    }

    public g(i iVar, Set set, Set set2) {
        this(iVar, set, set2, null);
    }

    public g(i iVar, Set set, Set set2, Set set3) {
        this.f30048d = iVar;
        this.f30049e = b(set);
        this.f30050f = b(set2);
        this.f30051g = b(set3);
        this.f30046b = new gm.i();
    }

    public final void a(String str) {
        this.f30046b.a(new p2(str));
    }

    public final Set b(Set set) {
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

    public f c(d dVar, BigInteger bigInteger, Date date) throws TSPException {
        try {
            return f(dVar, bigInteger, date, "Operation Okay");
        } catch (Exception e10) {
            return h(e10);
        }
    }

    public f d(int i10, int i11, String str) throws TSPException {
        this.f30045a = i10;
        this.f30046b = new gm.i();
        j(i11);
        if (str != null) {
            a(str);
        }
        try {
            return new f(new l(i(), null));
        } catch (IOException unused) {
            throw new TSPException("created badly formatted response!");
        }
    }

    public f e(d dVar, BigInteger bigInteger, Date date) throws TSPException {
        return f(dVar, bigInteger, date, null);
    }

    public f f(d dVar, BigInteger bigInteger, Date date, String str) throws TSPException {
        return g(dVar, bigInteger, date, str, null);
    }

    public f g(d dVar, BigInteger bigInteger, Date date, String str, z zVar) throws TSPException {
        if (date == null) {
            throw new TSPValidationException("The time source is not available.", 512);
        }
        dVar.q(this.f30049e, this.f30050f, this.f30051g);
        this.f30045a = 0;
        this.f30046b = new gm.i();
        if (str != null) {
            a(str);
        }
        try {
            try {
                return new f(new z2(new gm.h[]{i().b(), this.f30048d.g(dVar, bigInteger, date, zVar).l().q().b()}));
            } catch (IOException unused) {
                throw new TSPException("created badly formatted response!");
            }
        } catch (TSPException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new TSPException("Timestamp token received cannot be converted to ContentInfo", e11);
        }
    }

    public f h(Exception exc) throws TSPException {
        return d(2, exc instanceof TSPValidationException ? ((TSPValidationException) exc).b() : 1073741824, exc.getMessage());
    }

    public final b0 i() {
        gm.i iVar = new gm.i();
        iVar.a(new t(this.f30045a));
        if (this.f30046b.i() > 0) {
            iVar.a(v.y(new j2(this.f30046b)));
        }
        if (this.f30047c != 0) {
            iVar.a(new a(this.f30047c));
        }
        return b0.z(new j2(iVar));
    }

    public final void j(int i10) {
        this.f30047c = i10 | this.f30047c;
    }
}
