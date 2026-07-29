package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<c> f3053h;

    public b(char[] cArr) {
        super(cArr);
        this.f3053h = new ArrayList<>();
    }

    public static c y(char[] cArr) {
        return new b(cArr);
    }

    public c A(String str) throws CLParsingException {
        Iterator<c> it2 = this.f3053h.iterator();
        while (it2.hasNext()) {
            d dVar = (d) it2.next();
            if (dVar.b().equals(str)) {
                return dVar.b0();
            }
        }
        throw new CLParsingException("no element for key <" + str + ">", this);
    }

    public a B(int i10) throws CLParsingException {
        c cVarZ = z(i10);
        if (cVarZ instanceof a) {
            return (a) cVarZ;
        }
        throw new CLParsingException("no array at index " + i10, this);
    }

    public a C(String str) throws CLParsingException {
        c cVarA = A(str);
        if (cVarA instanceof a) {
            return (a) cVarA;
        }
        throw new CLParsingException("no array found for key <" + str + ">, found [" + cVarA.m() + "] : " + cVarA, this);
    }

    public a D(String str) {
        c cVarP = P(str);
        if (cVarP instanceof a) {
            return (a) cVarP;
        }
        return null;
    }

    public boolean E(int i10) throws CLParsingException {
        c cVarZ = z(i10);
        if (cVarZ instanceof CLToken) {
            return ((CLToken) cVarZ).y();
        }
        throw new CLParsingException("no boolean at index " + i10, this);
    }

    public boolean F(String str) throws CLParsingException {
        c cVarA = A(str);
        if (cVarA instanceof CLToken) {
            return ((CLToken) cVarA).y();
        }
        throw new CLParsingException("no boolean found for key <" + str + ">, found [" + cVarA.m() + "] : " + cVarA, this);
    }

    public float G(int i10) throws CLParsingException {
        c cVarZ = z(i10);
        if (cVarZ != null) {
            return cVarZ.g();
        }
        throw new CLParsingException("no float at index " + i10, this);
    }

    public float H(String str) throws CLParsingException {
        c cVarA = A(str);
        if (cVarA != null) {
            return cVarA.g();
        }
        throw new CLParsingException("no float found for key <" + str + ">, found [" + cVarA.m() + "] : " + cVarA, this);
    }

    public float I(String str) {
        c cVarP = P(str);
        if (cVarP instanceof e) {
            return cVarP.g();
        }
        return Float.NaN;
    }

    public int J(int i10) throws CLParsingException {
        c cVarZ = z(i10);
        if (cVarZ != null) {
            return cVarZ.i();
        }
        throw new CLParsingException("no int at index " + i10, this);
    }

    public int K(String str) throws CLParsingException {
        c cVarA = A(str);
        if (cVarA != null) {
            return cVarA.i();
        }
        throw new CLParsingException("no int found for key <" + str + ">, found [" + cVarA.m() + "] : " + cVarA, this);
    }

    public f L(int i10) throws CLParsingException {
        c cVarZ = z(i10);
        if (cVarZ instanceof f) {
            return (f) cVarZ;
        }
        throw new CLParsingException("no object at index " + i10, this);
    }

    public f M(String str) throws CLParsingException {
        c cVarA = A(str);
        if (cVarA instanceof f) {
            return (f) cVarA;
        }
        throw new CLParsingException("no object found for key <" + str + ">, found [" + cVarA.m() + "] : " + cVarA, this);
    }

    public f N(String str) {
        c cVarP = P(str);
        if (cVarP instanceof f) {
            return (f) cVarP;
        }
        return null;
    }

    public c O(int i10) {
        if (i10 < 0 || i10 >= this.f3053h.size()) {
            return null;
        }
        return this.f3053h.get(i10);
    }

    public c P(String str) {
        Iterator<c> it2 = this.f3053h.iterator();
        while (it2.hasNext()) {
            d dVar = (d) it2.next();
            if (dVar.b().equals(str)) {
                return dVar.b0();
            }
        }
        return null;
    }

    public String Q(int i10) throws CLParsingException {
        c cVarZ = z(i10);
        if (cVarZ instanceof g) {
            return cVarZ.b();
        }
        throw new CLParsingException("no string at index " + i10, this);
    }

    public String R(String str) throws CLParsingException {
        c cVarA = A(str);
        if (cVarA instanceof g) {
            return cVarA.b();
        }
        throw new CLParsingException("no string found for key <" + str + ">, found [" + (cVarA != null ? cVarA.m() : null) + "] : " + cVarA, this);
    }

    public String S(int i10) {
        c cVarO = O(i10);
        if (cVarO instanceof g) {
            return cVarO.b();
        }
        return null;
    }

    public String T(String str) {
        c cVarP = P(str);
        if (cVarP instanceof g) {
            return cVarP.b();
        }
        return null;
    }

    public boolean U(String str) {
        for (c cVar : this.f3053h) {
            if ((cVar instanceof d) && ((d) cVar).b().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> V() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (c cVar : this.f3053h) {
            if (cVar instanceof d) {
                arrayList.add(((d) cVar).b());
            }
        }
        return arrayList;
    }

    public void W(String str, c cVar) {
        Iterator<c> it2 = this.f3053h.iterator();
        while (it2.hasNext()) {
            d dVar = (d) it2.next();
            if (dVar.b().equals(str)) {
                dVar.c0(cVar);
                return;
            }
        }
        this.f3053h.add((d) d.Z(str, cVar));
    }

    public void X(String str, float f10) {
        W(str, new e(f10));
    }

    public void Y(String str) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : this.f3053h) {
            if (((d) cVar).b().equals(str)) {
                arrayList.add(cVar);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.f3053h.remove((c) it2.next());
        }
    }

    public int size() {
        return this.f3053h.size();
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (c cVar : this.f3053h) {
            if (sb2.length() > 0) {
                sb2.append("; ");
            }
            sb2.append(cVar);
        }
        return super.toString() + " = <" + ((Object) sb2) + " >";
    }

    public void x(c cVar) {
        this.f3053h.add(cVar);
        if (CLParser.f3042d) {
            System.out.println("added element " + cVar + " to " + this);
        }
    }

    public c z(int i10) throws CLParsingException {
        if (i10 >= 0 && i10 < this.f3053h.size()) {
            return this.f3053h.get(i10);
        }
        throw new CLParsingException("no element at index " + i10, this);
    }
}
