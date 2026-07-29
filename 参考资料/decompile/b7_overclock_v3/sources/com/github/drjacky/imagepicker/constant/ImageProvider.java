package com.github.drjacky.imagepicker.constant;

import java.util.Arrays;
import kotlin.d0;
import w3.c;

/* JADX INFO: loaded from: classes3.dex */
@d0(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/drjacky/imagepicker/constant/ImageProvider;", "", "(Ljava/lang/String;I)V", "GALLERY", c.f53846b, "FRONT_CAMERA", "BOTH", "imagepicker_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum ImageProvider {
    GALLERY,
    CAMERA,
    FRONT_CAMERA,
    BOTH;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ImageProvider[] valuesCustom() {
        ImageProvider[] imageProviderArrValuesCustom = values();
        return (ImageProvider[]) Arrays.copyOf(imageProviderArrValuesCustom, imageProviderArrValuesCustom.length);
    }
}
