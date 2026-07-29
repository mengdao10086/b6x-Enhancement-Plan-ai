package androidx.work;

import androidx.work.d;
import g.n0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class OverwritingInputMerger extends j {
    @Override // androidx.work.j
    @n0
    public d b(@n0 List<d> inputs) {
        d.a aVar = new d.a();
        HashMap map = new HashMap();
        Iterator<d> it2 = inputs.iterator();
        while (it2.hasNext()) {
            map.putAll(it2.next().x());
        }
        aVar.d(map);
        return aVar.a();
    }
}
