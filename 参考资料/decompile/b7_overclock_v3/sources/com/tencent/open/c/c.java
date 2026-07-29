package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.SecureJsInterface;

/* JADX INFO: loaded from: classes5.dex */
public class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private KeyEvent f22731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.tencent.open.web.security.a f22732c;

    public c(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f22730a);
        if (!f22730a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode == 67) {
            com.tencent.open.web.security.a.f22839b = true;
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getUnicodeChar() == 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
            return super.dispatchKeyEvent(keyEvent);
        }
        KeyEvent keyEvent2 = new KeyEvent(0, 17);
        this.f22731b = keyEvent2;
        return super.dispatchKeyEvent(keyEvent2);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + inputConnectionOnCreateInputConnection);
        if (inputConnectionOnCreateInputConnection == null) {
            f22730a = false;
            return inputConnectionOnCreateInputConnection;
        }
        f22730a = true;
        com.tencent.open.web.security.a aVar = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
        this.f22732c = aVar;
        return aVar;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f22730a);
        if (!f22730a) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.onKeyDown(i10, keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (keyCode == 66) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (keyCode == 67) {
            com.tencent.open.web.security.a.f22839b = true;
            return super.onKeyDown(i10, keyEvent);
        }
        if (keyEvent.getUnicodeChar() == 0) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
            return super.onKeyDown(i10, keyEvent);
        }
        KeyEvent keyEvent2 = new KeyEvent(0, 17);
        this.f22731b = keyEvent2;
        return super.onKeyDown(keyEvent2.getKeyCode(), this.f22731b);
    }
}
