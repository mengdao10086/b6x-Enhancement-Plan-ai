package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: classes5.dex */
public class a extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f22839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f22840c;

    public a(InputConnection inputConnection, boolean z10) {
        super(inputConnection, z10);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i10) {
        f22840c = true;
        f22838a = charSequence.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i10);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            SLog.i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f22838a = String.valueOf((char) keyEvent.getUnicodeChar());
            f22840c = true;
            SLog.d("openSDK_LOG.CaptureInputConnection", "s: " + f22838a);
        }
        SLog.d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f22838a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i10) {
        f22840c = true;
        f22838a = charSequence.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i10);
    }
}
