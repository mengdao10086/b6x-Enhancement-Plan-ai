package gt;

import com.google.android.material.timepicker.ChipTextInputComboView;
import gm.t;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public un.a f30018a;

    public a(un.a aVar) {
        this.f30018a = aVar;
    }

    public final String a(int i10) {
        StringBuilder sb2;
        String str;
        if (i10 < 10) {
            sb2 = new StringBuilder();
            str = ChipTextInputComboView.b.f21060b;
        } else {
            if (i10 >= 100) {
                return Integer.toString(i10);
            }
            sb2 = new StringBuilder();
            str = "0";
        }
        sb2.append(str);
        sb2.append(i10);
        return sb2.toString();
    }

    public int b() {
        return e(this.f30018a.y());
    }

    public int c() {
        return e(this.f30018a.z());
    }

    public int d() {
        return e(this.f30018a.A());
    }

    public final int e(t tVar) {
        if (tVar != null) {
            return tVar.Q();
        }
        return 0;
    }

    public String toString() {
        return d() + j3.b.f36044h + a(c()) + a(b());
    }
}
