/*
 * Copyright (c) 2008-2015 JPerf
 * All rights reserved.  http://www.jperf.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.jperf.helpers;

import junit.framework.TestCase;
import net.jperf.StopWatch;

/**
 * Tests the StopWatchParser class.
 */
public class StopWatchParserTest extends TestCase {

    public void testStopWatchParser() throws Exception {
        StopWatchParser parser = new StopWatchParser();

        StopWatch stopWatch = new StopWatch(123, 456, "tag", "message");
        assertEquals(stopWatch, parser.parseStopWatch(stopWatch.toString()));

        stopWatch = new StopWatch(789, 101112, "tag2", null);
        assertEquals(stopWatch, parser.parseStopWatch(stopWatch.toString()));

        assertNull(parser.parseStopWatch("not a stop watch string"));

        assertNull(parser.match("not a stop watch string"));
    }
}
