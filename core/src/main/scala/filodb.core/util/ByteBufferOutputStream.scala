package filodb.core.util

import java.io.{IOException, OutputStream}
import java.nio.ByteBuffer

class ByteBufferOutputStream(byteBuffer: ByteBuffer) extends OutputStream {

  @throws(classOf[IOException])
  def write(b: Int): Unit = {
    if (!byteBuffer.hasRemaining) flush
    byteBuffer.put(b.toByte)
  }

  @throws(classOf[IOException])
  override def write(bytes: Array[Byte], offset: Int, length: Int): Unit = {
    if (byteBuffer.remaining < length) flush
    byteBuffer.put(bytes, offset, length)
  }
}