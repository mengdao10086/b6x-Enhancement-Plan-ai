package androidx.fragment.app;

import androidx.lifecycle.a1;
import androidx.lifecycle.c1;
import androidx.lifecycle.x0;
import androidx.lifecycle.z0;
import g.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends x0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f6046k = "FragmentManager";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final z0.b f6047l = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f6051g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Fragment> f6048d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, y> f6049e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, c1> f6050f = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6052h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6053i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6054j = false;

    public class a implements z0.b {
        @Override // androidx.lifecycle.z0.b
        @g.n0
        public <T extends x0> T a(@g.n0 Class<T> cls) {
            return new y(true);
        }

        @Override // androidx.lifecycle.z0.b
        public /* synthetic */ x0 b(Class cls, p1.a aVar) {
            return a1.b(this, cls, aVar);
        }
    }

    public y(boolean z10) {
        this.f6051g = z10;
    }

    @g.n0
    public static y m(c1 c1Var) {
        return (y) new z0(c1Var, f6047l).a(y.class);
    }

    @Override // androidx.lifecycle.x0
    public void e() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCleared called for ");
            sb2.append(this);
        }
        this.f6052h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        return this.f6048d.equals(yVar.f6048d) && this.f6049e.equals(yVar.f6049e) && this.f6050f.equals(yVar.f6050f);
    }

    public void g(@g.n0 Fragment fragment) {
        if (this.f6054j) {
            FragmentManager.W0(2);
            return;
        }
        if (this.f6048d.containsKey(fragment.f5646f)) {
            return;
        }
        this.f6048d.put(fragment.f5646f, fragment);
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Updating retained Fragments: Added ");
            sb2.append(fragment);
        }
    }

    public void h(@g.n0 Fragment fragment) {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for ");
            sb2.append(fragment);
        }
        j(fragment.f5646f);
    }

    public int hashCode() {
        return (((this.f6048d.hashCode() * 31) + this.f6049e.hashCode()) * 31) + this.f6050f.hashCode();
    }

    public void i(@g.n0 String str) {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for saved state of Fragment ");
            sb2.append(str);
        }
        j(str);
    }

    public final void j(@g.n0 String str) {
        y yVar = this.f6049e.get(str);
        if (yVar != null) {
            yVar.e();
            this.f6049e.remove(str);
        }
        c1 c1Var = this.f6050f.get(str);
        if (c1Var != null) {
            c1Var.a();
            this.f6050f.remove(str);
        }
    }

    @p0
    public Fragment k(String str) {
        return this.f6048d.get(str);
    }

    @g.n0
    public y l(@g.n0 Fragment fragment) {
        y yVar = this.f6049e.get(fragment.f5646f);
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y(this.f6051g);
        this.f6049e.put(fragment.f5646f, yVar2);
        return yVar2;
    }

    @g.n0
    public Collection<Fragment> n() {
        return new ArrayList(this.f6048d.values());
    }

    @p0
    @Deprecated
    public x o() {
        if (this.f6048d.isEmpty() && this.f6049e.isEmpty() && this.f6050f.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, y> entry : this.f6049e.entrySet()) {
            x xVarO = entry.getValue().o();
            if (xVarO != null) {
                map.put(entry.getKey(), xVarO);
            }
        }
        this.f6053i = true;
        if (this.f6048d.isEmpty() && map.isEmpty() && this.f6050f.isEmpty()) {
            return null;
        }
        return new x(new ArrayList(this.f6048d.values()), map, new HashMap(this.f6050f));
    }

    @g.n0
    public c1 q(@g.n0 Fragment fragment) {
        c1 c1Var = this.f6050f.get(fragment.f5646f);
        if (c1Var != null) {
            return c1Var;
        }
        c1 c1Var2 = new c1();
        this.f6050f.put(fragment.f5646f, c1Var2);
        return c1Var2;
    }

    public boolean r() {
        return this.f6052h;
    }

    public void s(@g.n0 Fragment fragment) {
        if (this.f6054j) {
            FragmentManager.W0(2);
            return;
        }
        if ((this.f6048d.remove(fragment.f5646f) != null) && FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Updating retained Fragments: Removed ");
            sb2.append(fragment);
        }
    }

    @Deprecated
    public void t(@p0 x xVar) {
        this.f6048d.clear();
        this.f6049e.clear();
        this.f6050f.clear();
        if (xVar != null) {
            Collection<Fragment> collectionB = xVar.b();
            if (collectionB != null) {
                for (Fragment fragment : collectionB) {
                    if (fragment != null) {
                        this.f6048d.put(fragment.f5646f, fragment);
                    }
                }
            }
            Map<String, x> mapA = xVar.a();
            if (mapA != null) {
                for (Map.Entry<String, x> entry : mapA.entrySet()) {
                    y yVar = new y(this.f6051g);
                    yVar.t(entry.getValue());
                    this.f6049e.put(entry.getKey(), yVar);
                }
            }
            Map<String, c1> mapC = xVar.c();
            if (mapC != null) {
                this.f6050f.putAll(mapC);
            }
        }
        this.f6053i = false;
    }

    @g.n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it2 = this.f6048d.values().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it3 = this.f6049e.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it4 = this.f6050f.keySet().iterator();
        while (it4.hasNext()) {
            sb2.append(it4.next());
            if (it4.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public void u(boolean z10) {
        this.f6054j = z10;
    }

    public boolean v(@g.n0 Fragment fragment) {
        if (this.f6048d.containsKey(fragment.f5646f)) {
            return this.f6051g ? this.f6052h : !this.f6053i;
        }
        return true;
    }
}
