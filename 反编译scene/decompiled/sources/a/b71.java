package a;

import android.content.Intent;
import android.widget.ProgressBar;
import com.omarea.vtools.activities.ActionPageOnline;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActionPageOnline.g f237a;

    public b71(ActionPageOnline.g gVar, n92 n92Var) {
        this.f237a = gVar;
        this.f5679a = n92Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ActionPageOnline.this.setTitle(u61.kr_download_completed);
        ProgressBar progressBar = (ProgressBar) ActionPageOnline.this._$_findCachedViewById(t61.kr_download_progress);
        f92.c(progressBar, "kr_download_progress");
        progressBar.setVisibility(8);
        ActionPageOnline.this.r();
        Intent intent = new Intent();
        intent.putExtra("absPath", (String) this.f5679a.f6891a);
        ActionPageOnline.this.setResult(0, intent);
        ActionPageOnline.g gVar = this.f237a;
        if (gVar.b) {
            ActionPageOnline.this.finish();
        }
    }
}
