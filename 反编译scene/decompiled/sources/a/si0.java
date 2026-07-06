package a;

import android.content.Context;
import android.provider.Settings;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class si0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7401a;

    public si0(Context context) {
        f92.d(context, "context");
        this.f7401a = context;
    }

    public final ArrayList<String> a() {
        try {
            String string = Settings.Secure.getString(this.f7401a.getContentResolver(), "enabled_input_methods");
            if (!(string == null || string.length() == 0)) {
                ArrayList<String> arrayList = new ArrayList<>();
                List listD0 = ec2.d0(string, new String[]{":"}, false, 0, 6, null);
                ArrayList arrayList2 = new ArrayList(z42.m(listD0, 10));
                Iterator it = listD0.iterator();
                while (it.hasNext()) {
                    arrayList2.add((String) i52.A(ec2.d0((String) it.next(), new String[]{"/"}, false, 0, 6, null)));
                }
                i52.X(arrayList2, arrayList);
                return arrayList;
            }
        } catch (Exception unused) {
        }
        ArrayList<String> arrayList3 = new ArrayList<>();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f7401a.getSystemService("input_method");
        if (inputMethodManager != null) {
            for (InputMethodInfo inputMethodInfo : inputMethodManager.getInputMethodList()) {
                f92.c(inputMethodInfo, "input");
                arrayList3.add(inputMethodInfo.getPackageName());
            }
        }
        return arrayList3;
    }
}
