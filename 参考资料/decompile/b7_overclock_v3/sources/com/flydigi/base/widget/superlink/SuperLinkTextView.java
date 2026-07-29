package com.flydigi.base.widget.superlink;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.flydigi.base.widget.superlink.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class SuperLinkTextView extends AppCompatTextView implements a.InterfaceC0134a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a.InterfaceC0134a f13675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13677i;

    public SuperLinkTextView(Context context) {
        super(context);
        this.f13676h = 0;
        this.f13677i = false;
        k();
    }

    @Override // android.widget.TextView
    public void append(CharSequence charSequence, int i10, int i11) {
        super.append(j(charSequence), i10, i11);
    }

    @Override // com.flydigi.base.widget.superlink.a.InterfaceC0134a
    public void e(View view, String str) {
        a.InterfaceC0134a interfaceC0134a = this.f13675g;
        if (interfaceC0134a != null) {
            interfaceC0134a.e(view, str);
        }
    }

    public CharSequence j(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        try {
            Matcher matcher = Pattern.compile("(https?)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(charSequence);
            while (matcher.find()) {
                spannableStringBuilder = spannableStringBuilder.delete(matcher.end() - 1, matcher.end()).delete(matcher.start(), matcher.start() + 1);
                spannableStringBuilder.setSpan(new a(matcher.group().replaceAll("\\[", "").replaceAll("\\]", ""), this.f13676h, this.f13677i, this), matcher.start(), matcher.end() - 2, 33);
                matcher = Pattern.compile("(https?)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(spannableStringBuilder);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return spannableStringBuilder;
    }

    public final void k() {
        setOnTouchListener(new u5.a());
    }

    public void setSuperLinkClickListener(a.InterfaceC0134a interfaceC0134a) {
        this.f13675g = interfaceC0134a;
    }

    public void setSuperLinkColor(int i10) {
        this.f13676h = i10;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(j(charSequence), bufferType);
    }

    public void setUnderline(boolean z10) {
        this.f13677i = z10;
    }

    public SuperLinkTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13676h = 0;
        this.f13677i = false;
        k();
    }

    public SuperLinkTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f13676h = 0;
        this.f13677i = false;
        k();
    }
}
