package a;

import android.widget.Toast;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class os1 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g91 f7052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zs1 f2296a;

    public os1(zs1 zs1Var, g91 g91Var) {
        this.f2296a = zs1Var;
        this.f7052a = g91Var;
    }

    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        Boolean boolValueOf;
        f92.d(list, "selected");
        f92.d(zArr, "status");
        int i = 0;
        if (!(zArr.length == 0)) {
            int length = zArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    boolValueOf = null;
                    break;
                }
                boolean z = zArr[i2];
                if (z) {
                    boolValueOf = Boolean.valueOf(z);
                    break;
                }
                i2++;
            }
            if (boolValueOf != null) {
                int length2 = zArr.length;
                int i3 = 0;
                while (i < length2) {
                    int i4 = i3 + 1;
                    this.f2296a.f3875a.E(i3, zArr[i]);
                    qc2.d(xd2.a(qe2.b()), null, null, new ns1(null, this), 3, null);
                    i++;
                    i3 = i4;
                }
                return;
            }
        }
        Toast.makeText(this.f7052a, this.f2296a.J(u61.home_core_required), 0).show();
    }
}
