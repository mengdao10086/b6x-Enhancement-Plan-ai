package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.i0;
import g.i1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<g> f7027a = new a();

    public static class a implements Comparator<g> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            int i10 = gVar.f7050a - gVar2.f7050a;
            return i10 == 0 ? gVar.f7051b - gVar2.f7051b : i10;
        }
    }

    public static abstract class b {
        public abstract boolean areContentsTheSame(int i10, int i11);

        public abstract boolean areItemsTheSame(int i10, int i11);

        @p0
        public Object getChangePayload(int i10, int i11) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f7028h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f7029i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f7030j = 2;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f7031k = 4;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f7032l = 8;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f7033m = 16;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f7034n = 5;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f7035o = 31;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<g> f7036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f7037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f7038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f7039d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7040e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7041f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f7042g;

        public c(b bVar, List<g> list, int[] iArr, int[] iArr2, boolean z10) {
            this.f7036a = list;
            this.f7037b = iArr;
            this.f7038c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f7039d = bVar;
            this.f7040e = bVar.getOldListSize();
            this.f7041f = bVar.getNewListSize();
            this.f7042g = z10;
            a();
            j();
        }

        public static e m(List<e> list, int i10, boolean z10) {
            int size = list.size() - 1;
            while (size >= 0) {
                e eVar = list.get(size);
                if (eVar.f7043a == i10 && eVar.f7045c == z10) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f7044b += z10 ? 1 : -1;
                        size++;
                    }
                    return eVar;
                }
                size--;
            }
            return null;
        }

        public final void a() {
            g gVar = this.f7036a.isEmpty() ? null : this.f7036a.get(0);
            if (gVar != null && gVar.f7050a == 0 && gVar.f7051b == 0) {
                return;
            }
            g gVar2 = new g();
            gVar2.f7050a = 0;
            gVar2.f7051b = 0;
            gVar2.f7053d = false;
            gVar2.f7052c = 0;
            gVar2.f7054e = false;
            this.f7036a.add(0, gVar2);
        }

        public int b(@g.f0(from = 0) int i10) {
            if (i10 >= 0 && i10 < this.f7041f) {
                int i11 = this.f7038c[i10];
                if ((i11 & 31) == 0) {
                    return -1;
                }
                return i11 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i10 + ", new list size = " + this.f7041f);
        }

        public int c(@g.f0(from = 0) int i10) {
            if (i10 >= 0 && i10 < this.f7040e) {
                int i11 = this.f7037b[i10];
                if ((i11 & 31) == 0) {
                    return -1;
                }
                return i11 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i10 + ", old list size = " + this.f7040e);
        }

        public final void d(List<e> list, t tVar, int i10, int i11, int i12) {
            if (!this.f7042g) {
                tVar.onInserted(i10, i11);
                return;
            }
            for (int i13 = i11 - 1; i13 >= 0; i13--) {
                int[] iArr = this.f7038c;
                int i14 = i12 + i13;
                int i15 = iArr[i14] & 31;
                if (i15 == 0) {
                    tVar.onInserted(i10, 1);
                    Iterator<e> it2 = list.iterator();
                    while (it2.hasNext()) {
                        it2.next().f7044b++;
                    }
                } else if (i15 == 4 || i15 == 8) {
                    int i16 = iArr[i14] >> 5;
                    tVar.onMoved(m(list, i16, true).f7044b, i10);
                    if (i15 == 4) {
                        tVar.onChanged(i10, 1, this.f7039d.getChangePayload(i16, i14));
                    }
                } else {
                    if (i15 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i14 + i0.f11861z + Long.toBinaryString(i15));
                    }
                    list.add(new e(i14, i10, false));
                }
            }
        }

        public final void e(List<e> list, t tVar, int i10, int i11, int i12) {
            if (!this.f7042g) {
                tVar.onRemoved(i10, i11);
                return;
            }
            for (int i13 = i11 - 1; i13 >= 0; i13--) {
                int[] iArr = this.f7037b;
                int i14 = i12 + i13;
                int i15 = iArr[i14] & 31;
                if (i15 == 0) {
                    tVar.onRemoved(i10 + i13, 1);
                    Iterator<e> it2 = list.iterator();
                    while (it2.hasNext()) {
                        it2.next().f7044b--;
                    }
                } else if (i15 == 4 || i15 == 8) {
                    int i16 = iArr[i14] >> 5;
                    e eVarM = m(list, i16, false);
                    tVar.onMoved(i10 + i13, eVarM.f7044b - 1);
                    if (i15 == 4) {
                        tVar.onChanged(eVarM.f7044b - 1, 1, this.f7039d.getChangePayload(i14, i16));
                    }
                } else {
                    if (i15 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i14 + i0.f11861z + Long.toBinaryString(i15));
                    }
                    list.add(new e(i14, i10 + i13, true));
                }
            }
        }

        public void f(@n0 t tVar) {
            androidx.recyclerview.widget.f fVar = tVar instanceof androidx.recyclerview.widget.f ? (androidx.recyclerview.widget.f) tVar : new androidx.recyclerview.widget.f(tVar);
            List<e> arrayList = new ArrayList<>();
            int i10 = this.f7040e;
            int i11 = this.f7041f;
            for (int size = this.f7036a.size() - 1; size >= 0; size--) {
                g gVar = this.f7036a.get(size);
                int i12 = gVar.f7052c;
                int i13 = gVar.f7050a + i12;
                int i14 = gVar.f7051b + i12;
                if (i13 < i10) {
                    e(arrayList, fVar, i13, i10 - i13, i13);
                }
                if (i14 < i11) {
                    d(arrayList, fVar, i13, i11 - i14, i14);
                }
                for (int i15 = i12 - 1; i15 >= 0; i15--) {
                    int[] iArr = this.f7037b;
                    int i16 = gVar.f7050a;
                    if ((iArr[i16 + i15] & 31) == 2) {
                        fVar.onChanged(i16 + i15, 1, this.f7039d.getChangePayload(i16 + i15, gVar.f7051b + i15));
                    }
                }
                i10 = gVar.f7050a;
                i11 = gVar.f7051b;
            }
            fVar.a();
        }

        public void g(@n0 RecyclerView.g gVar) {
            f(new androidx.recyclerview.widget.b(gVar));
        }

        public final void h(int i10, int i11, int i12) {
            if (this.f7037b[i10 - 1] != 0) {
                return;
            }
            i(i10, i11, i12, false);
        }

        public final boolean i(int i10, int i11, int i12, boolean z10) {
            int i13;
            int i14;
            int i15;
            if (z10) {
                i11--;
                i14 = i10;
                i13 = i11;
            } else {
                i13 = i10 - 1;
                i14 = i13;
            }
            while (i12 >= 0) {
                g gVar = this.f7036a.get(i12);
                int i16 = gVar.f7050a;
                int i17 = gVar.f7052c;
                int i18 = i16 + i17;
                int i19 = gVar.f7051b + i17;
                if (z10) {
                    for (int i20 = i14 - 1; i20 >= i18; i20--) {
                        if (this.f7039d.areItemsTheSame(i20, i13)) {
                            i15 = this.f7039d.areContentsTheSame(i20, i13) ? 8 : 4;
                            this.f7038c[i13] = (i20 << 5) | 16;
                            this.f7037b[i20] = (i13 << 5) | i15;
                            return true;
                        }
                    }
                } else {
                    for (int i21 = i11 - 1; i21 >= i19; i21--) {
                        if (this.f7039d.areItemsTheSame(i13, i21)) {
                            i15 = this.f7039d.areContentsTheSame(i13, i21) ? 8 : 4;
                            int i22 = i10 - 1;
                            this.f7037b[i22] = (i21 << 5) | 16;
                            this.f7038c[i21] = (i22 << 5) | i15;
                            return true;
                        }
                    }
                }
                i14 = gVar.f7050a;
                i11 = gVar.f7051b;
                i12--;
            }
            return false;
        }

        public final void j() {
            int i10 = this.f7040e;
            int i11 = this.f7041f;
            for (int size = this.f7036a.size() - 1; size >= 0; size--) {
                g gVar = this.f7036a.get(size);
                int i12 = gVar.f7050a;
                int i13 = gVar.f7052c;
                int i14 = i12 + i13;
                int i15 = gVar.f7051b + i13;
                if (this.f7042g) {
                    while (i10 > i14) {
                        h(i10, i11, size);
                        i10--;
                    }
                    while (i11 > i15) {
                        k(i10, i11, size);
                        i11--;
                    }
                }
                for (int i16 = 0; i16 < gVar.f7052c; i16++) {
                    int i17 = gVar.f7050a + i16;
                    int i18 = gVar.f7051b + i16;
                    int i19 = this.f7039d.areContentsTheSame(i17, i18) ? 1 : 2;
                    this.f7037b[i17] = (i18 << 5) | i19;
                    this.f7038c[i18] = (i17 << 5) | i19;
                }
                i10 = gVar.f7050a;
                i11 = gVar.f7051b;
            }
        }

        public final void k(int i10, int i11, int i12) {
            if (this.f7038c[i11 - 1] != 0) {
                return;
            }
            i(i10, i11, i12, true);
        }

        @i1
        public List<g> l() {
            return this.f7036a;
        }
    }

    public static abstract class d<T> {
        public abstract boolean a(@n0 T t10, @n0 T t11);

        public abstract boolean b(@n0 T t10, @n0 T t11);

        @p0
        public Object c(@n0 T t10, @n0 T t11) {
            return null;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7045c;

        public e(int i10, int i11, boolean z10) {
            this.f7043a = i10;
            this.f7044b = i11;
            this.f7045c = z10;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7049d;

        public f() {
        }

        public f(int i10, int i11, int i12, int i13) {
            this.f7046a = i10;
            this.f7047b = i11;
            this.f7048c = i12;
            this.f7049d = i13;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7054e;
    }

    @n0
    public static c a(@n0 b bVar) {
        return b(bVar, true);
    }

    @n0
    public static c b(@n0 b bVar, boolean z10) {
        int oldListSize = bVar.getOldListSize();
        int newListSize = bVar.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new f(0, oldListSize, 0, newListSize));
        int iAbs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i10 = iAbs * 2;
        int[] iArr = new int[i10];
        int[] iArr2 = new int[i10];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            f fVar = (f) arrayList2.remove(arrayList2.size() - 1);
            g gVarC = c(bVar, fVar.f7046a, fVar.f7047b, fVar.f7048c, fVar.f7049d, iArr, iArr2, iAbs);
            if (gVarC != null) {
                if (gVarC.f7052c > 0) {
                    arrayList.add(gVarC);
                }
                gVarC.f7050a += fVar.f7046a;
                gVarC.f7051b += fVar.f7048c;
                f fVar2 = arrayList3.isEmpty() ? new f() : (f) arrayList3.remove(arrayList3.size() - 1);
                fVar2.f7046a = fVar.f7046a;
                fVar2.f7048c = fVar.f7048c;
                if (gVarC.f7054e) {
                    fVar2.f7047b = gVarC.f7050a;
                    fVar2.f7049d = gVarC.f7051b;
                } else if (gVarC.f7053d) {
                    fVar2.f7047b = gVarC.f7050a - 1;
                    fVar2.f7049d = gVarC.f7051b;
                } else {
                    fVar2.f7047b = gVarC.f7050a;
                    fVar2.f7049d = gVarC.f7051b - 1;
                }
                arrayList2.add(fVar2);
                if (!gVarC.f7054e) {
                    int i11 = gVarC.f7050a;
                    int i12 = gVarC.f7052c;
                    fVar.f7046a = i11 + i12;
                    fVar.f7048c = gVarC.f7051b + i12;
                } else if (gVarC.f7053d) {
                    int i13 = gVarC.f7050a;
                    int i14 = gVarC.f7052c;
                    fVar.f7046a = i13 + i14 + 1;
                    fVar.f7048c = gVarC.f7051b + i14;
                } else {
                    int i15 = gVarC.f7050a;
                    int i16 = gVarC.f7052c;
                    fVar.f7046a = i15 + i16;
                    fVar.f7048c = gVarC.f7051b + i16 + 1;
                }
                arrayList2.add(fVar);
            } else {
                arrayList3.add(fVar);
            }
        }
        Collections.sort(arrayList, f7027a);
        return new c(bVar, arrayList, iArr, iArr2, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:52:0x00cd
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.recyclerview.widget.i.g c(androidx.recyclerview.widget.i.b r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i.c(androidx.recyclerview.widget.i$b, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.i$g");
    }
}
