package io.objectbox.internal;

import java.io.Serializable;
import java.util.List;
import li.c;

/* JADX INFO: loaded from: classes5.dex */
@c
public interface ToManyGetter<SOURCE> extends Serializable {
    <TARGET> List<TARGET> s(SOURCE source);
}
