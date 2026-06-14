package a;

import android.content.Context;
import android.text.SpannableString;
import android.widget.Toast;
import com.omarea.krscript.model.ShellHandlerBase;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ib0 extends ShellHandlerBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<String> f1349a;

    public ib0(Context context) {
        f92.d(context, "context");
        this.f6393a = context;
        this.f1349a = new ArrayList<>();
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onError(Object obj) {
        f92.c(this.f6393a.getString(ob0.kr_script_task_has_error), "context.getString(R.stri…kr_script_task_has_error)");
        synchronized (this.f1349a) {
            ArrayList<String> arrayList = this.f1349a;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(obj != null ? obj.toString() : null);
            arrayList.add(sb.toString());
        }
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onExit(Object obj) {
        if (this.f1349a.size() > 0) {
            Toast.makeText(this.f6393a, this.f6393a.getString(ob0.kr_script_task_has_error) + "\n\n" + new j60(this.f6393a).c(this.f1349a), 1).show();
        }
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onProgress(int i, int i2) {
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onReader(Object obj) {
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onStart(Object obj) {
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onStart(Runnable runnable) {
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onWrite(Object obj) {
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void updateLog(SpannableString spannableString) {
    }
}
