package a;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7307a;

    public rj1(Context context) {
        f92.d(context, "context");
        this.f7307a = context;
        context.getResources();
        new ArrayList();
        m42 m42Var = m42.f6769a;
    }

    public final String a(Integer num) {
        String string;
        String str;
        if (num != null && num.intValue() == -1) {
            string = this.f7307a.getString(u61.orientation_default);
            str = "context.getString(R.string.orientation_default)";
        } else if (num != null && num.intValue() == 10) {
            string = this.f7307a.getString(u61.orientation_force_auto);
            str = "context.getString(R.string.orientation_force_auto)";
        } else if (num != null && num.intValue() == 13) {
            string = this.f7307a.getString(u61.orientation_auto);
            str = "context.getString(R.string.orientation_auto)";
        } else if (num != null && num.intValue() == 6) {
            string = this.f7307a.getString(u61.orientation_horizontal);
            str = "context.getString(R.string.orientation_horizontal)";
        } else if (num != null && num.intValue() == 7) {
            string = this.f7307a.getString(u61.orientation_vertical);
            str = "context.getString(R.string.orientation_vertical)";
        } else {
            string = this.f7307a.getString(u61.orientation_unknown);
            str = "context.getString(R.string.orientation_unknown)";
        }
        f92.c(string, str);
        return string;
    }
}
