package a;

import a.hn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class nn extends hn {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference<kn> f2118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e9<jn, mn> f2116a = new e9<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6933a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2120a = false;
    public boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<hn.b> f2119a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hn.b f2117a = hn.b.INITIALIZED;

    public nn(kn knVar) {
        this.f2118a = new WeakReference<>(knVar);
    }

    public static hn.a f(hn.b bVar) {
        int i = ln.b[bVar.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        }
        if (i == 2) {
            return hn.a.ON_DESTROY;
        }
        if (i == 3) {
            return hn.a.ON_STOP;
        }
        if (i == 4) {
            return hn.a.ON_PAUSE;
        }
        if (i == 5) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + bVar);
    }

    public static hn.b h(hn.a aVar) {
        switch (ln.f6723a[aVar.ordinal()]) {
            case 1:
            case 2:
                return hn.b.CREATED;
            case 3:
            case 4:
                return hn.b.STARTED;
            case 5:
                return hn.b.RESUMED;
            case 6:
                return hn.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    public static hn.b l(hn.b bVar, hn.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    public static hn.a r(hn.b bVar) {
        int i = ln.b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return hn.a.ON_START;
            }
            if (i == 3) {
                return hn.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return hn.a.ON_CREATE;
    }

    @Override // a.hn
    public void a(jn jnVar) {
        kn knVar;
        hn.b bVar = this.f2117a;
        hn.b bVar2 = hn.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = hn.b.INITIALIZED;
        }
        mn mnVar = new mn(jnVar, bVar2);
        if (this.f2116a.i(jnVar, mnVar) == null && (knVar = this.f2118a.get()) != null) {
            boolean z = this.f6933a != 0 || this.f2120a;
            hn.b bVarE = e(jnVar);
            this.f6933a++;
            while (mnVar.f6824a.compareTo(bVarE) < 0 && this.f2116a.contains(jnVar)) {
                o(mnVar.f6824a);
                mnVar.a(knVar, r(mnVar.f6824a));
                n();
                bVarE = e(jnVar);
            }
            if (!z) {
                q();
            }
            this.f6933a--;
        }
    }

    @Override // a.hn
    public hn.b b() {
        return this.f2117a;
    }

    @Override // a.hn
    public void c(jn jnVar) {
        this.f2116a.g(jnVar);
    }

    public final void d(kn knVar) {
        Iterator<Map.Entry<jn, mn>> itA = this.f2116a.a();
        while (itA.hasNext() && !this.b) {
            Map.Entry<jn, mn> next = itA.next();
            mn value = next.getValue();
            while (value.f6824a.compareTo(this.f2117a) > 0 && !this.b && this.f2116a.contains(next.getKey())) {
                hn.a aVarF = f(value.f6824a);
                o(h(aVarF));
                value.a(knVar, aVarF);
                n();
            }
        }
    }

    public final hn.b e(jn jnVar) {
        Map.Entry<jn, mn> entryH = this.f2116a.h(jnVar);
        hn.b bVar = null;
        hn.b bVar2 = entryH != null ? entryH.getValue().f6824a : null;
        if (!this.f2119a.isEmpty()) {
            bVar = this.f2119a.get(r0.size() - 1);
        }
        return l(l(this.f2117a, bVar2), bVar);
    }

    public final void g(kn knVar) {
        i9<jn, mn>.a aVarD = this.f2116a.d();
        while (aVarD.hasNext() && !this.b) {
            Map.Entry next = aVarD.next();
            mn mnVar = (mn) next.getValue();
            while (mnVar.f6824a.compareTo(this.f2117a) < 0 && !this.b && this.f2116a.contains((jn) next.getKey())) {
                o(mnVar.f6824a);
                mnVar.a(knVar, r(mnVar.f6824a));
                n();
            }
        }
    }

    public void i(hn.a aVar) {
        m(h(aVar));
    }

    public final boolean j() {
        if (this.f2116a.size() == 0) {
            return true;
        }
        hn.b bVar = this.f2116a.b().getValue().f6824a;
        hn.b bVar2 = this.f2116a.e().getValue().f6824a;
        return bVar == bVar2 && this.f2117a == bVar2;
    }

    @Deprecated
    public void k(hn.b bVar) {
        p(bVar);
    }

    public final void m(hn.b bVar) {
        if (this.f2117a == bVar) {
            return;
        }
        this.f2117a = bVar;
        if (this.f2120a || this.f6933a != 0) {
            this.b = true;
            return;
        }
        this.f2120a = true;
        q();
        this.f2120a = false;
    }

    public final void n() {
        this.f2119a.remove(r0.size() - 1);
    }

    public final void o(hn.b bVar) {
        this.f2119a.add(bVar);
    }

    public void p(hn.b bVar) {
        m(bVar);
    }

    public final void q() {
        kn knVar = this.f2118a.get();
        if (knVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean zJ = j();
            this.b = false;
            if (zJ) {
                return;
            }
            if (this.f2117a.compareTo(this.f2116a.b().getValue().f6824a) < 0) {
                d(knVar);
            }
            Map.Entry<jn, mn> entryE = this.f2116a.e();
            if (!this.b && entryE != null && this.f2117a.compareTo(entryE.getValue().f6824a) > 0) {
                g(knVar);
            }
        }
    }
}
