package com.google.common.html;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.y;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public final class HtmlEscapers {
    private static final Escaper HTML_ESCAPER = Escapers.builder().addEscape(y.f38188b, "&quot;").addEscape('\'', "&#39;").addEscape('&', "&amp;").addEscape('<', "&lt;").addEscape('>', "&gt;").build();

    private HtmlEscapers() {
    }

    public static Escaper htmlEscaper() {
        return HTML_ESCAPER;
    }
}
