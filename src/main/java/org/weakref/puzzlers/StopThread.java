/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.weakref.puzzlers;

import java.util.concurrent.TimeUnit;

public class StopThread
{
    private volatile static boolean done;

    public static void main(String[] args)
            throws InterruptedException
    {
        Thread thread = new Thread(() -> {
            long i = 0;
            while (!done) {
                i++;
            }
            System.out.println("end: " + i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        done = true;
    }
}
