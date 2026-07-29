package androidx.fragment.app;

import androidx.lifecycle.c1;
import g.p0;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final Collection<Fragment> f6043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final Map<String, x> f6044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final Map<String, c1> f6045c;

    public x(@p0 Collection<Fragment> collection, @p0 Map<String, x> map, @p0 Map<String, c1> map2) {
        this.f6043a = collection;
        this.f6044b = map;
        this.f6045c = map2;
    }

    @p0
    public Map<String, x> a() {
        return this.f6044b;
    }

    @p0
    public Collection<Fragment> b() {
        return this.f6043a;
    }

    @p0
    public Map<String, c1> c() {
        return this.f6045c;
    }

    public boolean d(Fragment fragment) {
        Collection<Fragment> collection = this.f6043a;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}
