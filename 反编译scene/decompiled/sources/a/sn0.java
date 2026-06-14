package a;

import android.content.Context;
import com.omarea.Scene;
import com.omarea.model.ActivatedStateModel;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ll0 f7415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2907a;

    public sn0(Context context) {
        f92.d(context, "context");
        this.f2907a = context;
        this.f7415a = new rn0(Scene.f4798a.c(), "pro_key_expire_date");
    }

    public static /* synthetic */ Object b(sn0 sn0Var, pn0 pn0Var, b62 b62Var, int i, Object obj) {
        if ((i & 1) != 0) {
            pn0Var = null;
        }
        return sn0Var.a(pn0Var, b62Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0291 A[Catch: all -> 0x00ab, TryCatch #3 {all -> 0x00ab, blocks: (B:23:0x009e, B:108:0x0289, B:110:0x0291, B:112:0x0298, B:118:0x02ba, B:125:0x031e, B:140:0x0367, B:129:0x0338, B:132:0x0340, B:137:0x034a, B:138:0x035f), top: B:152:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022a A[Catch: all -> 0x00fb, TryCatch #2 {all -> 0x00fb, blocks: (B:36:0x00e9, B:43:0x0126, B:45:0x012c, B:47:0x0132, B:53:0x0156, B:54:0x0159, B:59:0x0165, B:61:0x0174, B:63:0x0187, B:70:0x01a8, B:72:0x01b1, B:74:0x01c4, B:77:0x01cc, B:85:0x01dc, B:87:0x01e6, B:91:0x01f0, B:92:0x022a, B:94:0x0236, B:96:0x023f, B:99:0x0249, B:101:0x0251, B:102:0x025e, B:104:0x0264, B:120:0x02e3, B:41:0x0100), top: B:150:0x00e9, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [a.pn0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [a.sn0] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v5, types: [a.pn0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [a.pn0, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(a.pn0 r18, a.b62<? super a.m42> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 909
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.sn0.a(a.pn0, a.b62):java.lang.Object");
    }

    public final ActivatedStateModel c(String str) {
        ActivatedStateModel activatedStateModel;
        String string;
        String str2;
        String string2 = this.f7415a.toString();
        if (ec2.C(string2, "success@", false, 2, null)) {
            try {
                int iM = ec2.M(string2, '@', 0, false, 6, null) + 1;
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = string2.substring(iM);
                f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
                long j = Long.parseLong(strSubstring);
                if (j < 1000000000000L) {
                    j *= (long) 1000;
                }
                String str3 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
                ActivatedStateModel activatedStateModel2 = new ActivatedStateModel();
                activatedStateModel2.setActivated(true);
                activatedStateModel2.setText(str + str3);
                return activatedStateModel2;
            } catch (Exception unused) {
                ActivatedStateModel activatedStateModel3 = new ActivatedStateModel();
                activatedStateModel3.setActivated(false);
                activatedStateModel3.setText(str + "??");
                return activatedStateModel3;
            }
        }
        if (f92.a(string2, "expired")) {
            hz0.f1282a.D0(null);
            hz0.f1282a.E0(null);
            activatedStateModel = new ActivatedStateModel();
            activatedStateModel.setActivated(false);
            string = this.f2907a.getString(u61.license_state_expired);
            str2 = "context.getString(R.string.license_state_expired)";
        } else if (f92.a(string2, "empty")) {
            activatedStateModel = new ActivatedStateModel();
            activatedStateModel.setActivated(false);
            string = this.f2907a.getString(u61.license_state_not_activated);
            str2 = "context.getString(R.stri…ense_state_not_activated)";
        } else if (f92.a(string2, "invalid") || f92.a(string2, "not-you")) {
            activatedStateModel = new ActivatedStateModel();
            activatedStateModel.setActivated(false);
            string = this.f2907a.getString(u61.license_state_invalid);
            str2 = "context.getString(R.string.license_state_invalid)";
        } else {
            activatedStateModel = new ActivatedStateModel();
            activatedStateModel.setActivated(false);
            string = this.f2907a.getString(u61.license_state_unknown);
            str2 = "context.getString(R.string.license_state_unknown)";
        }
        f92.c(string, str2);
        activatedStateModel.setText(string);
        return activatedStateModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.omarea.model.ActivatedStateModel d() {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.sn0.d():com.omarea.model.ActivatedStateModel");
    }
}
