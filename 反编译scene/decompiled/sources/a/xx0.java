package a;

import android.content.Context;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7927a;

    public xx0(Context context) {
        f92.d(context, "context");
        this.f7927a = context;
    }

    public final ArrayList<g50> a() {
        List listS;
        new wc0(this.f7927a).f("custom-command");
        File file = new File(c60.f5764a.d(this.f7927a, "custom-command"));
        if (!file.exists()) {
            return new ArrayList<>();
        }
        File[] fileArrListFiles = file.listFiles(new wx0());
        if (fileArrListFiles != null) {
            ArrayList arrayList = new ArrayList(fileArrListFiles.length);
            for (File file2 : fileArrListFiles) {
                g50 g50Var = new g50();
                f92.c(file2, "it");
                String strDecode = URLDecoder.decode(file2.getName());
                f92.c(strDecode, "URLDecoder.decode(it.name)");
                g50Var.d(strDecode);
                String absolutePath = file2.getAbsolutePath();
                f92.c(absolutePath, "it.absolutePath");
                g50Var.c(absolutePath);
                arrayList.add(g50Var);
            }
            listS = i52.S(arrayList, new vx0());
        } else {
            listS = null;
        }
        return new ArrayList<>(listS);
    }

    public final void b(g50 g50Var) {
        f92.d(g50Var, "item");
        File file = new File(g50Var.a());
        if (file.exists()) {
            file.delete();
        }
    }
}
