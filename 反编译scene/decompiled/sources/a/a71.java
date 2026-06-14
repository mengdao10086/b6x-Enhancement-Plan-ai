package a;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.omarea.vtools.activities.ActionPageOnline;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5577a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f46a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActionPageOnline.g f47a;

    public a71(ActionPageOnline.g gVar, n92 n92Var, int i) {
        this.f47a = gVar;
        this.f46a = n92Var;
        this.f5577a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = (TextView) ActionPageOnline.this._$_findCachedViewById(t61.kr_download_name);
        f92.c(textView, "kr_download_name");
        textView.setText((String) this.f46a.f6891a);
        ProgressBar progressBar = (ProgressBar) ActionPageOnline.this._$_findCachedViewById(t61.kr_download_progress);
        f92.c(progressBar, "kr_download_progress");
        progressBar.setProgress(this.f5577a);
        ProgressBar progressBar2 = (ProgressBar) ActionPageOnline.this._$_findCachedViewById(t61.kr_download_progress);
        f92.c(progressBar2, "kr_download_progress");
        progressBar2.setIndeterminate(false);
        ActionPageOnline.this.setTitle(2131886945);
        ActionPageOnline.g gVar = this.f47a;
        gVar.f5084a.e(gVar.f5089a, this.f5577a);
    }
}
