package io.objectbox.converter;

import io.objectbox.flatbuffers.FlexBuffers;

/* JADX INFO: loaded from: classes5.dex */
public class StringLongMapConverter extends StringFlexMapConverter {
    @Override // io.objectbox.converter.FlexObjectConverter
    public boolean shouldRestoreAsLong(FlexBuffers.f fVar) {
        return true;
    }
}
