package io.reactivex.internal.util;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f35258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f35259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f35260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35261e;

    public h(int i10) {
        this.f35257a = i10;
    }

    public void a(Object obj) {
        if (this.f35260d == 0) {
            Object[] objArr = new Object[this.f35257a + 1];
            this.f35258b = objArr;
            this.f35259c = objArr;
            objArr[0] = obj;
            this.f35261e = 1;
            this.f35260d = 1;
            return;
        }
        int i10 = this.f35261e;
        int i11 = this.f35257a;
        if (i10 != i11) {
            this.f35259c[i10] = obj;
            this.f35261e = i10 + 1;
            this.f35260d++;
        } else {
            Object[] objArr2 = new Object[i11 + 1];
            objArr2[0] = obj;
            this.f35259c[i11] = objArr2;
            this.f35259c = objArr2;
            this.f35261e = 1;
            this.f35260d++;
        }
    }

    public Object[] b() {
        return this.f35258b;
    }

    public int c() {
        return this.f35260d;
    }

    public String toString() {
        int i10 = this.f35257a;
        int i11 = this.f35260d;
        ArrayList arrayList = new ArrayList(i11 + 1);
        Object[] objArrB = b();
        int i12 = 0;
        while (true) {
            int i13 = 0;
            while (i12 < i11) {
                arrayList.add(objArrB[i13]);
                i12++;
                i13++;
                if (i13 == i10) {
                    break;
                }
            }
            return arrayList.toString();
            objArrB = objArrB[i10];
        }
    }
}
