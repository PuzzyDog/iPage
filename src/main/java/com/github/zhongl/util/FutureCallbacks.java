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

package com.github.zhongl.util;

import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
public class FutureCallbacks {
    private FutureCallbacks() {}

    public static <T> FutureCallback<T> ignore() {
        return new FutureCallback<T>() {
            @Override
            public void onSuccess(T result) { }

            @Override
            public void onFailure(Throwable t) { }
        };
    }

    public static <T> T call(Function<FutureCallback<T>, Void> function) {
        CallbackFuture<T> callback = new CallbackFuture<T>();
        function.apply(callback);
        return getUnchecked(callback);
    }

    public static <T> T getUnchecked(Future<T> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e.getCause());
        }
    }
}
