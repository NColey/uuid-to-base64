package io.github.ncoley.util

import java.util.UUID
import java.util.Base64
import java.nio.ByteBuffer

object Base64Util {
  def encode(uuid: UUID): String = {
    Base64.getUrlEncoder
      .withoutPadding()
      .encodeToString(
        ByteBuffer
          .allocate(16)
          .putLong(uuid.getMostSignificantBits)
          .putLong(uuid.getLeastSignificantBits)
          .array()
      )
  }

  def decode(s: String): UUID = {
    val bytes = ByteBuffer.wrap(Base64.getUrlDecoder.decode(s))
    new UUID(bytes.getLong, bytes.getLong())
  }
}