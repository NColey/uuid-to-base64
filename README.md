# Sample Repro Of RoundTrip Encoding/Decoding Between UUID and Base64

```scala
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
```

Run `sbt test` to validate the above