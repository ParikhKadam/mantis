/*
 * Copyright 2022 Netflix, Inc.
 *
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

package io.mantisrx.runtime.loader;

import io.mantisrx.runtime.loader.SinkSubscriptionStateHandler.Factory;
import io.mantisrx.runtime.loader.config.WorkerConfiguration;
import io.mantisrx.server.core.Status;
import io.mantisrx.server.core.WrappedExecuteStageRequest;
import io.mantisrx.server.core.domain.WorkerId;
import io.mantisrx.server.master.client.MantisMasterGateway;
import io.mantisrx.shaded.com.google.common.util.concurrent.Service;
import org.apache.flink.util.UserCodeClassLoader;
import rx.Observable;

public interface RuntimeTask extends Service {

    void initialize(WrappedExecuteStageRequest request,
                    WorkerConfiguration config,
                    MantisMasterGateway masterMonitor,
                    UserCodeClassLoader userCodeClassLoader,
                    Factory sinkSubscriptionStateHandlerFactory);

    Observable<Status> getStatus();

    WorkerId getWorkerId();
}
