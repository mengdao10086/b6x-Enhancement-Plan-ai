package com.github.mikephil.charting.data;

import com.blankj.utilcode.util.i0;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import la.e;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DataSet<T extends Entry> extends e<T> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<T> f16633s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f16634t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f16635u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f16636v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f16637w;

    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.f16634t = -3.4028235E38f;
        this.f16635u = Float.MAX_VALUE;
        this.f16636v = -3.4028235E38f;
        this.f16637w = Float.MAX_VALUE;
        this.f16633s = list;
        if (list == null) {
            this.f16633s = new ArrayList();
        }
        K0();
    }

    @Override // qa.e
    public void F0(float f10, float f11) {
        List<T> list = this.f16633s;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f16634t = -3.4028235E38f;
        this.f16635u = Float.MAX_VALUE;
        int iQ0 = q0(f11, Float.NaN, Rounding.UP);
        for (int iQ02 = q0(f10, Float.NaN, Rounding.DOWN); iQ02 <= iQ0; iQ02++) {
            M1(this.f16633s.get(iQ02));
        }
    }

    @Override // qa.e
    public List<T> J0(float f10) {
        ArrayList arrayList = new ArrayList();
        int size = this.f16633s.size() - 1;
        int i10 = 0;
        while (true) {
            if (i10 > size) {
                break;
            }
            int i11 = (size + i10) / 2;
            T t10 = this.f16633s.get(i11);
            if (f10 == t10.F()) {
                while (i11 > 0 && this.f16633s.get(i11 - 1).F() == f10) {
                    i11--;
                }
                int size2 = this.f16633s.size();
                while (i11 < size2) {
                    T t11 = this.f16633s.get(i11);
                    if (t11.F() != f10) {
                        break;
                    }
                    arrayList.add(t11);
                    i11++;
                }
            } else if (f10 > t10.F()) {
                i10 = i11 + 1;
            } else {
                size = i11 - 1;
            }
        }
        return arrayList;
    }

    @Override // qa.e
    public void K0() {
        List<T> list = this.f16633s;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f16634t = -3.4028235E38f;
        this.f16635u = Float.MAX_VALUE;
        this.f16636v = -3.4028235E38f;
        this.f16637w = Float.MAX_VALUE;
        Iterator<T> it2 = this.f16633s.iterator();
        while (it2.hasNext()) {
            K1(it2.next());
        }
    }

    public void K1(T t10) {
        if (t10 == null) {
            return;
        }
        L1(t10);
        M1(t10);
    }

    @Override // qa.e
    public float L() {
        return this.f16635u;
    }

    public void L1(T t10) {
        if (t10.F() < this.f16637w) {
            this.f16637w = t10.F();
        }
        if (t10.F() > this.f16636v) {
            this.f16636v = t10.F();
        }
    }

    public void M1(T t10) {
        if (t10.e() < this.f16635u) {
            this.f16635u = t10.e();
        }
        if (t10.e() > this.f16634t) {
            this.f16634t = t10.e();
        }
    }

    public abstract DataSet<T> N1();

    public void O1(DataSet dataSet) {
        super.u1(dataSet);
    }

    public List<T> P1() {
        return this.f16633s;
    }

    public void Q1(List<T> list) {
        this.f16633s = list;
        w1();
    }

    @Override // qa.e
    public float R0() {
        return this.f16636v;
    }

    public String R1() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DataSet, label: ");
        sb2.append(J() == null ? "" : J());
        sb2.append(", entries: ");
        sb2.append(this.f16633s.size());
        sb2.append("\n");
        stringBuffer.append(sb2.toString());
        return stringBuffer.toString();
    }

    @Override // qa.e
    public T Z(int i10) {
        return this.f16633s.get(i10);
    }

    @Override // qa.e
    public void clear() {
        this.f16633s.clear();
        w1();
    }

    @Override // qa.e
    public int e1() {
        return this.f16633s.size();
    }

    @Override // qa.e
    public void l1(T t10) {
        if (t10 == null) {
            return;
        }
        if (this.f16633s == null) {
            this.f16633s = new ArrayList();
        }
        K1(t10);
        if (this.f16633s.size() > 0) {
            if (this.f16633s.get(r0.size() - 1).F() > t10.F()) {
                this.f16633s.add(q0(t10.F(), t10.e(), Rounding.UP), t10);
                return;
            }
        }
        this.f16633s.add(t10);
    }

    @Override // qa.e
    public float o() {
        return this.f16637w;
    }

    @Override // qa.e
    public boolean p0(T t10) {
        List<T> list;
        if (t10 == null || (list = this.f16633s) == null) {
            return false;
        }
        boolean zRemove = list.remove(t10);
        if (zRemove) {
            K0();
        }
        return zRemove;
    }

    @Override // qa.e
    public float q() {
        return this.f16634t;
    }

    @Override // qa.e
    public int q0(float f10, float f11, Rounding rounding) {
        int i10;
        T t10;
        List<T> list = this.f16633s;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i11 = 0;
        int size = this.f16633s.size() - 1;
        while (i11 < size) {
            int i12 = (i11 + size) / 2;
            float F = this.f16633s.get(i12).F() - f10;
            int i13 = i12 + 1;
            float F2 = this.f16633s.get(i13).F() - f10;
            float fAbs = Math.abs(F);
            float fAbs2 = Math.abs(F2);
            if (fAbs2 >= fAbs) {
                if (fAbs >= fAbs2) {
                    double d10 = F;
                    if (d10 < 0.0d) {
                        if (d10 < 0.0d) {
                        }
                    }
                }
                size = i12;
            }
            i11 = i13;
        }
        if (size == -1) {
            return size;
        }
        float F3 = this.f16633s.get(size).F();
        if (rounding == Rounding.UP) {
            if (F3 < f10 && size < this.f16633s.size() - 1) {
                size++;
            }
        } else if (rounding == Rounding.DOWN && F3 > f10 && size > 0) {
            size--;
        }
        if (Float.isNaN(f11)) {
            return size;
        }
        while (size > 0 && this.f16633s.get(size - 1).F() == F3) {
            size--;
        }
        float fE = this.f16633s.get(size).e();
        loop2: while (true) {
            i10 = size;
            do {
                size++;
                if (size >= this.f16633s.size()) {
                    break loop2;
                }
                t10 = this.f16633s.get(size);
                if (t10.F() != F3) {
                    break loop2;
                }
            } while (Math.abs(t10.e() - f11) >= Math.abs(fE - f11));
            fE = f11;
        }
        return i10;
    }

    @Override // qa.e
    public int t(Entry entry) {
        return this.f16633s.indexOf(entry);
    }

    @Override // qa.e
    public boolean t0(T t10) {
        if (t10 == null) {
            return false;
        }
        List<T> listP1 = P1();
        if (listP1 == null) {
            listP1 = new ArrayList<>();
        }
        K1(t10);
        return listP1.add(t10);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(R1());
        for (int i10 = 0; i10 < this.f16633s.size(); i10++) {
            stringBuffer.append(this.f16633s.get(i10).toString() + i0.f11861z);
        }
        return stringBuffer.toString();
    }

    @Override // qa.e
    public T u0(float f10, float f11, Rounding rounding) {
        int iQ0 = q0(f10, f11, rounding);
        if (iQ0 > -1) {
            return this.f16633s.get(iQ0);
        }
        return null;
    }

    @Override // qa.e
    public T y(float f10, float f11) {
        return (T) u0(f10, f11, Rounding.CLOSEST);
    }
}
