package a;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class bb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f5692a;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        f92.c(charsetForName, "Charset.forName(\"UTF-8\")");
        f5692a = charsetForName;
        f92.c(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        f92.c(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        f92.c(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        f92.c(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        f92.c(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
