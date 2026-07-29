package so;

import gm.l2;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class u0 implements d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Hashtable f50323g;

    public u0() {
        this.f50323g = new Hashtable();
    }

    public u0(mm.b bVar) {
        this.f50323g = bVar != null ? bVar.j() : new Hashtable();
    }

    @Override // so.d
    public mm.b a(Map map) {
        return new mm.b(b(map));
    }

    public Hashtable b(Map map) {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationKeys = this.f50323g.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable.put(objNextElement, this.f50323g.get(objNextElement));
        }
        gm.y yVar = mm.j.f41338a;
        if (!hashtable.containsKey(yVar)) {
            mm.a aVar = new mm.a(yVar, new l2(gm.y.N(map.get(d.f50127a))));
            hashtable.put(aVar.x(), aVar);
        }
        gm.y yVar2 = mm.j.f41339b;
        if (!hashtable.containsKey(yVar2)) {
            mm.a aVar2 = new mm.a(yVar2, new l2(new gm.f2((byte[]) map.get(d.f50128b))));
            hashtable.put(aVar2.x(), aVar2);
        }
        gm.y yVar3 = mm.j.f41344g;
        if (!hashtable.contains(yVar3)) {
            mm.a aVar3 = new mm.a(yVar3, new l2(new mm.i((zn.b) map.get(d.f50130d), 2, (zn.b) map.get(d.f50131e))));
            hashtable.put(aVar3.x(), aVar3);
        }
        return hashtable;
    }
}
