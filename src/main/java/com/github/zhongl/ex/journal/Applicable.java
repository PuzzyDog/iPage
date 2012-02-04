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

package com.github.zhongl.ex.journal;

import java.io.IOException;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
public interface Applicable {
    /**
     * Apply a record from {@link com.github.zhongl.ex.journal.Journal} with it's offset.
     *
     * @param record indicate an operation.
     */
    void apply(Object record) throws IOException;

    /** @return offset of last applied checkpoint. */
    Revision lastCheckpoint();

    /** Ensure all records have been applied , then Journal could be erased. */
    void force() throws IOException;
}
