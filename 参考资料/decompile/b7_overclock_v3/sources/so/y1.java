package so;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class y1 implements org.bouncycastle.util.k<x1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f50353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f50354b;

    public y1(Collection<x1> collection) {
        this.f50354b = new HashMap();
        for (x1 x1Var : collection) {
            v1 v1VarJ = x1Var.j();
            ArrayList arrayList = (ArrayList) this.f50354b.get(v1VarJ);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f50354b.put(v1VarJ, arrayList);
            }
            arrayList.add(x1Var);
        }
        this.f50353a = new ArrayList(collection);
    }

    public y1(x1 x1Var) {
        HashMap map = new HashMap();
        this.f50354b = map;
        ArrayList arrayList = new ArrayList(1);
        this.f50353a = arrayList;
        arrayList.add(x1Var);
        map.put(x1Var.j(), arrayList);
    }

    public x1 a(v1 v1Var) {
        Collection<x1> collectionD = d(v1Var);
        if (collectionD.size() == 0) {
            return null;
        }
        return collectionD.iterator().next();
    }

    public Collection<x1> b() {
        return new ArrayList(this.f50353a);
    }

    public Collection<x1> d(v1 v1Var) {
        if (v1Var instanceof h1) {
            h1 h1Var = (h1) v1Var;
            xn.d dVarB = h1Var.b();
            byte[] bArrD = h1Var.d();
            if (dVarB != null && bArrD != null) {
                ArrayList arrayList = new ArrayList();
                Collection<x1> collectionD = d(new h1(dVarB, h1Var.c()));
                if (collectionD != null) {
                    arrayList.addAll(collectionD);
                }
                Collection<x1> collectionD2 = d(new h1(bArrD));
                if (collectionD2 != null) {
                    arrayList.addAll(collectionD2);
                }
                return arrayList;
            }
        }
        ArrayList arrayList2 = (ArrayList) this.f50354b.get(v1Var);
        return arrayList2 == null ? new ArrayList() : new ArrayList(arrayList2);
    }

    @Override // org.bouncycastle.util.k, java.lang.Iterable
    public Iterator<x1> iterator() {
        return b().iterator();
    }

    public int size() {
        return this.f50353a.size();
    }
}
