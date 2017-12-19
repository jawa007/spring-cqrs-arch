/**
 * Copyright (C) 2017 Sylvain Leroy - BYOS Company All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the MIT license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the MIT license with
 * this file. If not, please write to: contact@sylvainleroy.com, or visit : https://sylvainleroy.com
 */
package com.byoskill.spring.cqrs.gate.api;

import java.util.concurrent.CompletableFuture;

/**
 * Main access point to the Application.<br>
 * It handles:
 * <ul>
 * <li>filtering command duplicates
 * <li>command queues for asynchronous commands
 * </ul>
 *
 * @author Slawek
 * @author sleroy
 *
 */
public interface Gate {

    /**
     * Dispatch a command and executes it sequentially.
     *
     * @param command
     *            the command.
     * @return the result of the command.
     */
    public <R> R dispatch(Object command);

    /**
     * Dispatch a command and executes it asynchronously.
     *
     * @param command
     *            the command.
     * @return the result of the command.
     */
    public <R> CompletableFuture<Object> dispatchAsync(Object command);

    /**
     * Dispatches an event and executes it asynchronously.
     *
     * @param _event
     *            the event.
     */
    public void dispatchEvent(Object _event);
}