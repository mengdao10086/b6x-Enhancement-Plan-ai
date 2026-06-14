package com.omarea.vtools;

import a.f92;
import a.tw0;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class SceneFreezeProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        f92.d(uri, "uri");
        return 0;
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
