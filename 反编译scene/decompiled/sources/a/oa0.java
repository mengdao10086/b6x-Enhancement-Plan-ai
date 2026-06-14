package a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.data.customer.DaemonTransReceiver$onReceive$1", f = "DaemonTransReceiver.kt", l = {40}, m = "invokeSuspend")
public final class oa0 extends d72 implements g82<b62<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j50 f7000a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oa0(j50 j50Var, b62 b62Var) {
        super(1, b62Var);
        this.f7000a = j50Var;
    }

    @Override // a.g82
    public final Object f(b62<? super Boolean> b62Var) {
        return ((oa0) n(b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            e50 e50Var = e50.f677a;
            j50 j50Var = this.f7000a;
            this.b = 1;
            obj = e50Var.M0(j50Var, "", this);
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

    public final b62<m42> n(b62<?> b62Var) {
        f92.d(b62Var, "completion");
        return new oa0(this.f7000a, b62Var);
    }
}
