package com.umeng.socialize.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f24529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f24530b = ContextUtil.getContext().getSharedPreferences("um_social_azx", 0);

    private b() {
    }

    public static b a() {
        if (f24529a == null) {
            synchronized (b.class) {
                if (f24529a == null) {
                    f24529a = new b();
                }
            }
        }
        return f24529a;
    }

    public String b(String str, String str2) {
        return this.f24530b.getString(str, str2);
    }

    public Map<String, ?> b() {
        return this.f24530b.getAll();
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f24530b.edit().putString(str, str2).apply();
    }

    public int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        SharedPreferences.Editor editorEdit = this.f24530b.edit();
        int i10 = 0;
        for (String str : strArr) {
            if (this.f24530b.contains(str)) {
                editorEdit.remove(str);
                i10++;
            }
        }
        if (i10 > 0) {
            editorEdit.apply();
        }
        return i10;
    }

    public void a(String str) {
        if (this.f24530b.contains(str)) {
            this.f24530b.edit().remove(str).apply();
        }
    }
}
