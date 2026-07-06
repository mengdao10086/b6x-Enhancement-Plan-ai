package a;

import android.view.View;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class e11 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l11 f5956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ File f639a;

    public e11(l11 l11Var, File file, View view) {
        this.f5956a = l11Var;
        this.f639a = file;
        this.f638a = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f639a.exists()) {
            Toast.makeText(this.f638a.getContext(), "所选的文件已被删除，请重新选择！", 0).show();
            return;
        }
        File[] fileArrListFiles = this.f639a.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            Snackbar.W(this.f638a, "该目录下没有文件！", -1).M();
        } else {
            this.f5956a.p(this.f639a);
        }
    }
}
