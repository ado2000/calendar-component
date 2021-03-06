/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.vaadin.addon.calendar.ui;

import com.vaadin.event.dd.DropTarget;
import com.vaadin.event.dd.TargetDetailsImpl;
import org.vaadin.addon.calendar.Calendar;

import java.util.Date;
import java.util.Map;

/**
 * Drop details for {@link Calendar}. When something is dropped on the Calendar,
 * this class contains the specific details of the drop point. Specifically,
 * this class gives access to the date where the drop happened. If the Calendar
 * was in weekly mode, the date also includes the start time of the slot.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 *
 */
@SuppressWarnings("serial")

public class CalendarTargetDetails extends TargetDetailsImpl {

    private boolean hasDropTime;

    public CalendarTargetDetails(Map<String, Object> rawDropData, DropTarget dropTarget) {
        super(rawDropData, dropTarget);
    }

    /**
     * @return true if {@link #getDropTime()} will return a date object with the
     *         time set to the start of the time slot where the drop happened
     */
    public boolean hasDropTime() {
        return hasDropTime;
    }

    /**
     * Does the dropped item have a time associated with it
     *
     * @param hasDropTime
     */
    public void setHasDropTime(boolean hasDropTime) {
        this.hasDropTime = hasDropTime;
    }

    /**
     * @return the date where the drop happened
     */
    public Date getDropTime() {
        if (hasDropTime) {
            return (Date) getData("dropTime");
        } else {
            return (Date) getData("dropDay");
        }
    }

    /**
     * @return the {@link Calendar} instance which was the target of the drop
     */
    public Calendar getTargetCalendar() {
        return (Calendar) getTarget();
    }
}
