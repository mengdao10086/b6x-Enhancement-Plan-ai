package a;

import a.p80;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class on1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f7040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ln1 f2271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f2272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f2273a;

    public on1(TextView textView, l92 l92Var, ln1 ln1Var, n92 n92Var) {
        this.f2273a = textView;
        this.f7040a = l92Var;
        this.f2271a = ln1Var;
        this.f2272a = n92Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = this.f2273a;
        f92.c(textView, "value");
        String string = textView.getText().toString();
        if ((!f92.a(string, String.valueOf(this.f7040a.f6687a))) && new nb2("^[-0-9]{1,10}").f(string)) {
            try {
                TextView textView2 = this.f2273a;
                f92.c(textView2, "value");
                int i = Integer.parseInt(textView2.getText().toString());
                if (i >= this.f2271a.a() && i <= this.f2271a.c()) {
                    this.f7040a.f6687a = i;
                }
            } catch (Exception unused) {
            }
        }
        if (!f92.a(string, String.valueOf(this.f7040a.f6687a))) {
            TextView textView3 = this.f2273a;
            f92.c(textView3, "value");
            textView3.setText(String.valueOf(this.f7040a.f6687a));
        } else {
            this.f2271a.b(this.f7040a.f6687a);
            p80.b bVar = (p80.b) this.f2272a.f6891a;
            if (bVar != null) {
                bVar.c();
            }
        }
    }
}
