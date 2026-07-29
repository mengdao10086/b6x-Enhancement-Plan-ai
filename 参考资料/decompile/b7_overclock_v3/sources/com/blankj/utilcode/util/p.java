package com.blankj.utilcode.util;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public p() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener) {
        ((ClipboardManager) j1.a().getSystemService("clipboard")).addPrimaryClipChangedListener(onPrimaryClipChangedListener);
    }

    public static void b() {
        ((ClipboardManager) j1.a().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, ""));
    }

    public static void c(CharSequence charSequence) {
        ((ClipboardManager) j1.a().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(j1.a().getPackageName(), charSequence));
    }

    public static void d(CharSequence charSequence, CharSequence charSequence2) {
        ((ClipboardManager) j1.a().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
    }

    public static CharSequence e() {
        CharSequence label;
        ClipDescription primaryClipDescription = ((ClipboardManager) j1.a().getSystemService("clipboard")).getPrimaryClipDescription();
        return (primaryClipDescription == null || (label = primaryClipDescription.getLabel()) == null) ? "" : label;
    }

    public static CharSequence f() {
        CharSequence charSequenceCoerceToText;
        ClipData primaryClip = ((ClipboardManager) j1.a().getSystemService("clipboard")).getPrimaryClip();
        return (primaryClip == null || primaryClip.getItemCount() <= 0 || (charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(j1.a())) == null) ? "" : charSequenceCoerceToText;
    }

    public static void g(ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener) {
        ((ClipboardManager) j1.a().getSystemService("clipboard")).removePrimaryClipChangedListener(onPrimaryClipChangedListener);
    }
}
