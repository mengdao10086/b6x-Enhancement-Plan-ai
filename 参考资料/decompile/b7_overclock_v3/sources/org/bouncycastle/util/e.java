package org.bouncycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class e<T> implements s<T>, k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Collection<T> f46041a;

    public e(Collection<T> collection) {
        this.f46041a = new ArrayList(collection);
    }

    @Override // org.bouncycastle.util.s
    public Collection<T> a(q<T> qVar) {
        if (qVar == null) {
            return new ArrayList(this.f46041a);
        }
        ArrayList arrayList = new ArrayList();
        for (T t10 : this.f46041a) {
            if (qVar.M(t10)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @Override // org.bouncycastle.util.k, java.lang.Iterable
    public Iterator<T> iterator() {
        return a(null).iterator();
    }
}
