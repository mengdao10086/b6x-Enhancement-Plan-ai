package a;

import a.wn;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cm extends vn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wn.a f5807a = new bm();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashSet<Fragment> f426a = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, cm> f425a = new HashMap<>();
    public final HashMap<String, xn> b = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f428b = false;
    public boolean c = false;

    public cm(boolean z) {
        this.f427a = z;
    }

    public static cm g(xn xnVar) {
        return (cm) new wn(xnVar, f5807a).a(cm.class);
    }

    @Override // a.vn
    public void c() {
        if (yl.h) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f428b = true;
    }

    public boolean d(Fragment fragment) {
        return this.f426a.add(fragment);
    }

    public void e(Fragment fragment) {
        if (yl.h) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        cm cmVar = this.f425a.get(fragment.f4267a);
        if (cmVar != null) {
            cmVar.c();
            this.f425a.remove(fragment.f4267a);
        }
        xn xnVar = this.b.get(fragment.f4267a);
        if (xnVar != null) {
            xnVar.a();
            this.b.remove(fragment.f4267a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || cm.class != obj.getClass()) {
            return false;
        }
        cm cmVar = (cm) obj;
        return this.f426a.equals(cmVar.f426a) && this.f425a.equals(cmVar.f425a) && this.b.equals(cmVar.b);
    }

    public cm f(Fragment fragment) {
        cm cmVar = this.f425a.get(fragment.f4267a);
        if (cmVar != null) {
            return cmVar;
        }
        cm cmVar2 = new cm(this.f427a);
        this.f425a.put(fragment.f4267a, cmVar2);
        return cmVar2;
    }

    public Collection<Fragment> h() {
        return this.f426a;
    }

    public int hashCode() {
        return (((this.f426a.hashCode() * 31) + this.f425a.hashCode()) * 31) + this.b.hashCode();
    }

    public xn i(Fragment fragment) {
        xn xnVar = this.b.get(fragment.f4267a);
        if (xnVar != null) {
            return xnVar;
        }
        xn xnVar2 = new xn();
        this.b.put(fragment.f4267a, xnVar2);
        return xnVar2;
    }

    public boolean j() {
        return this.f428b;
    }

    public boolean k(Fragment fragment) {
        return this.f426a.remove(fragment);
    }

    public boolean l(Fragment fragment) {
        if (this.f426a.contains(fragment)) {
            return this.f427a ? this.f428b : !this.c;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f426a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f425a.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.b.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
