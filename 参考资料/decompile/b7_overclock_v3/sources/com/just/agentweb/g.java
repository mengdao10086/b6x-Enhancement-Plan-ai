package com.just.agentweb;

import android.webkit.JavascriptInterface;
import com.just.agentweb.AgentWeb;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import xf.a0;

/* JADX INFO: loaded from: classes7.dex */
public abstract class g implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AgentWeb.SecurityType f22066a;

    public g(AgentWeb.SecurityType securityType) {
        this.f22066a = securityType;
    }

    @Override // xf.a0
    public boolean b(Object obj) {
        if (xf.c.f55204i == 2) {
            return true;
        }
        boolean z10 = false;
        for (Method method : obj.getClass().getMethods()) {
            Annotation[] annotations = method.getAnnotations();
            int length = annotations.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (annotations[i10] instanceof JavascriptInterface) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (z10) {
                break;
            }
        }
        return z10;
    }

    public boolean d() {
        if (this.f22066a != AgentWeb.SecurityType.STRICT_CHECK) {
            return true;
        }
        int i10 = xf.c.f55204i;
        return true;
    }
}
