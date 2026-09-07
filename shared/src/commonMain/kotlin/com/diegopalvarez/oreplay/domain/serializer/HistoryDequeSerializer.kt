package com.diegopalvarez.oreplay.domain.serializer

import com.diegopalvarez.oreplay.domain.model.StageCategory
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object HistoryDequeSerializer: KSerializer<ArrayDeque<StageCategory>> {

    private val delegate = ListSerializer(
        StageCategory.serializer()
    )

    override val descriptor: SerialDescriptor = delegate.descriptor

    override fun serialize(encoder: Encoder, value: ArrayDeque<StageCategory>) {
        delegate.serialize(
            encoder,
            value.toList()
        )
    }

    override fun deserialize(decoder: Decoder): ArrayDeque<StageCategory> {
        return ArrayDeque(
            delegate.deserialize(decoder)
        )
    }
}