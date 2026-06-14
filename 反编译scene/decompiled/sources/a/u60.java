package a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.shell.KernelProp$getProp$1", f = "KernelProp.kt", l = {75}, m = "invokeSuspend")
public final class u60 extends d72 implements k82<wd2, b62<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3145a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u60(String str, b62 b62Var) {
        super(2, b62Var);
        this.f3145a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        u60 u60Var = new u60(this.f3145a, b62Var);
        u60Var.f7569a = (wd2) obj;
        return u60Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super String> b62Var) {
        return ((u60) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7569a;
            x60 x60Var = x60.f7856a;
            String str = this.f3145a;
            this.f3144a = wd2Var;
            this.b = 1;
            obj = x60Var.e(str, this);
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
