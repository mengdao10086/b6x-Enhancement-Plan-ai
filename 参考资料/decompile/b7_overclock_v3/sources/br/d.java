package br;

import gm.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.crypto.util.f;
import org.bouncycastle.util.Strings;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set f9568a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set f9569b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Set f9570c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Set f9571d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Set f9572e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Set f9573f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Set f9574g = new HashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Set f9575h = new HashSet();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Set f9576i = new HashSet();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Set f9577j = new HashSet();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Set f9578k = new HashSet();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Set f9579l = new HashSet();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Set f9580m = new HashSet();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Set f9581n = new HashSet();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Map f9582o = new HashMap();

    static {
        f9568a.add("MD5");
        Set set = f9568a;
        y yVar = s.f46803f4;
        set.add(yVar.L());
        f9569b.add("SHA1");
        f9569b.add(et.e.f27137f);
        Set set2 = f9569b;
        y yVar2 = on.b.f44365i;
        set2.add(yVar2.L());
        f9570c.add("SHA224");
        f9570c.add(et.e.f27138g);
        Set set3 = f9570c;
        y yVar3 = kn.d.f37598f;
        set3.add(yVar3.L());
        f9571d.add("SHA256");
        f9571d.add("SHA-256");
        Set set4 = f9571d;
        y yVar4 = kn.d.f37592c;
        set4.add(yVar4.L());
        f9572e.add("SHA384");
        f9572e.add(et.e.f27140i);
        Set set5 = f9572e;
        y yVar5 = kn.d.f37594d;
        set5.add(yVar5.L());
        f9573f.add("SHA512");
        f9573f.add("SHA-512");
        Set set6 = f9573f;
        y yVar6 = kn.d.f37596e;
        set6.add(yVar6.L());
        f9574g.add("SHA512(224)");
        f9574g.add("SHA-512(224)");
        Set set7 = f9574g;
        y yVar7 = kn.d.f37600g;
        set7.add(yVar7.L());
        f9575h.add("SHA512(256)");
        f9575h.add("SHA-512(256)");
        Set set8 = f9575h;
        y yVar8 = kn.d.f37602h;
        set8.add(yVar8.L());
        f9576i.add("SHA3-224");
        Set set9 = f9576i;
        y yVar9 = kn.d.f37604i;
        set9.add(yVar9.L());
        f9577j.add("SHA3-256");
        Set set10 = f9577j;
        y yVar10 = kn.d.f37606j;
        set10.add(yVar10.L());
        f9578k.add("SHA3-384");
        Set set11 = f9578k;
        y yVar11 = kn.d.f37608k;
        set11.add(yVar11.L());
        f9579l.add("SHA3-512");
        Set set12 = f9579l;
        y yVar12 = kn.d.f37610l;
        set12.add(yVar12.L());
        f9580m.add("SHAKE128");
        Set set13 = f9580m;
        y yVar13 = kn.d.f37612m;
        set13.add(yVar13.L());
        f9581n.add("SHAKE256");
        Set set14 = f9581n;
        y yVar14 = kn.d.f37614n;
        set14.add(yVar14.L());
        f9582o.put("MD5", yVar);
        f9582o.put(yVar.L(), yVar);
        f9582o.put("SHA1", yVar2);
        f9582o.put(et.e.f27137f, yVar2);
        f9582o.put(yVar2.L(), yVar2);
        f9582o.put("SHA224", yVar3);
        f9582o.put(et.e.f27138g, yVar3);
        f9582o.put(yVar3.L(), yVar3);
        f9582o.put("SHA256", yVar4);
        f9582o.put("SHA-256", yVar4);
        f9582o.put(yVar4.L(), yVar4);
        f9582o.put("SHA384", yVar5);
        f9582o.put(et.e.f27140i, yVar5);
        f9582o.put(yVar5.L(), yVar5);
        f9582o.put("SHA512", yVar6);
        f9582o.put("SHA-512", yVar6);
        f9582o.put(yVar6.L(), yVar6);
        f9582o.put("SHA512(224)", yVar7);
        f9582o.put("SHA-512(224)", yVar7);
        f9582o.put(yVar7.L(), yVar7);
        f9582o.put("SHA512(256)", yVar8);
        f9582o.put("SHA-512(256)", yVar8);
        f9582o.put(yVar8.L(), yVar8);
        f9582o.put("SHA3-224", yVar9);
        f9582o.put(yVar9.L(), yVar9);
        f9582o.put("SHA3-256", yVar10);
        f9582o.put(yVar10.L(), yVar10);
        f9582o.put("SHA3-384", yVar11);
        f9582o.put(yVar11.L(), yVar11);
        f9582o.put("SHA3-512", yVar12);
        f9582o.put(yVar12.L(), yVar12);
        f9582o.put("SHAKE128", yVar13);
        f9582o.put(yVar13.L(), yVar13);
        f9582o.put("SHAKE256", yVar14);
        f9582o.put(yVar14.L(), yVar14);
    }

    public static org.bouncycastle.crypto.s a(String str) {
        String strO = Strings.o(str);
        if (f9569b.contains(strO)) {
            return f.c();
        }
        if (f9568a.contains(strO)) {
            return f.b();
        }
        if (f9570c.contains(strO)) {
            return f.d();
        }
        if (f9571d.contains(strO)) {
            return f.e();
        }
        if (f9572e.contains(strO)) {
            return f.f();
        }
        if (f9573f.contains(strO)) {
            return f.k();
        }
        if (f9574g.contains(strO)) {
            return f.l();
        }
        if (f9575h.contains(strO)) {
            return f.m();
        }
        if (f9576i.contains(strO)) {
            return f.g();
        }
        if (f9577j.contains(strO)) {
            return f.h();
        }
        if (f9578k.contains(strO)) {
            return f.i();
        }
        if (f9579l.contains(strO)) {
            return f.j();
        }
        if (f9580m.contains(strO)) {
            return f.n();
        }
        if (f9581n.contains(strO)) {
            return f.o();
        }
        return null;
    }

    public static y b(String str) {
        return (y) f9582o.get(str);
    }

    public static boolean c(String str, String str2) {
        return (f9569b.contains(str) && f9569b.contains(str2)) || (f9570c.contains(str) && f9570c.contains(str2)) || ((f9571d.contains(str) && f9571d.contains(str2)) || ((f9572e.contains(str) && f9572e.contains(str2)) || ((f9573f.contains(str) && f9573f.contains(str2)) || ((f9574g.contains(str) && f9574g.contains(str2)) || ((f9575h.contains(str) && f9575h.contains(str2)) || ((f9576i.contains(str) && f9576i.contains(str2)) || ((f9577j.contains(str) && f9577j.contains(str2)) || ((f9578k.contains(str) && f9578k.contains(str2)) || ((f9579l.contains(str) && f9579l.contains(str2)) || (f9568a.contains(str) && f9568a.contains(str2)))))))))));
    }
}
