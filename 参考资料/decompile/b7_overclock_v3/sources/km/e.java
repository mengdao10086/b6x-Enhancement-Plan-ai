package km;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class e extends gm.w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f37440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f37441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f37442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f37443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f37444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f37445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f37446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f37447i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f37448j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f37449k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f37450l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f37451m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f37452n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e f37453o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Map f37454p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.t f37455a;

    static {
        e eVar = new e(new gm.t(0L));
        f37440b = eVar;
        e eVar2 = new e(new gm.t(1L));
        f37441c = eVar2;
        e eVar3 = new e(new gm.t(2L));
        f37442d = eVar3;
        e eVar4 = new e(new gm.t(3L));
        f37443e = eVar4;
        e eVar5 = new e(new gm.t(4L));
        f37444f = eVar5;
        e eVar6 = new e(new gm.t(5L));
        f37445g = eVar6;
        e eVar7 = new e(new gm.t(6L));
        f37446h = eVar7;
        e eVar8 = new e(new gm.t(7L));
        f37447i = eVar8;
        e eVar9 = new e(new gm.t(8L));
        f37448j = eVar9;
        e eVar10 = new e(new gm.t(9L));
        f37449k = eVar10;
        e eVar11 = new e(new gm.t(10L));
        f37450l = eVar11;
        e eVar12 = new e(new gm.t(11L));
        f37451m = eVar12;
        e eVar13 = new e(new gm.t(12L));
        f37452n = eVar13;
        e eVar14 = new e(new gm.t(13L));
        f37453o = eVar14;
        HashMap map = new HashMap();
        f37454p = map;
        map.put(eVar.f37455a, eVar);
        f37454p.put(eVar2.f37455a, eVar2);
        f37454p.put(eVar3.f37455a, eVar3);
        f37454p.put(eVar4.f37455a, eVar4);
        f37454p.put(eVar5.f37455a, eVar5);
        f37454p.put(eVar9.f37455a, eVar9);
        f37454p.put(eVar6.f37455a, eVar6);
        f37454p.put(eVar7.f37455a, eVar7);
        f37454p.put(eVar8.f37455a, eVar8);
        f37454p.put(eVar9.f37455a, eVar9);
        f37454p.put(eVar10.f37455a, eVar10);
        f37454p.put(eVar5.f37455a, eVar5);
        f37454p.put(eVar9.f37455a, eVar9);
        f37454p.put(eVar11.f37455a, eVar11);
        f37454p.put(eVar12.f37455a, eVar12);
        f37454p.put(eVar13.f37455a, eVar13);
        f37454p.put(eVar14.f37455a, eVar14);
    }

    public e(gm.t tVar) {
        this.f37455a = tVar;
    }

    public static e x(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj == null) {
            return null;
        }
        e eVar = (e) f37454p.get(gm.t.I(obj));
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f37455a;
    }
}
