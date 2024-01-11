package io.github.ncoley.util

import java.util.UUID
import java.nio.ByteBuffer
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec


class Base64UtilSpec extends AnyWordSpec with Matchers {
  "UUID can be encoded into Base64 encoded string that is decodable back to original UUID" in {
    val uuid = UUID.randomUUID()
    val encodedUUID = Base64Util.encode(uuid)

    Base64Util.decode(encodedUUID) mustEqual uuid
  }

  "Base64 encoded string can be decoded into UUID that is encodable back to original string" in {
    val uuid = UUID.randomUUID()
    val base64String = Base64Util.encode(uuid)
    val decodedUUID = Base64Util.decode(base64String)

    Base64Util.encode(decodedUUID) mustEqual base64String
  }

  "verify nameUUIDFromBytes does not recreate original UUID" in {
    val uuid = UUID.randomUUID()
    val bytes = ByteBuffer.allocate(16).putLong(uuid.getMostSignificantBits).putLong(uuid.getLeastSignificantBits).array()

    UUID.nameUUIDFromBytes(bytes) != uuid
  }
}