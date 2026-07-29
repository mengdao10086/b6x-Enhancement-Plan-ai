package it;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.ers.ERSException;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cs.o f35851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<g> f35852b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f35853c = new a();

    public d(cs.o oVar) {
        this.f35851a = oVar;
    }

    public void a(List<g> list) {
        this.f35852b.addAll(list);
    }

    public void b(g gVar) {
        this.f35852b.add(gVar);
    }

    public c c(gt.f fVar) throws ERSException, TSPException {
        un.i[] iVarArrF = f();
        byte[] bArrA = this.f35853c.a(this.f35851a, iVarArrF);
        un.j jVarN = fVar.f().i().n();
        if (!jVarN.B().x().equals(this.f35851a.a())) {
            throw new ERSException("time stamp imprint for wrong algorithm");
        }
        if (org.bouncycastle.util.a.g(jVarN.B().y(), bArrA)) {
            return new c(iVarArrF.length == 1 ? new un.b(null, null, fVar.f().l().q()) : new un.b(this.f35851a.a(), iVarArrF, fVar.f().l().q()), this.f35851a, this.f35853c);
        }
        throw new ERSException("time stamp imprint for wrong root hash");
    }

    public gt.d d(gt.e eVar) throws TSPException, IOException {
        return eVar.i(this.f35851a.a(), this.f35853c.a(this.f35851a, f()));
    }

    public gt.d e(gt.e eVar, BigInteger bigInteger) throws TSPException, IOException {
        return eVar.j(this.f35851a.a(), this.f35853c.a(this.f35851a, f()), bigInteger);
    }

    public final un.i[] f() {
        List<byte[]> listA = o.a(this.f35851a, this.f35852b);
        un.i[] iVarArr = new un.i[listA.size()];
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 != this.f35852b.size(); i10++) {
            if (this.f35852b.get(i10) instanceof h) {
                hashSet.add((h) this.f35852b.get(i10));
            }
        }
        for (int i11 = 0; i11 != listA.size(); i11++) {
            byte[] bArr = listA.get(i11);
            h hVar = null;
            Iterator it2 = hashSet.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                h hVar2 = (h) it2.next();
                if (org.bouncycastle.util.a.g(hVar2.a(this.f35851a), bArr)) {
                    List<byte[]> listC = hVar2.c(this.f35851a);
                    iVarArr[i11] = new un.i((byte[][]) listC.toArray(new byte[listC.size()][]));
                    hVar = hVar2;
                    break;
                }
            }
            if (hVar == null) {
                iVarArr[i11] = new un.i(bArr);
            } else {
                hashSet.remove(hVar);
            }
        }
        return iVarArr;
    }
}
