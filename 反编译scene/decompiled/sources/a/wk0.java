package a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wk0 extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tk0 f7798a = new tk0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f3452a;

    public wk0(Context context) {
        super(context);
        this.f3452a = a42.a(new vk0(this));
    }

    public /* synthetic */ wk0(Context context, b92 b92Var) {
        this(context);
    }

    public final Resources b() {
        return (Resources) this.f3452a.getValue();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }
}
