package com.blankj.utilcode.util;

import android.app.Application;
import androidx.core.content.FileProvider;

/* JADX INFO: loaded from: classes2.dex */
public class UtilsFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        j1.b((Application) getContext().getApplicationContext());
        return true;
    }
}
