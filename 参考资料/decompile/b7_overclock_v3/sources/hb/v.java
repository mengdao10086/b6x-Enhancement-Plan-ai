package hb;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class v implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f30919b;

    public v(l lVar) {
        this.f30919b = lVar;
    }

    @Override // hb.l
    public int b(int i10) throws IOException {
        return this.f30919b.b(i10);
    }

    @Override // hb.l
    public boolean e(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        return this.f30919b.e(bArr, i10, i11, z10);
    }

    @Override // hb.l
    public boolean g(int i10, boolean z10) throws IOException {
        return this.f30919b.g(i10, z10);
    }

    @Override // hb.l
    public long getLength() {
        return this.f30919b.getLength();
    }

    @Override // hb.l
    public long getPosition() {
        return this.f30919b.getPosition();
    }

    @Override // hb.l
    public boolean h(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        return this.f30919b.h(bArr, i10, i11, z10);
    }

    @Override // hb.l
    public long i() {
        return this.f30919b.i();
    }

    @Override // hb.l
    public void j(int i10) throws IOException {
        this.f30919b.j(i10);
    }

    @Override // hb.l
    public <E extends Throwable> void l(long j10, E e10) throws Throwable {
        this.f30919b.l(j10, e10);
    }

    @Override // hb.l
    public int m(byte[] bArr, int i10, int i11) throws IOException {
        return this.f30919b.m(bArr, i10, i11);
    }

    @Override // hb.l
    public void n() {
        this.f30919b.n();
    }

    @Override // hb.l
    public void o(int i10) throws IOException {
        this.f30919b.o(i10);
    }

    @Override // hb.l
    public boolean q(int i10, boolean z10) throws IOException {
        return this.f30919b.q(i10, z10);
    }

    @Override // hb.l, ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.f30919b.read(bArr, i10, i11);
    }

    @Override // hb.l
    public void readFully(byte[] bArr, int i10, int i11) throws IOException {
        this.f30919b.readFully(bArr, i10, i11);
    }

    @Override // hb.l
    public void t(byte[] bArr, int i10, int i11) throws IOException {
        this.f30919b.t(bArr, i10, i11);
    }
}
