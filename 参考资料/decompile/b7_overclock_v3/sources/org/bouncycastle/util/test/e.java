package org.bouncycastle.util.test;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class e implements pp.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecureRandom f46064a = new SecureRandom();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f46065b;

    public class a implements pp.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f46066a;

        public a(int i10) {
            this.f46066a = i10;
        }

        @Override // pp.d
        public byte[] a() {
            byte[] bArr = new byte[(this.f46066a + 7) / 8];
            e.this.f46064a.nextBytes(bArr);
            return bArr;
        }

        @Override // pp.d
        public boolean b() {
            return e.this.f46065b;
        }

        @Override // pp.d
        public int c() {
            return this.f46066a;
        }
    }

    public e(boolean z10) {
        this.f46065b = z10;
    }

    @Override // pp.e
    public pp.d get(int i10) {
        return new a(i10);
    }
}
