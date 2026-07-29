package io.objectbox.internal;

import io.objectbox.relation.ToOne;
import java.io.Serializable;
import li.c;

/* JADX INFO: loaded from: classes5.dex */
@c
public interface ToOneGetter<SOURCE> extends Serializable {
    <TARGET> ToOne<TARGET> j0(SOURCE source);
}
