package sc;

import hd.c0;
import java.util.List;
import qc.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends qc.d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f49588o;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        c0 c0Var = new c0(list.get(0));
        this.f49588o = new b(c0Var.M(), c0Var.M());
    }

    @Override // qc.d
    public f A(byte[] bArr, int i10, boolean z10) {
        if (z10) {
            this.f49588o.r();
        }
        return new c(this.f49588o.b(bArr, i10));
    }
}
