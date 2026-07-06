package a;

import com.omarea.model.CpuClusterStatus;
import com.omarea.model.CpuStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zq0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<String[]> f3873a = new kl0().f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kl0 f8089a = new kl0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f3872a = a42.a(new yq0(this));
    public final z32 b = a42.a(new xq0(this));

    public zq0(boolean z) {
        this.f3874a = z;
    }

    public final String a() {
        g30 g30Var = new g30();
        Object g30Var2 = new g30();
        m42 m42Var = m42.f6769a;
        g30Var.x("alias", g30Var2);
        Object g30Var3 = new g30();
        m42 m42Var2 = m42.f6769a;
        g30Var.x("presets", g30Var3);
        g30 g30Var4 = new g30();
        String strP = wu0.f3480a.p();
        g30 g30Var5 = new g30();
        g30Var5.x("call", j(wu0.f3480a.p()));
        m42 m42Var3 = m42.f6769a;
        g30Var4.x(strP, g30Var5);
        String strC = wu0.f3480a.c();
        g30 g30Var6 = new g30();
        g30Var6.x("call", j(wu0.f3480a.c()));
        m42 m42Var4 = m42.f6769a;
        g30Var4.x(strC, g30Var6);
        String strO = wu0.f3480a.o();
        g30 g30Var7 = new g30();
        g30Var7.x("call", j(wu0.f3480a.o()));
        m42 m42Var5 = m42.f6769a;
        g30Var4.x(strO, g30Var7);
        String strI = wu0.f3480a.i();
        g30 g30Var8 = new g30();
        g30Var8.x("call", j(wu0.f3480a.i()));
        m42 m42Var6 = m42.f6769a;
        g30Var4.x(strI, g30Var8);
        String strN = wu0.f3480a.n();
        g30 g30Var9 = new g30();
        g30Var9.x("call", new d30());
        m42 m42Var7 = m42.f6769a;
        g30Var4.x(strN, g30Var9);
        m42 m42Var8 = m42.f6769a;
        g30Var.x("schemes", g30Var4);
        g30Var.x("apps", g());
        g30Var.x("games", g());
        String strA = g30Var.A(2);
        f92.c(strA, "json");
        return strA;
    }

    public final void c(CpuStatus cpuStatus) {
        f92.d(cpuStatus, "profile");
        e50.f677a.N0(f(cpuStatus));
    }

    public final g30 d(CpuStatus cpuStatus, CpuStatus cpuStatus2, CpuStatus cpuStatus3, CpuStatus cpuStatus4) {
        g30 g30Var = new g30();
        Object g30Var2 = new g30();
        m42 m42Var = m42.f6769a;
        g30Var.x("alias", g30Var2);
        Object g30Var3 = new g30();
        m42 m42Var2 = m42.f6769a;
        g30Var.x("presets", g30Var3);
        g30 g30Var4 = new g30();
        String strP = wu0.f3480a.p();
        g30 g30Var5 = new g30();
        g30Var5.x("call", f(cpuStatus));
        m42 m42Var3 = m42.f6769a;
        g30Var4.x(strP, g30Var5);
        String strC = wu0.f3480a.c();
        g30 g30Var6 = new g30();
        g30Var6.x("call", f(cpuStatus2));
        m42 m42Var4 = m42.f6769a;
        g30Var4.x(strC, g30Var6);
        String strO = wu0.f3480a.o();
        g30 g30Var7 = new g30();
        g30Var7.x("call", f(cpuStatus3));
        m42 m42Var5 = m42.f6769a;
        g30Var4.x(strO, g30Var7);
        String strI = wu0.f3480a.i();
        g30 g30Var8 = new g30();
        g30Var8.x("call", f(cpuStatus4));
        m42 m42Var6 = m42.f6769a;
        g30Var4.x(strI, g30Var8);
        String strN = wu0.f3480a.n();
        g30 g30Var9 = new g30();
        g30Var9.x("call", new d30());
        m42 m42Var7 = m42.f6769a;
        g30Var4.x(strN, g30Var9);
        m42 m42Var8 = m42.f6769a;
        g30Var.x("schemes", g30Var4);
        g30Var.x("apps", g());
        if (!this.f3874a) {
            g30Var.x("games", g());
            return g30Var;
        }
        l92 l92Var = new l92();
        l92Var.f6687a = 2;
        l92 l92Var2 = new l92();
        l92Var2.f6687a = 1;
        String strA = jm0.f6525a.a();
        if (f92.a(strA, "pineapple") || f92.a(strA, "tuna")) {
            l92Var.f6687a = 3;
        } else if (this.f3873a.size() == 2) {
            l92Var.f6687a = 1;
            l92Var2.f6687a = 0;
        }
        d30 d30Var = new d30();
        g30 g30Var10 = new g30();
        g30Var10.x("friendly", "All");
        d30 d30Var2 = new d30();
        d30Var2.k("*");
        m42 m42Var9 = m42.f6769a;
        g30Var10.x("packages", d30Var2);
        g30Var10.x("modes", new m30(new l30(new qq0(l92Var, l92Var2, this, cpuStatus, cpuStatus2, cpuStatus3, cpuStatus4)), new l30(new sq0(l92Var, l92Var2, this, cpuStatus, cpuStatus2, cpuStatus3, cpuStatus4)), new l30(new uq0(l92Var, l92Var2, this, cpuStatus, cpuStatus2, cpuStatus3, cpuStatus4)), new l30(new wq0(l92Var, l92Var2, this, cpuStatus, cpuStatus2, cpuStatus3, cpuStatus4))));
        m42 m42Var10 = m42.f6769a;
        d30Var.k(g30Var10);
        m42 m42Var11 = m42.f6769a;
        g30Var.x("games", d30Var);
        return g30Var;
    }

    public final d30 e(Object... objArr) {
        d30 d30Var = new d30();
        for (Object obj : objArr) {
            d30Var.k(obj.toString());
        }
        return d30Var;
    }

    public final d30 f(CpuStatus cpuStatus) {
        d30 d30Var = new d30();
        if (cpuStatus != null) {
            if (i()) {
                d30Var.k(e("@mtk_reset"));
            }
            if (h()) {
                d30Var.k(e("@msm_reset"));
            }
            Object obj = cpuStatus.cpusetBg;
            f92.c(obj, "cpuStatus.cpusetBg");
            Object obj2 = cpuStatus.cpusetSysBg;
            f92.c(obj2, "cpuStatus.cpusetSysBg");
            Object obj3 = cpuStatus.cpusetFg;
            f92.c(obj3, "cpuStatus.cpusetFg");
            Object obj4 = cpuStatus.cpusetTop;
            f92.c(obj4, "cpuStatus.cpusetTop");
            d30Var.k(e("@cpuset", obj, obj2, obj3, obj4));
            Object obj5 = cpuStatus.gpuMinFreq;
            f92.c(obj5, "cpuStatus.gpuMinFreq");
            Object obj6 = cpuStatus.gpuMaxFreq;
            f92.c(obj6, "cpuStatus.gpuMaxFreq");
            d30Var.k(e("@gpu_freq", obj5, obj6));
            d30 d30Var2 = new d30();
            d30Var2.k("@cpu_online");
            for (Boolean bool : cpuStatus.coreOnline) {
                f92.c(bool, "online");
                d30Var2.k(bool.booleanValue() ? "1" : "0");
            }
            m42 m42Var = m42.f6769a;
            d30Var.k(d30Var2);
            ArrayList<CpuClusterStatus> arrayList = cpuStatus.clusters;
            f92.c(arrayList, "cpuStatus.clusters");
            int i = 0;
            for (Object obj7 : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    y42.l();
                    throw null;
                }
                CpuClusterStatus cpuClusterStatus = (CpuClusterStatus) obj7;
                StringBuilder sb = new StringBuilder();
                sb.append("cpu");
                String[] strArr = this.f3873a.get(i);
                f92.c(strArr, "clusters[index]");
                sb.append((String) u42.n(strArr));
                String string = sb.toString();
                Object obj8 = cpuClusterStatus.governor;
                f92.c(obj8, "governor");
                d30Var.k(e("/sys/devices/system/cpu/" + string + "/cpufreq/scaling_governor", obj8));
                Object obj9 = cpuClusterStatus.min_freq;
                f92.c(obj9, "cluster.min_freq");
                Object obj10 = cpuClusterStatus.max_freq;
                f92.c(obj10, "cluster.max_freq");
                d30Var.k(e("@cpu_freq", string, obj9, obj10));
                HashMap<String, String> map = cpuClusterStatus.governor_params;
                f92.c(map, "cluster.governor_params");
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    Object key = entry.getKey();
                    f92.c(key, "param.key");
                    Object value = entry.getValue();
                    f92.c(value, "param.value");
                    d30Var.k(e(key, value));
                }
                i = i2;
            }
        }
        return d30Var;
    }

    public final d30 g() {
        d30 d30Var = new d30();
        g30 g30Var = new g30();
        g30Var.x("friendly", "All");
        d30 d30Var2 = new d30();
        d30Var2.k("*");
        m42 m42Var = m42.f6769a;
        g30Var.x("packages", d30Var2);
        m42 m42Var2 = m42.f6769a;
        d30Var.k(g30Var);
        return d30Var;
    }

    public final boolean h() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) this.f3872a.getValue()).booleanValue();
    }

    public final d30 j(String str) {
        d30 d30Var = new d30();
        d30 d30Var2 = new d30();
        d30Var2.k("@shell");
        d30Var2.k("sh /data/powercfg.sh '" + str + "' > /dev/null 2>&1");
        m42 m42Var = m42.f6769a;
        d30Var.k(d30Var2);
        return d30Var;
    }
}
