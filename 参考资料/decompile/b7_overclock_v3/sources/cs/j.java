package cs;

import gm.d2;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class j implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f25886a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map f25887b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map f25888c = new HashMap();

    static {
        Map map = f25886a;
        gm.y yVar = on.b.f44366j;
        gm.y yVar2 = on.b.f44365i;
        map.put(yVar, yVar2);
        Map map2 = f25886a;
        gm.y yVar3 = on.b.f44359c;
        gm.y yVar4 = pn.s.f46800e4;
        map2.put(yVar3, yVar4);
        f25886a.put(on.b.f44357a, yVar4);
        f25886a.put(on.b.f44367k, yVar2);
        Map map3 = f25886a;
        gm.y yVar5 = pn.s.K3;
        gm.y yVar6 = kn.d.f37598f;
        map3.put(yVar5, yVar6);
        Map map4 = f25886a;
        gm.y yVar7 = pn.s.H3;
        gm.y yVar8 = kn.d.f37592c;
        map4.put(yVar7, yVar8);
        Map map5 = f25886a;
        gm.y yVar9 = pn.s.I3;
        gm.y yVar10 = kn.d.f37594d;
        map5.put(yVar9, yVar10);
        Map map6 = f25886a;
        gm.y yVar11 = pn.s.J3;
        gm.y yVar12 = kn.d.f37596e;
        map6.put(yVar11, yVar12);
        Map map7 = f25886a;
        gm.y yVar13 = pn.s.L3;
        gm.y yVar14 = kn.d.f37600g;
        map7.put(yVar13, yVar14);
        Map map8 = f25886a;
        gm.y yVar15 = pn.s.M3;
        gm.y yVar16 = kn.d.f37602h;
        map8.put(yVar15, yVar16);
        Map map9 = f25886a;
        gm.y yVar17 = pn.s.f46857y3;
        gm.y yVar18 = pn.s.f46797d4;
        map9.put(yVar17, yVar18);
        f25886a.put(pn.s.f46860z3, yVar4);
        Map map10 = f25886a;
        gm.y yVar19 = pn.s.A3;
        gm.y yVar20 = pn.s.f46803f4;
        map10.put(yVar19, yVar20);
        f25886a.put(pn.s.B3, yVar2);
        f25886a.put(co.r.f11170i0, yVar2);
        f25886a.put(co.r.f11178n0, yVar6);
        f25886a.put(co.r.f11180o0, yVar8);
        f25886a.put(co.r.f11182p0, yVar10);
        f25886a.put(co.r.f11184q0, yVar12);
        f25886a.put(co.r.X0, yVar2);
        f25886a.put(jm.a.f36494d, yVar2);
        f25886a.put(jm.a.f36495e, yVar6);
        f25886a.put(jm.a.f36496f, yVar8);
        f25886a.put(jm.a.f36497g, yVar10);
        f25886a.put(jm.a.f36498h, yVar12);
        Map map11 = f25886a;
        gm.y yVar21 = jm.a.f36500j;
        gm.y yVar22 = kn.d.f37604i;
        map11.put(yVar21, yVar22);
        Map map12 = f25886a;
        gm.y yVar23 = jm.a.f36501k;
        gm.y yVar24 = kn.d.f37606j;
        map12.put(yVar23, yVar24);
        Map map13 = f25886a;
        gm.y yVar25 = jm.a.f36502l;
        gm.y yVar26 = kn.d.f37608k;
        map13.put(yVar25, yVar26);
        Map map14 = f25886a;
        gm.y yVar27 = jm.a.f36503m;
        gm.y yVar28 = kn.d.f37610l;
        map14.put(yVar27, yVar28);
        Map map15 = f25886a;
        gm.y yVar29 = jm.a.f36499i;
        gm.y yVar30 = tn.b.f51360b;
        map15.put(yVar29, yVar30);
        f25886a.put(sm.g.f49918s, yVar2);
        f25886a.put(sm.g.f49919t, yVar6);
        f25886a.put(sm.g.f49920u, yVar8);
        f25886a.put(sm.g.f49921v, yVar10);
        f25886a.put(sm.g.f49922w, yVar12);
        f25886a.put(kn.d.X, yVar6);
        f25886a.put(kn.d.Y, yVar8);
        f25886a.put(kn.d.Z, yVar10);
        f25886a.put(kn.d.f37589a0, yVar12);
        f25886a.put(kn.d.f37607j0, yVar22);
        f25886a.put(kn.d.f37609k0, yVar24);
        f25886a.put(kn.d.f37611l0, yVar26);
        f25886a.put(kn.d.f37613m0, yVar28);
        f25886a.put(kn.d.f37591b0, yVar22);
        f25886a.put(kn.d.f37593c0, yVar24);
        f25886a.put(kn.d.f37595d0, yVar26);
        f25886a.put(kn.d.f37597e0, yVar28);
        f25886a.put(kn.d.f37599f0, yVar22);
        f25886a.put(kn.d.f37601g0, yVar24);
        f25886a.put(kn.d.f37603h0, yVar26);
        f25886a.put(kn.d.f37605i0, yVar28);
        Map map16 = f25886a;
        gm.y yVar31 = tn.b.f51365g;
        gm.y yVar32 = tn.b.f51361c;
        map16.put(yVar31, yVar32);
        f25886a.put(tn.b.f51364f, yVar30);
        Map map17 = f25886a;
        gm.y yVar33 = tn.b.f51366h;
        gm.y yVar34 = tn.b.f51362d;
        map17.put(yVar33, yVar34);
        Map map18 = f25886a;
        gm.y yVar35 = qm.a.f47464n;
        gm.y yVar36 = qm.a.f47452b;
        map18.put(yVar35, yVar36);
        f25886a.put(qm.a.f47465o, yVar36);
        Map map19 = f25886a;
        gm.y yVar37 = qn.a.f47519i;
        gm.y yVar38 = qn.a.f47513c;
        map19.put(yVar37, yVar38);
        Map map20 = f25886a;
        gm.y yVar39 = qn.a.f47520j;
        gm.y yVar40 = qn.a.f47514d;
        map20.put(yVar39, yVar40);
        f25886a.put(im.a.f32500v, yVar28);
        f25886a.put(im.a.f32499u, yVar12);
        f25886a.put(xm.b.f55624f0, yVar8);
        Map map21 = f25886a;
        gm.y yVar41 = xm.b.f55620d0;
        gm.y yVar42 = xm.b.f55616b0;
        map21.put(yVar41, yVar42);
        Map map22 = f25886a;
        gm.y yVar43 = mm.k.X2;
        gm.y yVar44 = kn.d.f37612m;
        map22.put(yVar43, yVar44);
        Map map23 = f25886a;
        gm.y yVar45 = mm.k.Y2;
        gm.y yVar46 = kn.d.f37614n;
        map23.put(yVar45, yVar46);
        f25886a.put(mm.k.Z2, yVar44);
        f25886a.put(mm.k.f41347a3, yVar46);
        f25887b.put(et.e.f27137f, yVar2);
        f25887b.put(et.e.f27138g, yVar6);
        f25887b.put("SHA-256", yVar8);
        f25887b.put(et.e.f27140i, yVar10);
        f25887b.put("SHA-512", yVar12);
        f25887b.put("SHA-512-224", yVar14);
        f25887b.put("SHA-512-256", yVar16);
        f25887b.put("SHA1", yVar2);
        f25887b.put("SHA224", yVar6);
        f25887b.put("SHA256", yVar8);
        f25887b.put("SHA384", yVar10);
        f25887b.put("SHA512", yVar12);
        f25887b.put("SHA512-224", yVar14);
        f25887b.put(et.k.f27170b, yVar16);
        f25887b.put("SHA3-224", yVar22);
        f25887b.put("SHA3-256", yVar24);
        f25887b.put("SHA3-384", yVar26);
        f25887b.put("SHA3-512", yVar28);
        f25887b.put("SHAKE128", yVar44);
        f25887b.put("SHAKE256", yVar46);
        f25887b.put("SHAKE-128", yVar44);
        f25887b.put("SHAKE-256", yVar46);
        f25887b.put("GOST3411", yVar36);
        f25887b.put("GOST3411-2012-256", yVar38);
        f25887b.put("GOST3411-2012-512", yVar40);
        f25887b.put("MD2", yVar18);
        f25887b.put("MD4", yVar4);
        f25887b.put("MD5", yVar20);
        f25887b.put("RIPEMD128", yVar32);
        f25887b.put("RIPEMD160", yVar30);
        f25887b.put("RIPEMD256", yVar34);
        f25887b.put("SM3", yVar42);
        d(yVar2, true);
        d(yVar6, false);
        d(yVar8, false);
        d(yVar10, false);
        d(yVar12, false);
        d(yVar14, false);
        d(yVar16, false);
        d(yVar22, false);
        d(yVar24, false);
        d(yVar26, false);
        d(yVar28, false);
        d(yVar44, false);
        d(yVar46, false);
        d(yVar36, true);
        d(yVar38, false);
        d(yVar40, false);
        d(yVar18, true);
        d(yVar4, true);
        d(yVar20, true);
        d(yVar32, true);
        d(yVar30, true);
        d(yVar34, true);
    }

    public static void d(gm.y yVar, boolean z10) {
        f25888c.put(yVar, z10 ? new zn.b(yVar, d2.f29657b) : new zn.b(yVar));
    }

    @Override // cs.n
    public zn.b a(String str) {
        gm.y yVar = (gm.y) f25887b.get(str);
        if (yVar != null) {
            return b(yVar);
        }
        try {
            return b(new gm.y(str));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // cs.n
    public zn.b b(gm.y yVar) {
        Objects.requireNonNull(yVar, "digest OID is null");
        zn.b bVar = (zn.b) f25888c.get(yVar);
        return bVar == null ? new zn.b(yVar) : bVar;
    }

    @Override // cs.n
    public zn.b c(zn.b bVar) {
        gm.y yVarX = bVar.x();
        if (yVarX.C(tm.a.f51341e)) {
            return new zn.b(kn.d.f37620t, new gm.t(512L));
        }
        return b(yVarX.C(pn.s.G3) ? pn.a0.y(bVar.A()).x().x() : yVarX.C(tm.a.f51340d) ? kn.d.f37596e : (gm.y) f25886a.get(bVar.x()));
    }
}
