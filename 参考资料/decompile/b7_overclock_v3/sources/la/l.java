package la;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class l extends c<qa.b<? extends Entry>> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f39514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f39515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s f39516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public i f39517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f39518n;

    @Override // la.k
    public void E() {
        m mVar = this.f39514j;
        if (mVar != null) {
            mVar.E();
        }
        a aVar = this.f39515k;
        if (aVar != null) {
            aVar.E();
        }
        i iVar = this.f39517m;
        if (iVar != null) {
            iVar.E();
        }
        s sVar = this.f39516l;
        if (sVar != null) {
            sVar.E();
        }
        g gVar = this.f39518n;
        if (gVar != null) {
            gVar.E();
        }
        d();
    }

    @Override // la.k
    @Deprecated
    public boolean F(int i10) {
        return false;
    }

    @Override // la.k
    @Deprecated
    public boolean H(float f10, int i10) {
        return false;
    }

    @Override // la.k
    @Deprecated
    public boolean I(Entry entry, int i10) {
        return false;
    }

    public List<c> Q() {
        ArrayList arrayList = new ArrayList();
        m mVar = this.f39514j;
        if (mVar != null) {
            arrayList.add(mVar);
        }
        a aVar = this.f39515k;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        s sVar = this.f39516l;
        if (sVar != null) {
            arrayList.add(sVar);
        }
        i iVar = this.f39517m;
        if (iVar != null) {
            arrayList.add(iVar);
        }
        g gVar = this.f39518n;
        if (gVar != null) {
            arrayList.add(gVar);
        }
        return arrayList;
    }

    public a R() {
        return this.f39515k;
    }

    public g S() {
        return this.f39518n;
    }

    public i T() {
        return this.f39517m;
    }

    public c U(int i10) {
        return Q().get(i10);
    }

    public int V(k kVar) {
        return Q().indexOf(kVar);
    }

    public qa.b<? extends Entry> W(oa.d dVar) {
        if (dVar.c() >= Q().size()) {
            return null;
        }
        c cVarU = U(dVar.c());
        if (dVar.d() >= cVarU.m()) {
            return null;
        }
        return (qa.b) cVarU.q().get(dVar.d());
    }

    public m X() {
        return this.f39514j;
    }

    public s Y() {
        return this.f39516l;
    }

    @Override // la.k
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public boolean G(qa.b<? extends Entry> bVar) {
        Iterator<c> it2 = Q().iterator();
        boolean zG = false;
        while (it2.hasNext() && !(zG = it2.next().G(bVar))) {
        }
        return zG;
    }

    public void a0(a aVar) {
        this.f39515k = aVar;
        E();
    }

    public void b0(g gVar) {
        this.f39518n = gVar;
        E();
    }

    public void c0(i iVar) {
        this.f39517m = iVar;
        E();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // la.k
    public void d() {
        if (this.f39513i == 0) {
            this.f39513i = new ArrayList();
        }
        this.f39513i.clear();
        this.f39505a = -3.4028235E38f;
        this.f39506b = Float.MAX_VALUE;
        this.f39507c = -3.4028235E38f;
        this.f39508d = Float.MAX_VALUE;
        this.f39509e = -3.4028235E38f;
        this.f39510f = Float.MAX_VALUE;
        this.f39511g = -3.4028235E38f;
        this.f39512h = Float.MAX_VALUE;
        for (c cVar : Q()) {
            cVar.d();
            this.f39513i.addAll((Collection<? extends T>) cVar.q());
            if (cVar.z() > this.f39505a) {
                this.f39505a = cVar.z();
            }
            if (cVar.B() < this.f39506b) {
                this.f39506b = cVar.B();
            }
            if (cVar.x() > this.f39507c) {
                this.f39507c = cVar.x();
            }
            if (cVar.y() < this.f39508d) {
                this.f39508d = cVar.y();
            }
            float f10 = cVar.f39509e;
            if (f10 > this.f39509e) {
                this.f39509e = f10;
            }
            float f11 = cVar.f39510f;
            if (f11 < this.f39510f) {
                this.f39510f = f11;
            }
            float f12 = cVar.f39511g;
            if (f12 > this.f39511g) {
                this.f39511g = f12;
            }
            float f13 = cVar.f39512h;
            if (f13 < this.f39512h) {
                this.f39512h = f13;
            }
        }
    }

    public void d0(m mVar) {
        this.f39514j = mVar;
        E();
    }

    public void e0(s sVar) {
        this.f39516l = sVar;
        E();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [qa.e] */
    @Override // la.k
    public Entry s(oa.d dVar) {
        if (dVar.c() >= Q().size()) {
            return null;
        }
        c cVarU = U(dVar.c());
        if (dVar.d() >= cVarU.m()) {
            return null;
        }
        for (Entry entry : cVarU.k(dVar.d()).J0(dVar.h())) {
            if (entry.e() == dVar.j() || Float.isNaN(dVar.j())) {
                return entry;
            }
        }
        return null;
    }
}
