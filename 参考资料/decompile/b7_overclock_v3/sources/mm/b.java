package mm;

import gm.l2;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f41282a;

    public b(gm.h0 h0Var) {
        this.f41282a = new Hashtable();
        for (int i10 = 0; i10 != h0Var.size(); i10++) {
            a aVarA = a.A(h0Var.J(i10));
            b(aVarA.x(), aVarA);
        }
    }

    public b(gm.i iVar) {
        this.f41282a = new Hashtable();
        for (int i10 = 0; i10 != iVar.i(); i10++) {
            a aVarA = a.A(iVar.g(i10));
            b(aVarA.x(), aVarA);
        }
    }

    public b(Hashtable hashtable) {
        this.f41282a = new Hashtable();
        this.f41282a = c(hashtable);
    }

    public b(a aVar) {
        this.f41282a = new Hashtable();
        b(aVar.x(), aVar);
    }

    public b(c cVar) {
        this(gm.h0.I(cVar.b()));
    }

    public b a(gm.y yVar, gm.h hVar) {
        b bVar = new b(this.f41282a);
        bVar.b(yVar, new a(yVar, new l2(hVar)));
        return bVar;
    }

    public final void b(gm.y yVar, a aVar) {
        Vector vector;
        Object obj = this.f41282a.get(yVar);
        if (obj == null) {
            this.f41282a.put(yVar, aVar);
            return;
        }
        if (obj instanceof a) {
            vector = new Vector();
            vector.addElement(obj);
        } else {
            vector = (Vector) obj;
        }
        vector.addElement(aVar);
        this.f41282a.put(yVar, vector);
    }

    public final Hashtable c(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable2.put(objNextElement, hashtable.get(objNextElement));
        }
        return hashtable2;
    }

    public a d(gm.y yVar) {
        Object obj = this.f41282a.get(yVar);
        return obj instanceof Vector ? (a) ((Vector) obj).elementAt(0) : (a) obj;
    }

    public gm.i e(gm.y yVar) {
        gm.i iVar = new gm.i();
        Object obj = this.f41282a.get(yVar);
        if (obj instanceof Vector) {
            Enumeration enumerationElements = ((Vector) obj).elements();
            while (enumerationElements.hasMoreElements()) {
                iVar.a((a) enumerationElements.nextElement());
            }
        } else if (obj != null) {
            iVar.a((a) obj);
        }
        return iVar;
    }

    public b f(gm.y yVar) {
        b bVar = new b(this.f41282a);
        bVar.f41282a.remove(yVar);
        return bVar;
    }

    public int g() {
        Enumeration enumerationElements = this.f41282a.elements();
        int size = 0;
        while (enumerationElements.hasMoreElements()) {
            Object objNextElement = enumerationElements.nextElement();
            size = objNextElement instanceof Vector ? size + ((Vector) objNextElement).size() : size + 1;
        }
        return size;
    }

    public gm.i h() {
        gm.i iVar = new gm.i();
        Enumeration enumerationElements = this.f41282a.elements();
        while (enumerationElements.hasMoreElements()) {
            Object objNextElement = enumerationElements.nextElement();
            if (objNextElement instanceof Vector) {
                Enumeration enumerationElements2 = ((Vector) objNextElement).elements();
                while (enumerationElements2.hasMoreElements()) {
                    iVar.a(a.A(enumerationElements2.nextElement()));
                }
            } else {
                iVar.a(a.A(objNextElement));
            }
        }
        return iVar;
    }

    public c i() {
        return new c(h());
    }

    public Hashtable j() {
        return c(this.f41282a);
    }
}
