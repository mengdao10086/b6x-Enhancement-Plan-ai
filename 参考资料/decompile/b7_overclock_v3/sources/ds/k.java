package ds;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes6.dex */
public class k implements cs.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f26495a = j.f26492b;

    public class a implements cs.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f26496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f26497b;

        public a(zn.b bVar, b bVar2) {
            this.f26496a = bVar;
            this.f26497b = bVar2;
        }

        @Override // cs.o
        public zn.b a() {
            return this.f26496a;
        }

        @Override // cs.o
        public OutputStream b() {
            return this.f26497b;
        }

        @Override // cs.o
        public byte[] c() {
            return this.f26497b.a();
        }
    }

    public class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public org.bouncycastle.crypto.s f26499a;

        public b(org.bouncycastle.crypto.s sVar) {
            this.f26499a = sVar;
        }

        public byte[] a() {
            byte[] bArr = new byte[this.f26499a.h()];
            this.f26499a.c(bArr, 0);
            return bArr;
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f26499a.update((byte) i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f26499a.update(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f26499a.update(bArr, i10, i11);
        }
    }

    @Override // cs.p
    public cs.o a(zn.b bVar) throws OperatorCreationException {
        return new a(bVar, new b(this.f26495a.a(bVar)));
    }
}
