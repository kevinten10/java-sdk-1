/*
 * Copyright 2021 Layotto Authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spec.sdk.runtime.v1.domain.state;

import java.util.Map;

/**
 * This class reprent what a State is.
 *
 * @param <T> The type of the value of the state
 */
public class State<T> {

    /**
     * The key of the state.
     */
    private final String              key;

    /**
     * The value of the state.
     */
    private final T                   value;

    /**
     * The ETag to be used Keep in mind that for some state stores (like redis) only numbers are supported.
     */
    private final String              etag;

    /**
     * The metadata which will be passed to state store component.
     */
    private final Map<String, String> metadata;

    /**
     * The error in case the key could not be retrieved.
     */
    private final String              error;

    /**
     * The options used for saving the state.
     */
    private final StateOptions        options;

    /**
     * Create an immutable state reference to be retrieved or deleted. This Constructor CAN be used anytime you need to retrieve or delete a
     * state.
     *
     * @param key - The key of the state
     */
    public State(String key) {
        this.key = key;
        this.value = null;
        this.etag = null;
        this.metadata = null;
        this.options = null;
        this.error = null;
    }

    /**
     * Create an immutable state. This Constructor MUST be used anytime the key could not be retrieved and contains an error.
     *
     * @param key   - The key of the state.
     * @param error - Error when fetching the state.
     */
    public State(String key, String error) {
        this.value = null;
        this.key = key;
        this.etag = null;
        this.metadata = null;
        this.options = null;
        this.error = error;
    }

    /**
     * Create an immutable state reference to be retrieved or deleted. This Constructor CAN be used anytime you need to retrieve or delete a
     * state.
     *
     * @param key     - The key of the state
     * @param etag    - The etag of the state - Keep in mind that for some state stores (like redis) only numbers are supported.
     * @param options - REQUIRED when saving a state.
     */
    public State(String key, String etag, StateOptions options) {
        this.value = null;
        this.key = key;
        this.etag = etag;
        this.metadata = null;
        this.options = options;
        this.error = null;
    }

    /**
     * Create an immutable state. This Constructor CAN be used anytime you want the state to be saved.
     *
     * @param key     - The key of the state.
     * @param value   - The value of the state.
     * @param etag    - The etag of the state - for some state stores (like redis) only numbers are supported.
     * @param options - REQUIRED when saving a state.
     */
    public State(String key, T value, String etag, StateOptions options) {
        this.value = value;
        this.key = key;
        this.etag = etag;
        this.metadata = null;
        this.options = options;
        this.error = null;
    }

    /**
     * Create an immutable state. This Constructor CAN be used anytime you want the state to be saved.
     *
     * @param key      - The key of the state.
     * @param value    - The value of the state.
     * @param etag     - The etag of the state - for some state stores (like redis) only numbers are supported.
     * @param metadata - The metadata of the state.
     * @param options  - REQUIRED when saving a state.
     */
    public State(String key, T value, String etag, Map<String, String> metadata, StateOptions options) {
        this.value = value;
        this.key = key;
        this.etag = etag;
        this.metadata = metadata;
        this.options = options;
        this.error = null;
    }

    /**
     * Create an immutable state. This Constructor CAN be used anytime you want the state to be saved.
     *
     * @param key   - The key of the state.
     * @param value - The value of the state.
     * @param etag  - The etag of the state - some state stores (like redis) only numbers are supported.
     */
    public State(String key, T value, String etag) {
        this.value = value;
        this.key = key;
        this.etag = etag;
        this.metadata = null;
        this.options = null;
        this.error = null;
    }

    /**
     * Retrieves the Value of the state.
     *
     * @return The value of the state
     */
    public T getValue() {
        return value;
    }

    /**
     * Retrieves the Key of the state.
     *
     * @return The key of the state
     */
    public String getKey() {
        return key;
    }

    /**
     * Retrieve the ETag of this state.
     *
     * @return The etag of the state
     */
    public String getEtag() {
        return etag;
    }

    /**
     * Retrieve the metadata of this state.
     *
     * @return the metadata of this state
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * Retrieve the Options used for saving the state.
     *
     * @return The options to save the state
     */
    public StateOptions getOptions() {
        return options;
    }

    /**
     * Getter method for property <tt>error</tt>.
     *
     * @return property value of error
     */
    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "State{" +
            "key='" + key + '\'' +
            ", value=" + value +
            ", etag='" + etag + '\'' +
            ", metadata=" + metadata +
            ", error='" + error + '\'' +
            ", options=" + options +
            '}';
    }
}
