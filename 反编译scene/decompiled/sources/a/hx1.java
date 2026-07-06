package a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitor$getRamText$kMemInfo$1", f = "FloatMonitor.kt", l = {227}, m = "invokeSuspend")
public final class hx1 extends d72 implements k82<wd2, b62<? super vl0>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ox1 f6352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1264a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hx1(ox1 ox1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6352a = ox1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        hx1 hx1Var = new hx1(this.f6352a, b62Var);
        hx1Var.f1263a = (wd2) obj;
        return hx1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super vl0> b62Var) {
        return ((hx1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1263a;
            xl0 xl0Var = this.f6352a.f2319a;
            this.f1264a = wd2Var;
            this.b = 1;
            obj = xl0Var.b(this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return obj;
    }
}
