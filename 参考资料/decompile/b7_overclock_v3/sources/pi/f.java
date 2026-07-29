package pi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f46680a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f46681b;

    @Override // pi.d
    public synchronized boolean W() {
        return this.f46681b;
    }

    public synchronized void a(d dVar) {
        this.f46680a.add(dVar);
        this.f46681b = false;
    }

    public synchronized int b() {
        return this.f46680a.size();
    }

    @Override // pi.d
    public synchronized void cancel() {
        this.f46681b = true;
        Iterator<d> it2 = this.f46680a.iterator();
        while (it2.hasNext()) {
            it2.next().cancel();
        }
        this.f46680a.clear();
    }
}
