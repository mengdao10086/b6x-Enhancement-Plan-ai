package cr;

import gm.y;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class l implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f25827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f25828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f25829c;

    public l(y yVar, y yVar2) {
        this(yVar, yVar2, null);
    }

    public l(y yVar, y yVar2, y yVar3) {
        this.f25827a = yVar;
        this.f25828b = yVar2;
        this.f25829c = yVar3;
    }

    public l(String str) {
        this(d(str), a(str), null);
    }

    public static y a(String str) {
        return str.indexOf("12-512") > 0 ? qn.a.f47514d : str.indexOf("12-256") > 0 ? qn.a.f47513c : qm.a.f47466p;
    }

    public static y d(String str) {
        return qm.b.j(str);
    }

    public y b() {
        return this.f25828b;
    }

    public y c() {
        return this.f25829c;
    }

    public y e() {
        return this.f25827a;
    }

    public String f() {
        return qm.b.h(e());
    }
}
