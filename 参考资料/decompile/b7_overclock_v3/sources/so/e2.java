package so;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class e2 implements org.bouncycastle.util.k<d2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f50162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f50163b = new HashMap();

    public e2(Collection<d2> collection) {
        this.f50162a = new ArrayList();
        for (d2 d2Var : collection) {
            a2 a2VarM = d2Var.m();
            ArrayList arrayList = (ArrayList) this.f50163b.get(a2VarM);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f50163b.put(a2VarM, arrayList);
            }
            arrayList.add(d2Var);
        }
        this.f50162a = new ArrayList(collection);
    }

    public e2(d2 d2Var) {
        this.f50162a = new ArrayList();
        ArrayList arrayList = new ArrayList(1);
        this.f50162a = arrayList;
        arrayList.add(d2Var);
        this.f50163b.put(d2Var.m(), this.f50162a);
    }

    public d2 a(a2 a2Var) {
        Collection<d2> collectionD = d(a2Var);
        if (collectionD.size() == 0) {
            return null;
        }
        return collectionD.iterator().next();
    }

    public Collection<d2> b() {
        return new ArrayList(this.f50162a);
    }

    public Collection<d2> d(a2 a2Var) {
        if (a2Var.a() == null || a2Var.c() == null) {
            ArrayList arrayList = (ArrayList) this.f50163b.get(a2Var);
            return arrayList == null ? new ArrayList() : new ArrayList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Collection<d2> collectionD = d(new a2(a2Var.a(), a2Var.b()));
        if (collectionD != null) {
            arrayList2.addAll(collectionD);
        }
        Collection<d2> collectionD2 = d(new a2(a2Var.c()));
        if (collectionD2 != null) {
            arrayList2.addAll(collectionD2);
        }
        return arrayList2;
    }

    @Override // org.bouncycastle.util.k, java.lang.Iterable
    public Iterator<d2> iterator() {
        return b().iterator();
    }

    public int size() {
        return this.f50162a.size();
    }
}
