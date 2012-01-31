/*
 * Copyright 2012 zhongl
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.github.zhongl.ex.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
public abstract class Forcer {

    public static final String CLASS_NAME = System.getProperty(
            "ipage.forcer.class.name",
            "com.github.zhongl.ex.nio.MappedForcer");

    private static final Forcer SINGLETON;

    static {
        try {
            SINGLETON = (Forcer) Class.forName(CLASS_NAME).newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Forcer getInstance() {
        return SINGLETON;
    }

    public abstract int force(FileChannel channel, ByteBuffer buffer) throws IOException;
}