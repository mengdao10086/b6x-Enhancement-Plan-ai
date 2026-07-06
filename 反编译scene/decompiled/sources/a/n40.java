package a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$socketApiSync$r$1", f = "Daemon.kt", l = {434}, m = "invokeSuspend")
public final class n40 extends d72 implements k82<wd2, b62<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Long f2001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2003a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ String f2004b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n40(String str, String str2, Long l, b62 b62Var) {
        super(2, b62Var);
        this.f2003a = str;
        this.f2004b = str2;
        this.f2001a = l;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        n40 n40Var = new n40(this.f2003a, this.f2004b, this.f2001a, b62Var);
        n40Var.f6872a = (wd2) obj;
        return n40Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super String> b62Var) {
        return ((n40) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f6872a;
            e50 e50Var = e50.f677a;
            String str = this.f2003a;
            String str2 = this.f2004b;
            Long l = this.f2001a;
            this.f2002a = wd2Var;
            this.b = 1;
            obj = e50Var.g1(str, str2, l, this);
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
