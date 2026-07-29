package jo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.util.q;
import org.bouncycastle.util.s;

/* JADX INFO: loaded from: classes5.dex */
public class h implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f36537a;

    public h(List list) {
        HashMap map = new HashMap();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            b bVar = (b) it2.next();
            map.put(bVar.b(), bVar);
        }
        this.f36537a = Collections.unmodifiableMap(map);
    }

    @Override // org.bouncycastle.util.s
    public Collection a(q qVar) throws StoreException {
        if (qVar == null) {
            return this.f36537a.values();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f36537a.values()) {
            if (qVar.M(obj)) {
                arrayList.add(obj);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public s b() {
        Collection collectionA = a(null);
        ArrayList arrayList = new ArrayList(collectionA.size());
        Iterator it2 = collectionA.iterator();
        while (it2.hasNext()) {
            arrayList.add(((b) it2.next()).a());
        }
        return new org.bouncycastle.util.e(arrayList);
    }
}
