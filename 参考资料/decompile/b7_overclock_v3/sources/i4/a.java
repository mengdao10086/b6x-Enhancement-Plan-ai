package i4;

import android.text.TextUtils;
import g.n0;
import g.p0;
import h4.h;
import h4.m;
import h4.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<Model> implements n<Model, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<h4.g, InputStream> f31822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final m<Model, h4.g> f31823b;

    public a(n<h4.g, InputStream> nVar) {
        this(nVar, null);
    }

    public static List<c4.b> c(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new h4.g(it2.next()));
        }
        return arrayList;
    }

    @Override // h4.n
    @p0
    public n.a<InputStream> a(@n0 Model model, int i10, int i11, @n0 c4.e eVar) {
        m<Model, h4.g> mVar = this.f31823b;
        h4.g gVarB = mVar != null ? mVar.b(model, i10, i11) : null;
        if (gVarB == null) {
            String strF = f(model, i10, i11, eVar);
            if (TextUtils.isEmpty(strF)) {
                return null;
            }
            h4.g gVar = new h4.g(strF, e(model, i10, i11, eVar));
            m<Model, h4.g> mVar2 = this.f31823b;
            if (mVar2 != null) {
                mVar2.c(model, i10, i11, gVar);
            }
            gVarB = gVar;
        }
        List<String> listD = d(model, i10, i11, eVar);
        n.a<InputStream> aVarA = this.f31822a.a(gVarB, i10, i11, eVar);
        return (aVarA == null || listD.isEmpty()) ? aVarA : new n.a<>(aVarA.f30486a, c(listD), aVarA.f30488c);
    }

    public List<String> d(Model model, int i10, int i11, c4.e eVar) {
        return Collections.emptyList();
    }

    @p0
    public h e(Model model, int i10, int i11, c4.e eVar) {
        return h.f30464b;
    }

    public abstract String f(Model model, int i10, int i11, c4.e eVar);

    public a(n<h4.g, InputStream> nVar, @p0 m<Model, h4.g> mVar) {
        this.f31822a = nVar;
        this.f31823b = mVar;
    }
}
