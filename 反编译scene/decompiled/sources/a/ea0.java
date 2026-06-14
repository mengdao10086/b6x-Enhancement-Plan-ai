package a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.data.GlobalStatus$updateBatteryTemperature$t$1", f = "GlobalStatus.kt", l = {91}, m = "invokeSuspend")
public final class ea0 extends d72 implements k82<wd2, b62<? super Double>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j92 f5982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f712a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ea0(j92 j92Var, b62 b62Var) {
        super(2, b62Var);
        this.f5982a = j92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ea0 ea0Var = new ea0(this.f5982a, b62Var);
        ea0Var.f711a = (wd2) obj;
        return ea0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super Double> b62Var) {
        return ((ea0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f711a;
            e50 e50Var = e50.f677a;
            Double dC = t62.c(this.f5982a.f6490a);
            this.f712a = wd2Var;
            this.b = 1;
            obj = e50Var.u0("battery", dC, this);
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
