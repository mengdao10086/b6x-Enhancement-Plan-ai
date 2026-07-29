package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f22659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    public final WebChromeClient f22660b;

    public b(Context context, int i10) {
        super(context, i10);
        this.f22660b = new WebChromeClient() { // from class: com.tencent.open.b.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                b.this.a(consoleMessage.message());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i11, String str2) {
                SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i11 + " of " + str2);
            }
        };
    }

    public abstract void a(String str);

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f22659a = new a();
    }
}
