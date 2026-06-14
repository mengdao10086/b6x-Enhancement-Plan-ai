package a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.shell.KernelProp$getPropsSync$1", f = "KernelProp.kt", l = {64}, m = "invokeSuspend")
public final class w60 extends d72 implements k82<wd2, b62<? super String[]>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String[] f3402a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w60(String[] strArr, b62 b62Var) {
        super(2, b62Var);
        this.f3402a = strArr;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        w60 w60Var = new w60(this.f3402a, b62Var);
        w60Var.f7760a = (wd2) obj;
        return w60Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super String[]> b62Var) {
        return ((w60) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7760a;
            e50 e50Var = e50.f677a;
            String[] strArr = this.f3402a;
            this.f3401a = wd2Var;
            this.b = 1;
            obj = e50Var.p0(strArr, this);
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
