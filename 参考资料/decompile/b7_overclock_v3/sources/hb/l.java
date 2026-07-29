package hb;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface l extends ed.h {
    int b(int i10) throws IOException;

    boolean e(byte[] bArr, int i10, int i11, boolean z10) throws IOException;

    boolean g(int i10, boolean z10) throws IOException;

    long getLength();

    long getPosition();

    boolean h(byte[] bArr, int i10, int i11, boolean z10) throws IOException;

    long i();

    void j(int i10) throws IOException;

    <E extends Throwable> void l(long j10, E e10) throws Throwable;

    int m(byte[] bArr, int i10, int i11) throws IOException;

    void n();

    void o(int i10) throws IOException;

    boolean q(int i10, boolean z10) throws IOException;

    @Override // ed.h
    int read(byte[] bArr, int i10, int i11) throws IOException;

    void readFully(byte[] bArr, int i10, int i11) throws IOException;

    void t(byte[] bArr, int i10, int i11) throws IOException;
}
