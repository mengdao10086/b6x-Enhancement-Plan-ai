package zc;

import hd.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements qc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f58430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f58431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f58432c;

    public k(List<e> list) {
        this.f58430a = Collections.unmodifiableList(new ArrayList(list));
        this.f58431b = new long[list.size() * 2];
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = list.get(i10);
            int i11 = i10 * 2;
            long[] jArr = this.f58431b;
            jArr[i11] = eVar.f58369b;
            jArr[i11 + 1] = eVar.f58370c;
        }
        long[] jArr2 = this.f58431b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f58432c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    public static /* synthetic */ int b(e eVar, e eVar2) {
        return Long.compare(eVar.f58369b, eVar2.f58369b);
    }

    @Override // qc.f
    public int c(long j10) {
        int iF = u0.f(this.f58432c, j10, false, false);
        if (iF < this.f58432c.length) {
            return iF;
        }
        return -1;
    }

    @Override // qc.f
    public long d(int i10) {
        hd.a.a(i10 >= 0);
        hd.a.a(i10 < this.f58432c.length);
        return this.f58432c[i10];
    }

    @Override // qc.f
    public List<qc.b> e(long j10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < this.f58430a.size(); i10++) {
            long[] jArr = this.f58431b;
            int i11 = i10 * 2;
            if (jArr[i11] <= j10 && j10 < jArr[i11 + 1]) {
                e eVar = this.f58430a.get(i10);
                qc.b bVar = eVar.f58368a;
                if (bVar.f47235d == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: zc.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return k.b((e) obj, (e) obj2);
            }
        });
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            arrayList.add(((e) arrayList2.get(i12)).f58368a.a().t((-1) - i12, 1).a());
        }
        return arrayList;
    }

    @Override // qc.f
    public int f() {
        return this.f58432c.length;
    }
}
