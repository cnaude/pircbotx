/**
 * Copyright (C) 2010-2014 Leon Blakey <lord.quackstar at gmail.com>
 *
 * This file is part of PircBotX.
 *
 * PircBotX is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * PircBotX is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * PircBotX. If not, see <http://www.gnu.org/licenses/>.
 */
package org.pircbotx.hooks.events;

import javax.annotation.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.pircbotx.hooks.Event;
import org.pircbotx.PircBotX;

/**
 * This event is dispatched when the Motd is finished being sent. Motd lines are
 * separated by
 * <code>\n</code>
 * @author Leon Blakey <lord.quackstar at gmail.com>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MotdEvent<T extends PircBotX> extends Event<T> {
	/**
	 * The full motd separated by newlines (<code>\n</code>)
	 */
	protected final String motd;

	public MotdEvent(T bot, @NonNull String motd) {
		super(bot);
		this.motd = motd;
	}

	/**
	 * Responds by sending a <b>raw line</b> to the server.
	 * @param response The response to send
	 */
	@Override
	public void respond(@Nullable String response) {
		getBot().sendRaw().rawLine(response);
	}
}
