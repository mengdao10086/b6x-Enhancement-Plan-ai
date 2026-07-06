package com.omarea.vtools;

import a.f92;
import a.fz0;
import a.tw0;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.omarea.model.SceneConfigInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class SceneUnfreezeProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        f92.d(uri, "uri");
        int i = 0;
        if (str != null) {
            fz0 fz0Var = new fz0(getContext());
            for (SceneConfigInfo sceneConfigInfo : fz0Var.e(str, strArr)) {
                if (sceneConfigInfo.freeze) {
                    tw0.a aVar = tw0.f3070a;
                    String str2 = sceneConfigInfo.packageName;
                    f92.c(str2, "app.packageName");
                    aVar.a(str2);
                    i++;
                }
            }
            fz0Var.close();
        }
        return i;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        f92.d(uri, "uri");
        return "application/json";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        f92.d(uri, "uri");
        if (contentValues == null || !contentValues.containsKey("packageName")) {
            return null;
        }
        tw0.f3070a.f(contentValues.get("packageName").toString());
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        f92.d(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        f92.d(uri, "uri");
        return 0;
    }
}
