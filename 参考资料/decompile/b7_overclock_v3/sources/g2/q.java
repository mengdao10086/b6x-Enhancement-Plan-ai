package g2;

import android.view.View;
import g.n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f28973b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f28972a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<androidx.transition.q> f28974c = new ArrayList<>();

    @Deprecated
    public q() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f28973b == qVar.f28973b && this.f28972a.equals(qVar.f28972a);
    }

    public int hashCode() {
        return (this.f28973b.hashCode() * 31) + this.f28972a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f28973b + "\n") + "    values:";
        for (String str2 : this.f28972a.keySet()) {
            str = str + wn.a.f54751a + str2 + ": " + this.f28972a.get(str2) + "\n";
        }
        return str;
    }

    public q(@n0 View view) {
        this.f28973b = view;
    }
}
