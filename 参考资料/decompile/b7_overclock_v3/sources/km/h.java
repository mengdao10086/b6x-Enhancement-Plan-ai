package km;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class h extends gm.w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f37497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f37498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f37499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f37500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f37501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f37502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f37503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Map f37504i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.t f37505a;

    static {
        h hVar = new h(new gm.t(0L));
        f37497b = hVar;
        h hVar2 = new h(new gm.t(2L));
        f37498c = hVar2;
        h hVar3 = new h(new gm.t(3L));
        f37499d = hVar3;
        h hVar4 = new h(new gm.t(4L));
        f37500e = hVar4;
        h hVar5 = new h(new gm.t(5L));
        f37501f = hVar5;
        h hVar6 = new h(new gm.t(6L));
        f37502g = hVar6;
        h hVar7 = new h(new gm.t(7L));
        f37503h = hVar7;
        HashMap map = new HashMap();
        f37504i = map;
        map.put(hVar.f37505a, hVar);
        f37504i.put(hVar2.f37505a, hVar2);
        f37504i.put(hVar3.f37505a, hVar3);
        f37504i.put(hVar4.f37505a, hVar4);
        f37504i.put(hVar5.f37505a, hVar5);
        f37504i.put(hVar6.f37505a, hVar6);
        f37504i.put(hVar7.f37505a, hVar7);
    }

    public h(gm.t tVar) {
        this.f37505a = tVar;
    }

    public static h x(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj == null) {
            return null;
        }
        h hVar = (h) f37504i.get(gm.t.I(obj));
        if (hVar != null) {
            return hVar;
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f37505a;
    }
}
