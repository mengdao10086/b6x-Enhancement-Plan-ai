package a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatTemperature$supported$1$1", f = "FloatTemperature.kt", l = {187}, m = "invokeSuspend")
public final class a22 extends d72 implements k82<wd2, b62<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f27a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Map.Entry f28a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a22(Map.Entry entry, b62 b62Var) {
        super(2, b62Var);
        this.f28a = entry;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        a22 a22Var = new a22(this.f28a, b62Var);
        a22Var.f5563a = (wd2) obj;
        return a22Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super Boolean> b62Var) {
        return ((a22) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f5563a;
            e50 e50Var = e50.f677a;
            String str = (String) this.f28a.getKey();
            this.f27a = wd2Var;
            this.b = 1;
            obj = e50.v0(e50Var, str, null, this, 2, null);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return t62.a(((Number) obj).doubleValue() > ((double) (-1)));
    }
}
