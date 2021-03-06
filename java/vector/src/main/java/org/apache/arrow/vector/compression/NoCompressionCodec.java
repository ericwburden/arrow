/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.arrow.vector.compression;

import org.apache.arrow.flatbuf.BodyCompressionMethod;
import org.apache.arrow.memory.ArrowBuf;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.ipc.message.ArrowBodyCompression;

/**
 * The default compression codec that does no compression.
 */
public class NoCompressionCodec implements CompressionCodec {

  public static final NoCompressionCodec INSTANCE = new NoCompressionCodec();

  public static final byte COMPRESSION_TYPE = -1;

  public static final ArrowBodyCompression DEFAULT_BODY_COMPRESSION =
      new ArrowBodyCompression(COMPRESSION_TYPE, BodyCompressionMethod.BUFFER);

  private NoCompressionCodec() {
  }

  @Override
  public ArrowBuf compress(BufferAllocator allocator, ArrowBuf unCompressedBuffer) {
    return unCompressedBuffer;
  }

  @Override
  public ArrowBuf decompress(BufferAllocator allocator, ArrowBuf compressedBuffer) {
    return compressedBuffer;
  }

  @Override
  public String getCodecName() {
    return "default";
  }
}
