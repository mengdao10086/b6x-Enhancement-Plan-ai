package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;
import qa.i;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class PieDataSet extends DataSet<PieEntry> implements i {
    public ValuePosition A;
    public ValuePosition B;
    public boolean C;
    public int D;
    public float E;
    public float F;
    public float G;
    public float H;
    public boolean I;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f16639x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f16640y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f16641z;

    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    public PieDataSet(List<PieEntry> list, String str) {
        super(list, str);
        this.f16639x = 0.0f;
        this.f16641z = 18.0f;
        ValuePosition valuePosition = ValuePosition.INSIDE_SLICE;
        this.A = valuePosition;
        this.B = valuePosition;
        this.C = false;
        this.D = -16777216;
        this.E = 1.0f;
        this.F = 75.0f;
        this.G = 0.3f;
        this.H = 0.4f;
        this.I = true;
    }

    @Override // qa.i
    public boolean B0() {
        return this.I;
    }

    @Override // qa.i
    public float E0() {
        return this.H;
    }

    @Override // qa.i
    public boolean L0() {
        return this.C;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<PieEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f16633s.size(); i10++) {
            arrayList.add(((PieEntry) this.f16633s.get(i10)).z());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, J());
        T1(pieDataSet);
        return pieDataSet;
    }

    @Override // qa.i
    public float P0() {
        return this.f16641z;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public void K1(PieEntry pieEntry) {
        if (pieEntry == null) {
            return;
        }
        M1(pieEntry);
    }

    @Override // qa.i
    public float T0() {
        return this.F;
    }

    public void T1(PieDataSet pieDataSet) {
        super.O1(pieDataSet);
    }

    public void U1(boolean z10) {
        this.f16640y = z10;
    }

    public void V1(float f10) {
        this.f16641z = k.e(f10);
    }

    @Override // qa.i
    public boolean W() {
        return this.f16640y;
    }

    public void W1(float f10) {
        if (f10 > 20.0f) {
            f10 = 20.0f;
        }
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        this.f16639x = k.e(f10);
    }

    public void X1(boolean z10) {
        this.C = z10;
    }

    public void Y1(int i10) {
        this.D = i10;
    }

    public void Z1(float f10) {
        this.G = f10;
    }

    public void a2(float f10) {
        this.F = f10;
    }

    public void b2(float f10) {
        this.H = f10;
    }

    @Override // qa.i
    public int c0() {
        return this.D;
    }

    public void c2(boolean z10) {
        this.I = z10;
    }

    public void d2(float f10) {
        this.E = f10;
    }

    public void e2(ValuePosition valuePosition) {
        this.A = valuePosition;
    }

    public void f2(ValuePosition valuePosition) {
        this.B = valuePosition;
    }

    @Override // qa.i
    public float g0() {
        return this.E;
    }

    @Override // qa.i
    public float h0() {
        return this.G;
    }

    @Override // qa.i
    public float j() {
        return this.f16639x;
    }

    @Override // qa.i
    public ValuePosition j0() {
        return this.A;
    }

    @Override // qa.i
    public ValuePosition x0() {
        return this.B;
    }
}
