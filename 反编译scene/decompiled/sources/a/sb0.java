package a;

import android.content.DialogInterface;
import java.util.UUID;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class sb0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tb0 f7380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2872a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public sb0(tb0 tb0Var, String str, String str2, String str3) {
        this.f7380a = tb0Var;
        this.f2872a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new sc0(this.f7380a.f7484a.f1351a, null).b(this.f2872a, this.b, this.c, UUID.randomUUID().toString(), null);
    }
}
