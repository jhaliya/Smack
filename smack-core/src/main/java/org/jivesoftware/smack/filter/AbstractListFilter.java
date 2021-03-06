/**
 *
 * Copyright 2015 Florian Schmaus
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

package org.jivesoftware.smack.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jivesoftware.smack.util.Objects;

/**
 * 
 */
public abstract class AbstractListFilter implements PacketFilter {

    /**
     * The list of filters.
     */
    protected final List<PacketFilter> filters;

    /**
     * Creates an empty filter.
     */
    protected AbstractListFilter() {
        filters = new ArrayList<PacketFilter>();
    }

    /**
     * Creates an filter using the specified filters.
     *
     * @param filters the filters to add.
     */
    protected AbstractListFilter(PacketFilter... filters) {
        Objects.requireNonNull(filters, "Parameter must not be null.");
        for(PacketFilter filter : filters) {
            Objects.requireNonNull(filter, "Parameter must not be null.");
        }
        this.filters = new ArrayList<PacketFilter>(Arrays.asList(filters));
    }

    /**
     * Adds a filter to the filter list. A stanza will pass the filter if all of the filters in the
     * list accept it.
     *
     * @param filter a filter to add to the filter list.
     */
    public void addFilter(PacketFilter filter) {
        Objects.requireNonNull(filter, "Parameter must not be null.");
        filters.add(filter);
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" (");
        for (PacketFilter filter : filters) {
            sb.append(' ' + filter.toString() + ',');
        }
        sb.append(")");
        return sb.toString();
    }
}
