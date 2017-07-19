/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.saga.core;

import static io.servicecomb.saga.core.Operation.NO_OP;
import static io.servicecomb.saga.core.SagaEventMatcher.eventWith;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

import org.junit.Test;

public class SagaStartTaskTest {

  private final IdGenerator<Long> idGenerator = new LongIdGenerator();
  private final EventQueue eventQueue = new EmbeddedEventQueue();
  private final SagaStartTask state = new SagaStartTask(eventQueue, idGenerator);

  @Test
  public void transitToNextStateAfterEmittingEvent() {
    state.commit();

    assertThat(eventQueue, contains(eventWith(1L, NO_OP, SagaStartedEvent.class)));
  }
}