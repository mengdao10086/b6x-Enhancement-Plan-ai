package ca;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.d0;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lca/a;", "", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "", "fileName", "a", "<init>", "()V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f10675a = new a();

    @k
    public final String a(@k Context context, @k String fileName) throws IOException {
        f0.p(context, "context");
        f0.p(fileName, "fileName");
        InputStream inputStreamOpen = context.getAssets().open(fileName);
        f0.o(inputStreamOpen, "context.assets.open(fileName)");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpen, kotlin.text.d.f38161b);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String strK = TextStreamsKt.k(bufferedReader);
            kotlin.io.b.a(bufferedReader, null);
            return strK;
        } finally {
        }
    }
}
