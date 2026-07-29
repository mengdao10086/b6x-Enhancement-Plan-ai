package zn;

import gm.f2;
import gm.j2;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f58662c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f58663a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f58664b = new Vector();

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(y.f59061h);
        hashSet.add(y.f59062i);
        hashSet.add(y.f59057d);
        hashSet.add(y.f59072q);
        f58662c = Collections.unmodifiableSet(hashSet);
    }

    public void a(gm.y yVar, boolean z10, gm.h hVar) throws IOException {
        b(yVar, z10, hVar.b().v(gm.j.f29713a));
    }

    public void b(gm.y yVar, boolean z10, byte[] bArr) {
        if (!this.f58663a.containsKey(yVar)) {
            this.f58664b.addElement(yVar);
            this.f58663a.put(yVar, new y(yVar, z10, new f2(bArr)));
            return;
        }
        if (!f58662c.contains(yVar)) {
            throw new IllegalArgumentException("extension " + yVar + " already added");
        }
        gm.f0 f0VarJ = gm.f0.J(gm.z.I(((y) this.f58663a.get(yVar)).A()).J());
        gm.f0 f0VarJ2 = gm.f0.J(bArr);
        gm.i iVar = new gm.i(f0VarJ.size() + f0VarJ2.size());
        Enumeration enumerationL = f0VarJ.L();
        while (enumerationL.hasMoreElements()) {
            iVar.a((gm.h) enumerationL.nextElement());
        }
        Enumeration enumerationL2 = f0VarJ2.L();
        while (enumerationL2.hasMoreElements()) {
            iVar.a((gm.h) enumerationL2.nextElement());
        }
        try {
            this.f58663a.put(yVar, new y(yVar, z10, new j2(iVar).getEncoded()));
        } catch (IOException e10) {
            throw new ASN1ParsingException(e10.getMessage(), e10);
        }
    }

    public void c(y yVar) {
        if (!this.f58663a.containsKey(yVar.z())) {
            this.f58664b.addElement(yVar.z());
            this.f58663a.put(yVar.z(), yVar);
        } else {
            throw new IllegalArgumentException("extension " + yVar.z() + " already added");
        }
    }

    public void d(z zVar) {
        gm.y[] yVarArrB = zVar.B();
        for (int i10 = 0; i10 != yVarArrB.length; i10++) {
            gm.y yVar = yVarArrB[i10];
            y yVarZ = zVar.z(yVar);
            b(gm.y.N(yVar), yVarZ.D(), yVarZ.A().J());
        }
    }

    public z e() {
        y[] yVarArr = new y[this.f58664b.size()];
        for (int i10 = 0; i10 != this.f58664b.size(); i10++) {
            yVarArr[i10] = (y) this.f58663a.get(this.f58664b.elementAt(i10));
        }
        return new z(yVarArr);
    }

    public y f(gm.y yVar) {
        return (y) this.f58663a.get(yVar);
    }

    public boolean g(gm.y yVar) {
        return this.f58663a.containsKey(yVar);
    }

    public boolean h() {
        return this.f58664b.isEmpty();
    }

    public void i(gm.y yVar) {
        if (this.f58663a.containsKey(yVar)) {
            this.f58664b.removeElement(yVar);
            this.f58663a.remove(yVar);
        } else {
            throw new IllegalArgumentException("extension " + yVar + " not present");
        }
    }

    public void j(gm.y yVar, boolean z10, gm.h hVar) throws IOException {
        k(yVar, z10, hVar.b().v(gm.j.f29713a));
    }

    public void k(gm.y yVar, boolean z10, byte[] bArr) {
        l(new y(yVar, z10, bArr));
    }

    public void l(y yVar) {
        if (this.f58663a.containsKey(yVar.z())) {
            this.f58663a.put(yVar.z(), yVar);
            return;
        }
        throw new IllegalArgumentException("extension " + yVar.z() + " not present");
    }

    public void m() {
        this.f58663a = new Hashtable();
        this.f58664b = new Vector();
    }
}
