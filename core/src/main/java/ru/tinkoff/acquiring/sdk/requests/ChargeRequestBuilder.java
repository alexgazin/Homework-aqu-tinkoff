/*
 * Copyright © 2016 Tinkoff Bank
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

package ru.tinkoff.acquiring.sdk.requests;

/**
 * @author Mikhail Artemyev
 */
final public class ChargeRequestBuilder extends AcquiringRequestBuilder<ChargeRequest> {

    private ChargeRequest request = new ChargeRequest();

    public ChargeRequestBuilder(final String password, final String terminalKey) {
        super(password, terminalKey);
    }

    public ChargeRequestBuilder setPaymentId(final Long value) {
        request.setPaymentId(value);
        return this;
    }

    public ChargeRequestBuilder setRebillId(final Long value) {
        request.setRebillId(value);
        return this;
    }

    @Override
    protected void validate() {
        validateZeroOrPositive(request.getPaymentId(), "Payment ID");
        validateZeroOrPositive(request.getRebillId(), "Rebill ID");
    }

    @Override
    protected ChargeRequest getRequest() {
        return request;
    }
}
