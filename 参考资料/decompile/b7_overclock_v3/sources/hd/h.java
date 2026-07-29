package hd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class h<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f30994a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.b0("lock")
    public final Map<E, Integer> f30995b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.b0("lock")
    public Set<E> f30996c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.b0("lock")
    public List<E> f30997d = Collections.emptyList();

    public void a(E e10) {
        synchronized (this.f30994a) {
            ArrayList arrayList = new ArrayList(this.f30997d);
            arrayList.add(e10);
            this.f30997d = Collections.unmodifiableList(arrayList);
            Integer num = this.f30995b.get(e10);
            if (num == null) {
                HashSet hashSet = new HashSet(this.f30996c);
                hashSet.add(e10);
                this.f30996c = Collections.unmodifiableSet(hashSet);
            }
            this.f30995b.put(e10, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public void b(E e10) {
        synchronized (this.f30994a) {
            Integer num = this.f30995b.get(e10);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f30997d);
            arrayList.remove(e10);
            this.f30997d = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.f30995b.remove(e10);
                HashSet hashSet = new HashSet(this.f30996c);
                hashSet.remove(e10);
                this.f30996c = Collections.unmodifiableSet(hashSet);
            } else {
                this.f30995b.put(e10, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.f30994a) {
            set = this.f30996c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it2;
        synchronized (this.f30994a) {
            it2 = this.f30997d.iterator();
        }
        return it2;
    }
}
