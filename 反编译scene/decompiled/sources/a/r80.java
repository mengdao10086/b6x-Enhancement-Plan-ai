package a;

import a.p80;
import android.content.DialogInterface;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r80 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7281a;

    public r80(p80.b bVar) {
        this.f7281a = bVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f7281a.f2405a.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(this.f7281a.f7095a);
        }
        p80.f2403a.I(r3.v() - 1);
    }
}
