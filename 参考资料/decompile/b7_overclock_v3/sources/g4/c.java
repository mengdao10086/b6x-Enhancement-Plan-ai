package g4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<d, Integer> f29023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f29024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29026d;

    public c(Map<d, Integer> map) {
        this.f29023a = map;
        this.f29024b = new ArrayList(map.keySet());
        Iterator<Integer> it2 = map.values().iterator();
        while (it2.hasNext()) {
            this.f29025c += it2.next().intValue();
        }
    }

    public int a() {
        return this.f29025c;
    }

    public boolean b() {
        return this.f29025c == 0;
    }

    public d c() {
        d dVar = this.f29024b.get(this.f29026d);
        Integer num = this.f29023a.get(dVar);
        if (num.intValue() == 1) {
            this.f29023a.remove(dVar);
            this.f29024b.remove(this.f29026d);
        } else {
            this.f29023a.put(dVar, Integer.valueOf(num.intValue() - 1));
        }
        this.f29025c--;
        this.f29026d = this.f29024b.isEmpty() ? 0 : (this.f29026d + 1) % this.f29024b.size();
        return dVar;
    }
}
