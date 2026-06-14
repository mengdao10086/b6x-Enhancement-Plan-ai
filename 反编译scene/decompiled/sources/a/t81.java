package a;

import a.p80;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.vtools.activities.ActivityAppXposedDetails;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t81 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f3002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppXposedDetails.i f3003a;

    public t81(ActivityAppXposedDetails.i iVar, EditText editText, n92 n92Var) {
        this.f3003a = iVar;
        this.f3002a = editText;
        this.f7476a = n92Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        EditText editText = this.f3002a;
        f92.c(editText, "inputDpi");
        String string = editText.getText().toString();
        if (string.length() == 0) {
            ActivityAppXposedDetails.this.t().f(0);
            return;
        }
        try {
            int i = Integer.parseInt(string);
            if (i < 96 && i != 0) {
                Toast.makeText(ActivityAppXposedDetails.this.getApplicationContext(), ActivityAppXposedDetails.this.getString(u61.xp_dpi_limit), 0).show();
                return;
            }
            ActivityAppXposedDetails.this.t().f(i);
            if (i == 0) {
                TextView textView = (TextView) ActivityAppXposedDetails.this._$_findCachedViewById(t61.app_details_dpi);
                f92.c(textView, "app_details_dpi");
                textView.setText(ActivityAppXposedDetails.this.getString(u61._default));
            } else {
                TextView textView2 = (TextView) ActivityAppXposedDetails.this._$_findCachedViewById(t61.app_details_dpi);
                f92.c(textView2, "app_details_dpi");
                textView2.setText(String.valueOf(i));
            }
            p80.b bVar = (p80.b) this.f7476a.f6891a;
            if (bVar != null) {
                bVar.c();
            }
        } catch (Exception unused) {
        }
    }
}
