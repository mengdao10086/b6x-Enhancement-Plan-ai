package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ji1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ki1 f6513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1547a;

    public ji1(ki1 ki1Var, String str) {
        this.f6513a = ki1Var;
        this.f1547a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!new nb2("^\\[.*]$").f(this.f1547a)) {
            this.f6513a.f1644a.setText(this.f1547a);
            return;
        }
        String str = this.f1547a;
        String string = this.f6513a.f1642a.getString(u61.apps_op_translate_copy);
        f92.c(string, "context.getString(R.string.apps_op_translate_copy)");
        String strT = bc2.t(str, "[copy ", string, false, 4, null);
        String string2 = this.f6513a.f1642a.getString(u61.apps_op_translate_uninstall);
        f92.c(string2, "context.getString(R.stri…s_op_translate_uninstall)");
        String strT2 = bc2.t(strT, "[uninstall ", string2, false, 4, null);
        String string3 = this.f6513a.f1642a.getString(u61.apps_op_translate_install);
        f92.c(string3, "context.getString(R.stri…pps_op_translate_install)");
        String strT3 = bc2.t(strT2, "[install ", string3, false, 4, null);
        String string4 = this.f6513a.f1642a.getString(u61.apps_op_translate_restore);
        f92.c(string4, "context.getString(R.stri…pps_op_translate_restore)");
        String strT4 = bc2.t(strT3, "[restore ", string4, false, 4, null);
        String string5 = this.f6513a.f1642a.getString(u61.apps_op_translate_backup);
        f92.c(string5, "context.getString(R.stri…apps_op_translate_backup)");
        String strT5 = bc2.t(strT4, "[backup ", string5, false, 4, null);
        String string6 = this.f6513a.f1642a.getString(u61.apps_op_translate_show);
        f92.c(string6, "context.getString(R.string.apps_op_translate_show)");
        String strT6 = bc2.t(strT5, "[unhide ", string6, false, 4, null);
        String string7 = this.f6513a.f1642a.getString(u61.apps_op_translate_hide);
        f92.c(string7, "context.getString(R.string.apps_op_translate_hide)");
        String strT7 = bc2.t(strT6, "[hide ", string7, false, 4, null);
        String string8 = this.f6513a.f1642a.getString(u61.apps_op_translate_delete);
        f92.c(string8, "context.getString(R.stri…apps_op_translate_delete)");
        String strT8 = bc2.t(strT7, "[delete ", string8, false, 4, null);
        String string9 = this.f6513a.f1642a.getString(u61.apps_op_translate_disable);
        f92.c(string9, "context.getString(R.stri…pps_op_translate_disable)");
        String strT9 = bc2.t(strT8, "[disable ", string9, false, 4, null);
        String string10 = this.f6513a.f1642a.getString(u61.apps_op_translate_enable);
        f92.c(string10, "context.getString(R.stri…apps_op_translate_enable)");
        String strT10 = bc2.t(strT9, "[enable ", string10, false, 4, null);
        String string11 = this.f6513a.f1642a.getString(u61.apps_op_translate_clear_cache);
        f92.c(string11, "context.getString(R.stri…op_translate_clear_cache)");
        String strT11 = bc2.t(strT10, "[trim caches ", string11, false, 4, null);
        String string12 = this.f6513a.f1642a.getString(u61.apps_op_translate_clear_data);
        f92.c(string12, "context.getString(R.stri…_op_translate_clear_data)");
        String strT12 = bc2.t(strT11, "[clear ", string12, false, 4, null);
        String string13 = this.f6513a.f1642a.getString(u61.apps_op_translate_skip);
        f92.c(string13, "context.getString(R.string.apps_op_translate_skip)");
        String strT13 = bc2.t(strT12, "[skip ", string13, false, 4, null);
        String string14 = this.f6513a.f1642a.getString(u61.apps_op_translate_link);
        f92.c(string14, "context.getString(R.string.apps_op_translate_link)");
        String strT14 = bc2.t(strT13, "[link ", string14, false, 4, null);
        String string15 = this.f6513a.f1642a.getString(u61.apps_op_translate_compile);
        f92.c(string15, "context.getString(R.stri…pps_op_translate_compile)");
        this.f6513a.f1644a.setText(bc2.t(strT14, "[compile ", string15, false, 4, null));
    }
}
