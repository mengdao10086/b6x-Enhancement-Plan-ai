package ap;

import np.l0;

/* JADX INFO: loaded from: classes5.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l0 f8816a;

    @Override // ap.b
    public void a(org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof l0)) {
            throw new IllegalArgumentException("ECPrivateKeyParameters are required for decryption.");
        }
        this.f8816a = (l0) kVar;
    }

    @Override // ap.b
    public ir.i b(i iVar) {
        l0 l0Var = this.f8816a;
        if (l0Var == null) {
            throw new IllegalStateException("ECElGamalDecryptor not initialised");
        }
        ir.e eVarA = l0Var.d().a();
        return ir.c.a(eVarA, iVar.c()).J(ir.c.a(eVarA, iVar.b()).z(this.f8816a.e())).B();
    }
}
