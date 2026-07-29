package com.flydigi.base.widget.superlink;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0134a f13678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13681d;

    /* JADX INFO: renamed from: com.flydigi.base.widget.superlink.a$a, reason: collision with other inner class name */
    public interface InterfaceC0134a {
        void e(View view, String str);
    }

    public a(String str, int i10, boolean z10, InterfaceC0134a interfaceC0134a) {
        this.f13679b = i10;
        this.f13680c = z10;
        this.f13678a = interfaceC0134a;
        this.f13681d = str;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        InterfaceC0134a interfaceC0134a = this.f13678a;
        if (interfaceC0134a != null) {
            interfaceC0134a.e(view, this.f13681d);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i10 = this.f13679b;
        if (i10 > 0) {
            textPaint.setColor(i10);
        }
        textPaint.setUnderlineText(this.f13680c);
    }
}
