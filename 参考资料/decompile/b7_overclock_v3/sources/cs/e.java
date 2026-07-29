package cs;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f25881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputStream f25882b;

    public e(f fVar) {
        this.f25881a = fVar;
        this.f25882b = new kt.a(fVar.b());
    }

    public e(f fVar, int i10) {
        this.f25881a = fVar;
        this.f25882b = new kt.a(fVar.b(), i10);
    }

    @Override // cs.f
    public zn.b a() {
        return this.f25881a.a();
    }

    @Override // cs.f
    public OutputStream b() {
        return this.f25882b;
    }

    @Override // cs.f
    public byte[] getSignature() {
        return this.f25881a.getSignature();
    }
}
