/**
 * ﻿Copyright (C) 2012
 * by 52 North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * This program is free software; you can redistribute and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; even without the implied
 * WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program (see gnu-gpl v2.txt). If not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or
 * visit the Free Software Foundation web page, http://www.fsf.org.
 */
package org.n52.client.sos.event;

import org.eesgmbh.gimv.client.event.FilteredDispatchGwtEvent;
import org.n52.client.sos.event.handler.DatesChangedEventHandler;

public class DatesChangedEvent extends FilteredDispatchGwtEvent<DatesChangedEventHandler> {

    private long start;

    private long end;

    private boolean silent = false;

    public static Type<DatesChangedEventHandler> TYPE = new Type<DatesChangedEventHandler>();

    public DatesChangedEvent(long start, long end, DatesChangedEventHandler... blockedHandlers) {
        super(blockedHandlers);
        this.start = start;
        this.end = end;
    }

    public DatesChangedEvent(long start, long end, boolean silent, DatesChangedEventHandler... blockedHandlers) {
        super(blockedHandlers);
        this.start = start;
        this.end = end;
        this.silent = silent;
    }

    public boolean isSilent() {
        return this.silent;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        return this.end;
    }

    @Override
    protected void onDispatch(DatesChangedEventHandler handler) {
        handler.onDatesChanged(this);
    }

    @Override
    public Type<DatesChangedEventHandler> getAssociatedType() {
        return TYPE;
    }
}
