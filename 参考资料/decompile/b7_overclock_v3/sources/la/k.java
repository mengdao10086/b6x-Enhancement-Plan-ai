package la;

import android.graphics.Typeface;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qa.e;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k<T extends qa.e<? extends Entry>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f39505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f39506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f39507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f39508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f39509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f39510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f39511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f39512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<T> f39513i;

    public k() {
        this.f39505a = -3.4028235E38f;
        this.f39506b = Float.MAX_VALUE;
        this.f39507c = -3.4028235E38f;
        this.f39508d = Float.MAX_VALUE;
        this.f39509e = -3.4028235E38f;
        this.f39510f = Float.MAX_VALUE;
        this.f39511g = -3.4028235E38f;
        this.f39512h = Float.MAX_VALUE;
        this.f39513i = new ArrayList();
    }

    public float A(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f10 = this.f39509e;
            return f10 == -3.4028235E38f ? this.f39511g : f10;
        }
        float f11 = this.f39511g;
        return f11 == -3.4028235E38f ? this.f39509e : f11;
    }

    public float B() {
        return this.f39506b;
    }

    public float C(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f10 = this.f39510f;
            return f10 == Float.MAX_VALUE ? this.f39512h : f10;
        }
        float f11 = this.f39512h;
        return f11 == Float.MAX_VALUE ? this.f39510f : f11;
    }

    public boolean D() {
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            if (!it2.next().i1()) {
                return false;
            }
        }
        return true;
    }

    public void E() {
        d();
    }

    public boolean F(int i10) {
        if (i10 >= this.f39513i.size() || i10 < 0) {
            return false;
        }
        return G(this.f39513i.get(i10));
    }

    public boolean G(T t10) {
        if (t10 == null) {
            return false;
        }
        boolean zRemove = this.f39513i.remove(t10);
        if (zRemove) {
            d();
        }
        return zRemove;
    }

    public boolean H(float f10, int i10) {
        Entry entryY;
        if (i10 < this.f39513i.size() && (entryY = this.f39513i.get(i10).y(f10, Float.NaN)) != null) {
            return I(entryY, i10);
        }
        return false;
    }

    public boolean I(Entry entry, int i10) {
        T t10;
        if (entry == null || i10 >= this.f39513i.size() || (t10 = this.f39513i.get(i10)) == null) {
            return false;
        }
        boolean zP0 = t10.p0(entry);
        if (zP0) {
            d();
        }
        return zP0;
    }

    public void J(boolean z10) {
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            it2.next().c1(z10);
        }
    }

    public void K(boolean z10) {
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            it2.next().c(z10);
        }
    }

    public void L(na.l lVar) {
        if (lVar == null) {
            return;
        }
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            it2.next().I(lVar);
        }
    }

    public void M(int i10) {
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            it2.next().R(i10);
        }
    }

    public void N(List<Integer> list) {
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            it2.next().H0(list);
        }
    }

    public void O(float f10) {
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            it2.next().A0(f10);
        }
    }

    public void P(Typeface typeface) {
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            it2.next().E(typeface);
        }
    }

    public void a(T t10) {
        if (t10 == null) {
            return;
        }
        f(t10);
        this.f39513i.add(t10);
    }

    public void b(Entry entry, int i10) {
        if (this.f39513i.size() <= i10 || i10 < 0) {
            return;
        }
        T t10 = this.f39513i.get(i10);
        if (t10.t0(entry)) {
            e(entry, t10.a1());
        }
    }

    public final List<T> c(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            arrayList.add(t10);
        }
        return arrayList;
    }

    public void d() {
        List<T> list = this.f39513i;
        if (list == null) {
            return;
        }
        this.f39505a = -3.4028235E38f;
        this.f39506b = Float.MAX_VALUE;
        this.f39507c = -3.4028235E38f;
        this.f39508d = Float.MAX_VALUE;
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            f(it2.next());
        }
        this.f39509e = -3.4028235E38f;
        this.f39510f = Float.MAX_VALUE;
        this.f39511g = -3.4028235E38f;
        this.f39512h = Float.MAX_VALUE;
        qa.e eVarT = t(this.f39513i);
        if (eVarT != null) {
            this.f39509e = eVarT.q();
            this.f39510f = eVarT.L();
            for (T t10 : this.f39513i) {
                if (t10.a1() == YAxis.AxisDependency.LEFT) {
                    if (t10.L() < this.f39510f) {
                        this.f39510f = t10.L();
                    }
                    if (t10.q() > this.f39509e) {
                        this.f39509e = t10.q();
                    }
                }
            }
        }
        qa.e eVarU = u(this.f39513i);
        if (eVarU != null) {
            this.f39511g = eVarU.q();
            this.f39512h = eVarU.L();
            for (T t11 : this.f39513i) {
                if (t11.a1() == YAxis.AxisDependency.RIGHT) {
                    if (t11.L() < this.f39512h) {
                        this.f39512h = t11.L();
                    }
                    if (t11.q() > this.f39511g) {
                        this.f39511g = t11.q();
                    }
                }
            }
        }
    }

    public void e(Entry entry, YAxis.AxisDependency axisDependency) {
        if (this.f39505a < entry.e()) {
            this.f39505a = entry.e();
        }
        if (this.f39506b > entry.e()) {
            this.f39506b = entry.e();
        }
        if (this.f39507c < entry.F()) {
            this.f39507c = entry.F();
        }
        if (this.f39508d > entry.F()) {
            this.f39508d = entry.F();
        }
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            if (this.f39509e < entry.e()) {
                this.f39509e = entry.e();
            }
            if (this.f39510f > entry.e()) {
                this.f39510f = entry.e();
                return;
            }
            return;
        }
        if (this.f39511g < entry.e()) {
            this.f39511g = entry.e();
        }
        if (this.f39512h > entry.e()) {
            this.f39512h = entry.e();
        }
    }

    public void f(T t10) {
        if (this.f39505a < t10.q()) {
            this.f39505a = t10.q();
        }
        if (this.f39506b > t10.L()) {
            this.f39506b = t10.L();
        }
        if (this.f39507c < t10.R0()) {
            this.f39507c = t10.R0();
        }
        if (this.f39508d > t10.o()) {
            this.f39508d = t10.o();
        }
        if (t10.a1() == YAxis.AxisDependency.LEFT) {
            if (this.f39509e < t10.q()) {
                this.f39509e = t10.q();
            }
            if (this.f39510f > t10.L()) {
                this.f39510f = t10.L();
                return;
            }
            return;
        }
        if (this.f39511g < t10.q()) {
            this.f39511g = t10.q();
        }
        if (this.f39512h > t10.L()) {
            this.f39512h = t10.L();
        }
    }

    public void g(float f10, float f11) {
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            it2.next().F0(f10, f11);
        }
        d();
    }

    public void h() {
        List<T> list = this.f39513i;
        if (list != null) {
            list.clear();
        }
        E();
    }

    public boolean i(T t10) {
        Iterator<T> it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            if (it2.next().equals(t10)) {
                return true;
            }
        }
        return false;
    }

    public int[] j() {
        if (this.f39513i == null) {
            return null;
        }
        int size = 0;
        for (int i10 = 0; i10 < this.f39513i.size(); i10++) {
            size += this.f39513i.get(i10).C0().size();
        }
        int[] iArr = new int[size];
        int i11 = 0;
        for (int i12 = 0; i12 < this.f39513i.size(); i12++) {
            Iterator<Integer> it2 = this.f39513i.get(i12).C0().iterator();
            while (it2.hasNext()) {
                iArr[i11] = it2.next().intValue();
                i11++;
            }
        }
        return iArr;
    }

    public T k(int i10) {
        List<T> list = this.f39513i;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.f39513i.get(i10);
    }

    public T l(String str, boolean z10) {
        int iO = o(this.f39513i, str, z10);
        if (iO < 0 || iO >= this.f39513i.size()) {
            return null;
        }
        return this.f39513i.get(iO);
    }

    public int m() {
        List<T> list = this.f39513i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T n(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i10 = 0; i10 < this.f39513i.size(); i10++) {
            T t10 = this.f39513i.get(i10);
            for (int i11 = 0; i11 < t10.e1(); i11++) {
                if (entry.C(t10.y(entry.F(), entry.e()))) {
                    return t10;
                }
            }
        }
        return null;
    }

    public int o(List<T> list, String str, boolean z10) {
        int i10 = 0;
        if (z10) {
            while (i10 < list.size()) {
                if (str.equalsIgnoreCase(list.get(i10).J())) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        while (i10 < list.size()) {
            if (str.equals(list.get(i10).J())) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public String[] p() {
        String[] strArr = new String[this.f39513i.size()];
        for (int i10 = 0; i10 < this.f39513i.size(); i10++) {
            strArr[i10] = this.f39513i.get(i10).J();
        }
        return strArr;
    }

    public List<T> q() {
        return this.f39513i;
    }

    public int r() {
        Iterator<T> it2 = this.f39513i.iterator();
        int iE1 = 0;
        while (it2.hasNext()) {
            iE1 += it2.next().e1();
        }
        return iE1;
    }

    public Entry s(oa.d dVar) {
        if (dVar.d() >= this.f39513i.size()) {
            return null;
        }
        return this.f39513i.get(dVar.d()).y(dVar.h(), dVar.j());
    }

    public T t(List<T> list) {
        for (T t10 : list) {
            if (t10.a1() == YAxis.AxisDependency.LEFT) {
                return t10;
            }
        }
        return null;
    }

    public T u(List<T> list) {
        for (T t10 : list) {
            if (t10.a1() == YAxis.AxisDependency.RIGHT) {
                return t10;
            }
        }
        return null;
    }

    public int v(T t10) {
        return this.f39513i.indexOf(t10);
    }

    public T w() {
        List<T> list = this.f39513i;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t10 = this.f39513i.get(0);
        for (T t11 : this.f39513i) {
            if (t11.e1() > t10.e1()) {
                t10 = t11;
            }
        }
        return t10;
    }

    public float x() {
        return this.f39507c;
    }

    public float y() {
        return this.f39508d;
    }

    public float z() {
        return this.f39505a;
    }

    public k(T... tArr) {
        this.f39505a = -3.4028235E38f;
        this.f39506b = Float.MAX_VALUE;
        this.f39507c = -3.4028235E38f;
        this.f39508d = Float.MAX_VALUE;
        this.f39509e = -3.4028235E38f;
        this.f39510f = Float.MAX_VALUE;
        this.f39511g = -3.4028235E38f;
        this.f39512h = Float.MAX_VALUE;
        this.f39513i = c(tArr);
        E();
    }

    public k(List<T> list) {
        this.f39505a = -3.4028235E38f;
        this.f39506b = Float.MAX_VALUE;
        this.f39507c = -3.4028235E38f;
        this.f39508d = Float.MAX_VALUE;
        this.f39509e = -3.4028235E38f;
        this.f39510f = Float.MAX_VALUE;
        this.f39511g = -3.4028235E38f;
        this.f39512h = Float.MAX_VALUE;
        this.f39513i = list;
        E();
    }
}
