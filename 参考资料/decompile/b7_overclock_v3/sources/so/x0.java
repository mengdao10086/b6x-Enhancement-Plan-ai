package so;

import gm.l2;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class x0 implements d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Hashtable f50339g;

    public x0() {
        this.f50339g = new Hashtable();
    }

    public x0(mm.b bVar) {
        this.f50339g = bVar != null ? bVar.j() : new Hashtable();
    }

    public static Hashtable b(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable2.put(objNextElement, hashtable.get(objNextElement));
        }
        return hashtable2;
    }

    @Override // so.d
    public mm.b a(Map map) {
        return new mm.b(c(map));
    }

    public Hashtable c(Map map) {
        gm.y yVarN;
        Hashtable hashtableB = b(this.f50339g);
        gm.y yVar = mm.j.f41338a;
        if (!hashtableB.containsKey(yVar) && (yVarN = gm.y.N(map.get(d.f50127a))) != null) {
            mm.a aVar = new mm.a(yVar, new l2(yVarN));
            hashtableB.put(aVar.x(), aVar);
        }
        gm.y yVar2 = mm.j.f41340c;
        if (!hashtableB.containsKey(yVar2)) {
            mm.a aVar2 = new mm.a(yVar2, new l2(new mm.w0(new Date())));
            hashtableB.put(aVar2.x(), aVar2);
        }
        gm.y yVar3 = mm.j.f41339b;
        if (!hashtableB.containsKey(yVar3)) {
            mm.a aVar3 = new mm.a(yVar3, new l2(new gm.f2((byte[]) map.get(d.f50128b))));
            hashtableB.put(aVar3.x(), aVar3);
        }
        gm.y yVar4 = mm.j.f41344g;
        if (!hashtableB.contains(yVar4)) {
            mm.a aVar4 = new mm.a(yVar4, new l2(new mm.i((zn.b) map.get(d.f50130d), 1, (zn.b) map.get(d.f50132f))));
            hashtableB.put(aVar4.x(), aVar4);
        }
        return hashtableB;
    }
}
