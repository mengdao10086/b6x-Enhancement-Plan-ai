package it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class h extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<g> f35856b;

    public h(g gVar) {
        this.f35856b = Collections.singletonList(gVar);
    }

    public h(List<g> list) {
        ArrayList arrayList = new ArrayList(list.size());
        this.f35856b = arrayList;
        arrayList.addAll(list);
    }

    public h(g... gVarArr) {
        ArrayList arrayList = new ArrayList(gVarArr.length);
        this.f35856b = arrayList;
        arrayList.addAll(Arrays.asList(gVarArr));
    }

    @Override // it.f
    public byte[] b(cs.o oVar) {
        List<byte[]> listC = c(oVar);
        return listC.size() > 1 ? o.f(oVar, listC.iterator()) : listC.get(0);
    }

    public List<byte[]> c(cs.o oVar) {
        return o.a(oVar, this.f35856b);
    }

    public int d() {
        return this.f35856b.size();
    }
}
