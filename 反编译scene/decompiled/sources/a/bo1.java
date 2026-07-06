package a;

import com.omarea.Scene;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogPaymentMethods$show$2$1$1", f = "DialogPaymentMethods.kt", l = {177}, m = "invokeSuspend")
public final class bo1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ co1 f5720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f288a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f289b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo1(co1 co1Var, b62 b62Var) {
        super(2, b62Var);
        this.f5720a = co1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        bo1 bo1Var = new bo1(this.f5720a, b62Var);
        bo1Var.f287a = (wd2) obj;
        return bo1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((bo1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.CharSequence, java.lang.String] */
    @Override // a.s62
    public final Object j(Object obj) throws ExecutionException, InterruptedException, TimeoutException {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f287a;
            n92 n92Var = new n92();
            String str = new mp0(this.f5720a.f5813a.f5922a.f1572a).I().get(3L, TimeUnit.SECONDS);
            n92Var.f6891a = str;
            if (str == 0 || str.length() == 0) {
                Scene.f4798a.o("请截图保存上方二维码，然后使用微信扫码（在扫一扫界面右下角从相册选择图片）", 1);
            } else {
                fg2 fg2VarC = qe2.c();
                ao1 ao1Var = new ao1(this, n92Var, null);
                this.f288a = wd2Var;
                this.f289b = n92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, ao1Var, this) == objC) {
                    return objC;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }
}
