package a;

import a.p80;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vn1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jo1 f7710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f3293a;

    public vn1(jo1 jo1Var, p80.b bVar) {
        this.f7710a = jo1Var;
        this.f3293a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:1191634433@qq.com"));
            intent.putExtra("android.intent.extra.SUBJECT", "Scene(Paypal)");
            intent.putExtra("android.intent.extra.TEXT", "I have finished the payment, please send the activation to me as soon as possible.\nHere is my payment information:\nOrderID: XXXXXX\nTime: YYYY/MM/DD");
            this.f7710a.f1572a.startActivity(Intent.createChooser(intent, "Send payment information"));
        } catch (Exception unused) {
            p80.a.C(p80.f2403a, this.f7710a.f1572a, "Failed to launch the mail app on your phone, Please send email to helloklf@outlook.com in the following format\n\nI have finished the payment, please send the activation to me as soon as possible.\nHere is my payment information:\nOrderID: XXXXXX\nTime: YYYY/MM/DD", null, 4, null);
        }
        this.f3293a.c();
    }
}
