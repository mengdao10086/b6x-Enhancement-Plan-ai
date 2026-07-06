package a;

import a.p80;
import com.omarea.Scene;
import com.omarea.model.AccountPoints;
import com.omarea.model.AccountPointsResponse;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$accountInfo$1$1", f = "FragmentUser.kt", l = {}, m = "invokeSuspend")
public final class nv1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6953a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ov1 f2156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2157a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nv1(ov1 ov1Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f2156a = ov1Var;
        this.f6953a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        nv1 nv1Var = new nv1(this.f2156a, this.f6953a, b62Var);
        nv1Var.f2157a = (wd2) obj;
        return nv1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((nv1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        String str;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f2156a.f7059a.S1().c();
        if (!this.f2156a.f7059a.R()) {
            if (((AccountPointsResponse) this.f6953a.f6891a) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f2156a.f7059a.J(u61.user_points_total) + ((AccountPointsResponse) this.f6953a.f6891a).getTotal() + '\n');
                sb.append(this.f2156a.f7059a.J(u61.user_points_used) + ((AccountPointsResponse) this.f6953a.f6891a).getConsume() + '\n');
                sb.append(this.f2156a.f7059a.J(u61.user_points_free) + ((AccountPointsResponse) this.f6953a.f6891a).getFree() + "\n\n");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f2156a.f7059a.J(u61.user_points_detail));
                sb2.append("\n");
                sb.append(sb2.toString());
                for (AccountPoints accountPoints : ((AccountPointsResponse) this.f6953a.f6891a).getRecords()) {
                    sb.append(accountPoints.getRemark());
                    sb.append("\t\t");
                    sb.append(accountPoints.getIntegral() > 0 ? "+" + accountPoints.getIntegral() : String.valueOf(accountPoints.getIntegral()));
                    sb.append("\t\t");
                    String strO1 = bx1.O1(this.f2156a.f7059a, accountPoints.getTime(), null, 2, null);
                    if (strO1 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String strSubstring = strO1.substring(0, 10);
                    f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(strSubstring);
                    String[] strArr = {accountPoints.getSerial_id(), accountPoints.getSerial_no(), accountPoints.getDevice_id()};
                    int i = 0;
                    while (true) {
                        if (i >= 3) {
                            str = null;
                            break;
                        }
                        str = strArr[i];
                        if (t62.a(!(str == null || str.length() == 0)).booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    if (str != null) {
                        sb.append("    ");
                        sb.append(str);
                        sb.append("");
                    }
                    sb.append("\n");
                }
                p80.a aVar = p80.f2403a;
                cl clVarJ = this.f2156a.f7059a.j();
                f92.b(clVarJ);
                f92.c(clVarJ, "activity!!");
                String strJ = this.f2156a.f7059a.J(u61.user_current_account);
                f92.c(strJ, "getString(R.string.user_current_account)");
                String string = sb.toString();
                f92.c(string, "str.toString()");
                String strJ2 = this.f2156a.f7059a.J(2131886519);
                f92.c(strJ2, "getString(R.string.btn_confirm)");
                q80 q80Var = new q80(strJ2, new lv1(), false, 4, null);
                String strJ3 = this.f2156a.f7059a.J(u61.user_log_out);
                f92.c(strJ3, "getString(R.string.user_log_out)");
                aVar.h(clVarJ, strJ, string, q80Var, new q80(strJ3, new mv1(this), false, 4, null));
            } else {
                Scene.c cVar = Scene.f4798a;
                String strJ4 = this.f2156a.f7059a.J(u61.user_points_failure);
                f92.c(strJ4, "getString(R.string.user_points_failure)");
                Scene.c.p(cVar, strJ4, 0, 2, null);
            }
        }
        return m42.f6769a;
    }
}
